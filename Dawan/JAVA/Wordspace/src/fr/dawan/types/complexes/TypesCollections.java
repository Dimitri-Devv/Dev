package fr.dawan.types.complexes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class TypesCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Une collection c'est un conteneur qui permet de regrouper plusieurs objets en une seule entité.
		//Contrairement au trableax, une collection a une taille dynamique.
		
		//Il existe de nombreux types de collections
		
		List<String> list = new ArrayList<String>(); // Déclaration d'une variable nommée 'list' de type List<String>
		
		//'List' est une interface
		//'ArrayList' est 'l'une des classes qui implémente d'interface 'List'
		
		list.add("a");
		list.add("b");
		list.add("d");
		list.add(2, "c"); //insertion à l'indice 2
		list.add("e");
		list.add("f");
		list.add("g");
		
		list.remove("g"); //supprime la première occurence de l'élément 'g'
		
		//Suppression par index
		list.remove(2); //supprime l'élément dont l'indice 2
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		
		numbers.remove(1); //supprime l'élément à l'indice 1(20)
		numbers.remove(Integer.valueOf(30)); //Supprime l'objet dont la valeur est 30
		
		
		System.out.println("Boucle for type foreach");
		
		for(String s:list) {
			System.out.println(s);
		}
		
		//list.forEach(s -> System.out.println(s));
		list.forEach(System.out::println);
		
		List<String> sub = list.subList(2,  5);//Retourne une sous liste de l'indice 2 à 5 exclu
		
		System.out.println("--- Sous liste");
		sub.forEach(System.out::println);
		
		System.out.println("--- La classe utilitaire Collections");
		Collections.shuffle(list); //mélange la liste
		
		list.forEach(System.out::println);
		
		System.out.println("---sort"); // tri
		Collections.sort(list);
		
		list.forEach(System.out::println);
		
		System.out.println("-- rotate + 1");
		Collections.rotate(list, +1); // décalage à droite
		
		list.forEach(System.out::println);
		
		System.out.println("-- rotate - 1");
		Collections.rotate(list, -1); // décalage à gauche
		
		list.forEach(System.out::println);
		
		System.out.println("\n --- Tableaux associatifs (dictionnaires) ---- \n");
		//Collection de couple clé/valeur
		
		Map<Integer, String> map = new TreeMap<>();	//Déclaration une variable nommée 'map' de type Map<Integer, String>
		
		//Map<> : est une interface
		
		// TreeMap est l'une des impémentations de l'interface Map
		
		map = new HashMap<>();
		
		//HashMap, TreeMap et LinkedHashMap sont des implémentations de l'interface Map
		
		//HashMap : rapide en lecture mais les clés ne sont pas triées
		//TreeMap : plus lent mais les clés sont triées
		// LinkedHashMap : assez rapide et clés triées mais occupe plus de mémoire
		
		map.put(1, "un");
		map.put(2, "deux");
		map.put(3, "trois");
		map.put(1, "doublon"); // la clé existe déjà => la valeur sera écrasée par la nouvelle 
		
		//keySet : retourne l'ensemble des clés du dictionnaire
		for(Integer i : map.keySet()) {
			System.out.println(i + " ");
		}
		
		//entrySet retourne l'ensemble des entrées (la clé et la valeur associée)
		
		System.out.println("--- entrySet");
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("clé : " + key + "- valeur :" + value);
		}
		
		//suppression 
		map.remove(2); //supprime l'élément dont la clé vaut 2 ( à ne pas confondre avec un indice)
		System.out.println(map);
		
	}

}
