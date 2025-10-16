package fr.dawan.g.interfaces;

/*
Une interface est un contrat que toutes classe qui implémente l'interface doit respecter.

Ce contrat se présente sous la forme d'un ensemble de méthodes abstraites que les classes qui implémentent l'interface seront
obligés d'implémenter.
 */
public interface IPeutMarcher {
    /*public*/ void marcher(); // par défaut les membres d'une interfaces sont public et abstract (pas la peine de le préciser)

    void courir();
}
