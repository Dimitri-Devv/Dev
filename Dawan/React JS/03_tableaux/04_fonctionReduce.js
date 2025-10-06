//La fonction reduce ne modifie pas le tableau d'origine
// La fonction reduce applique une fonction du reduction
//.reduce() retourne une valeur unique

const myArray = [1,2,3,4,5];

//Appliquer .reduce() pour additionner tous les chiffres
const sum = myArray.reduce((total, element ) => total + element);
console.log(sum);


//Avec une 'initialValue'
// --> ci-dessous, le total intial est égale à 10
const sum2 = myArray.reduce((total, element ) => total + element, 10);
console.log(sum2);
