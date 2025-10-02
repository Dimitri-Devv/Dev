let h3 = document.getElementById('H3');

let h2 = document.getElementById('H2');

let p = document.getElementById('p');

let btn = document.getElementById('btn');

let zoneTexte = document.getElementById('texte');

h2.addEventListener('click', function (event) {

    let e = document.createElement('h2');
    e.textContent = "Voici le texte"

    texte.append(e);


})

h3.addEventListener('click', function (event) {

    let e = document.createElement('h3');
    e.textContent = "Voici le texte"

    texte.append(e);


})

p.addEventListener('click', function (event) {

    let e = document.createElement('p');
    e.textContent = "Voici le texte"

    texte.append(e);


})

btn.addEventListener('click', function (event) {

    let e = document.createElement('button');
    e.textContent = "Voici le texte"
    e.classList.add('btn', 'btn-success');
    e.addEventListener('click', function (event) {

        alert('Tu as cliqué sur le bouton !');



    })

    texte.append(e);


})