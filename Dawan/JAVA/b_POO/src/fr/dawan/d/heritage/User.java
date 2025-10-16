package fr.dawan.d.heritage;

public class User {

    protected String nom;
    private String prenom;
    private int age;

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

    private static int nUsers;

    public static int getnUsers(){
        return nUsers;
    }

    public User(){
        nUsers++;
    }

    public User(String nom, String prenom){
        this();
        this.nom = nom;
        this.prenom = prenom;
    }
    public User(String nom, String prenom, int age) {
        this(nom, prenom);
        this.age = age;
    }

    @Override
    public String toString(){
        return "User [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
    }

    public void faiUnTruc(){
        System.out.println("faiUnTruc");
    }


    public void faitUnTruc(){
        System.out.println("faitUnTruc");
    }
}
