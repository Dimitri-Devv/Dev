package fr.dawan.magasin.contollers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.magasin.entities.ateliers.Produit;
import fr.dawan.magasin.repositories.ProduitRepository;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitRepository repository;

    @GetMapping("/prix/{prixMin}/{prixMax}")
    public String getByPrixInterval(@PathVariable double prixMin, @PathVariable double prixMax, Model model) {
        List<Produit> lstProduit = repository.findByPrixBetween(prixMin, prixMax);
        model.addAttribute("produits", lstProduit);
        return "produit";
    }

    @GetMapping("/search/{modele}")
    public String getByNomLike(@PathVariable String modele, Model model) {
        List<Produit> lstProduit = repository.findByNomLike(modele + "%");
        model.addAttribute("produits", lstProduit);
        return "produit";
    }

    @GetMapping
    public String getAllOrderByPrix(Model model) {
        List<Produit> lstProduit = repository.findByOrderByPrixDescNom();
        model.addAttribute("produits", lstProduit);
        return "produit";
    }

    @GetMapping("/categorie/{nom}")
    public String getBycategorie(@PathVariable String nom, Model model) {
        List<Produit> lstProduit = repository.findByCategorieNom(nom);
        model.addAttribute("produits", lstProduit);
        return "produit";
    }

    @GetMapping("/fournisseur/{nom}")
    public String getByfournisseur(@PathVariable String nom, Model model) {
        List<Produit> lstProduit = repository.findByFournisseurNom(nom);
        model.addAttribute("produits", lstProduit);
        return "produit";
    }

    @GetMapping("/commande/{date}")
    public String getByCommandeDate(@PathVariable LocalDate date, Model model) {
        List<Produit> lstProduit = repository.findByCommandesDateCommande(date);
        model.addAttribute("produits", lstProduit);
        return "produit";
    }

    @GetMapping("/top5prix")
    public String getTop5Prix(Model model) {
        List<Produit> lstProduit = repository.findTop5ByOrderByPrixDesc();
        model.addAttribute("produits", lstProduit);
        return "produit";
    }

    @GetMapping("/categorie/{nom}/top3prix")
    public String getTop3Categorie(@PathVariable String nom, Model model) {
        List<Produit> lstProduit = repository.findTop3ByCategorieNomOrderByPrix(nom);
        model.addAttribute("produits", lstProduit);
        return "produit";
    }

    @GetMapping("/categorie/jpql/{nom}")
    public String getBycategorieJPQL(@PathVariable String nom, Model model) {
        List<Produit> lstProduit = repository.getByCategorieNomJPQL(nom);
        model.addAttribute("produits", lstProduit);
        return "produit";
    }

    @GetMapping("/sommeprix/{date}")
    public String sommePrixCommande(@PathVariable LocalDate date, Model model) {
        double somme = repository.sommePrixCommande(date);
        System.out.println(somme);
        return "redirect:/admin/users";
    }

    @GetMapping("/augmentation/{pourcentage}")
    public String augmentation(@PathVariable double pourcentage, Model model) {
        repository.augmentationPrix(pourcentage);
        List<Produit> produits = repository.findAll();
        model.addAttribute("produits", produits);
        return "produit";
    }
}
