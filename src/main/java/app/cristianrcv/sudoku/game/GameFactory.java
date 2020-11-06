package app.cristianrcv.sudoku.game;

import app.cristianrcv.sudoku.game.constants.GameState;

public interface GameFactory {

    static SudokuGame newGame() {
        return null;
    }

    static SudokuGame newGame(int[][] grid) {
        return null;
    }
}
