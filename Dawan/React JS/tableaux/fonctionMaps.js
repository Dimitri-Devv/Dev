// La fonction map crée une copie du tableau existant, et applique la même opération sur chacun des éléments du tableau.
// La fonction map de MODIFIE PAS le tableau d'origine.

const persons = [

  { firstName: "Malcom", lastName: "Reynolds" },

  { firstName: "Kaylee", lastName: "Frye" },

  { firstName: "Jayne", lastName: "Cobb" },

];

const firstName = persons.map((element) => element.firstName);


 