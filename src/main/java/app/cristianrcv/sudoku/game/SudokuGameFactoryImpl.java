package app.cristianrcv.sudoku.game;

import app.cristianrcv.sudoku.game.constants.GameState;

public class SudokuGameFactoryImpl implements GameFactory {

    private SudokuGameFactoryImpl() {
        // Prevent factory from being instantiated
    }

    public static SudokuGame newGame() {
        return new SudokuGame(GameState.NEW, GameGenerator.getNewGameGrid());
    }

    public static SudokuGame newGame(int[][] grid) {
        GameState status = GameLogic.checkForCompletion(grid);
        return new SudokuGame(status, grid);
    }
}
