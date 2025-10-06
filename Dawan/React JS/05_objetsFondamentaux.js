// 1. Création d'un objet 'à la volée'

const user = {
  firstName: "John",
  lastName: "Doe",
  age: 25,
};

// 2. Création d'un objet en passant par un modèle
class Car {
  #name;
  //   model;
  //   year;

  constructor(nameProp, model, year) {
    // this.#name = nameProp; // Pour attribuer la valeur directement, sans utiliser le 'setter'
    this.name = nameProp; // En passant par le setter. Intéressant pour nous, car on exécute la vérif du setter aussi lors de la création
    this.model = model;
    this.year = year;
  }

  display() {
    console.log(
      `voiture, nom: ${this.#name}, modèle: ${this.model}, annee: ${this.year}`
    );
  }

  get name() {
    return this.#name;
  }

  set name(newValue) {
    if (!newValue || newValue === "") {
      throw new Error("'name' de l'objet 'Car' est obligatoire !");
    }
    this.#name = newValue;
  }
}

const car = new Car("BMW", "X5", 2019);

console.log(user);
console.log(car);

// 3. Accès aux propriétés et aux méthodes de class d'un objet
const name = user.firstName;
const model = car.model;
car.display();

console.log(name);
console.log(model);

// 3.bis Accès aux propriétés d'un objet avec les accesseurs
const age = user["age"];
const year = car["year"];
console.log(age);
console.log(year);

// 4. Accès aux propriétés avec getter
const car2 = new Car("Audi", "A4", 2019);
// console.log(car2.#name); // Impossible car #name est privé
console.log(car2.name);

car2.name = null;
console.log(car2.name);

const carError = new Car("", "X5", 2019);