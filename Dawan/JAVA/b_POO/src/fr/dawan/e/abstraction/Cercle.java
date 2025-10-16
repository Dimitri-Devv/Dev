package fr.dawan.e.abstraction;

public class Cercle extends Forme {

    private int rayon;

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        if(rayon < 0){
            throw new IllegalArgumentException("Rayon invalide");
        }else{
            this.rayon = rayon;
        }


    }

    public Cercle(int rayon){
        super();
        setRayon(rayon);
    }
    @Override
    public double surface() {
        return Math.round(Math.PI * rayon * rayon * 100) /100.0;
    }
}
