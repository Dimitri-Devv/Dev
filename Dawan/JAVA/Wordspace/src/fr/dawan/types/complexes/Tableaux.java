package fr.dawan.types.complexes;

import java.util.Arrays;

public class Tableaux {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Un tableau a une taille fixe.
		 */
		
		int[] tab; //déclaration d'un tableau d'entiers non initialialisé
		
		String[] names = {"riri", "fifi"}; //Déclaration et initialisation d'un tableau de chaine de caractères 
		
		System.out.println(names.length); // 2
		
		System.out.println(names[1]); //"fifi"
		
		names[1] = "loulou"; //affectation de la valeur "loulou" à la deuxième case du tableau 'names'
		
		System.out.println(names[1]); //loulou
		
		System.out.println("Parcours d'un tableau avec une boucle for avec un index");
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		System.out.println("Parcours d'un tableau avec une boucle for de type foreach");
		
		for(String name: names) {
			System.out.println(name);
		}
		
		//Tableaux de tableaux
		String[][] names2D = {{"rire", "fifi", "loulou"},{"donald","daisy"}};
		
		//Parcours d'un tableau 2D avec boucle imbriquées
		for(int line = 0; line < names2D.length;line++) {
			for(int col = 0; col < names2D[line].length; col++) {
				System.out.println(names2D[line][col]);
			}
		}
		
		System.out.println("Arrays: Classe utilitaire pour les tableaux");
		
		String [] tabStr = new String[5];
		
		Arrays.fill(tabStr,"Bonjour"); //initialisation d'un tableau avec une valeur
		
		System.out.println(Arrays.toString(tabStr)); //Arrays.toString() retourne une chaine de caractère et permet d'afficher un tableau sans faire de bboucle
		
		int tab1[] = {1, 5, 7, 3, 8};
		
		int tab2[] = {1, 5, 7, 3, 8};
		
		System.out.println(Arrays.equals(tab1, tab2)); // true
		
		//sort => tri d'un tableau
		Arrays.sort(tab2);
		
		System.out.println(Arrays.toString(tab2));
		
		System.out.println(Arrays.binarySearch(tab2, 5)); // 2 => binarySearch s'applique à un tableau trié par ordre croissant et retourne l'index à la première occurence de la valeur recherchée ou une valeur négative si non trouvé
		
		}
}
