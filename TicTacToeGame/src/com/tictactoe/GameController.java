package com.tictactoe;

public class GameController {

    private TicTacToe game;

    public GameController() {
        game = new TicTacToe();
    }

    // Get the current game state (board and player)
    public String[] getBoard() {
        return game.getBoard();
    }

    public String getCurrentPlayer() {
        return game.getCurrentPlayer();
    }

    // Handle a move from the player
    public boolean makeMove(int position) {
        return game.makeMove(position);
    }

    // Check if the game is over (win or draw)
    public boolean isGameOver() {
        return game.isGameOver();
    }

    // Reset the game for a new round
    public void resetGame() {
        game.resetGame();
    }

    // Check if there's a winner
    public boolean checkWinner() {
        return game.checkWinner();
    }
}
