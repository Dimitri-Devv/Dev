package fr.dawan.d.heritage;



public class Client extends User //La classe client hérite de User
{

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private boolean subscribed;
    public boolean isSubscribed() { //le getter d'un attribut booléen commence par 'is' (et non pas 'get')
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    //Constructeur à 4 paramètres qui appelle le constructeur à 3 paramètres de sa super classe (User)
    public Client(String nom, String prenom, int age, String phone) {
        super(nom, prenom, age);
        this.setPhone(phone); // mieux de faire appel au setter que this.phone = phone
    }

    @Override
    public String toString(){
        return super.toString() + "Je suis client. Mon numéro est " + this.getPhone();
    }

    //Redéfinition (override) de la méthode faitUnTruc de la classe User.
    @Override
    public void faitUnTruc() {

        String test = super.nom;

        test= super.getPrenom();
        ;System.out.println("Client faitUnTruc");
    }
}
