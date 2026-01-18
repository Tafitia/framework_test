package test;

import myframework.*;
import myframework.util.*;

@Controller
public class SessionController {

    @UrlAnnotation(url = "/login")
    @RequestMapping("GET")
    public ModelView index() {
        ModelView mv = new ModelView();
        mv.setView("login.jsp"); 
        return mv;
    }

    @UrlAnnotation(url = "/login")
    @RequestMapping("POST")
    public ModelView login(SessionUtil session, @RequestParam("nom") String nom, String email) {
        
        session.add("user_nom", nom);
        session.add("user_email", email);

        if ("Tita".equalsIgnoreCase(nom)) {
            session.add("user_role", "manager");
        } else {
            session.add("user_role", "user");
        }

        ModelView mv = new ModelView();
        mv.setView("profile.jsp");

        mv.addAttributes("nomAffichage", nom);
        mv.addAttributes("emailAffichage", email);
        
        return mv;
    }

    @Auth("")
    @UrlAnnotation(url = "/profile")
    @RequestMapping("GET")
    public ModelView profil(SessionUtil session) {
        ModelView mv = new ModelView();

        Object nomSession = session.get("user_nom");
        Object emailSession = session.get("user_email");
        
        if (nomSession == null) {
            mv.setView("login.jsp");
            mv.addAttributes("error", "Session expirée, veuillez vous reconnecter.");
        } else {
            mv.setView("profile.jsp");
            mv.addAttributes("nomAffichage", nomSession);
            mv.addAttributes("emailAffichage", emailSession);
        }
        
        return mv;
    }

    @Auth("manager")
    @UrlAnnotation(url = "/admin")
    @RequestMapping("GET")
    public String pageAdmin() {
        return "<h1>Espace admin</h1> <p>Si vous voyez ça, c'est que vous avez le rôle 'manager'.</p>";
    }

    @UrlAnnotation(url = "/logout")
    @RequestMapping("GET")
    public ModelView logout(SessionUtil session) {
        session.invalidate(); 
        
        ModelView mv = new ModelView();
        mv.setView("login.jsp");
        mv.addAttributes("info", "Au revoir !");
        return mv;
    }
}