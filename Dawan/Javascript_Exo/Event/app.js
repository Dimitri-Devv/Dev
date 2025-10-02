//Sélectionner l'élément qui va écouter l'élément

const btn = document.querySelector('button');

//Applique l'écouteur d'événement 

//3 parametre possible sur le addEventListener

//1er parametre que l'on va écouter

//2eme parametre => Action à produire

//3eme parametre => Objet d'options optionnelles
btn.addEventListener('click', function (event) {
    //alert('ça fonctionne')
    //btn.style.color = 'yellow'
    //event.target renvoi la cible du click
    //console.log(event.target);
    //event.currentTarget va renvoyer la cible qui lance l'événement
    //console.log(event.currentTarget);


}, {
    //once: lance l'action une seule fois
    once: true,
    //capture: changer le sens de propagation
    capture: true,
    //Désactive la verification du prevent default pour gagner en performance,

    passive: true

})

let btns = document.querySelectorAll('button')
btns.forEach(btn => {
    btn.addEventListener('click', (event) => {
        console.log(event.currentTarget);

        if (event.currentTarget.value == 1) {
            alert("j'ai cliqué")
        } else if (event.currentTarget.value == 2) {
            event.currentTarget.textContent = "j'ai déjà cliqué"
        } else {
            event.currentTarget.style.color = 'blue'
        }
    })
});

document.querySelector('div').addEventListener('click', (e) => {
    console.log('Click sur le bouton');

}, {
    capture: true
})

document.querySelector('.new').addEventListener('click', (e) => {
    console.log('click sur le btn');

})



