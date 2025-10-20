package fr.dawan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Télécharger log4j sur le site d'Apache : https://logging.apache.org/log4j/2.x/download.html
 * => apache-log4j-2.25.0-bin.zip
 * 
 * Extraire le zip
 * 
 * Créer un dossier "lib" dans le projet(optionnel)
 * Y ajouter :
 * 		- log4j-api-2.20.0.jar
 * 		- log4j-core-2.20.0.jar

 * Clic droit sur le projet => "Build Path" => "Configure Buil Path" => "Librairies" => "ClassPath" => Add jars => Ajouter les 2 fichiers préalablement importés dans le dossier lib
 * 
 * Créer un dossier "resources", y ajouter un fichier nommé log4j2.xml (copier coller le contenu du fichier depuis gitlab)
 * 
 * Ajouter le dossier "resources" au build path : clic droit sur le projet, build path => configure build path => Source => Add Folfer => cocher le dossier "resources"
 * 
 */
public class App {

    private static Logger logger = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {

		try {
			
			User user = new User("Duck", "Riri", 12);

			user.setAge(13);

			System.out.println(user);

			user.setAge(-1);

			int[] tab = new int[2];

			tab[3] = 12;
		} catch (IllegalAgeException e) { // A un bloc try est associé au moins un bloc 'catch'
//			System.out.println(e.getMessage());
			logger.error(e.getMessage());
		} catch (IllegalArgumentException e) { // A un bloc try est associé au moins un bloc 'catch'
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) { // mais ont peut optionnellement mettre plusieurs blocs catch si on a besoin de fai un traitement différent en fonction dy type d'eception
			System.out.println(e.getMessage());
		}
		catch(Exception e) { // Exception est la classe mère de toute les exceptions. 
			System.out.println(e.getMessage()); // Si une exception se produit dans le bloc try qui n'est ni de type  IllegalArgumentException ni de type ArrayIndexOutOfBoundsException, on passera forcément par le catch(Exception e) 
		}
		finally {
			System.out.println("finally : bloc optionnel. Le bloc finally est exécuté en toute circonstance. Avec ou sans exception.\n Il est souvent utilisé pour libérer des ressources (fichier, connexion à une base de données, Scanner...");
		}

		System.out.println("La suite du programme");
	}
}
