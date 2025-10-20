package fr.dawan;

public class IllegalAgeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IllegalAgeException() {
		super("Un age ne peut être négatif");
	}

}
