// 1. Création d'un tableau

let myArray = [];
const myNames = ["Riri", "Fifi", "Loulou"];
let myArray2 = new Array(5);

console.log(myArray, myNames, myArray2);

// 2. Ajout / suppression de valeurs

    // Ajout : 
    // .push => Permet d'ajouter une valeur à la fin
    myArray.push('Toto');
     myNames.push('Bob');
    myArray2.push('Flo');
   
    console.log(myArray, myNames, myArray2);

    // Suprresion :
    // .splice() => Voir MDN si besoin): .splice(index, nombre d'élément à supprimer)
    myArray.splice(0, 1); // On choisit de supprimer l'élément, à partir de l'élément d'index 1
    myNames.splice(3, 1);
    myArray2.splice(5, 1);

    console.log(myArray, myNames, myArray2);

    // Remplacement :
    // .splice() => On veut remplacer 'Fifi' par 'Tata'
    myNames.splice(1, 1, "Tata");
    console.log(myNames);

    //3. Parcourir les tableaux
    for (name of myNames){
        console.log(name);
    }

    myNames.forEach((name) => console.log(name));

    myNames.forEach((element, index, array) => 
        console.log(index + ': ' + element + 'et tableau: ' + array)
    );