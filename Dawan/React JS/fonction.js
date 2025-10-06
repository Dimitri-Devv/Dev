// Fonction type "void" -> Elles ne retournent rien.
function hello(){
    console.log("Hello World !");
}

// Fontion qui retourne quelque chose :
function helloName(name){
    return "Hello, " + name;
}

hello();

const result = helloName("Florian");
console.log(result);


console.log("______________ fonctions fléchées _________________");

const helloFleche = () => {
    console.log("Hello World !");
};

const helloNameFleche = (name) => {
    return "Hello, " + name;
}

helloFleche();
const resultFleche = helloNameFleche("Toto");
console.log(resultFleche);

console.log("______________ Réécriture helloNameFleche _________________");

const helloNameFleche2 = (name) => "Hello, " + name;

const exp = () =>{
    // Plusieurs instructions
    // Puis le return

    return "résultat !";
}

const resultFleche2 = helloNameFleche2("Bob");
console.log(resultFleche2);