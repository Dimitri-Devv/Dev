
let texte = document.getElementById('texte');

let btns = document.querySelectorAll('button');

function ajouteClass(btn) {
    btn.classList.add('active-onglet');
}

btns.forEach(e => {

    e.addEventListener('click', function (event) {

        let activeOnglet = document.querySelector('.active-onglet');
        activeOnglet.classList.remove('active-onglet');


        if (e.textContent == "Onglet 1") {

            texte.textContent = "Je m'appelle Guillaume"
            ajouteClass(e);


        } else if (e.textContent == "Onglet 2") {
            texte.textContent = "Je m'appelle Jason"
            ajouteClass(e);
        } else {
            texte.textContent = "Je m'appelle Louis"
            ajouteClass(e);
        }


    })
}
);


