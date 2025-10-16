package fr.dawan.g.interfaces;

public class App {
    public static void main(String[] args) {
        Animal anichien = new Chien();
        Chien chien = new Chien();
        IPeutMarcher chat = new Chat();

        //anichien.marcher(); // Erreur, la variable 'chien' a été définie en tant que Animal, or la classe
        // n'implémente pas l'interface IPeutMarcher
        chien.courir(); // Ok, la variable 'chien' est un Chien qui implémente IPeutMarcher
        chat.courir(); // Ok, chat a été défini en tant que IPeutMarcher

        Corbeau c = new Corbeau(); // Le corbeau sait voler et marcher car il implémente les 2 interfaces
        c.atterir();
        c.marcher();
    }
}
