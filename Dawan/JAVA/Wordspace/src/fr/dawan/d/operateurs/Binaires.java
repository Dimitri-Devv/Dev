package fr.dawan.d.operateurs;

public class Binaires {

    public static void main(String[] args) {
        
        int a = 12; // Binaire : 0000 1100
        int b = 10; // Binaire : 0000 1010
        
        System.out.println("a = " + a + ", b = " + b);
        
        // ET (&)
        // 1100 (a)
        // 1010 (b)
        // 1000 (a&b) => 8
        
        System.out.println("a & b = " + (a & b));
        
        
        // OU (|)
        // 1100 (a)
        // 1010 (b)
        // 1110 (a | b) => 1*2^3 + 1*2^2 + 1*2^1 + 0*2^0 = 8 + 4 + 2 = 14
        
        System.out.println("a | b = " + (a | b));
        
        //Il existe d'autres opérateurs binaire, le non, décallage de bit à droite et à gauche...
    }

}