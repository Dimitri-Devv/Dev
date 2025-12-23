package fr.dawan.formationtdd.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.ArticleRepository;
import services.ArticleService;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceM3Test {

    private ArticleRepository repository;


    private ArticleService service;

    @BeforeEach
    public void setUp() throws Exception {

        service=new ArticleService(repository);
    }


}
