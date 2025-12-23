package fr.dawan.springcore.beans;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Exemple Lombok 

//Constructeurs
@NoArgsConstructor // -> Création d'un constructeur sans paramètre
@AllArgsConstructor // -> Création d'un constructeur avec un paramètre pour chaque variable
                    // d'instance
//@AllArgsConstructor(access = AccessLevel.PRIVATE) // On peut modifier la visibilitée du constructeur (par défaut Public)

@Getter // -> si on place @Getter sur la classe, on a un getter créer pour chaque
        // variable d'instance
@Setter // -> si on place @Setter sur la classe, on a un setter créer pour chaque
        // variable d'instance

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@EqualsAndHashCode -> par défaut equals et hashCode, pour toutes les variables d'instances 
//                  On peut ignorer une variable d'instance avec @Exclude  
//avec le paramètre onlyExplicitlyIncluded = true -> par défaut aucune variable d'instance n'est pas sélectionner
//                                       Il faut ajouter les variables avec @Include

@ToString(onlyExplicitlyIncluded = true, callSuper = true)
//@ToString -> par défaut toutes les variables d'instances sont utilisées pour toString 
//       On peut ignorer une variable d'instance avec @lombok.ToString.Exclude
//avec le paramètre onlyExplicitlyIncluded = true -> par défaut aucune variable n'est utilisé pour toString 
//                                             Il faut ajouter les variables avec @Include
//l'attribut callSuper = true permet:
//- pour @EqualsAndHashCode, d'appeler la méthode equals et la méthode hashcode de la classe parent, (sauf si la classe hérite de object -> erreur de compilation)
//- pour @ToString, d'appeler la méthode toString de la classe parent

//@Data => équivalant à @ToString, @Getter/@Setter @EqualsAndHashCode et @RequiredArgsConstructor

//@Value => équivalant à @Data mais pour créer des classes immuables
public class Article {

    @EqualsAndHashCode.Include // (avec onlyExplicitlyIncluded = true)
    @ToString.Include(name = "description de l'article", rank = 1)
    private String description;

    // @Getter
    @ToString.Include(rank = 2) // (avec onlyExplicitlyIncluded = true)
    private double prix;

    // @EqualsAndHashCode.Exclude
    // @ToString.Exclude
    // @Getter 1-> on peut aussi placer les annotation @Getter et @Setter sur la
    // variable d’instance
    // pour générer les getters et/ou les setters sur lequel elles sont placées
    // @Getter(value = AccessLevel.PROTECTED) // On peut définir la visibilité des
    // getter/setter (attribut value)
    @Setter(AccessLevel.NONE) // On peut ne pas générer le setter et/ou le getters pour un variable d'instance
    // si les annotations sont placées sur la classe, en donnant l'AccessLevel.NONE
    // l'annotation
    private LocalDate dateProduction;

    // On peut aussi définir ses propres constructeurs
    public Article(String description, double prix) {
        this.description = description;
        this.prix = prix;
    }

}
