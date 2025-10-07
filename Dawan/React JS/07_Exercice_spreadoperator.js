// Données initiales
const taskList = [
  { id: 1, title: "Acheter du lait", completed: false },
  { id: 2, title: "Répondre aux emails", completed: true },
  { id: 3, title: "Faire du sport", completed: false },
];
 
// 1. Utilisez la destructuration pour extraire le titre et le statut (completed) de la première tâche
// Stockez-les dans des variables nommées "firstTaskTitle" et "firstTaskStatus"
 
 const [firstTask] = taskList;

 const {title: firstTaskTitle, completed: firstTaskStatus} = firstTask;
 
 console.log(firstTaskTitle, firstTaskStatus);
 

// 2. Utilisez le spread operator pour créer une copie du tableau taskList
// nommée "taskListCopy"
const taskListCopy = [...taskList];
console.log(taskListCopy);
 
// 3. Copier le dernier objet de la liste, remplacer le title par 'Faire de la musique'
// + ajouter une nouvelle propriété "priority" avec une valeur de 1

const [, , lastTask] = taskList;
const copy = {...taskList, title: "Faire de la musique", priority: 1};
console.log(copy);


 //4.Faire une fonction qui affiche les éléments passés paramètre dans un console.log
 // --> On doit pouvoir passer autant de paramètres que l'on veut quand on appelle la fonction

 
const myFunction = (...params) => {
  params.forEach(element => {
      console.log(element);
      
  });
}
 // 5. Faire un copie du tableau en ne gardant que les objets 'completed' qui sont égales à 'true'
//  --> Vous pouvez le faire aec le .filter()

const taskFiltreRed = taskList.filter((task) => task.completed === true);
console.log(taskFiltreRed);
