package test;

import myframework.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Test1Controller {

    @UrlAnnotation(url = "/upload")
    @RequestMapping("GET")
    public ModelView uploadForm() {
        ModelView mv = new ModelView();
        mv.setView("upload.jsp");
        return mv;
    }

    @UrlAnnotation(url = "/upload")
    @RequestMapping("POST")
    public String handleMultiUpload(Map<String, byte[]> files) {
        // Ta demande exacte : juste le nom du dossier
        String dir = "uploads"; 
        
        File uploadDir = new File(dir);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><body>");
        sb.append("<h2>Résultat Upload</h2>");
        
        // J'affiche le chemin absolu pour que tu saches où chercher sur ton disque !
        sb.append("<p>Dossier sur le disque : <strong>").append(uploadDir.getAbsolutePath()).append("</strong></p>");
        sb.append("<ul>");

        if (files != null) {
            for (Map.Entry<String, byte[]> entry : files.entrySet()) {
                String inputName = entry.getKey(); // ex: "file1"
                byte[] content = entry.getValue();
                
                // On sauvegarde avec le nom de l'input
                File destFile = new File(uploadDir, inputName);
                
                try (FileOutputStream fos = new FileOutputStream(destFile)) {
                    fos.write(content);
                    sb.append("<li>Fichier <strong>").append(inputName)
                      .append("</strong> sauvegardé (").append(content.length).append(" octets)</li>");
                } catch (Exception e) {
                    sb.append("<li>Erreur sur ").append(inputName).append("</li>");
                    e.printStackTrace();
                }
            }
        }
        sb.append("</ul></body></html>");
        return sb.toString();
    }
}