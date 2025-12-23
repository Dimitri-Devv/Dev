package fr.dawan.magasin.contollers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dawan.magasin.entities.Personne;
import fr.dawan.magasin.entities.ateliers.User;

@Controller
@RequestMapping("/exemple")
public class ExempleController {

    @GetMapping()
    public String exemple() {
        return "exemple";
    }

    // @RequestMapping => utilisée pour mapper les requêtes HTTP aux méthodes du
    // contrôleur
    // Model=> utilisé pour transférer des données entre la vue et le contrôleur
    @RequestMapping(value = { "/testmodel", "/model" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String testModel(Model model) {
        String message = "Test Model";
        model.addAttribute("msg", message);
        return "exemple";
    }

    // ModelAndView => permet de transmettre le nom de la vue et les attributs avec
    // un seul return
    @GetMapping("/testmodelandview")
    public ModelAndView testModelAndView() {
        // On peut passer le nom de la vue au constructeur
//      ModelAndView mdv=new ModelAndView("exemple");
        ModelAndView mdv = new ModelAndView();
        mdv.addObject("msg", "Test ModelAndView");
        mdv.setViewName("exemple"); // ou utiliser la méthode setViewName
        return mdv;
    }

    @GetMapping("/testthymeleaf")
    public String testThymeleaf(Model model) {
        int val = -102;
        model.addAttribute("val", val);

        User u1 = new User("John", "Doe", "1,rue Esquermoise Lille 59800", LocalDate.of(1995, 3, 17), "jdoe@dawan.com",
                "azerty", new HashSet<>());
        model.addAttribute("utilisateur", u1);

        double tab[] = { 1.2, 5.6, 3.4, 7.1, 8.9 };
        model.addAttribute("tab", tab);

        Map<String, Integer> m = new HashMap<>();
        m.put("Yves", 56);
        m.put("John", 34);
        m.put("Alan", 52);
        m.put("Jane", 26);
        model.addAttribute("ages", m);

        model.addAttribute("v1", 25);
        model.addAttribute("datejour", LocalDate.now());
        model.addAttribute("phrase", "Il ne pleut pas aujourd'hui");

        return "exemplethymeleaf";
    }

    @GetMapping(value = "/testparams", params = "id")
    public String testParam(Model model) {
        model.addAttribute("msg", "La requete testparams à un paramètre id");
        return "exemple";
    }

    @GetMapping(value = "/testparamsvalue", params = "id=21")
    public String testParamValue(Model model) {
        model.addAttribute("msg", "La requete testparamsvalue à un paramètre id égal à 21");
        return "exemple";
    }

    // PathVariable
    @GetMapping("/testpath/{id}")
    // public String testPathVariable(@PathVariable("id") String idValue) {
    public String testPathVariable(@PathVariable String id, Model model) {
        model.addAttribute("msg", "path id=" + id);
        return "exemple";
    }

    @GetMapping("/testpathmulti/{id}/{nom}")
    public String testPathVariableMulti(@PathVariable String id, @PathVariable String nom, Model model) {
        model.addAttribute("msg", "path id=" + id + " nom=" + nom);
        return "exemple";
    }

    @GetMapping("/testpathmap/{id}/{nom}")
    public String testPathVariableMap(@PathVariable Map<String, String> m, Model model) {
        model.addAttribute("msg", "path id=" + m.get("id") + " nom=" + m.get("nom"));
        return "exemple";
    }

    @GetMapping("/testpathamb/{id:[0-9]+}")
    public String testPathAmbigue1(@PathVariable String id, Model model) {
        model.addAttribute("msg", "paramètre de chemin id=" + id);
        return "exemple";
    }

    // @GetMapping("/testpathamb/{nom:[a-zA-Z ]+}")
    @GetMapping("/testpathamb/{nom:^\\D[\\w]+}")
    public String testPathAmbigue2(@PathVariable String nom, Model model) {
        model.addAttribute("msg", "paramètre de chemin nom=" + nom);
        return "exemple";
    }

    // RequestParam
    @GetMapping("/testparam")
    // public String testParam(@RequestParam("id") String idParam,Model model)
    public String testParam(@RequestParam String id, Model model) {
        model.addAttribute("msg", "paramètre de requête id=" + id);
        return "exemple";
    }

    @GetMapping("/testparammulti")
    public String testParamMulti(@RequestParam String id, @RequestParam String nom, Model model) {
        model.addAttribute("msg", "paramètres de requêtes id=" + id + " nom=" + nom);
        return "exemple";
    }

    @GetMapping("/testparammap")
    public String testParam(@RequestParam Map<String, String> m, Model model) {
        model.addAttribute("msg", "paramètres de requêtes id=" + m.get("id") + " nom=" + m.get("nom"));
        // | clé | valeur
        // | id | 42
        // | nom | marcel
        return "exemple";
    }

    @GetMapping(value = "/testparamamb", params = "id")
    public String testParamAmbigue1(@RequestParam String id, Model model) {
        model.addAttribute("msg", "paramètre de requête id=" + id);
        return "exemple";
    }

    @GetMapping(value = "/testparamamb", params = "nom")
    public String testParamAmbigue2(@RequestParam String nom, Model model) {
        model.addAttribute("msg", "paramètre de requête nom=" + nom);
        return "exemple";
    }

    @GetMapping({ "/testpathop/{id}", "/testpathop" })
    public String testPathoptionnel(@PathVariable(required = false) String id, Model model) {
        model.addAttribute("msg", "paramètre de chemin optionnel id=" + id);
        return "exemple";
    }

    @GetMapping({ "/testpathop2/{id}", "/testpathop2" })
    public String testPathoptionnel(@PathVariable Optional<String> id, Model model) {
        if (id.isEmpty()) {
            model.addAttribute("msg", "Il n'y a pas de paramètre");
        } else {
            model.addAttribute("msg", "paramètre de chemin optionnel id=" + id.get());
        }
        return "exemple";
    }

    @GetMapping("/testparamdefault")
    public String testParamDefault(@RequestParam(defaultValue = "doe") String nom, Model model) {
        model.addAttribute("msg", "paramètre de requête nom=" + nom);
        return "exemple";
    }

    @GetMapping("/testheader")
    public String testHeader(@RequestHeader("user-agent") String userAgent, Model model) {
        model.addAttribute("msg", userAgent);
        return "exemple";
    }

    @GetMapping("/testheaders")
    public String testHeaders(@RequestHeader HttpHeaders headers, Model model) {
        List<String> lstHeader = new ArrayList<>();
        var entry = headers.headerSet();
        for (var e : entry) {
            String entete = e.getKey() + "= ";
            for (String v : e.getValue()) {
                entete += v + " ";
            }
            lstHeader.add(entete);
        }
        model.addAttribute("headers", lstHeader);
        return "exemple";
    }

    // Conversion
    @GetMapping("/testconv/{id}")
    public String testPathConv(@PathVariable int id, Model model) {
        model.addAttribute("msg", "id=" + id);
        return "exemple";
    }

    @GetMapping("/testconvdate/{date}")
    public String testConvDate(@DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable LocalDate date, Model model) {
        model.addAttribute("msg", date.toString());
        return "exemple";
    }

    // Lier des objets
    @GetMapping("/testpathbind/{id}/{prenom}/{nom}")
    public String testPathBind(Personne p, Model model) {
        model.addAttribute("msg", p.toString());
        return "exemple";
    }

    @GetMapping("/testparambind")
    public String testParamBind(Personne p, Model model) {
        model.addAttribute("msg", p.toString());
        return "exemple";
    }

    // Redirection
    @GetMapping("/testredirect") // 302
    public String testRedirect() {
        return "redirect:/hello";
    }

    @GetMapping("/testforward") // du coté serveur
    public String testForward() {
        return "forward:/hello";
    }
    
    // ModelAttribute sur une méthode
    @ModelAttribute("datejour")
    public LocalDateTime testModelAttribute() {
        return LocalDateTime.now();
    }
    
    @ModelAttribute
    public void testModelAttribute2(Model model) {
        model.addAttribute("per1", new Personne(42L,"yves", "Roulo"));
    }
    
    @GetMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("per1") Personne personne,Model model) {
        model.addAttribute("msg", personne.toString());
        return "exemple";
    }
    
    // Flash Attribute
    @GetMapping("/testflash")
    public String testFlashAttribute(RedirectAttributes rAtt) {
        rAtt.addFlashAttribute("message", "Vous venez d'être redirigé");
        return "redirect:/exemple/cibleflash";
    }
    
    @GetMapping("/cibleflash")
    public String testFlashCible(@ModelAttribute("message") String messageFlash, Model model) {
        model.addAttribute("msg", messageFlash);
        return "exemple";
    }
}
