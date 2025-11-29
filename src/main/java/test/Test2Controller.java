package test;

import myframework.*;

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
}
