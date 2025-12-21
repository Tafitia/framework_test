package test;

import myframework.*;
import util.Employe;
import util.Departement;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class Test2Controller {
    @UrlAnnotation(url = "/hello")
    public String hello() {
        return """
            <!DOCTYPE html>
            <html lang="fr">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Test Page</title>
            </head>
            <body>
                <h1>HELLO Coucou</h1>
            </body>
            </html>
            """;
    }

    @UrlAnnotation(url = "/test")
    public ModelView test() {
        ModelView mv = new ModelView();
        mv.setView("test.jsp");
        String[] persons = { "Iratra", "Tafita", "Itia" };
        mv.addAttributes("persons", persons);
        return mv;
    }

    @UrlAnnotation(url = "/data")
    public double data() {
        return 18;
    }

    @UrlAnnotation(url = "/tests/{id}")
    public String get(String id) {
        return "Test ID trouvé!" + id;
    }

    @UrlAnnotation(url = "/form-test")
    @RequestMapping("POST")
    public String formTest(@RequestParam("name") String param, int id, String name) {
        return """
            <!DOCTYPE html>
            <html lang="fr">
            <head>
                <meta charset="UTF-8">
                <title>Form Test</title>
            </head>
            <body>
                <h1>Resultat du formulaire</h1>
                <p>ID : """ + id + """
                </p>
                <p>Nom : """ + name + """
                </p>
                <p>param : """ + param + """
                </p>
            </body>
            </html>
            """;
    }

   @UrlAnnotation(url = "/formulaire")
   @RequestMapping("GET")
    public ModelView afficherFormulaire() {
        ModelView mv = new ModelView();
        mv.setView("simple-form.jsp"); 
        return mv;
    }

   @UrlAnnotation(url = "/formulaire")
    @RequestMapping("POST")
    public ModelView traiterFormulaire(String nom) {
        ModelView mv = new ModelView();
        mv.setView("simple-result.jsp");
        mv.addAttributes("leNom", nom); 
        return mv;
    }

    @UrlAnnotation(url = "/info")
    @RequestMapping("GET")
    public ModelView formInfo() {
        ModelView mv = new ModelView();
        mv.setView("infos.jsp");
        return mv;
    }

    @UrlAnnotation(url = "/info")
    @RequestMapping("POST")
    public String traiterInfos(Map<String, Object[]> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><body>");
        sb.append("<h2>Résultats du formulaire</h2>");

        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            sb.append("<p><strong>").append(entry.getKey()).append("</strong> : ");
            Object[] values = entry.getValue();
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    Object val = values[i];
                    sb.append(val);
                    if (i < values.length - 1) sb.append(", ");
                }
            } else {
                sb.append("null");
            }
            sb.append("</p>");
        }

        sb.append("</body></html>");
        return sb.toString();
    }

    @UrlAnnotation(url = "/form-emp")
    @RequestMapping("GET")
    public ModelView formEmploye() {
        ModelView mv = new ModelView();
        mv.setView("emp-form.jsp");
        return mv;
    }

    @UrlAnnotation(url = "/form-emp")
    @RequestMapping("POST")
    public String handleDepartementForm(Departement d, Employe[] liste) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body>");
        sb.append("<h2>Details du Departement soumis</h2>");
        sb.append("<p><strong>ID Dept :</strong> ").append(d.getId()).append("</p>");
        sb.append("<p><strong>Nom Dept :</strong> ").append(d.getNom()).append("</p>");
        sb.append("<h3>Liste des employes :</h3>");
        
        if (liste != null && liste.length > 0) {
            sb.append("<ul>");
            for (int i = 0; i < liste.length; i++) {
                Employe emp = liste[i];
                sb.append("<li>")
                  .append("Index ").append(i).append(" : ")
                  .append(emp.getNom())
                  .append(" (ID: ").append(emp.getId()).append(")")
                  .append("</li>");
            }
            sb.append("</ul>");
        } else {
            sb.append("<p>Aucun employé soumis.</p>");
        }
        sb.append("<br><a href='form-dept'>Retour</a>");
        sb.append("</body></html>");
        return sb.toString();
    }

    @UrlAnnotation(url = "/api/employes")
    @Json
    @RequestMapping("GET")
    public List<Employe> apiList() {
        List<Employe> liste = new ArrayList<>();
        
        Departement dep = new Departement("D1", "IT", null);
        
        Employe e1 = new Employe();
        e1.setId("1"); e1.setNom("Jean"); e1.setDepartement(dep);
        
        Employe e2 = new Employe();
        e2.setId("2"); e2.setNom("Paul"); e2.setDepartement(dep);
        
        liste.add(e1);
        liste.add(e2);
        
        return liste;
    }

    // TEST 2 : OBJET UNIQUE -> Renvoie { data: { ... } } (Pas de count)
    @UrlAnnotation(url = "/api/employe-seul")
    @Json
    @RequestMapping("GET")
    public Employe apiOne() {
        Employe e = new Employe();
        e.setId("99");
        e.setNom("Super Admin");
        return e;
    }
}
