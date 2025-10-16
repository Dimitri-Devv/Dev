package fr.dawan.g.interfaces;

public class Chat extends Animal implements IPeutMarcher
{
    private String couleur;

     public String getCouleur() {
         return couleur;
     }

     public void setCouleur(String couleur) {
         this.couleur = couleur;

     }

     public Chat(){


     }
     public Chat(String nom, int age ){
         super(nom, age);

     }

     public Chat(String nom, int age, String couleur){
         super(nom, age);
         this.couleur = couleur;
     }

    @Override
    public void marcher() {
        System.out.println("Je suis en train de marcher");
    }
    @Override
    public void courir() {
        System.out.println("Je suis en train de courir");
    }

}
