// 1. Création d'un tableau

let myArray = [];
const myNames = ["Riri", "Fifi", "Loulou"];
let myArray2 = new Array(5);

console.log(myArray, myNames, myArray2);

// 2. Ajout / suppression de valeurs

// Ajout :
myArray.push("Toto");
myNames.push("Toto");
myArray2.push("Toto");
console.log(myArray, myNames, myArray2);

// Suppression : (avec splice() __ https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice )
// --> supression avec splice: splice(index, nombre d'élements à supprimer)
myArray.splice(0, 1); // On choisit de supprimer 1 élément, à partir de l'élément d'index 1
myNames.splice(3, 1);
myArray2.splice(5, 1);
console.log(myArray, myNames, myArray2);

// Remplacement avec splice
// -> On veut remplacer 'Fifi' par 'Tata'
myNames.splice(1, 1, "Tata");
console.log(myNames);

// 3. Parcourir les tableaux
for (name of myNames) {
  console.log(name);
}

myNames.forEach((name) => console.log(name));

myNames.forEach((element, index, array) =>
  console.log(index + ": " + element + " et tableau: " + array)
);
