// 1. Destructuration sur les tableaux

const numbersOne = [1, 2, 3, 4, 5];
const numbersTwo = [6, 7, 8, 9, 10];

console.log(...numbersOne);
console.log(1, 2, 3, 4, 5); // Equivalent

// Pour copie propre d'un tableau
const copy1 = [...numbersOne];
console.log(copy1);

copy1.push(6);
console.log(numbersOne, copy1);

// Pour concaténer (/fusionner) deux tableaux
const allNumbers = [...numbersOne, ...numbersTwo];
console.log(allNumbers);

//2. Sprad operator En paramètres d'une fonction
const add = (...numbers) => {
  console.log(numbers); // Numbers est un tableaus
  let result = 0;
  // numbers.forEach((n) => result = result + n);
  numbers.forEach((n) => (result += n));

  return result;
};

const addWithReduce = (...numbers) => {
  return numbers.reduce((total, n) => total + n);
};

const result = add(1, 2, 3, 4, 5, 8);
const result2 = addWithReduce(1, 2, 3, 4, 5, 8);

console.log("fonction add: ", result, result2);

// 3. Destructuration sur les objets
user = {
  firstName: "John",
  lastName: "Doe",
  age: 25,
};

// Copie propre d'un objet
userCopy = { ...user };
console.log(userCopy);

userCopy.firstName = "James";
console.log(userCopy);

// Copie + modification/ajout de propriétés
user2 = { ...user, city: "New York" }; // rajoute un propriété
console.log(user2);

user2 = { ...user, age: 30 }; // copier en modifiant l'age
console.log(user2);

// Concaténation de 2 objets
userInfo = {
  numberPhone: "0123456789",
  city: "Paris",
};

user3 = { ...user, ...userInfo };
console.log(user3);

// 4. Destruction
const cars = ["Mustang", "Corvette", "F-150", "Focus"];

const [car1, car2, car3, car4] = cars; // Equivalent aux lignes ci-dessous
// const car1 = cars[0];
// const car2 = cars[1];
// const car3 = cars[2];
// const car4 = cars[3];

console.log(car1, car2, car3, car4);

const [car5, , , car6] = cars;
console.log(car5, car6);

const calculate = (a, b) => {
  const add = () => a + b;
  const sub = () => a - b;
  const mul = () => a * b;
  const div = () => a / b;

  return [add, sub, mul, div];
};

const [calAdd, calSub, , calDiv] = calculate(2, 1);
console.log(calAdd(), calSub(), calDiv());

// 5. Destructuration + Spread operator
const numbers = [1, 2, 3, 4, 5];
const [a, b, ...c] = numbers;
// const [a, b, ...rest] = numbers;  // On retrouve souvent '...rest' , mais on peut choisir le nom que l'on souhaite

console.log(c);

// 6. Destructuration sur les objets
const person = {
  firstName: "John",
  lastName: "Doe",
  age: 25,
};

const { age, lastName, firstName } = person;
console.log(age, lastName, firstName);

// Choisir un nom de variable différent de celui de l'attribut de l'objet
const { age: personAge } = person;

const calculateObj = (a, b) => {
  const add = () => a + b;
  const sub = () => a - b;
  const mul = () => a * b;
  const div = () => a / b;

  //   return { add: add, sub: sub, mul: mul, div: div };
  return { add, sub, mul, div }; // équivalent à la ligne ci-dessus
};

// L'objet retourné par la fonction calculateObj :
{
  add: () => a + b;
  sub: () => a - b;
  mul: () => a * b;
  div: () => a / b;
}

const { div } = calculateObj(2, 1); // importer / récupérer la fonction

const resultDiv = div();

console.log(div());