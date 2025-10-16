package fr.dawan.c.association;

import java.util.List;

public class Promotion {
    List<Etudiant> etudiants; // Les etudiants peuvent exister sans promo : Aggregation

    public Promotion(List<Etudiant> etudiants){
        this.etudiants = etudiants;

    }

    @Override
    public String toString(){
        return "Promotion [etudiants=" + etudiants + "]";
    }
}
