package fr.dawan.j.records;

public record UserRecord(String nom, String prenom, int age) {

    // il est possible d'accéder au nom via this.nom() ( au lieu de this.getNom() avec une classe)
    //toString, equals, hashCode sont déjà implémentés
}
