package fr.dawan.e.instructions;

import java.util.Scanner;

public class Conditionnelles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------ if, else if, else --------");
		int n = 12;
		
		//if(n>0) System.out.println("n est positif"); on peut omettre les accolades lorsque le bloc d'instructions ne contient qu'une seule instruction
		if(n > 0) {
			System.out.println("n est positif");
		}
		else if( n == 0) {
			System.out.println("n vaut 0");
		}
		else if( n * n == 25) { // on peut mettre plusieurs else if
			System.out.println("n vaut -5");
		}
		else {
			System.out.println("n est négatif");
		}
		
		System.out.println("-------- switch ---------");
		
		int jours = 7;
		
		switch(jours) {
		case 1:
			System.out.println("lundi");
			break;
		case 2:
			System.out.println("mardi");
			break;
		case 3:
			System.out.println("mercredi");
			break;
		case 4:
			System.out.println("jeudi");
			break;
		case 5:
			System.out.println("vendredi");
			break;
		case 6:
			System.out.println("samedi");
			break;
		case 7:
			System.out.println("dimanche");
			break;
		default:
			System.out.println("Entree invalide");
			
		}
		
		switch(jours) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("semaine de travail");
			break;
		case 6:
			break;
		case 7:
			System.out.println("weekend");
			break;
		default:
			System.out.println("Entree invalide");
			
		}
		
		// depuis java 17
		
		switch(jours) {
		case 1,2,3,4,5 -> System.out.println("semaine de travail");
		case 6,7 -> System.out.println("weekend");
		default -> System.out.println("Entrée invalide");
		}
		
		String result = switch(jours) {
		case 1,2,3,4,5 -> "semaine de travail"; // retourne la chaine "semaine de travail"
		case 6,7 -> "weekend";
		default -> "Entrée invalide";
		};
		
		System.out.println(result);
		
		System.out.println("-----------opérateur ternaire-----------");
		
		//syntaxe : expression qui retourne un booléen ? si vrai : si faux
		String message = jours < 6 ? "semaine de travail" :"weekend";
		
		System.out.println(message);
		
		// Exercice: Calculatrice
				// Saisir dans la console :
				// - un nombre à virgule flottante v1
				// - un caractère (sous forme de chaine) 'opérateur' qui a pour valeur valide: +
				// - * /
				// - un nombre à virgule flottante v2
				// Afficher:
				// - Le résultat de l’opération
				// - Un message d’erreur si l’opérateur est incorrect
				// - Un message d’erreur si l’on fait une division par 0
		Scanner clavier = new Scanner(System.in);

        System.out.print("Entrez un premier nombre à virgule : ");
        float v1 = clavier.nextFloat();

        System.out.print("Entrez un opérateur (+, -, *, /) : ");
        String operateur = clavier.next();

        System.out.print("Entrez un deuxième nombre à virgule : ");
        float v2 = clavier.nextFloat();

        float resultat;

        // Gestion des opérateurs
        switch (operateur) {
            case "+":
                resultat = v1 + v2;
                System.out.println("Résultat : " + resultat);
                break;
            case "-":
                resultat = v1 - v2;
                System.out.println("Résultat : " + resultat);
                break;
            case "*":
                resultat = v1 * v2;
                System.out.println("Résultat : " + resultat);
                break;
            case "/":
                if (v2 == 0) {
                    System.out.println("Erreur : Division par zéro !");
                } else {
                    resultat = v1 / v2;
                    System.out.println("Résultat : " + resultat);
                }
                break;
            default:
                System.out.println("Erreur : opérateur incorrect (" + operateur + ")");
                break;
        }

        clavier.close();
    }
		
		
		
		
		
	}

}
