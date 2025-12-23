package fr.dawan.springcore;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.dawan.springcore.beans.ArticleRepository;
import fr.dawan.springcore.beans.DataSource;

@Configuration // => classe de configuration
//@ComponentScan => cherche des composants dans le package fr.dawan.springcore
@ComponentScan(basePackages = "fr.dawan.springcore")
public class AppConf {

    // Déclarer un bean une méthode annotée avec @Bean
    // Le type de retour est le type du bean, le nom du bean et le nom de la méthode
    // L'attribut name de @Bean permet de définir le nom du bean (un ou plusieurs)
    // dans ce cas, le nom de la méthode n'est plus prix en compte
    @Bean
    DataSource dataSource1() {
        return new DataSource();
    }

    @Bean
    // @Primary => s'il y a plusieurs beans du même type, avec un @Autowired,
    // c'est le bean annoté avec @Primary qui sera sélectionné
    ArticleRepository repository2() {
        return new ArticleRepository();
    }

//  Une dépendance peut être matérialisé de manière explicite avec:
//  - les paramètres de la méthode
//    @Bean
//    ArticleService service1(ArticleRepository repository2) {
//        return new ArticleService(repository2);
//    }

//  - une méthode du bean qui en appelle une autre
//    @Bean
//    ArticleService service1() {
//        return new ArticleService(repository2());
//    }

    // Atelier
    @Bean
    ModelMapper mapper() {
        return new ModelMapper();
    }
}
