package fr.dawan.l.tp;

public class production extends Employe {


    private int nbUnite;



    @Override
    public String getNom() {
        return "Production";
    }

    @Override
    public int calculerSalaire() {
        return nbUnite*5;
    }



    public production(String nom, String prenom, int age, int nbUnite) {
        super(nom, prenom, age);
        this.nbUnite = nbUnite;

    }
}
