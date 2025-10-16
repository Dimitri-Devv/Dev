
package fr.dawan.g.exercices;
import java.util.Scanner;
/*
 * 
 * En mathématiques, la suite de Fibonacci est une suite d'entiers dans laquelle chaque terme est la somme des deux termes qui le précèdent.
 * Elle commence par les termes 0 et 1 si on part de l'indice 0, ou par 1 et 1 si on part de l'indice 1.
 * Dans les exercices suivants, nous nous concentrerons sur des tableaux à une dimension. Nous vous montrerons comment implémenter et utiliser des tableaux.
 * 
 * Exemple : 1 1 2 3 5 8 13 21 34….
 * 
 * Notée (Fn), elle est donc définie par :
 * 
 * F0 = 0,
 * F1 = 1 et
 * Fn = Fn-1 + Fn-2 pour n >= 2
 * 
 * On peut définir cette suite par récurrence.
 * 
 * On initialise les formules avec deux conditions initiales : F0 = 0, F1 = 1
 * Formule de récurrence : Fn = Fn-1 + Fn-2 pour n >= 2
 */

public class Exo10 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner clavier = new Scanner(System.in);

        System.out.print("Combien de termes de la suite de Fibonacci voulez-vous afficher ? ");
        int n = clavier.nextInt();

        // On crée un tableau pour stocker les termes
        int[] fibonacci = new int[n];

        // Conditions initiales
        if (n > 0) fibonacci[0] = 0; // F0 = 0
        if (n > 1) fibonacci[1] = 1; // F1 = 1

        // Calcul des termes suivants
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        System.out.print("Suite de Fibonacci : ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci[i] + " ");
        }

        clavier.close();
	}

}
