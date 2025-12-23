package fr.dawan.springcore.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // => Création d'un constructeur sans paramètre
@AllArgsConstructor // => Création d'un constructeur avec un paramètre pour chaque variable d'instance
@Getter // => si on place @Getter sur la classe, on a un getter créer pour chaque variable d'instance
@Setter // => si on place @Setter sur la classe, on a un setter créer pour chaque variable d'instance
@ToString // => par défaut toutes les variables d'instances sont utilisées pour toString
// ou @Data
public class DataSource {

    private String url;
    
}
