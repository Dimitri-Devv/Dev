package fr.dawan.d.operateurs;

public class Affectations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a = 0;
	        System.out.println("a = " + a);
	        
	        a +=5;
	        System.out.println("a = " + a);
	        
	        a *= 5;
	        System.out.println("a = " + a);
	        
	        a /= 5;
	        System.out.println("a = " + a);
	        
	        a -= 5;
	        System.out.println("a = " + a);
	        
	        int c = 10;

	        System.out.println("post incrémentation = " + c++); //  c => 10 d'abord on affiche puis on incrémente
	        
	        System.out.println("pre incrémentation : " + ++c); // c => 11 d'abord on incrémente puis on affiche
	    
	}

}
