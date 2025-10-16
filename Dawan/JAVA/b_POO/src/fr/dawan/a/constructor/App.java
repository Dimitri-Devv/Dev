package fr.dawan.a.constructor;
/*
la programmation Orientée objet(POO) est paradigme de programmation consistant à définir et faire interragir des "objets"

Qu'est ce qu'un objet ?

Un objet est caractérisé par un "en-dedans" et "en-dehors". L'en dehors ne doit pas connaitre la façon dont fonctionne l'en dedans.
L'en dehors ne peut communiquer et interragir avec l'en dedans qu'à travers une "interface" fournis par l'objet. Cette interface se présente sous la forme d'un ensemble de :

- propriété

- méthodes

Ces propriétés et ces méthodes seront regroupées dans une classe.

Une classe et ces méthodes seront regroupées dans une classe.

Ces objets sont appelés des instances de la classe.

On instancie donc une classe pour construire un objet du type de la classe

La POO permet :

- de créer des objets facilement utilisables tout en masquant la complexité de leur implémentation.
- renforcer la sécurité en évitant la corruption accidentelle de données.

Concepts fondamentaux de la POO : Encapsulation, polymorphisme, héritage, abstraction, agrégation...


 */

public class App {
    public static void main(String[] args){

        System.out.println("nUsers = " + User.nUsers);
        User u1 = new User();

        u1.prenom = "John";
        u1.nom = "Scofield";
        u1.age = 18;

        System.out.println(u1.nom);
        System.out.println(u1.prenom);
        System.out.println(u1.age);

        User u2 = new User("John", "Scofield");

        User u3 = new User("John", "Scofield", 18);
        System.out.println(u2.prenom);

        //Problème : les champs de notre clase User sont public, et donc accessibles directement et sans controle depuis l'en dehors. Ce qui viole le principe d'encapsulation.
        //Il est possible d'accéder en écriture à nUsers
        User.nUsers = 12;
        //Il est même possible d'assigner des valeurs incohérentes
        User.nUsers = -12;
        //idem pour les attributs d'instance
        u3.age = -55;


    }
}
