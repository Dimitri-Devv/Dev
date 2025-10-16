package fr.dawan.b.encapsulation;

import fr.dawan.b.encapsulation.User;

public class App {
    public static void main(String[] args) {
        User user = new User("John", "Scofield",  18);

        System.out.println(user); //appel implicite à toString()

        //user.age = -12;
        user.setAge(14);

        System.out.println(user.getAge());

        System.out.println(User.getnUsers());
    }
}

