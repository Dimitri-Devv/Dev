/*
 Exo:
 - Placer la classe flex sur la balise <main>
 - Changer l'image img1.jpg par img2.jpg
 - Placer la classe grey sur le paragraphe
 - Placer la classe title sur tous les titres h2
 - Changer la taille du titre h3 a 20px
 - Changer le texte du 2eme élément de liste 'Sur les berges' par 'Un repos sur les berges'
*/

let main = document.querySelector('main');

main.classList.add('flex');

let img1 = document.querySelector('img');

img1.setAttribute('src', 'img2.jpeg');

let p = document.querySelector('p');

p.classList.add('grey');

let h2 = document.querySelectorAll('h2')



h2.forEach(e => {
    e.classList.add('title');

});

let h3 = document.querySelector('h3');

h3.style.fontSize = "43px";




document.querySelectorAll('li')[1].textContent = "Un repos sur les berges";







