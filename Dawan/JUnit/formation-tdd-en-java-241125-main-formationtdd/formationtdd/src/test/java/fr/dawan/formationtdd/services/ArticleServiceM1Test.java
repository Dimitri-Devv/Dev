package fr.dawan.formationtdd.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import repositories.ArticleRepository;
import services.ArticleService;

import static org.mockito.Mockito.mock;

public class ArticleServiceM1Test {

    private ArticleRepository repository;


    private ArticleService service;

    @BeforeEach
    public void setUp() throws Exception {
        //Méthode 1 -> création
        repository=mock(ArticleRepository.class);
        service=new ArticleService(repository);
    }


}
