package app.cristianrcv.sudoku.userinterface.logic;

import app.cristianrcv.sudoku.persistence.Storage;
import app.cristianrcv.sudoku.userinterface.SudokuUserInterface;

public class UserInterfaceControlLogicFactoryImpl {

    private UserInterfaceControlLogicFactoryImpl() {
        // Prevent factory from being instantiated
    }

    public static UserInterfaceControlLogic newControlLogic(Storage storage, SudokuUserInterface view) {
        return new UserInterfaceControlLogicImpl(storage, view);
    }
}
