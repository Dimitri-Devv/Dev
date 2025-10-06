function hello() {
  console.log("Hello world");
}

function helloName(name) {
  return "Hello " + name;
}

hello();
const result = helloName("Toto");
console.log(result);

console.log("___________________ fonctions fléchées ___________________");

const helloFleche = () => {
  console.log("Hello world");
};

const helloNameFleche = (name) => {
  return "Hello " + name;
};

helloFleche();

const resultFleche = helloNameFleche("Toto");
console.log(resultFleche);

console.log(
  "___________________ Réécriture helloNameFleche ___________________"
);

const helloNameFleche2 = (name) => "Hello " + name;

const exp = () => {
  // Plusieurs instruction
  // Puis le return

  return "résultat";
};

const resultFleche2 = helloNameFleche2("Toto");
console.log(resultFleche2);
