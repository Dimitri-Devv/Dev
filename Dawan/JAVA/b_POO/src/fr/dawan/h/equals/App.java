package fr.dawan.h.equals;

public class App {
    public static void main(String[] args) {
        CompteBancaire cb1 = new CompteBancaire("toto", "12aaa41", 1000);
        CompteBancaire cb2 = new CompteBancaire("titi", "12bbb41", 2000);
        CompteBancaire cb3 = new CompteBancaire("tata", "12ccc41", 3000);
        CompteBancaire cb4 = new CompteBancaire("toto", "12ccc41", 3000);

        System.out.println(cb1);

        System.out.println(cb3.equals(cb4)); // true
        System.out.println(cb2.equals(cb4)); // false



    }
}
