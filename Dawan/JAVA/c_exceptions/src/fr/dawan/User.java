package fr.dawan;

public class User {

	private String nom;
	private String prenom;
	private int age;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws IllegalAgeException { // throws IllegalAgeException permet d'avertir les utilisateur de la méthode qu'elle est susceptible de déclencher une IllegalAgeException
		
		if(age < 0) {
//			throw new IllegalArgumentException("Age négatif"); // throw permet de lever (déclencher) une exception
			throw new IllegalAgeException();
		}
		this.age = age;
	}
	
	public User() {
		
	}
	
	public User(String nom, String prenom) {
		
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public User(String nom, String prenom, int age) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
}
