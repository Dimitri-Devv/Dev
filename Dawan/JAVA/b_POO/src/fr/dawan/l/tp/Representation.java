package fr.dawan.l.tp;

public class Representation extends Employe {

    private int chiffreDAffaire;



    @Override
    public String getNom() {
        return "Representation";
    }

    @Override
    public int calculerSalaire() {
        return chiffreDAffaire*20/100 + 800;
    }

    @Override
    public double salaireMoyen() {
        return 0;
    }


    public Representation(String nom, String prenom, int age, int leChiffreDAffaire) {
        super(nom, prenom, age);
        this.chiffreDAffaire = leChiffreDAffaire;

    }
}
