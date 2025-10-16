package fr.dawan.f.methodes;

/*
 * une méthode est un bloc d'instructions réutilisable
 * une méthode est une fonction qui se rapport à un objet
 * 
 * Déclaration : 
 * 
 * Visibilité [mot(s)-clé(s)] type-retour nomMethode(params){instructions}
 * 
 * une methode peut avoir plusieurs signatures(avec des paramètres différents. On parlera de surcharge
 * 
 * Il existe différents niveau de visibilité
 * 
 * - public : accessible partout
 * 
 * - private : accessible uniquement à l i'ntérieur de la classe 
 * 
 * - protected : accessible à l'intérieur de la classe, dans les sous-classe(classes filles)même si elles sont pas dans le même package, ainsi qu'aux classes du même package.
 * 
 * - package-private (aucun modificateur) : si on ne spécifie pas de modificateur, la méthode est dite package-private. Accessible uniquement aux classes du même package
 * 
 */
public class Methodes {
	
	//une méthode qui ne retourne rien doit quand même spécifier le type de retour 'void'
	//static : méthode classe (voir chapitre sur la POO)

	private static void afficher() {
		// TODO Auto-generated method stub
		
		System.out.println("Méthode afficher");
		
	}
	
	//surchage de la méthode afficher qui accepte un paramètre de type 'String'
	private static void afficher(String message) {
		// TODO Auto-generated method stub
		
		System.out.println(message);
		
	}
	
	private static void afficher(int [] tab) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i <tab.length; i++) {
			System.out.println(tab[i]);
		}
		
		
	}
	
	private static int somme(int i, int j) {
		// TODO Auto-generated method stub
		
		return i +j;
		
		
	}
	
	private static int somme(int [] tab) {
		// TODO Auto-generated method stub
		int somme = 0;
		for(int i = 0; i < tab.length; i++) {
			somme += tab[i];
		}
		return somme;
		
		
	}
	//Methode récursive : l'implémentation de la méthode repose sur l'appel de la méthode elle-même
	//un algorithme récursif doit commencer par envisager le/les cas terminaux pour arrêter la récursivité
	
	//2^0 = 1
	//2^3 = 2*2*2
	// 2^4 = 2*2*22* = 2^3 * 2
	private static int power(int value, int pow) {
		// TODO Auto-generated method stub
		if(pow == 0) return 1;
		
		return value * power(value,pow-1);
		
		
		
	}
	
	// '...' permet de considérer le paramètre comme s'il s'agissait d'un itérable
	private static void afficher(String... tab) {
		// TODO Auto-generated method stub
		for(String item : tab) {
			System.out.println(item);
		}
		
		
		
	}

	public static void main(String [] args) {
		afficher();
		
		afficher("Hello World");
		
		int[] tab = { 20, 30, 40};
		
		afficher(tab);
		
		afficher("somme(2, 3) = " + somme(2,3));
		
		afficher("somme(tab) = " + somme(tab));
		
		afficher("power(3, 3) = " + power(3, 3));
		
		afficher("riri", "fifi");
		
		afficher("riri", "fifi", "loulou");
	}
}
