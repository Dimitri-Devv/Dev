package fr.dawan.types.complexes;


/*
 * Contrairement aux types primitifs, les types complexes/référence/objet exposent des propriétés et/ou des méthodes.
 * 
 * Visuellement ils se distinguent des types primitifs en ce qu'ils commencent par une majuscule.
 */
public class Strings {
	
	

	public static void main(Strings[] args) {
		// TODO Auto-generated method stub
		//Une chaine de caractères est un objet non modifiable
		String immutable = "Ma chaine de caractères"; // déclaration d'une variable nommée 'immutable de type String initialisée avec la valeur "Ma chaine"
		
		System.out.println(immutable);
		
		immutable = "ma nouvelle chaine";//Création d'une nouvelle chaine (allocation de nouvelle mémoire pour stocker la nouvelle chaine) dont l'adresse est affecté à la variable 'immutable'
		
		//la mémoire alloué pour "Ma chaine" sera libérée automatiquement par le garbage collector (ramasse miettes)
		System.out.println(immutable);
		
		//Concaténation
		
		String firstName = "riri";
		
		String lastName = "Duck";
		
		String fullName = firstName + ' ' + lastName;
		
		System.out.println(fullName);
		
		System.out.println("6" + 4 + 5);
		
		System.out.println(4 + 5 + "7");
		
		System.out.println(4 + "5" + 7);
		
		int x = 5 + 'A';
		
		System.out.println("x = " + x);
		
		char y = 5 + 'A';
		
		System.out.println("y = " + y);
		
		System.out.println("6" + 4 * 5); //"620" => L'opérateur * est prioritaire sur l'addition : on commence par faire 4 * 5 = 20, puis concatenatko de 6 et 20 => 620
		
		System.out.println("6" + (5-1)); // "64";
		
		//Quelques méthodes courantes relatives au chaines de caractères
		
		String str = "Java";
		System.out.println(str.charAt(1)); 
		
		System.out.println(str.substring(1)); // ava => str.substring(1) retourne une sous chaine de la chaine 'str' à partir de l'indice 1
		System.out.println(str.substring(0,2));// Ja :retourne une sous chaine de l'indice 0 à 2 exclu
		
		String phrase = "Ceci est une chaine de caractères";
		
		
		String[] mots = phrase.split(" ");
		
		for(String mot : mots ) System.out.println(mot + " | ");
		System.out.println();
		
		System.out.println(phrase.toUpperCase());
		System.out.println(phrase.toLowerCase());
		
		// ================
		
		String strInt = "123";
		
		int parsedInt = Integer.parseInt(strInt);
		
		System.out.println(parsedInt + 1); //124
		
		String strDouble = "123.456";
		
		double parsedDouble = Double.parseDouble(strDouble);
		
		System.out.println(parsedDouble + 1); //124.456
		
		// ======================
		//Formatage (String.format())
		//=======================
		
		String formatee = String.format("parsedInt = %04d", parsedInt); // formattage de parseInt sur 4 digits
		
		System.out.println(formatee);
		
		formatee = String.format(" parsedInt = %05d, parseDouble = %05.2f",  parsedInt, parsedDouble); // formatage de parsedInt sur 5 digits et de parsedDouble sur 5 digits dont 2 après la virgule
		
		System.out.println(formatee);
		
		//StringBuilder
		
		StringBuilder builder = new StringBuilder("Texte de base");
		
		builder.append("Ajouté à la fin);");
		
		System.out.println(builder);
		
		//Quand on a beaucoup de traitements à faire sur une / des chaine(s), il est préférable de passer par un StringBuilder qui permet de moins soliciter la mémoire(allocation/désallocation)
		
		
		
		
	}

}
