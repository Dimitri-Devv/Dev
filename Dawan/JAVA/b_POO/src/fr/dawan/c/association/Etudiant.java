package fr.dawan.c.association;

public class Etudiant {


    int id;

    String nom;

    Notes notes;

    public Etudiant(int id, String nom, Notes notes ) {
        this.id = id;
        this.nom = nom;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Etudiant [id=" + id + ", nom=" + nom + ", notes=" + notes + "]";
    }
}
