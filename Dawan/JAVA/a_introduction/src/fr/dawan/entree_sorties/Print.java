package fr.dawan.entree_sorties;

public class Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("La méthode printIn permet d'écrire une ligne");
		System.out.print("la méthode print");
		System.out.print("permet d'écrire une chaine de caractères");
		System.out.print("sans retour à la ligne");
		
		System.out.print("Il est néanmoins possible de revenir à la ligne. \n");
		
		String str = "printf";
		
		System.out.printf("La méthode %s permet d'écrire des chaines de caractères formatées", str);
		
		/* %s : permet de formater une chaine de caractères
		 * %c :permet de formater un caractère
		 * %d : permet de formater un entier en base décimal
		 * %x : permet de formation un entier en base hexadécimale
		 * %f : permet de formater un nombre réel
		 * %e : permet de formater un nombre réel en notation scientifique
		 */
		
		int monEntier = 25;
		
		System.out.printf("Mon entier vaut %d\n", monEntier);
		
		String nom = "Riri";
		
		int score = 55;
		
		// chaine de caractères formatée
				String message = """
						Bonjour %s,
						votre score est de %d points.
						""".formatted(nom, score);
				
				System.out.println(message);

		
	}

}
