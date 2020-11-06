package app.cristianrcv.sudoku;

import app.cristianrcv.sudoku.game.SudokuGame;
import app.cristianrcv.sudoku.game.SudokuGameFactoryImpl;
import app.cristianrcv.sudoku.persistence.Storage;
import app.cristianrcv.sudoku.persistence.StorageLocalFactoryImpl;
import app.cristianrcv.sudoku.userinterface.GameUserInterfaceFactoryImpl;
import app.cristianrcv.sudoku.userinterface.SudokuUserInterface;
import app.cristianrcv.sudoku.userinterface.logic.UserInterfaceControlLogic;
import app.cristianrcv.sudoku.userinterface.logic.UserInterfaceControlLogicFactoryImpl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is the Root Container (the thing which attends to all of the primary objects which must communicate when
 * the program is running (a running program is called a "process").
 */
public class SudokuApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Initialise components
        SudokuUserInterface sudokuUserInterface = GameUserInterfaceFactoryImpl.newSudokuUserInterface(primaryStage);
        Storage storage = StorageLocalFactoryImpl.newStorage();
        UserInterfaceControlLogic uiControlLogic = UserInterfaceControlLogicFactoryImpl.newControlLogic(storage, sudokuUserInterface);

        sudokuUserInterface.setListener(uiControlLogic);

        // Retrieve game or start a new one
        SudokuGame initialState;
        try {
            // Will throw if no game data is found in local storage
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = SudokuGameFactoryImpl.newGame();
            //this method below will also throw an IOException
            //if we cannot update the game data. At this point
            //the application is considered unrecoverable
            storage.updateGameData(initialState);
        }

        // Start or continue game
        sudokuUserInterface.updateBoard(initialState);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
