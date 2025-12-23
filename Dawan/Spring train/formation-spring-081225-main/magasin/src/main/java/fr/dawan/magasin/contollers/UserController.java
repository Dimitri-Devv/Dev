package fr.dawan.magasin.contollers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.magasin.entities.ateliers.Commande;
import fr.dawan.magasin.entities.ateliers.Produit;
import fr.dawan.magasin.entities.ateliers.User;
import fr.dawan.magasin.forms.UserForm;
import fr.dawan.magasin.repositories.UserRepository;
import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/admin/users")
    public String display(Model model) {
//        List<User> users=new ArrayList<>();
//        users.add(new User("John","Doe",LocalDate.of(1995, 3, 17),"jdoe@dawan.com","azerty"));
//        users.add(new User("Jane","Doe",LocalDate.of(1998, 7, 11),"janedoe@dawan.com","azerty"));
//        users.add(new User("Jo","Dalton",LocalDate.of(1987, 8, 7),"jdalton@dawan.com","azerty"));
//        users.add(new User("Yves","Roulo",LocalDate.of(2000, 1, 1),"yroulo@dawan.com","azerty"));
//        model.addAttribute("utilisateurs", users);

        List<User> users = repository.findAll();
        model.addAttribute("utilisateurs", users);
        return "users";
    }


    @GetMapping("/admin/users/delete/{id}")
    public String remove(@PathVariable long id) {
        Optional<User> user=repository.findById(id);
        if(user.isPresent()) {
            for(Commande c : user.get().getCommandes()) {
                for(Produit p : c.getProduits()) {
                    p.getCommandes().remove(c);
                }
            }
        }
        repository.deleteById(id);
        return "redirect:/admin/users";
    }

    // Exemple Formulaire
    @GetMapping("/admin/users/add")
    public String ajouter(@ModelAttribute UserForm userForm) {
        return "ajout_utilisateur";
    }
    
    @PostMapping("/admin/users/add")
    public ModelAndView ajouterPost(@Valid @ModelAttribute UserForm userForm,BindingResult result) {
        ModelAndView mdv=new ModelAndView();
        if(result.hasErrors()) {
            mdv.addObject("userForm",userForm);
            mdv.addObject("errors", result);
            mdv.setViewName("ajout_utilisateur");
        }
        else {
        System.out.println(userForm.toString());
        
        
        mdv.setViewName("redirect:/admin/users");
        }
        return mdv;
    }
    
    // Exemple Repository
    @GetMapping("/users/{nom}")
    public String getByNom(@PathVariable String nom, Model model) {
        model.addAttribute("utilisateurs", repository.findByNom(nom));
        return "users";
    }

    @GetMapping("/users/idmax/{idMax}")
    public String getByNom(@PathVariable long idMax, Model model) {
        List<User> lstUser = repository.findByIdGreaterThan(idMax);
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/{dateMin}/{dateMax}")
    public String getByNom(@PathVariable LocalDate dateMin, @PathVariable LocalDate dateMax, Model model) {
        List<User> lstUser = repository.findByDateNaissanceBetween(dateMin, dateMax);
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/nom/{nomMin}/{nomMax}")
    public String getByNom(@PathVariable String nomMin, @PathVariable String nomMax, Model model) {
        List<User> lstUser = repository.findByNomBetween(nomMin, nomMax);
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/nom/{nomMin}/date/{dateMax}")
    public String getByNom(@PathVariable String nomMin, @PathVariable LocalDate dateMax, Model model) {
        List<User> lstUser = repository.findByNomGreaterThanAndDateNaissanceLessThan(nomMin, dateMax);
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/email/{emailEnding}")
    public String getByEndingEmail(@PathVariable String emailEnding, Model model) {
        List<User> lstUser = repository.findByEmailEndingWith(emailEnding);
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/prenomlike")
    public String getByPrenomLike(Model model) {
        List<User> lstUser = repository.findByPrenomLike("_a%");
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/prenomlist")
    public String getByPrenomList(Model model) {
        List<User> lstUser = repository.findByPrenomIn("Maria", "Thomas", "Marcel");
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/emailtri/{emailEnding}")
    public String getByEndingEmailtri(@PathVariable String emailEnding, Model model) {
        List<User> lstUser = repository.findByEmailEndingWithOrderByDateNaissanceAscNom(emailEnding);
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/commandes/{dateCommandeMin}")
    public String getByDateCommande(@PathVariable LocalDate dateCommandeMin, Model model) {
        List<User> lstUser = repository.findByCommandesDateCommandeAfter(dateCommandeMin);
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/older")
    public String getByOlder(Model model) {
        Optional<User> user = repository.findTopByOrderByDateNaissance();
        List<User> lstUser = new ArrayList<>();
        lstUser.add(user.get());
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/younger")
    public String getBy5Younger(Model model) {
        List<User> lstUser = repository.findTop5ByOrderByDateNaissanceDesc();
        model.addAttribute("utilisateurs", lstUser);
        return "users";
    }

    @GetMapping("/users/naissance/{dateNaissance}")
    public String getByNaissance(@PathVariable LocalDate dateNaissance, Model model, Pageable page) {
        Page<User> p = repository.findByDateNaissanceAfter(dateNaissance, page);
        // Page<User> p=repository.findByDateNaissanceAfter(dateNaissance,
        // Pageable.unpaged());
        System.out.println(p.getNumber());
        System.out.println(p.getSize());
        System.out.println(p.getNumberOfElements());
        System.out.println(p.getTotalPages());
        System.out.println(p.getTotalElements());
        model.addAttribute("utilisateurs", p.getContent());
        return "users";

    }
    
    @GetMapping("/users/naissancemax/{date}")
    public String getByNaissanceMax(@PathVariable LocalDate date, Model model) {
        List<User> users=repository.getUserBornBefore(date);
        model.addAttribute("utilisateurs", users);
        return "users";
    }
}
