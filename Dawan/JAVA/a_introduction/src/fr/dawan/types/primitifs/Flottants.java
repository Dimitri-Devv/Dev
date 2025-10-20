package fr.dawan.types.primitifs;

public class Flottants {

    public static void main(String[] args) {

        /*
         * Types numériques flottants :
         * 
         * - float (32 bits) - double (64 bits)
         */

        System.out.printf("- %s (%d bits) from %e to %e\n", Float.TYPE, Float.SIZE, Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("- %s (%d bits) from %e to %e\n", Double.TYPE, Double.SIZE, Double.MIN_VALUE,
                Double.MAX_VALUE);
        
        float myFloat = 3.4F; // f ou F obligatoire
        double myDouble = 3.4; // d ou D optionnel
        
        System.out.println("myFloat = " + myFloat);
        System.out.println("myDouble = " + myDouble);
        
        // Notation exponentielle
        
        double myDoubleExp = 3.4e10;
        
        System.out.println("myDoubleExp = " + myDoubleExp);
        
        // Valeurs particulières 
        
        System.out.println(Double.POSITIVE_INFINITY); // + Infini
        System.out.println(Double.NEGATIVE_INFINITY); // - Infini
        System.out.println(Double.NaN); // Not A Number
        
        // Quelques test sur ces valeurs ...
        
        System.out.println(Float.isFinite(myFloat)); // true
        System.out.println(Float.isFinite(Float.NEGATIVE_INFINITY)); // false
        
        System.out.println(Float.isNaN(myFloat));
        System.out.println(Float.isNaN(Float.NaN));
        
        
        
    }

}