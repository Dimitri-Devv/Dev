package fr.dawan.g.exercices;

import java.util.Scanner;

//Ecrire un programme qui demande à l'utilisateur de rentrer un nombre entier et qui retourne sa racine carrée.


public class Exo2 {
	public static void main(String [] args) {
		Scanner clavier = new Scanner(System.in);
		
		
		
		System.out.print("Entre un entier :");
		int entier = clavier.nextInt();
		
		
		while (true) { // Boucle infinie qui ne s'arrêtera que quand l'entrée est valide
            System.out.print("Entrez un nombre entier positif ou nul : ");

            // 1. Si l'utilisateur a saisi un entier
            if (clavier.hasNextInt()) {
                entier = clavier.nextInt();

                // 2. Si c'est un entier, on vérifie s'il est positif
                if (entier >= 0) {
                    break; // L'entrée est valide, on sort de la boucle
                } else {
                    System.out.println("Erreur : Le nombre doit être positif.");
                }
            } else {
                System.out.println("Erreur : Ceci n'est pas un nombre entier valide.");
                clavier.next(); // on consomme l'entrée invalide pour éviter une boucle infinie
            }
        }

		
		int result = entier*entier; // Math.sqrt(entier)
		
		System.out.print("Racine carré de " + entier + " = " + result);
}
}
