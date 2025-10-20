package fr.dawan.l.tp;

public class Manutention extends Employe {

    private int nbHeure;



    @Override
    public String getNom() {
        return "Manutention";
    }

    @Override
    public int calculerSalaire() {
        return nbHeure*65;
    }

    @Override
    public double salaireMoyen() {
        return 0;
    }


    Manutention(int chiffreDAffaire) {}
    public Manutention(String nom, String prenom, int age, int nbHeure) {
        super(nom, prenom, age);
        this.nbHeure = nbHeure;

    }



}
