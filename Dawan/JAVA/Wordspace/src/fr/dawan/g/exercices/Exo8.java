package fr.dawan.g.exercices;

import java.util.Scanner;

/*
 * Demander à l'utilisateur de choisir un nombre entier et retourner sa
 * factorielle. Utiliser la récursivité.
 * n! = n*(n-1)! si n!=1
 * 1! = 1;
 */

public class Exo8 {
	// Méthode récursive pour calculer la factorielle
    public static long factorielle(int n) {
        if (n == 1 || n == 0) {
            return 1; // 0! = 1 et 1! = 1
        } else {
            return n * factorielle(n - 1); 
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner clavier = new Scanner(System.in);

        System.out.print("Entrez un nombre entier : ");
        int nombre = clavier.nextInt();

        if (nombre < 0) {
            System.out.println("La factorielle n'est pas définie pour les nombres négatifs !");
        } else {
            long resultat = factorielle(nombre);
            System.out.println("La factorielle de " + nombre + " est : " + resultat);
        }

        clavier.close();
        
        
	}

}
