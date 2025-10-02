
let titre = document.getElementById('titre');

let imgs = document.querySelectorAll('.onglet-texte img');

let imgCenter = document.getElementById('imgCenter');


function ajouteClass(img) {

    if (img.getAttribute('id') == "imgCenter") {
    } else {
        img.classList.add('active-onglet');
    }



}

imgs.forEach(e => {

    e.addEventListener('click', function (event) {



        let activeOnglet = document.querySelector('.active-onglet');

        if (activeOnglet != null) {
            activeOnglet.classList.remove('active-onglet');
        }



        if (e.getAttribute('src') == "img1.jpeg") {
            imgCenter.src = "img1.jpeg";
            titre.textContent = "Arbre rose"

            ajouteClass(e);


        } else if (e.getAttribute('src') == "img2.jpeg") {
            titre.textContent = "Mongolfière"
            imgCenter.src = "img2.jpeg";
            ajouteClass(e);
        } else if (e.getAttribute('src') == "img3.jpeg") {
            titre.textContent = "Plaine"
            imgCenter.src = "img3.jpeg";
            ajouteClass(e);
        } else {
            ajouteClass(e);
            imgCenter.src = "img4.jpeg";
            titre.textContent = "Montagne"
        }


    })
}
);


