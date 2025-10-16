
package fr.dawan.g.exercices;
//Permuter 2 variables
/*
* Exemple :
* Données d'entrée : a = 5, b = 9
* Sortie prévue :
* Avant l’échange : a = 5, b = 9
* Après l’échange : a = 9, b = 5
*/

import java.util.Scanner;

public class Exo1{
	public static void main(String [] args) {
		Scanner clavier = new Scanner(System.in);
		
		
		
		System.out.print("Entre un entier a :");
		int a = clavier.nextInt();
		
		System.out.print("Entre un autre entier  b:");
		int b = clavier.nextInt();
		
		System.out.println("Avant l'échange : a = " + a + " b = " + b);
		System.out.println("Après l'échange : a = " + b + " b = " + a);
	}
	
	
	
}
