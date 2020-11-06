package app.cristianrcv.sudoku.userinterface;

import javafx.stage.Stage;

/**
 * Factory interface for new {@link SudokuUserInterface} instances.
 */
public interface SudokuUserInterfaceFactory {

    /**
     * Creates a new {@link SudokuUserInterface} instance.
     *
     * @param primaryStage First stage.
     * @return A new {@link SudokuUserInterface} instance.
     */
    static SudokuUserInterface newSudokuUserInterface(Stage primaryStage) {
        return null;
    }
}
