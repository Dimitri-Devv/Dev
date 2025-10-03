const board = document.getElementById('board');
const status = document.getElementById('status');

let currentPlayer = 'X';
let cells = Array(9).fill(''); // tableau pour stocker l'état des cases

// Créer 9 cases
for (let i = 0; i < 9; i++) {
  const cell = document.createElement('div');
  cell.classList.add('cell');
  cell.dataset.index = i;
  cell.addEventListener('click', handleClick, { once: true });
  board.appendChild(cell);
}

function handleClick(e) {
  const index = e.target.dataset.index;
  cells[index] = currentPlayer;
  e.target.textContent = currentPlayer;

  if (checkWin()) {
    textContent = `${currentPlayer} a gagné !`;
    endGame();
    return;
  }

  if (cells.every(cell => cell !== '')) {
    status.textContent = "Égalité !";
    return;
  }

  currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
  status.textContent = `À ${currentPlayer} de jouer`;
}

function checkWin() {
  const winCombos = [
    [0,1,2],[3,4,5],[6,7,8], // lignes
    [0,3,6],[1,4,7],[2,5,8], // colonnes
    [0,4,8],[2,4,6]          // diagonales
  ];

  return winCombos.some(combo => 
    combo.every(index => cells[index] === currentPlayer)
  );
}

function endGame() {
  // enlever l'écoute des clics pour toutes les cases
  document.querySelectorAll('.cell').forEach(cell => cell.replaceWith(cell.cloneNode(true)));
}
