package fr.dawan.a.constructor;

public class User {

    //public : ne respecte pas le principe d'encapsulation (voir chapitre suivant)
    public String nom;
    public String prenom;
    public int age;

    //Un constructeur est méthode qui :
    // - porte le même nom que la classe (ici User)
    // - ne spécifie pas de type de retour dans sa signature
    // - est appelé automatiquement via le mot clé 'new' lorsque l'on instancie la classe


    /*
    nom, prenom et age sont des attributs d'instance : chaque instance de la classe User de ses propres nom, prenom et age

    Il existe des variables (attributs / méthode) dites "de classe". Ces variables / méthodes sont communes à toutes les instances de la classe. Pour définir une variable / méthode de classe, on utilise le mot clé "static"

     */

    public static int nUsers;
    //Constructeur sans paramètre (crée implicitement par défaut en l'absence de tout autre constructeur défini)
    public User() {
        nUsers++;
    }
    //
     //surcharge du constructeur à 2 paramètres de type String
    public User(String nom, String prenom) {
        //this : fait référence à l'objet courant
        this();
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(String nom, String prenom, int age) {
        //this : fait référence à l'objet courant
//        this.nom = nom;
//        this.prenom = prenom;
        this(nom, prenom); // appel au constructeur à 2 paramètres pour initialiser le nom et le prénom
        this.age = age;
        //nUsers++; ( la variable est déjà incrémenté via l'appel du constructeur à 2 paramètres
    }
}
