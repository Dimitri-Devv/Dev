// Exo recreer une structure HTML

/*
    <h2>Titre de l'article</h2>
    <div class="card">
        <div class="right">
            <h3>Call to action</h3>
            <p>Texte de la carte</p>
        </div>
        <button>Voir plus</button>

    </div>

*/

let div = document.getElementById('container');

let h2 = document.createElement('h2');
h2.textContent = "Titre de l'article"
div.append(h2);

let div2 = document.createElement('div');
div2.classList.add('card');

let div3 = document.createElement('div');
div3.classList.add('right')

let h3 = document.createElement('h3');
h3.textContent = "Call to action"

let p = document.createElement('p');
p.textContent = "Texte de la carte"

div3.appendChild(h3);
div3.appendChild(p);
let button = document.createElement('button');
button.textContent = "Voir plus"

div2.appendChild(div3);
div2.appendChild(button);

div.append(div2);

console.log(div);
