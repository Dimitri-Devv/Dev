package fr.dawan.magasin.entities.ateliers;

import java.time.LocalDate;
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
@Table(name = "commandes")
public class Commande extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, name = "date_commande")
    private LocalDate dateCommande;

    @ToString.Exclude
    @ManyToMany(mappedBy = "commandes")
    private List<Produit> produits = new ArrayList<>();
    
    @ManyToOne
    private User user;
}
