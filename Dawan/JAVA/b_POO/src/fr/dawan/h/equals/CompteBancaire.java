package fr.dawan.h.equals;
import java.util.Objects;

public class CompteBancaire {
    private String Client;

    private String numeroCompte;

    private double solde;
    public String getClient() {
        return Client;
    }
    public void setClient(String client) {
        Client = client;
    }
    public String getNumeroCompte() {
        return numeroCompte;
    }
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }

    public CompteBancaire() {

    }

    public CompteBancaire(String client, String numeroCompte, double solde) {
        super();
        Client = client;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "CompteBancaire [Client=" + Client + ", NumeroCompte=" + numeroCompte + ", solde=" + solde + "]";
    }

    // Comme toString, les méthodes equals et hashCode sont fournies par défaut dans la classe 'Object'

    // Quand on redéfinit equals, il faut redéfinir hashCode. Et il faut que les 2 méthodes, equals et hashCode portent sur la même liste d'attribut. Dans l'exemple si dessous, equals ne compare que numeroCompte, donc hashCode ne doit faire apparaitre que numeroCompte.
    @Override
    public int hashCode() {
        return Objects.hash(numeroCompte);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // Si l'objet passé en paramètre est le même objet equals retourne true
            return true;
        if (obj == null) // si l'objet passé en paramètre est null equals retourne false
            return false;
        if (this.getClass() != obj.getClass()) // si l'objet passé en paramètre n'est pas du même type que l'objet courant, equals retourne false
            return false;

        // si on atteint cette ligne, cela veut dire que obj n'est ni le même objet que this, ni null, et que c'est un objet de type CompteBancaire

        CompteBancaire other = (CompteBancaire) obj; // Création d'un objet de type CompteBancaire à parir de obj
        return Objects.equals(numeroCompte, other.numeroCompte); // on considère que 2 CompteBancaire sont égaux s'ils ont le même numéro de de compte.
    }
}
