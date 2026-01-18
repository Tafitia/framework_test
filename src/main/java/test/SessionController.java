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

        ModelView mv = new ModelView();
        mv.setView("profile.jsp");

        mv.addAttributes("nomAffichage", nom);
        mv.addAttributes("emailAffichage", email);
        
        return mv;
    }

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