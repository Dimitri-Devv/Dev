package fr.dawan.e.abstraction;


/*
Une classe abstraite :

- contient au moins une méthode abstraite
- peut contenir des méthodes non abstraites
- peut contenir des constructeurs MAIS ne peut pas être instanciée(les constructeurs servent aux classes filles)


Une classe qui hérite d'une classe abstraite est OBLIGE d'implémenter toutes les méthodes abstraites de leur classe mère
 */
public abstract class Forme
{
    private String couleur;

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Forme() {
        System.out.println("Constructeur sans paramètre de la classe abstraite 'Forme'");
    }
    //Les classes filles seront OLIGES d'implémenter la méthode surface
    public abstract double surface();

    //Les classes filles pourront optionnellement overrider la méthode non abstraite
    public void methodeNonAbstraite() {
        System.out.println("je suis une methode non abstraite dans une classe abstraite");
    }
}
