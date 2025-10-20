package fr.dawan.entree_sorties;

import java.util.Scanner;

public class Scan {

	public static void main(String[] args) {
		
		//La classe Scanner permet de lire des informations depuis la console
		// TODO Auto-generated method stub
		Scanner clavier = new Scanner(System.in);
		
		int n = 0;
		double d = 0.0;
		
		System.out.print("Entre un entier :");
		n = clavier.nextInt();
		
		System.out.println("Le carré de " + n + " vaut " + n*n);
		
		System.out.print("Entre un nombre réel :");
		d = clavier.nextDouble(); // la méthode nextDouble permet de récupérer un réel
		
		//il faut renseigner le nombre avec une virgule, pas un point.
		
		
		System.out.println("Vous avez entré : " + d);
		
		
		System.out.println("Entrez une phrase :");
		
		String mot = clavier.next();		
		clavier.close();//fermeture du scanner
	}

}

