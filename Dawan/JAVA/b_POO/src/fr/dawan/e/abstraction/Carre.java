package fr.dawan.e.abstraction;

public class Carre extends Forme{

    private int cote;

    public int getCote() {
        return cote;
    }
    public void setCote(int cote) {
        this.cote = cote;
    }

    public Carre(int cote) {
        super();
        setCote(cote);
    }

    // En tant que fille de la classe abstraite 'Forme', la classe Carre est obligée d'implémenter l'ensemble des méthodes abstraites
    // de la classe 'Forme'. La classe 'Forme'contient une méthode : la méthode surface. Donc la classe 'Carre' est obligé
    // d'implémenter la méthode 'surface'.
    @Override
    public double surface() {
        return cote * cote;
    }
}
