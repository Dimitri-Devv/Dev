package fr.dawan.d.operateurs;

public class Transtypage {

    public static void main(String[] args) {
        
        System.out.println("\n--- TRANSTYPAGES IMPLICITES ---\n");
        // transtypages implicites : pas de risque de perte de données / précision
        byte myByte = 111;
        
        short myShort = /*(short)*/ myByte; // cast implicite car il y a suffisament de place pour stocket un byt dans un short
        
        int myInt = /*(int)*/ myShort;
        
        long myLong = /*(long)*/ myInt;
        
        float myFloat = /*(float)*/ myLong;
        
        double myDouble = /*(double)*/ myLong; 
        
        System.out.println("myByte = " + myByte);
        System.out.println("myShort = " + myShort);
        System.out.println("myInt = " + myInt);
        System.out.println("myLong = " + myLong);
        System.out.println("myFloat = " + myFloat);
        System.out.println("myDouble = " + myDouble);
        
        System.out.println("\n--- TRANSTYPAGES EXPLICITES ---\n");
        
        // cast explicites car pert potentielle de données / précision
        myDouble = 1234568901.1245679;
        
        myFloat = (float)myDouble;
        myLong = (long)myFloat;
        myInt = (int)myLong;
        myShort = (short)myInt;
        myByte = (byte)myShort;
        
        System.out.println("myDouble = " + myDouble);
        System.out.println("myFloat = " + myFloat);
        System.out.println("myLong = " + myLong);
        System.out.println("myShort = " + myShort);
        System.out.println("myByte = " + myByte);
        
             
        System.out.println("\n--- Dépassement des capacités ---\n");
        int i = 130;
        
        byte b = (byte) i;
        
        System.out.println("i = " + i);
        System.out.println("b = " + b); // -126 car byte est compris -12 et 127
        
        // int vs byte
        // 127 vs 127
        // 128 vs -128
        // 129 vs -127
        // 130 vs -126      
    }

}