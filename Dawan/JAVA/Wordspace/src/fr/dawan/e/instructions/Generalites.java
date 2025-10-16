package fr.dawan.e.instructions;

public class Generalites {

	/*
	 * Une construction se termine par un ';'
	 * 
	 * Un bloc d'instructions est contenu entre accolades '{}'
	 * 
	 * Les variables déclarées dans un bloc d'instructions ne sont accessibles que dans l'edit bloc (et donc ses potentiels blocs imbriqués)
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		
		{
			System.out.println("a = " + a);
		}
		System.out.println("a = " + a);
		
	}
	
	//System.out.println("a = " + a); Erreur : la variable 'a' n'existe pas dans ce bloc
}
