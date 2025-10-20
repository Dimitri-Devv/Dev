package fr.dawan.l.tp;

public abstract class Employe implements IPersonnel {

    private String nom;
    private String prenom;
    private int age;
    private String dateEntree;
    private int salaire;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDateEntree() {
        return dateEntree;
    }
    public void setDateEntree(String dateEntree) {
        this.dateEntree = dateEntree;
    }

    public int getSalaire() {
        return salaire;
    }
    public void setSalaire(int salaire) {
        this.salaire = salaire;

    }

    public abstract int calculerSalaire();


    public Employe() {

    }

    public Employe(String nom, String prenom, int age) {
        nom = getNom();
        prenom = getPrenom();
        age = getAge();
        dateEntree = getDateEntree();
    }

    public void ajouterEmploye(Employe employe ) {
         System.out.println("L'Employe " + employe.nom + " " + employe.prenom + " a bien été ajouté !");
    }
}
