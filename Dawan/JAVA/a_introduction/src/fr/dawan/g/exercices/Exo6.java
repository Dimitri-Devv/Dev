package fr.dawan.g.exercices;

import java.util.Random;
import java.util.Scanner;

/*
 * L'utilisateur doit deviner un nombre secret (généré automatiquement) entre 1 et 1000.
 * On va donc demander à l'utilisateur de trouver ce nombre secret.
 * Tant qu'il n'a pas trouvé ce nombre on lui demandera encore et encore, jusqu'à ce qu'il le trouve.
 * Si l'utilisateur choisit un nombre trop petit, l'application lui dira que le nombre qu’il a rentré est trop petit
 * Si l'utilisateur choisit un nombre trop grand, l'application lui dira que le nombre qu’il a rentré est trop grand
 * Si l'utilisateur trouve le nombre recherché, l'application lui indiquera le nombre d'essais dont il a eu besoin
 * 
 * Exemple :
 * Entrée : Entrer un nombre entre 1 et 1000 (1 - 1000) : 500
 * Sorties possibles :
 * Votre nombre est trop grand !
 * Votre nombre est trop petit !
 * Trouvé en 8 essais ! Bien Joué !
 */

public class Exo6 {
	public static void main(String[] args) {
		int numberToFind = new Random().nextInt(0, 10);
		
		Scanner clavier = new Scanner(System.in);

		int nombrePropose = 0;
		int compteur = 0;
		
		while(numberToFind != nombrePropose) {
			compteur++;
			if(nombrePropose < numberToFind && compteur != 1) {
				System.out.println("Nombre trop petit !");
			}else if(nombrePropose > numberToFind && compteur != 1) {
				System.out.println("Nombre trop grand !");
			}
			System.out.print("Entrez un nombre entre 1 et 1000 : ");
	         nombrePropose = clavier.nextInt();
		}
		System.out.println("nombre trouvé en " + compteur + " essaie(s), bien joué !");
        
		
	}
}
