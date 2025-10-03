let prenom = document.querySelector('#prenom')

prenom.addEventListener('change', ()=>{

    if(prenom.value.length < 5){
        console.log('Erreur nom trop court');
        document.querySelector('span').textContent = 'Nom trop court'
    }else{
        document.querySelector('span').textContent = ''
    }  

})

let nom = document.querySelector('#nom')

nom.addEventListener('input', ()=>{
    console.log("Detection à l'input");
    console.log(nom.value);

})

nom.addEventListener('focus', ()=>{
    console.log('Au focus');
})


let form = document.querySelector('form')

form.addEventListener('submit', (e)=>{
    // 
    let data = new FormData(form)

    console.log(data);
    console.log(data.get('prenom'));


    let check = document.querySelector('#cgu')

    console.log(check.checked);

    console.log(check.value);


    e.preventDefault()
})