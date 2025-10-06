{
//var a une portée plus grande --> Accessible hors du bloc dans lequel il est déclaré.
// Attention var est déconseillé
var myVar = "Hello World !";


// let & const --> Ne sont pas disponibles que dnas le bloc et pas hors du bloc ( {} )
let myLet = "Hello World !";
const myConst = "Hello world !";

console.log(myLet);
console.log(myConst);
}

console.log(myVar);


var x = 10;
console.log("1", x);

{
    let x = 2;

    console.log("2", x);

    var y = 5;
    const z = 6;

}

console.log("3", x);
console.log("4", y);
console.log("5", z);