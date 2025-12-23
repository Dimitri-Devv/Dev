package fr.dawan.springcore;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dawan.springcore.atelier.UserService;
import fr.dawan.springcore.beans.Article;
import fr.dawan.springcore.beans.ArticleRepository;
import fr.dawan.springcore.beans.ArticleService;
import fr.dawan.springcore.beans.DataSource;
import fr.dawan.springcore.beans.User;

public class App {
    public static void main(String[] args) {

        // Exemple lombok
        Article a1 = new Article("Tv 4k", 600.0, LocalDate.of(2024, 10, 1));
        User u1 = new User("Test");
        System.out.println(u1);
        
        System.out.println(a1.getPrix());
        a1.setPrix(650.0);

        Article a2 = new Article("Tv 4k", 500.0, LocalDate.of(2023, 10, 1));
        System.out.println(a1.equals(a2));

        System.out.println(a1);

        // Spring Core
        // Création du conteneur d'ioc
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
        DataSource d1 = ctx.getBean("dataSource1", DataSource.class);
        System.out.println(d1);

        ArticleRepository r1 = ctx.getBean("repository1", ArticleRepository.class);
        System.out.println(r1);

        ArticleService s1 = ctx.getBean("service1", ArticleService.class);
        System.out.println(s1);

        UserService us1 = ctx.getBean("userservice", UserService.class);
        System.out.println(us1);

        ((AbstractApplicationContext) ctx).close();
    }
}
