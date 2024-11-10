package com.tictactoe;

public class TicTacToe {

    // Game board as a 3x3 array
    private String[] board;
    private String currentPlayer;
    private boolean gameOver;

    public TicTacToe() {
        board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = "";
        }
        currentPlayer = "X"; // X starts first
        gameOver = false;
    }

    // Get the current board state
    public String[] getBoard() {
        return board;
    }

    // Get the current player
    public String getCurrentPlayer() {
        return currentPlayer;
    }

    // Switch the player turn
    public void switchPlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }

    // Make a move in the game
    public boolean makeMove(int position) {
        if (position < 0 || position >= 9 || !board[position].equals("") || gameOver) {
            return false;
        }

        // Place the current player's mark on the board
        board[position] = currentPlayer;

        // Check for a winner
        if (checkWinner()) {
            gameOver = true;
        } else {
            switchPlayer();
        }
        return true;
    }

    // Check if there is a winner
    public boolean checkWinner() {
        // Winning combinations
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] pattern : winPatterns) {
            if (board[pattern[0]].equals(currentPlayer) &&
                board[pattern[1]].equals(currentPlayer) &&
                board[pattern[2]].equals(currentPlayer)) {
                return true;
            }
        }
        return false;
    }

    // Check if the game is over (either win or draw)
    public boolean isGameOver() {
        // If the game is over due to a winner
        if (gameOver) {
            return true;
        }

        // Check for a draw: no empty spaces left and no winner
        for (String cell : board) {
            if (cell.equals("")) {
                return false;
            }
        }
        return true; // It's a draw if all spaces are filled and no winner
    }

    // Reset the game for a new round
    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            board[i] = "";
        }
        gameOver = false;
        currentPlayer = "X";
    }
}
