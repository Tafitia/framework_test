package test;

import myframework.Controller;
import myframework.UrlAnnotation;
import myframework.ModelView;

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
    public String get() {
        return "Test ID trouvé!";
    }
}
