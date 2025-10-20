package fr.dawan.types.primitifs;

public class Caractere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'a';
		
		System.out.println(c);
		
		//les caractères sont stockés dans une table unicode
		// à chaque caractères est donc associé un entier correspondant à sa position dans table unicode
		c = 97; // 9 correspond à la lettre 'a'
		
		System.out.println(c);
		
		c = '\u0061'; // \u0061 correspond au caractère 'a' en unicode
		
		System.out.println(c); // a ( le nombre hexadecimal 0061 correspond à 97 en décimal)
		
		//caractère spéciaux
		
		char retourLigne = '\n'; //retour à la ligne
		char tabulation = '\t'; // tabulation
		char apostrophe = '\''; //apostrophe
		char antislash = '\\'; //antislash
		
		//Il existe une classe utilitaire nommée 'Character' qui propose des méthodes utilitaires
		
		boolean isDigit = Character.isDigit('a');
		
		System.out.println(isDigit); //false
		
		boolean isLetter = Character.isLetter('a');
		
		System.out.println(isLetter); //true
		
		boolean isUpperCase = Character.isUpperCase('a');
		
		System.out.println(isUpperCase); //false
	}

}
