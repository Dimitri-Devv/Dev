console.log(window.document);

//alert("Vous n'avez pas rempli ce champ");
//L'objet window automatiquement présent
//possède des méthodes et des propriété 
// utile pour diverse actions en js

//Selection

//Selecteur CSS

//Selection d'élement HTML => le nom de la balise(H2) (u1)
//Selection de la classe => .nom_de_la_classe
//Selection d'ID => #nom_de_l_id

let h1 = document.querySelector('h1');

//let h2_id = document.querySelector('#select')

//Ancienne méthode

//document.getElementById();
//document.getElementsByClassName();

console.log(h1);
//console.log(h2_class);
//console.log(h2_id);

//Element.textContent => Récupérer le text brut 
// de l'élément html
h1.textContent = 'le <span> texte </span> modifié'

//element.innerHTML => permet de modifier et d'interprété le contenu de la balise
h1.innerHTML = '<span> Le nouveau texte <span>'

//Modification attribut

let btn = document.querySelector('button');

console.log(btn.getAttribute('value'));

btn.setAttribute('value',7)
btn.setAttribute('type','submit');
console.log(btn.getAttribute('value'));

//Pour 80% des cas, les attributs vont être disponibles en tant que propriété de votre élément
console.log(btn.value);
btn.value = 9

//modification de classe

let p = document.querySelector('.select')

console.log(p);

//classlist donne un objet
//DomTokenList, référe toutes les classes existante sur 
// l'élément HTML, et donne acces a de nouvelles méthodes
console.log(p.classList);
//ajouter
p.classList.add('red');
//retirer
p.classList.remove('red');

p.classList.toggle('red');

setInterval(function(){
    p.classList.toggle('red')
},1000)

//Modification directe de style

let p2 = document.querySelector('#select')
console.log(p2.style);

p2.style.color = 'blue'
p2.style.backgroundColor = 'black'

//Selection multiples et avancée

let div1 = document.querySelector('.un');
//On peut partir d'un parent pour 
// selectionner ses enfants
let lis = div1.querySelectorAll('li')
console.log(lis);

console.log(lis(2));

//Pour intérargir avec une liste d'élément on est obliger d'utiliser une boucle
for (const li of lis) {
    li.text.textContent = 'Salade'
}

lis.forEach(li => {
    li.textContent = 'Tomate'
});



