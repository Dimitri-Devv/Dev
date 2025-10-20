package fr.dawan.l.tp;
/*
 * Le directeur d'une entreprise de produits chimiques souhaite gérer les
 * salaires et primes de ses employés au moyen d'un programme Java. Un employé
 * est caractérisé par :
 *
 * - son nom
 *
 * - son prénom
 *
 * - son âge
 *
 * - sa date d'entrée enservice (string) dans l'entreprise.
 *
 * Codez une classe abstraite Employe dotée :
 *
 * - des attributs nécessaires
 *
 * - d'une méthode abstraite "calculerSalaire" (ce calcul dépendra en effet du
 * type de l'employé)
 *
 * - d'une méthode "getNom" retournant une chaine de caractères obtenue en
 * concaténant la chaine de caractères "L'employé " avec le prénom et le nom.
 *
 * - d'un constructeur prenant en paramètre l'ensemble des attributs
 * nécessaires.
 *
 * ********************************************
 * ********************************************
 * Calcul du salaire
 *
 * Le calcul du salaire mensuel dépend du type de l'employé. On distingue les
 * types d'employés suivants :
 *
 * - Ceux affectés à la Vente. Leur salaire mensuel vaut 20 % du chiffre
 * d'affaire qu'ils réalisent mensuellement, plus 400 Euros.
 *
 * - Ceux affectés à la Représentation. Leur salaire mensuel vaut également 20 %
 * du chiffre d'affaire qu'ils réalisent mensuellement, plus 800 Euros.
 *
 * - Ceux affectés à la Production. Leur salaire vaut le nombre d'unités
 * produites mensuellement multipliées par 5.
 *
 * - Ceux affectés à la Manutention. Leur salaire vaut leur nombre d'heures de
 * travail mensuel multipliées par 65 Euros.
 *
 *
 * Codez une hiérarchie de classes pour les employés en respectant les
 * conditions suivantes :
 *
 * - La super-classe de la hiérarchie doit être la classe "Employe".
 *
 * - Les nouvelles classes doivent contenir les attributs qui leur sont
 * spécifiques ainsi que le codage approprié des méthodes "calculerSalaire" et
 * "getNom", en changeant le mot "employé" par la catégorie correspondante.
 *
 * - Chaque sous classe est dotée de constructeur prenant en argument l'ensemble
 * des attributs nécessaires.
 *
 * N'hésitez pas à introduire des classes intermédiaires pour éviter au maximum
 * les redondances d'attributs et de méthodes dans les sous-classes
 *
 *
 * ********************************************
 * ********************************************
 * Employés à risques
 *
 * Certains employés des secteurs production et manutention sont appelés à
 * fabriquer et manipuler des produits dangereux. Après plusieurs négociations
 * syndicales, ces derniers parviennent à obtenir une prime de risque mensuelle.
 * Complétez votre programme java en introduisant deux nouvelles sous-classes
 * d'employés ou en modifiants les classe existantes.
 *
 * Ces sous-classes désigneront les employés des secteurs production et
 * manutention travaillant avec des produits dangereux.
 *
 * Modifier votre programme de sorte à attribuer une prime mensuelle de 200 €
 * aux employés à risque.
 *
 * Collection d'employés
 *
 * Satisfait de la hiérarchie proposée, notre directeur souhaite maintenant
 * l'exploiter pour afficher le salaire de tous ses employés ainsi que le
 * salaire moyen. Ajoutez une classe Personnel contenant une "collection"
 * d'employés. Il s'agira d'une collection polymorphique d'Employe - regardez le
 * cours si vous ne voyez pas de quoi il s'agit.
 *
 * Définissez ensuite les méthodes suivantes à la classe Personnel :
 *
 * - void ajouterEmploye(Employe) : ajoute un employé à la collection.
 *
 * - void calculerSalaires() : affiche le salaire de chacun des employés de la collection.
 *
 * - double salaireMoyen() : affiche le salaire moyen des employés de la collection.
 *
 * Tester le tout avec la méthode main ci dessous.
 *
 * Vous devriez obtenir : Le vendeur Pierre Business gagne 6400.0 €
 *
 * Le représentant Léon Vendtout gagne 4800.0 €
 *
 * Le technicien Yves Bosseur gagne 5000.0 €
 *
 * Le manutentionnaire Jeanne Stocketout gagne 2925.0 €
 *
 * Le technicien Jean Flippe gagne 5200.0 €
 *
 * Le manutentionnaire Al Abordage gagne 3125.0 €
 *
 * Le salaire moyen dans l'entreprise est de 4575.0 Euros.
 */

public class App {
    public static void main(String[] args) {
        IPersonnel p = new Employe() {

        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000, false));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45, false));
        p.ajouterEmploye(new Technicien("Jean", "Flippe", 28, "2000", 1000, true));
        p.ajouterEmploye(new Manutentionnaire("Al", "Abordage", 30, "2001", 45, true));

        p.calculerSalaires();

        System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + "Euros.");

    }
}
