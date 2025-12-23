package fr.dawan.magasin.entities.ateliers;

import java.util.ArrayList;
import java.util.List;

import fr.dawan.magasin.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name="produits")
public class Produit extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(length=100,nullable=false)
    private String nom;

    @Column(nullable=false)
    private double prix;

    @Column(name="photo_path")
    private String photoPath;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Fournisseur fournisseur;
    
    @ToString.Exclude
    @ManyToMany
    private List<Commande> commandes=new ArrayList<>();
}
