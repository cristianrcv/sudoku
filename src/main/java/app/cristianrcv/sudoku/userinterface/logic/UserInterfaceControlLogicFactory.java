package app.cristianrcv.sudoku.userinterface.logic;

import app.cristianrcv.sudoku.persistence.Storage;
import app.cristianrcv.sudoku.userinterface.SudokuUserInterface;

interface UserInterfaceControlLogicFactory {

    static UserInterfaceControlLogic newControlLogic(Storage storage, SudokuUserInterface view) {
        return null;
    }
}
