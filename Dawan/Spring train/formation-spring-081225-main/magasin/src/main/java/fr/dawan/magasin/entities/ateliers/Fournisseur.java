package fr.dawan.magasin.entities.ateliers;

import java.util.HashSet;
import java.util.Set;

import fr.dawan.magasin.entities.BaseEntity;
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
@Table(name = "fournisseurs")
public class Fournisseur extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(length = 150, nullable = false)
    private String nom;

    private String adresse;

    @Column(length = 25)
    private String telephone;

    @ToString.Exclude
    @OneToMany(mappedBy = "fournisseur")
    private Set<Produit> produits = new HashSet<>();
}
