package fr.dawan.l.tp;

public class Vente extends Employe {

    private int chiffreDAffaire;



    @Override
    public String getNom() {
        return "Vente";
    }

    @Override
    public int calculerSalaire() {
        return chiffreDAffaire*20/100 + 400;
    }

    @Override
    public double salaireMoyen() {
        return 0;
    }


    public Vente(String nom, String prenom, int age, int leChiffreDAffaire) {
        super(nom, prenom, age);
        this.chiffreDAffaire = leChiffreDAffaire;

    }


}
