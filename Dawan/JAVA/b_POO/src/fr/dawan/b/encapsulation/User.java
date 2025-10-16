package fr.dawan.b.encapsulation;

public class User {


    public String nom;
    public String prenom;
    //public int age;
    private int age;

    //Getter and Setter
    public int getAge() { //Getter : permet d'accéder à l'âge en lecture
        return this.age;
    }

    public void setAge(int value) { //setter : permet de récupérer l'age
        if(value < 0){
            System.out.println("Erreur : un age doit être positif");

            //throw new IllegalArgumentException("Un age doit être positif");
        }else{
            this.age = value;
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static int getnUsers() {
        return nUsers;
    }

    private static int nUsers;

    public User() {
        nUsers++;
    }
    //

    public User(String nom, String prenom) {

        this();
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(String nom, String prenom, int age) {

        this(nom, prenom);
        this.age = age;
    }
    //Redéfinition de la méthode toString() qui appartient la classe Objet
    //La classe Object est la classe mère de toutes les classes. N'importe quelle classe est forcément une fille,
    // une petite fille,ou une arrière-petite-fille de la classe Object. A ce titre toutes les classes ont accès aux méthodes de la classe
    // Object, parmis lesquelles,
    // la méthode toString() qui permet de représenter un objet sous forme de chaine de caractères.


    @Override
    public String toString(){
        return prenom + " " + nom + " a " + age + " ans.";
    }
}
