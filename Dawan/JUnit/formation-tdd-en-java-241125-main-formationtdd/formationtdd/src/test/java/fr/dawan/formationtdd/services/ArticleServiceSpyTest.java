package fr.dawan.formationtdd.services;

import beans.Article;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.ArticleRepository;
import services.ArticleService;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceSpyTest {
    @Spy
    private ArticleRepository repository;

    @InjectMocks
    private ArticleService service;

    @Test
    public void getByIdTest() throws Exception {
        Article a=new Article(42L,"description",30.0, LocalDate.of(2023,1,5));
        doReturn(a).when(repository).findById(42L);

        assertThat(service.getById(42L), Matchers.samePropertyValuesAs(a));

    }

    //Appel de la méthode réel findAll de l'objet repository
    @Test
    public void getAll() throws Exception {
        assertEquals(5,service.getAll().size());
    }

}
