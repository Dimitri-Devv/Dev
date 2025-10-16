package fr.dawan.d.operateurs;

public class Logiques {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Les opérateurs logiques s'appliquent à des types booléens et produisent un résultat également booléen
		 * 
		 * Il existe 3 opérateurs logiques : 
		 * 
		 * - ET : A && B -> true si A et B sont true
		 * 
		 * -OU : A || B => trie si A et/ou B true, false sinon
		 * 
		 * -non : !A => true si A est false, false sinon
		 *
		 */
		
		boolean a = false;
		boolean b = true;
		
		if(a && b) {
			System.out.println("a ou b sont vrais");
		}else {
			System.out.println("a et / ou b est faux");
		}
	}

}
