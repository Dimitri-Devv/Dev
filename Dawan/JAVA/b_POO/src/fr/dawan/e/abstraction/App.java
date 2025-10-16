package fr.dawan.e.abstraction;

public class App
{
    public static void main( String[] args )
    {
        //Forme f = new Forme(); Erreur

        //En tant que 'forme', on est certain que notre objet 'carre' a défini une méthode 'surface'
        Forme carre = new Carre(3);

        System.out.println("carre.surface() = " + carre.surface());

        Forme cercle = new Cercle(5);

        System.out.println("cercle.surface() = " + cercle.surface());
    }
}
