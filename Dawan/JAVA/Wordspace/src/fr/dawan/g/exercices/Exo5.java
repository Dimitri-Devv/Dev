
package fr.dawan.g.exercices;

import java.util.Scanner;

/*
 * Vérifier si l'année donnée par l'utilisateur est bissextile (366 jours) ou non.
 * 
 * Une année est considérée comme une année bissextile si :
 * 
 * - elle est divisible par 4 et non divisible par 100
 * 
 * - ou si elle est divisible par 400
 * 
 * « divisible » signifie que la division donne un nombre entier, sans reste (c'est à dire le reste égale à zéro) : 21 est divisible par 3. 22 non.
 */
public class Exo5 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner clavier = new Scanner(System.in);

        System.out.print("Entrez une année : ");
        int annee = clavier.nextInt();

        boolean estBissextile;

        // Règle : divisible par 4 et pas par 100, ou divisible par 400
        if ((annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0)) {
            estBissextile = true;
        } else {
            estBissextile = false;
        }

        // Affichage du résultat
        if (estBissextile) {
            System.out.println(annee + " est une année bissextile.");
        } else {
            System.out.println(annee + " n'est pas une année bissextile.");
        }
		
	}

}
