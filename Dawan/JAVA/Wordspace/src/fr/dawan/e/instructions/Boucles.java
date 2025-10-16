package fr.dawan.e.instructions;

import java.util.ArrayList;
import java.util.Scanner;

public class Boucles {

    public static void main(String[] args) {
        
        /*
         * Une boucle permet de répéter un bloc d'insctructions
         * 
         * - for 
         * - while 
         * - do while
         * 
         */
        
        System.out.println("------------------ FOR ----------------------");
        
        String[] mois = { "Janvier", "Février" , "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" };
        
        // Syntaxe : for (initExpr, textExpr, incExpr)
        
        for (int index = 0; index < mois.length; index++) {
            System.out.println(mois[index]);
        }
        
        System.out.println("------------------ CONTINUE ----------------------");
        // Le mot clé continue sort de l'itération en cours et passe directement  à la suivante
        for (int index = 0; index < mois.length; index++) {
            
            if (mois[index].equals("Octrobre")) continue;
            
            System.out.println(mois[index]);
        }
        
        System.out.println("------------------ FOR (EACH) ----------------------");
        
        // La boucle foreach s'implémente avec le mot clé 'for'
        for (String m : mois) {
            System.out.println(m);
        }
        
        System.out.println("------------------ .forEach ----------------------");
        
        // .forEach() est une méthode, pas à proprement parler une boucle, la méthode .foreach ne s'applique qu'aux collections, pas aux tableaux.
        
        // mois.forEach(System.out::println); | Erreur : mois est un simple tableau, pas une collection : la méthode .forEach n'est pas disponible dans ce cas.
        
        ArrayList<Integer> intArrayList = new ArrayList<>();
        
        intArrayList.add(1);
        intArrayList.add(4);
        intArrayList.add(12);
        
        intArrayList.forEach(System.out::println);
        
        System.out.println("------------------ WHILE ----------------------");
        
        /*
         * La boucle 'While' permet de répéter un bloc d'instructions tant qu'une condition est vérifiée.
         * 
         * Syntaxe : while(testExpr) { bloc d'insctructions à itérer}
         * 
         */
        
        Scanner clavier = new Scanner(System.in);
        
        System.out.println("Saisi votre âge : ");
        int age = clavier.nextInt();
        
        while(age <= 0) {
            System.out.println("Merci de renseigner un âge valide");
            age = clavier.nextInt();
        }
        
        System.out.println("Vous avez " + age + " ans");
        
        System.out.println("------------------ DO WHILE ----------------------");
        
        /*
         * La boucle do while est similaire à la boucle while excepté que la condition est vérifiée après l'exécution du bloc d'instructions.
         * 
         * On est donc certain d'exécuter au moins une fois le bloc d'instructions d'une boucle do whule même si la condition est initialement fausse.
         */
        
        age = 10;
        
        do {
            System.out.println("Entrez un âge positif : ");
        } while (age <= 0);
        
        	// Série harmonique : Saisir un nombre entier n
     		// Et calculer la somme des n premiers termes de la série harmonique :
      
     		// S(1) = 1
     		// S(2) = 1 + 1/2 = 1.5
     		// S(3) = 1 + 1/2 +1/3 = 1.8
     		// S(n) = 1 + 1 / 2 + 1 / 3 + 1 / 4 + ... +1 / n
     		// ...
     		// Afficher toutes les valeurs de la série harmonique jusqu'à l'ordre 'n'
      
     		
        
        
        


        // ======= 1) Série harmonique =======
        
        System.out.println("Entrez un entier positif n : ");
        int n = clavier.nextInt();
        
        double result = 0;
        
        for(int i = 1; i <= n; i++) {
        	result += 1 / i;
        	result += 1.0 / i;
        	System.out.println("S(" + i + ") = " + Math.round(result * 100) / 100.0);
        }
            
		
     // Quadrillage :Créer un quadrillage dynamiquement
 		// Saisir le nombre de colonnes et de lignes
 		// ex: pour 2 3
 		// [0,0][0,1]
 		// [1,0][1,1]
 		// [2,0][2,1]
		
        System.out.println("Nombre de colonnes : ");
        int co = clavier.nextInt();
        
        System.out.println("Nombre de lignes : ");
        int li = clavier.nextInt();
        
        for(int l= 0; l <li; l++) {
        	for(int c = 0; c < co; c++) {
        		 System.out.print("[" + l + ", " + c +"]");
        	       
        	}
        	 System.out.println("");
             
        }
		
        
        
        clavier.close();
        

    }

}