package app.cristianrcv.sudoku.userinterface;

import app.cristianrcv.sudoku.userinterface.logic.UserInterfaceControlLogic;
import app.cristianrcv.sudoku.game.SudokuGame;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public interface SudokuUserInterface extends EventHandler<KeyEvent> {

    void setListener(UserInterfaceControlLogic listener);

    //update a single square after user input
    void updateSquare(int x, int y, int input);

    //update the entire board, such as after game completion or initial execution of the program
    void updateBoard(SudokuGame game);

    void showDialog(String message);

    void showError(String message);
}
