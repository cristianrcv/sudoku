package app.cristianrcv.sudoku.persistence;

import app.cristianrcv.sudoku.game.SudokuGame;

import java.io.IOException;

public interface Storage {

    void updateGameData(SudokuGame game) throws IOException;

    SudokuGame getGameData() throws IOException;
}
