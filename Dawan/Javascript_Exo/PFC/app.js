

let btnPierre = document.getElementById('1');

let btnFeuille = document.getElementById('2');

let btnCiseau = document.getElementById('3');

let affichageResultat = document.getElementById('resultat');

let ResultatG = "Tu as gagné !";

let ResultatP = "Tu as Perdu :(";

let ResultatE = "Egalité !";

let imgPierre = "pierre.png";

let imgFeuille = "feuille.png";

let imgCiseau = "ciseau.png"

let div = document.createElement('div');
let resultat = document.createElement('h2');

let imgMoi = document.createElement('img');


let imgOrdi = document.createElement('img');
imgMoi.style.height = "80px";
imgMoi.style.borderRadius = "90%"
imgMoi.style.padding = "10px"
imgOrdi.style.height = "80px";
imgOrdi.style.borderRadius = "90%"
imgOrdi.style.padding = "10px"

let tableau = document.createElement('table');
let l1 = document.createElement('tr');
let l2 = document.createElement('tr');
let l3 = document.createElement('tr');

let moi = document.createElement('th');
moi.textContent = "Moi"

let ordi = document.createElement('th');
ordi.textContent = "Ordi"


l1.append(moi, ordi);

let td1 = document.createElement('td');

let td2 = document.createElement('td');

let tdimg1 = document.createElement('td')

let tdimg2 = document.createElement('td')

l2.append(tdimg1, tdimg2);

l3.append(td1, td2);
btnPierre.addEventListener('click', function (event) {

    let ordi = Math.floor(Math.random() * 3) + 1;
    console.log(ordi);

    imgMoi.src = imgPierre;

    if (ordi === 3) {
        console.log("J'ai gagné");
        resultat.textContent = ResultatG;
        div.append(resultat);
        div.style.backgroundColor = "green";
        td1.textContent = "1"
        td2.textContent = "0"
        imgOrdi.src = imgCiseau;



    } else if (ordi == 2) {
        console.log("J'ai perdu");

        resultat.textContent = ResultatP;
        div.append(resultat);
        div.style.backgroundColor = "red";
        td1.textContent = "0"
        td2.textContent = "1"
        imgOrdi.src = imgFeuille;

    } else {
        console.log("un partout")
        resultat.textContent = ResultatE;
        div.append(resultat);
        div.style.backgroundColor = "orange";
        td1.textContent = "1"
        td2.textContent = "1"
        imgOrdi.src = imgPierre;


    }

    tdimg1.append(imgMoi)
    tdimg2.append(imgOrdi)
    tableau.append(l1, l2, l3);
    div.append(tableau);
    affichageResultat.append(div);




})

btnFeuille.addEventListener('click', function (event) {


    let ordi = Math.floor(Math.random() * 3) + 1;

    imgMoi.src = imgFeuille;
    if (ordi == 1) {
        console.log("J'ai gagné");
        resultat.textContent = ResultatG;
        div.append(resultat);
        div.style.backgroundColor = "green";
        td1.textContent = "1"
        td2.textContent = "0"
        imgOrdi.src = imgPierre;


    } else if (ordi == 3) {
        console.log("J'ai perdu");

        resultat.textContent = ResultatP;
        div.append(resultat);
        div.style.backgroundColor = "red";

        imgOrdi.src = imgCiseau;
        td1.textContent = "0"
        td2.textContent = "1"


    } else {
        console.log("un partout")
        resultat.textContent = ResultatE;
        div.append(resultat);
        div.style.backgroundColor = "orange";
        td1.textContent = "1"
        td2.textContent = "1"
        imgOrdi.src = imgFeuille;
    }

    tdimg1.append(imgMoi)
    tdimg2.append(imgOrdi)
    tableau.append(l1, l2, l3);
    div.append(tableau);
    affichageResultat.append(div);


})

btnCiseau.addEventListener('click', function (event) {



    let ordi = Math.floor(Math.random() * 3) + 1;

    imgMoi.src = imgCiseau;
    if (ordi == 2) {
        console.log("J'ai gagné");
        resultat.textContent = ResultatG;
        div.append(resultat);
        div.style.backgroundColor = "green";
        td1.textContent = "1"
        td2.textContent = "0"
        imgOrdi.src = imgFeuille;

    } else if (ordi == 1) {
        console.log("J'ai perdu");

        resultat.textContent = ResultatP;
        div.append(resultat);
        div.style.backgroundColor = "red";
        td1.textContent = "0"
        td2.textContent = "1"
        imgOrdi.src = imgPierre;

    } else {
        console.log("un partout")
        resultat.textContent = ResultatE;
        div.append(resultat);
        div.style.backgroundColor = "orange";
        td1.textContent = "1"
        td2.textContent = "1"
        imgOrdi.src = imgCiseau;
    }

    tdimg1.append(imgMoi)
    tdimg2.append(imgOrdi)
    tableau.append(l1, l2, l3);
    div.append(tableau);
    affichageResultat.append(div);


})


