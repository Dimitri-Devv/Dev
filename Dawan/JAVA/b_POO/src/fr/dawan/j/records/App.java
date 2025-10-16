package fr.dawan.j.records;
/*
Les records ont été introduits avec Java 16 en 2021
Les records permettent de simplifier l'écriture des classes qui ne sont que de simple "enregistrements" de données immutables (non modifiables)
 */
public class App {
    public static void main(String[] args) {
        UserRecord user = new UserRecord("John", "Doe", 25);

        System.out.println(user);

        System.out.println(user.prenom());

        //user.prenom("fifi"); erreur : un record est immutable ( non modifiable )
    }
}
