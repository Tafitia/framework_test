package util;

import java.util.List;

public class Departement {
    private String id;
    private String nom;
    private List<Employe> employes;

    public Departement() {
    }
    
    public Departement(String id, String nom, List<Employe> employes) {
        this.id = id;
        this.nom = nom;
        this.employes = employes;
    }
    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public List<Employe> getEmployes() {
        return employes;
    }
    // setters ici
    public void setId(String id) {
        this.id = id;
    }   
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
}
