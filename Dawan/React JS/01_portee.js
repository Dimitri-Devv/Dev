{
  // var a une portée plus grande -> accessible hors du bloc dans lequel il est déclaré
  // Attention: var est déconseillé
  var myVar = "Hello world";

  let myLet = "Hello world";
  const myConst = "Hello world";
}

console.log(myVar);
// console.log(myLet);
// console.log(myConst);

console.log("_____________________________________");

var x = 10;
console.log("1", x); // 1 -> 10

{
  let x = 2;
  console.log("2", x); // 2 ->  20 | 2 | 22

  var y = 5;
  const Z = 6;
}

console.log("3", x); // 3 -> 10
console.log("4", y); // 4 -> 5
console.log("5", Z); // 5 -> erreur
