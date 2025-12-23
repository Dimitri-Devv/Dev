package fr.dawan.springboot;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		 SpringApplication.run(SpringbootApplication.class, args);
	   
		
//	    SpringApplication app=new SpringApplication(SpringbootApplication.class);
//	    app.setAddCommandLineProperties(false);
//	    app.setBannerMode(Mode.OFF);
//	    app.run(args);
	}

}
