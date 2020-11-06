package app.cristianrcv.sudoku.userinterface;

import javafx.stage.Stage;

public class BadUserInterfaceFactoryImpl {

    private BadUserInterfaceFactoryImpl() {
        // Prevent factory from being instantiated
    }

    public static SudokuUserInterface newSudokuUserInterface(Stage primaryStage) {
        return new BadUserInterfaceImpl(primaryStage);
    }
}
