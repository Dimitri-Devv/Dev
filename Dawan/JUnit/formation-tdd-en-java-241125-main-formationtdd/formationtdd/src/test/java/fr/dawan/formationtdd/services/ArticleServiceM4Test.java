package fr.dawan.formationtdd.services;

import argumentmatchers.ArticleMatcher;
import beans.Article;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.ArticleRepository;
import services.ArticleService;
import services.NotFoundException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceM4Test {

    @Mock
    private ArticleRepository repository;

    //Mockito va automatiquement injecter un mock
    @InjectMocks
    private ArticleService service;

    @Test
    public void getByIdM4Test() throws Exception {
        Article a42 = new Article(42L, "description", 20.0, LocalDate.of(1970, 1, 1));
        when(repository.findById(42L)).thenReturn(a42);
        Article a = service.getById(42L);
        assertThat(a, Matchers.samePropertyValuesAs(a42));
    }

    @Test
    public void getByIdFailTest() throws Exception {
        when(repository.findById(1000L)).thenThrow(Exception.class);

        assertThrows(NotFoundException.class, () -> service.getById(1000L));
    }

    //Méthode static
    @Test
    public void checkTest(){
        try(MockedStatic<ArticleRepository> ms= Mockito.mockStatic(ArticleRepository.class)) {
            ms.when(ArticleRepository::tool).thenReturn(new Article());
            assertThat(ArticleService.check(), Matchers.samePropertyValuesAs(new Article()));
        }
    }

    //Méthode void
    @Test
    public void removeByIdFail() throws Exception {
        doThrow(Exception.class).when(repository).remove(1000L);
        assertThrows(NotFoundException.class, () -> service.remove(1000L));
    }

    @Test
    //ArgumentMatcher
    public void getByIdArgumentMatcherTest() throws Exception {
        Article article = new Article(4L, "Description", 20.0, LocalDate.of(1970, 1, 1));
        when(repository.findById(anyLong())).thenReturn(article);

        assertThat(service.getById(3L), Matchers.samePropertyValuesAs(article));
        assertThat(service.getById(23L), Matchers.samePropertyValuesAs(article));
    }

    // ArgumentMatcher Personnalisé
    @Test
    public void saveOrUpdateTest() throws Exception {
        Article a= new Article(45L, "Micro Yeti", 100.0, LocalDate.of(2016, 1, 1));
        //when(repository.save(argThat(new ArticleMatcher()))).thenReturn(a);
        when(repository.save
                (argThat(article -> article.getPrix() > 100.0 && article.getDescription().isEmpty()
                ))).thenReturn(a);
        assertThat(service.saveOrUpdate(new Article(0L, "Micro yeti", 150.0, LocalDate.of(2016, 1,10))),Matchers.samePropertyValuesAs(a));
    }

    //Verify
    @Test
    public void removeByIdTest() throws Exception {
        service.remove(1L);
        verify(repository).remove(anyLong());

    }

    @Test
    public void getByIdVerifyTest() throws Exception {
        service.getById(23L);
        service.getById(3L);
        service.getById(33L);

        verify(repository, times(3)).findById(anyLong());
        verify(repository, atLeastOnce()).findById(anyLong());
        verify(repository, atLeast(2)).findById(anyLong());
        verify(repository, never()).findAll();
    }
}
