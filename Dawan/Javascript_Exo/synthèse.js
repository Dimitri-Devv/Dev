// ============================================================
// 📘 FICHE DE RÉVISION JAVASCRIPT
// ============================================================

// ------------------------------------------------------------
// VARIABLES & TYPES
// ------------------------------------------------------------
// let et const : deux mots-clés pour déclarer des variables
// const = valeur qui ne change pas
// let   = valeur qui peut changer
// var   = ancien, à éviter (problèmes de portée)

let chaine = "Coucou"; // Chaîne de caractères
let nombre = 42;       // Nombre (entier ou flottant)
let bool   = true;     // Booléen (true / false)

// Différence entre guillemets simples, doubles et backticks :
// '' ou "" => identiques
// `` (backticks) => permettent l'interpolation de variables :

let prenom = "prenom";
console.log(`Bonjour ${prenom}`); // Bonjour prenom

// ------------------------------------------------------------
// OBJETS & TABLEAUX
// ------------------------------------------------------------
let notes = [12, 15, 18]; // Tableau
console.log(notes[1]);    // Accède au 2ème élément

let personne = {
  nom: "Nom_famille",
  prenom: "Prenom",
  age: 22,
  notes: [12, 14, 18],
  job: { titre: "Élève", type: "POEI" }
};
console.log(personne.prenom); // Accès à une propriété

// ------------------------------------------------------------
// CONDITIONS
// ------------------------------------------------------------
// if, else if, else : permettent de vérifier une condition

let note = 10;

if (note > 10) {
  console.log("Vous avez la moyenne");
} else if (note === 10) {
  console.log("Vous avez eu chaud");
} else {
  console.log("Vous n'avez pas la moyenne");
}

/*
Opérateurs de comparaison :
<   inférieur
>   supérieur
<=  inférieur ou égal
>=  supérieur ou égal
==  égalité (valeur)
=== égalité stricte (valeur + type)
!=  différent
!== différent strict
*/

// Opérateurs logiques :
// && (ET), || (OU), ! (NON)

// ------------------------------------------------------------
// BOUCLES
// ------------------------------------------------------------

// Boucle for (on connaît le nombre d'itérations)
for (let i = 0; i < 3; i++) {
  console.log("Itération " + i);
}

// Boucle while (on répète tant que la condition est vraie)
let i = 0;
while (i < 3) {
  console.log("i = " + i);
  i++;
}

// Boucle do...while (exécutée au moins une fois)
let j = 5;
do {
  console.log("Valeur de j : " + j);
} while (j < 5);

// Boucle for...of (pour parcourir un tableau)
let fruits = ["pomme", "banane", "kiwi"];
for (const fruit of fruits) {
  console.log(fruit);
}

// Boucle for...in (pour parcourir les propriétés d'un objet)
for (const cle in personne) {
  console.log(cle + " : " + personne[cle]);
}

// ------------------------------------------------------------
// FONCTIONS
// ------------------------------------------------------------

// Déclaration classique (hoisting possible)
function bonjour(nom) {
  return "Salut " + nom;
}
console.log(bonjour("prenom"));

// Fonction stockée dans une variable (anonyme)
const salut = function(nom) {
  return "Salut " + nom;
};
console.log(salut("prenom2"));

// Fonction fléchée (syntaxe moderne et courte)
const hello = (nom) => "Hello " + nom;
console.log(hello("Alex"));

// ------------------------------------------------------------
// MATH
// ------------------------------------------------------------
console.log(Math.random()); // nombre aléatoire entre 0 et 1
console.log(Math.floor(4.9)); // arrondi inférieur = 4
console.log(Math.ceil(4.1));  // arrondi supérieur = 5
console.log(Math.round(4.5)); // arrondi normal = 5

// ------------------------------------------------------------
// MÉTHODES UTILES SUR LES TABLEAUX
// ------------------------------------------------------------
let arr = [1, 2, 3, 4];

arr.push(5);   // ajoute à la fin
arr.pop();     // retire le dernier
arr.shift();   // retire le premier
arr.unshift(0);// ajoute au début

arr.forEach(x => console.log(x));        // boucle simple
let doubles = arr.map(x => x * 2);       // retourne [2,4,6,8]
let pairs = arr.filter(x => x % 2 === 0);// retourne [2,4]
let somme = arr.reduce((a, b) => a + b); // additionne tous

// ------------------------------------------------------------
// MÉTHODES UTILES SUR LES CHAÎNES
// ------------------------------------------------------------
let phrase = "Bonjour le LOUP";

console.log(phrase.length);        // longueur de la chaîne
console.log(phrase.toLowerCase()); // minuscule
console.log(phrase.toUpperCase()); // majuscule
console.log(phrase.includes("LOUP")); // true si le mot est présent

// ------------------------------------------------------------
// PORTEE DES VARIABLES
// ------------------------------------------------------------
// var = disponible partout (⚠️ déconseillé)
// let et const = seulement dans le bloc où elles sont définies

if (true) {
  let test = "visible ici";
  console.log(test);
}
// console.log(test); // ❌ Erreur : test n'existe pas ici

// ------------------------------------------------------------
// LE DOM (Document Object Model)
// ------------------------------------------------------------
// Permet de modifier une page HTML avec JS

// Sélecteurs
let h1 = document.querySelector("h1");       // sélectionne un <h1>
let p  = document.querySelector(".paragraphe"); // sélectionne par classe
let btn = document.querySelector("#monBtn"); // sélectionne par ID

// Modifier du texte
h1.textContent = "Nouveau texte";   // change le contenu brut
h1.innerHTML = "<em>Texte en italique</em>"; // interprète du HTML

// Modifier des attributs
btn.setAttribute("type", "submit");
console.log(btn.getAttribute("type"));

// Classes
p.classList.add("highlight");   // ajoute une classe
p.classList.remove("highlight"); // retire une classe
p.classList.toggle("rouge");     // ajoute si absent, retire si présent

// Styles en JS
p.style.color = "blue";
p.style.backgroundColor = "yellow";

// ------------------------------------------------------------
// EVENEMENTS
// ------------------------------------------------------------
// Permettent d’exécuter du code quand une action se produit (clic, clavier, etc.)

btn.addEventListener("click", (event) => {
  console.log("Clic sur le bouton");
  console.log(event.target); // élément cliqué
});

// ------------------------------------------------------------
// TEMPLATE HTML & CLONAGE
// ------------------------------------------------------------
// Exemple avec une balise <template id="tpl"> dans le HTML
let template = document.querySelector("#tpl");
let clone = template.content.cloneNode(true);
clone.querySelector("h2").textContent = "Titre cloné";
document.body.append(clone);

// ------------------------------------------------------------
// OBJET WINDOW
// ------------------------------------------------------------
// alert("Ceci est une alerte");
// let nomUser = prompt("Votre nom ?");
// let confirmation = confirm("Êtes-vous sûr ?");
// console.log(window.innerWidth, window.innerHeight);

// ============================================================