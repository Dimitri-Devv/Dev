package fr.dawan.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("service1")
public class ArticleService {

    // @Autowired -> @Autowired peut être placé sur les variables d'instances
    // injection en utilisant la réflexion

    @Autowired
    @Qualifier("repository2")
    // Injection automatique de la dépendence. Un bean de type ArticleRepository est
    // recherché dans le conteneur d'ioc et il est injecté dans la variable
    // d'instance repository
    // s'il y a plusieurs bean une exception est générée, à moins de lever
    // l'ambiguité avec @Primary ou @Qualifier

    // @Autowired(required = false)
    // required = false-> dépendence optionnelle: s'il n'y a pas de bean de type
    // ArticleRepository dans le conteneur -> repository= null et pas d'exception
    private ArticleRepository repository;

    public ArticleService() {
        System.out.println("Constructeur par défaut");
    }

    // @Autowired peut être placé sur le constructeur uniquement, s'il y en a
    // plusieurs pour indiquer celui qui doit être utilisé.
    // s'il y a un constructeur, il n'est pas nécessaire.
    @Autowired
    public ArticleService(/* @Qualifier("repository2") */ ArticleRepository repository) {
        this.repository = repository;
        System.out.println("Constructeur un paramètre");
    }

    public ArticleRepository getRepository() {
        return repository;
    }

    // @Autowired -> @Autowired peut être placé sur les setter
    public void setRepository( /* @Qualifier("repository2") */ ArticleRepository repository) {
        this.repository = repository;
        System.out.println("Setter");
    }

    @Override
    public String toString() {
        return "ArticleService [repository=" + repository + ", toString()=" + super.toString() + "]";
    }

    

}
