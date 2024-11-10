// Initialize the game board and game state
let gameBoard = ['', '', '', '', '', '', '', '', ''];
let currentPlayer = 'X'; // X starts first

// Render the game board dynamically
function renderBoard() {
    const board = document.getElementById('game-board');
    board.innerHTML = '';  // Clear the board first

    gameBoard.forEach((cell, index) => {
        const cellElement = document.createElement('div');
        cellElement.classList.add('cell');
        cellElement.innerText = cell;
        cellElement.addEventListener('click', () => handleCellClick(index));
        board.appendChild(cellElement);
    });
}

// Handle cell click and make a move
function handleCellClick(index) {
    if (gameBoard[index] !== '') return; // Don't allow move if cell is occupied

    gameBoard[index] = currentPlayer;
    renderBoard();
    if (checkWinner()) {
        setTimeout(() => alert(`${currentPlayer} wins!`), 100);
        return;
    }
    currentPlayer = currentPlayer === 'X' ? 'O' : 'X'; // Switch player
}

// Check if there is a winner
function checkWinner() {
    const winPatterns = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], // Rows
        [0, 3, 6], [1, 4, 7], [2, 5, 8], // Columns
        [0, 4, 8], [2, 4, 6] // Diagonals
    ];

    for (const pattern of winPatterns) {
        const [a, b, c] = pattern;
        if (gameBoard[a] && gameBoard[a] === gameBoard[b] && gameBoard[a] === gameBoard[c]) {
            return true;
        }
    }
    return false;
}

// Reset the game
function resetGame() {
    gameBoard = ['', '', '', '', '', '', '', '', ''];
    currentPlayer = 'X';
    renderBoard();
}

document.getElementById('reset-btn').addEventListener('click', resetGame);

// Initialize the board
renderBoard();
