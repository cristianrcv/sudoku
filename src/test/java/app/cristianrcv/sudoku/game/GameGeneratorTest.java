package app.cristianrcv.sudoku.game;

import org.junit.jupiter.api.Test;

class GameGeneratorTest {

    /**
     * Generate a new puzzle based on the appropriate rules, with 30 numbers initially completed.
     */
    @Test
    void onGenerateNewPuzzle() {
        int[][] newPuzzle = SudokuGameFactoryImpl.newGame().getCopyOfGridState();

        int numberOfFilledSquares = 0;

        // Traverse array
        for (int xIndex = 0; xIndex < 9; xIndex++) {
            for (int yIndex = 0; yIndex < 9; yIndex++) {
                if (newPuzzle[xIndex][yIndex] != 0) numberOfFilledSquares++;
            }
        }

        //Check of invalid set up
        assert (!GameLogic.rowsAreInvalid(newPuzzle));
        assert (!GameLogic.columnsAreInvalid(newPuzzle));
        assert (!GameLogic.squaresAreInvalid(newPuzzle));
        assert (numberOfFilledSquares == 81);
    }

    /**
     * After spending several days sorting out how to generate a new valid sudoku puzzle, this test
     * will confirm if my algorithm works.
     */
    @Test
    void test100NewPuzzles() {
        for (int testIndex = 0; testIndex < 100; testIndex++) {
            int[][] newPuzzle = SudokuGameFactoryImpl.newGame().getCopyOfGridState();

            assert (!GameLogic.rowsAreInvalid(newPuzzle));
            assert (!GameLogic.columnsAreInvalid(newPuzzle));
            assert (!GameLogic.squaresAreInvalid(newPuzzle));
            assert (!GameLogic.tilesAreNotFilled(newPuzzle));
        }
    }
}
