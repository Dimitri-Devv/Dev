package fr.dawan.g.exercices;

import java.util.Scanner;

/*
 * Vérifier si un nombre est divisible par 3 et 13 ou non.
 * Un nombre entier est divisible par un autre quand
 * le résultat de la division euclidienne est un entier sans reste.
 * On peut écrire b = k*a + R, avec R = 0.
 */

public class Exo4 {
	public static void main(String [] args) {
		Scanner clavier = new Scanner(System.in);
		
		
		
		System.out.print("Entre un nombre :");
		int nombre = clavier.nextInt();
		
		if(nombre % 3 == 0 || nombre % 13 == 0) {
			System.out.print("Le nombre est divisible par 3 ou 13");
		}else {
			System.out.print("Le nombre n'est pas divisible par 3 ou 13");
		}
		
	}

}
