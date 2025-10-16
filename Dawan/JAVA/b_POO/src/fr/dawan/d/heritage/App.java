package fr.dawan.d.heritage;

/*
L'héritage est relation type "est un". Exemple : un chien est un animal.

Une classe fille/ sous classe hérite des attributs et des méthodes de sa classe mère / (super class).

En java, seul l'héritage simple est autorisé : une classe ne peut pas hériter de plusieurs classes en ascendance directe.
 */
public class App {
    public static void main(String[] args) {

        User user = new User("duck", "riri", 12);

        System.out.println(user);

        System.out.println(User.getnUsers()); // 1

        user.faiUnTruc();

        Client client = new Client("duck", "picsou",70, "+33612137398");

        System.out.println(client);

        System.out.println(User.getnUsers()); // 2

        user.faiUnTruc();
    }
}
