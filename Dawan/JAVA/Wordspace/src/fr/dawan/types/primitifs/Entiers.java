package fr.dawan.types.primitifs;

public class Entiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Il existe 4 types entiers : 
		 * bytes(8bits) -128 à 127
		 * short(16bits) de -2^15 à 2^15-1
		 * int (32bits) de -2^31 à 2^31-1
		 * long (64bits) de -2^63 à 2^63-1
		 */
		
		byte b = 120; 
		short s = 32767;
		int i = 10000000;
		long l = 1_000_000_000L; // l ou L à la fin
		
		/*
		 * A chaque type primitif est associé un type complexe sous forme de classe englobante (wrapper) proposant des propriétés et des méthodes utilitaires.
		 */
		
		System.out.printf("- %s (%d bits) from %d to %d\n", Byte.TYPE, Byte.SIZE, Byte.MIN_VALUE, Byte.MAX_VALUE);
		
		System.out.printf("- %s (%d bits) from %d to %d\n", Short.TYPE, Short.SIZE, Short.MIN_VALUE, Short.MAX_VALUE);
		
		System.out.printf("- %S (%d bits) from %d to %d\n", Long.TYPE, Long.SIZE, Long.MIN_VALUE, Long.MAX_VALUE);
		
		short myBinaryShort = 0b11; //Notation binaire
		short myHexaShort = 0x61; //Notation hexadecimal
		
		System.out.println("myBinaryShort = " + myBinaryShort);
		System.out.println("myHexaShort = " + myHexaShort);
	}

}
