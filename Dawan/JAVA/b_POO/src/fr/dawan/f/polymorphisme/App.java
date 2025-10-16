package fr.dawan.f.polymorphisme;

import java.util.ArrayList;
import java.util.List;

/*
Polymorphisme : un même type d'objet (ex:Animal) peut prendre plusieurs formes (Chien, chat...)

Le polymorphisme est une conséquence directe de l'héritage

 */
public class App {
    public static void main(String[] args) {

        Animal animal = new Animal();

        animal.communiquer();

        List<Animal> animals = new ArrayList<>(); // Une List<t> est fortement typé : on ne peut y mettre
        // que des objets d'un seul et même type

        animals.add(new Chien());// Mais on peut ajouter des chiens
        animals.add(new Chat());// et des chats
        animals.add(new Chien());// dans une liste( ou un tableau) de Animal grace au polymorphisme

        for(Animal a : animals){
            a.communiquer(); // les animaux ont des comportements / formes différent(e)s
        }





    }
}
