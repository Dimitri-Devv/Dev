package fr.dawan.g.interfaces;

public class Corbeau extends Animal implements IPeutMarcher, IPeutVoler{
    @Override
    public void courir() {
        System.out.println("Je suis en train de courir");
    }

    @Override
    public void marcher() {
        System.out.println("Je suis en train de marcher");
    }

    @Override
    public void decoller() {
        System.out.println("Je suis en train de decoller");
    }

    @Override
    public void atterir() {
        System.out.println("Je suis en train d'atterir");

    }
}
