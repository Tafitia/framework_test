package util;

public class Employe {
    private String id;
    private String nom;
    private Departement departement;

    public Employe() {
    }
    
    public Employe(String id, String nom, Departement departement) {
        this.id = id;
        this.nom = nom;
        this.departement = departement;
    }

    public String getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public Departement getDepartement() {
        return departement;
    }
    // setters ici
    public void setId(String id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}