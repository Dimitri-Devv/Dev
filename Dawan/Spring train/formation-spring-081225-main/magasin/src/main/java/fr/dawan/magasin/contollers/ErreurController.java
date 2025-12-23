package fr.dawan.magasin.contollers;

import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErreurController implements ErrorController {

    @GetMapping("/erreur")
    public String gestionnaireErreur(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            model.addAttribute("codeStatus", status.toString());
            switch (status.toString()) {
            case "404" -> model.addAttribute("msgErr", "La page est introuvable");
            case "401" -> model.addAttribute("msgErr", "Vous n'êtes pas authentifié pour accèder à cette page");
            case "403" -> model.addAttribute("msgErr", "Vous n'êtes pas authorisé à accèder à cette page");
            case "500" -> model.addAttribute("msgErr", "Erreur Interne");
            default -> model.addAttribute("msgErr", "Autre erreur");
            }
        }
        return "erreur";
    }

}
