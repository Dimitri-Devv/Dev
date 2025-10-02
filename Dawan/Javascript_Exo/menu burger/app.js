//header
const header = document.createElement("header");

// Logo
const logo = document.createElement("div");
logo.className = "logo";
logo.textContent = "Mon Site";
header.appendChild(logo);

// Navigation
const nav = document.createElement("nav");
const liens = ["Accueil", "Services", "Portfolio", "Contact"];

liens.forEach(texte => {
    const a = document.createElement("a");
    a.href = "#";
    a.textContent = texte;
    nav.appendChild(a);
});

document.body.appendChild(nav);

// Burger
const burger = document.createElement("div");
burger.className = "burger";
burger.innerHTML = "<div></div><div></div><div></div>";
header.appendChild(burger);

// Ajout du header dans la page
document.body.prepend(header);

// Overlay
const overlay = document.createElement("div");
overlay.className = "overlay";
document.body.appendChild(overlay);

// === Interaction Burger ===
burger.addEventListener("click", () => {
    nav.classList.toggle("active");
    overlay.classList.toggle("active");
});

// === Fermer le menu si on clique sur l’overlay ===
overlay.addEventListener("click", () => {
    nav.classList.remove("active");
    overlay.classList.remove("active");
});

//Utilisation btn
let btn = document.querySelector('button');
btn.addEventListener("click", () => {
    alert('Coucou')
});

