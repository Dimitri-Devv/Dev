// La fonction filter crée une copie du tableau existant, ne MODIFIE PAS le tableau d'origine.
//filter() applique un filtre sur les éléements
const words = ["spray", "elite", "exuberant", "destruction", "present"];

//La fonction passée en param du .filter doit retourner la condition de votre 'filtre'
const wordsFilter = words.filter((word) => word.length > 6)
//console.log(wordsFilter);

//Exercice
//1.Créer un tableau qui contient les nombres supérieurs à 5
//2.Créer un tableau qui contient les nombres pairs ( % 2 === 0)
//3. Faire une fonction 'textFilter(entreeUtilisateur)' qui prend un parametre une chaine de caractères
// la fonction doit retourner un tableau qui contient uniquement les mots qui contiennent la chaine de caractères passée en param

const numbers  = [1,2,3,4,5,6,7,8,9,10];

const newNumhers = [];
const NbPair = [];

numbers.forEach(element => {
    if(element > 5){
        newNumhers.push(element);
    }
    if(element % 2 === 0){
        NbPair.push(element);
    }
});

console.log(newNumhers);
console.log(NbPair);

const entreeUtilisateurss = "es";

const textFilter = (entreeUtilisateur) => words.filter((mot) => mot.includes(entreeUtilisateur));
    

console.log(textFilter(entreeUtilisateurss));


