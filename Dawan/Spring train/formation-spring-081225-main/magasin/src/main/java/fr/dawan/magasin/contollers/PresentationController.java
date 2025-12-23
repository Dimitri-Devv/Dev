package fr.dawan.magasin.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/presentation")
public class PresentationController {

    @GetMapping()
    public String presentation() {
        return "presentation";
    }

    @GetMapping("/path/{prenom}/{nom}")
    public String presentationPath(@PathVariable String prenom, @PathVariable String nom, Model model) {
        model.addAttribute("prenom", prenom);
        model.addAttribute("nom", nom);
        return "presentation";
    }

    @RequestMapping(value = "/param", method= {RequestMethod.GET,RequestMethod.POST})
    public String presentationParam(@RequestParam String prenom, @RequestParam String nom, Model model) {
        model.addAttribute("prenom", prenom);
        model.addAttribute("nom", nom);
        return "presentation";
    }
}
