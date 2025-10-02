//Création d'élément

//Création dans la mémoire  interne du js

const new_li = document.createElement('li')

new_li.textContent = 'Troisième ligne'

console.log(new_li);

const ul = document.querySelector('ul');

console.log(ul);

//Ajoute à la fin de l'élément, dernier enfant
ul.append(new_li)

//Ajoute au debut du parent, premier enfant
ul.prepend(new_li)
//Creation div
const div = document.createElement('div')
//Placement balise h2 via innerHTML, interprétation
div.innerHTML = '<h2>Je suis la div</h2'
//Placement à coté du ul, insertAdjacentElement permet
// un plus grand controle du placement
ul.insertAdjacentElement("beforebegin", div)

//Selection avancée

const premier_li = document.querySelector('.premier')
console.log(premier_li);
//Selectionne élement suivant
console.log(premier_li.nextElementSibling)
//" Element précédent
console.log(premier_li.previousElementSibling);
//" Le parent de l'élément
console.log(premier_li.parentElement);

//Selection de tous les enfants

let all_li = document.querySelectorAll('li');
console.log(ul.children);

console.log(all_li);

//ul.children permet de récupérer dynamiquement
// dynamiquement les enfant, permet d'avoir une liste
//des enfants à jour meme après ajout ou suppression
// d'un enfant

console.log(ul.childElementCount);

//Cloner un élément 
const clone_li = premier_li.cloneNode(true);
ul.append(clone_li)
console.log(clone_li);

//clone de la div 
const clone_div = div.cloneNode(true);

//Modification du h2 du clone
clone_div.querySelector('h2').textContent = 'Clone de la div'

//insertion apres la div déjà existante
div.insertAdjacentElement('afterend', clone_div)

//supression d'un élément
clone_li.removeChild();

//verification de la présence d'un élément
console.log(ul.contains(clone_li))
