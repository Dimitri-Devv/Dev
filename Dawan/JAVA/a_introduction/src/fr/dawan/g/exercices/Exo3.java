package fr.dawan.g.exercices;

import java.util.Scanner;

/*
 * Vérifier si un nombre est pair ou impair
 * 
 * Un nombre pair est un multiple de 2.
 * 
 * Il peut s’écrire sous la forme b = 2*k avec k un entier :
 * 
 * 21 est un nombre impair car 21 = 2 * 10 + 1 (Le reste vaut 1 : R = 1)
 * 
 * 30 est un nombre pair car 30 = 2 * 15 (R = 0)
 */

public class Exo3 {
	public static void main(String [] args) {
		Scanner clavier = new Scanner(System.in);
		
		
		
		System.out.print("Entre un nombre :");
		int nombre = clavier.nextInt();
		
		if(nombre % 2 == 0) {
			System.out.print("Le nombre est pair");
		}else {
			System.out.print("Le nombre est impair");
		}
	}
}
