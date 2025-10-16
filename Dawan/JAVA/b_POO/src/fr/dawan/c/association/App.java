package fr.dawan.c.association;

import java.util.ArrayList;
import java.util.List;

public class App
{
    /*
    Une relation d'association est une relation de type "possède, a (avoir)". Exemple, un étudiant "possède des notes"

    Aggregation vs Composition

    Le zèbre appartient à un troupeau. Le zèbre peut exister sans le troupeau : Relation d'aggrégation
    L'appartement possède une cuisine. La cuisine ne peut pas exister sans l'appartement : Relation de composition.
    (aggregation forte)
     */
    public static void main(String[] args)
    {
        Notes notes = new Notes(12,4);

        Etudiant e1 = new Etudiant(1, "Riri", notes);

        Etudiant e2 = new Etudiant(2, "Ron", new Notes(13,14));

        List<Etudiant> l1 = new ArrayList<Etudiant>();

        l1.add(e1);
        l1.add(e2);

        Promotion p1 = new Promotion(l1);

        System.out.println(p1);

        System.out.println(e1.toString());
    }
}
