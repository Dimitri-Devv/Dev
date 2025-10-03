 
let form = document.querySelector('form')
let pseudo = document.querySelector('#pseudo')
let password = document.querySelector('#password')
let pseudo_error = document.querySelector('#pseudo_error')
let password_error = document.querySelector('#password_error')
let div = document.querySelector('#affichage')
let pseudo_ok = false
let pwd_ok = false
pseudo.addEventListener('blur', ()=>{
    if(pseudo.value.includes(' ')){
        pseudo_error.style.display = 'inline'
        pseudo_ok = false
    }else{
        pseudo_error.style.display = 'none'
        pseudo_ok = true
    }
})
password.addEventListener('blur', ()=>{
    if(password.value.length < 5){
        password_error.style.display = 'inline'
        pwd_ok = false
    }else{
        password_error.style.display = 'none'
        pwd_ok = true
    }
})

form.addEventListener('submit', (e)=>{
    if(!pseudo_ok || !pwd_ok){
        document.querySelector('#submit_error').style.display = 'inline'
    }
    const data = new FormData(form)
    let total = 0
    total += parseInt(data.get('formule'))
    total += parseInt(data.get('dessert'))
    const options = data.getAll('supp')
    options.forEach(supp => {
        total += parseInt(supp)
    });
    console.log(total);
    form.style.display = 'none'
    div.innerHTML = `<h2> Bonjour ${data.get("pseudo")} </h2>
    <p>Vottre commande vous coute ${total}</p>`
    e.preventDefault()
})
 