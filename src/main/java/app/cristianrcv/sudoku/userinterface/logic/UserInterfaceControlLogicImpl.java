package app.cristianrcv.sudoku.userinterface.logic;

import app.cristianrcv.sudoku.game.SudokuGame;
import app.cristianrcv.sudoku.game.SudokuGameFactoryImpl;
import app.cristianrcv.sudoku.game.constants.GameState;
import app.cristianrcv.sudoku.game.constants.Messages;
import app.cristianrcv.sudoku.persistence.Storage;
import app.cristianrcv.sudoku.userinterface.SudokuUserInterface;

import java.io.IOException;

/**
 * Since this is a single screen application, just one container (class) for the logic of the user interface is
 * necessary. Break these things up when building applications with more screens/features. Don't build God Classes!
 */
class UserInterfaceControlLogicImpl implements UserInterfaceControlLogic {

    private Storage storage;
    //Remember, this could be the real UserInterfaceImpl, or it could be a test class
    //which implements the same interface!
    private SudokuUserInterface view;

    UserInterfaceControlLogicImpl(Storage storage, SudokuUserInterface view) {
        this.storage = storage;
        this.view = view;
    }

    /**
     * Use Case:
     * 1. Retrieve current "state" of the data from IStorage
     * 2. Update it according to the input
     * 3. Write the result to IStorage
     *
     * @param x     X coordinate of the selected input
     * @param y     Y ...
     * @param input Which key was entered, One of:
     *              - Numbers 0-9
     */
    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            gameData = SudokuGameFactoryImpl.newGame(newGridState);

            storage.updateGameData(gameData);

            //either way, update the view
            view.updateSquare(x, y, input);

            //if game is complete, show dialog
            if (gameData.getGameState() == GameState.COMPLETE) view.showDialog(Messages.GAME_COMPLETE);
        } catch (IOException e) {
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogClick() {
        try {
            storage.updateGameData(SudokuGameFactoryImpl.newGame());
            view.updateBoard(storage.getGameData());
        } catch (IOException e) {
            view.showError(Messages.ERROR);
        }
    }
}
