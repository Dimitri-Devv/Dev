package fr.dawan.k.seeled;

//sealed permet de restreindre l'héritage à une liste de classes autorisés
public sealed class Computer permits Desktop, Laptop
{

}
