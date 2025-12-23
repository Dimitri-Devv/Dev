package fr.dawan.springcore.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)

@Repository("repository1")
@Primary
public class ArticleRepository {
    
    private String urlBdd; 

}
