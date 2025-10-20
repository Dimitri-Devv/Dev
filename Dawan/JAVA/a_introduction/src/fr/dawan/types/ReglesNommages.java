package fr.dawan.types;
 
public class ReglesNommages {
 
	    public static void main(String[] args) {
 
	        /*
	         * Le nom d'une variable peut être composé :
	         * - de caractères alphanumériques
	         * - du caractère '$'
	         * - du caractère '_'
	         *
	         * Le nom d'une variable ne peut pas commencer par un chiffre
	         *
	         * Les mots clés réservés du langage ne peuvent être utilisés en tant que nom de variable
	         */
	    	
	    	/*
	    	 * Par convention, les variables en Java sont déclarées en camelCase
	    	 *
	    	 * - camelCase : maVariable
	    	 * - PascalCase : MaVariable
	    	 * - snake_case : ma_variable
	    	 */
	    	
	    	int monEntier = 10;
 
	    	String maChaineDeCaracteres = "ma chaine de caractères";
 
	    	char monCaractere = 'a';
	    	
	    	// double 00monDouble; // interdit de commencer par un chiffre
	    	
	    	// double mon-double;  // trait d'union interdit
 
	    }
}