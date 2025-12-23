package fr.dawan.magasin.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.magasin.entities.ateliers.Categorie;
import fr.dawan.magasin.entities.ateliers.Produit;

@Transactional
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
    List<Produit> findByPrixBetween(double prixMin, double prixMax);

    List<Produit> findByNomLike(String modele);

    List<Produit> findByOrderByPrixDescNom();
    
    List<Produit> findByCategorie(Categorie categorie);
    
    // path expression -> jointure interne
    List<Produit> findByCategorieNom(String nomCategorie);
    
    // Atelier
    
    List<Produit> findByFournisseurNom(String nomFournisseur);
    
    List<Produit> findByCommandesDateCommande(LocalDate dateCommande);
    
    List<Produit> findTop5ByOrderByPrixDesc();
    
    List<Produit> findTop3ByCategorieNomOrderByPrix(String nomCategorie);
    
    // JPQL path expression uniquement @OneToOne et @ManyToOne
    @Query("SELECT p FROM Produit p WHERE p.categorie.nom = :nomCategorie")
    List<Produit> getByCategorieNomJPQL(String nomCategorie);
    
    // Erreur -> commande c'est une relation @ManyToMany
   // @Query("SELECT p FROM Produit p WHERE p.commandes.dateCommande = dateCommande")
    // avec @ManyToMany et @OneToMany il faut utiliser une jointure
    @Query("SELECT p FROM Produit p JOIN p.commandes c WHERE c.dateCommande = dateCommande")
    List<Produit> getByCommandeDateJPQL(LocalDate dateCommande);
    
    // GROUP BY
    @Query("SELECT sum(p.prix) FROM Produit p JOIN p.commandes c WHERE c.dateCommande = :dateCommande GROUP BY c.dateCommande")
    double sommePrixCommande(LocalDate dateCommande);
    
    // SQL
    @Query(value="SELECT * FROM produits WHERE prix<:prixMax", nativeQuery = true)
    List<Produit> getByPrixInf(double prixMax);
    
    // JPQL -> UPDATE et DELETE
    @Modifying
    @Query("UPDATE Produit p SET p.prix=p.prix*:pourcentage")
    void augmentationPrix(double pourcentage);
}
