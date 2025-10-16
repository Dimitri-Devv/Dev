package fr.dawan.i.genericite;
/*
    Le concept de généricité peut s'appliquer à des classes, interfaces, méthodes :
    - identiques d'un point de vue algorithmique
    - mais uniquement des types de données différents
     */
public class App {

    // Déclaration dd'une méthode générique portant sur un type générique 'T' qui doit étendre
    // l'interface 'comparable'
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        T max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) { // Pour utiliser compareTo il faut que le type étende l'interface Comparable
                max = array[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {


        MyGeneric<String> myGenericStr = new MyGeneric<String>("Hello");
        MyGeneric<Integer> myGenericInt = new MyGeneric<Integer>(13);

        System.out.println(myGenericStr);
        System.out.println(myGenericInt);


        // ============ Methode générique =====
        Integer[] intArray = new Integer[]{3,4,5,6,7,8,9,10};
        String[] stringArray = new String[]{"Hello", "World"};

        Integer maxInt = findMax(intArray);
        String maxStr = findMax(stringArray); //trie par ordre alphabétique décroissant

        System.out.println("Max int = " + maxInt);
        System.out.println("Max String = " + maxStr);

    }
}
