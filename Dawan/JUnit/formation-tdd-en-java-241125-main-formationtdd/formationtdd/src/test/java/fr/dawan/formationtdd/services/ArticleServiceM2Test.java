package fr.dawan.formationtdd.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.ArticleRepository;
import services.ArticleService;

import static org.mockito.Mockito.mock;
public class ArticleServiceM2Test {

    @Mock
    private ArticleRepository repository;


    private ArticleService service;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() throws Exception {
        //Méthode 2 -> création du Mock avec une annotation et MockitoAnnotations.openMocks
        closeable= MockitoAnnotations.openMocks(this);

        service=new ArticleService(repository);
    }

    @AfterEach
    public void tearDown() throws Exception {
        try{
            closeable.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //Test du service

}
