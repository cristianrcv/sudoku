package app.cristianrcv.sudoku.userinterface;

import javafx.stage.Stage;

public class GameUserInterfaceFactoryImpl implements SudokuUserInterfaceFactory {

    private GameUserInterfaceFactoryImpl() {
        // Prevent factory from being instantiated
    }

    public static SudokuUserInterface newSudokuUserInterface(Stage primaryStage) {
        return new GameUserInterfaceImpl(primaryStage);
    }
}
