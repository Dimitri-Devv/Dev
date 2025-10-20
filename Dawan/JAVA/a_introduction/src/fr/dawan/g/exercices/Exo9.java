package fr.dawan.g.exercices;

import java.util.Scanner;
/* PGCD : Plus Grand Dénominateur Commun
 * Appliquer l’Algorithme d’Euclide qui dit :
 * si b divise a alors pgcd(a,b) = b
 * sinon pgcd(a,b) = pgcd(b, a mod b)
 * 
 * où a mod b est le reste de la division de a par b.
 * Ecrivez un programme permettant de trouver le PGCD à partir cet algorithme.
 */

public class Exo9 {

	// Méthode récursive selon l'algorithme d'Euclide
    public static int pgcd(int a, int b) {
        if (b == 0) {
            return a; // Si b divise a, alors pgcd(a, b) = a
        } else {
            return pgcd(b, a % b); // Sinon, pgcd(a, b) = pgcd(b, a mod b)
        }
    }

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        System.out.print("Entrez le premier nombre entier : ");
        int a = clavier.nextInt();

        System.out.print("Entrez le deuxième nombre entier : ");
        int b = clavier.nextInt();

        // On calcule le PGCD avec la méthode récursive
        int resultat = pgcd(a, b);

        System.out.println("Le PGCD de " + a + " et " + b + " est : " + resultat);

        clavier.close();
    }

}
