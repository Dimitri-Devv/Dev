package fr.dawan.magasin.entities.ateliers;

import java.util.HashSet;
import java.util.Set;

import fr.dawan.magasin.entities.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "categories")
public class Categorie extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(length=60,nullable=false)
    private String nom;

    @Column(length=100)
    private String description;
    
    @ToString.Exclude
    @OneToMany(mappedBy="categorie",cascade= {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    private Set<Produit> produits=new HashSet<>();
}
