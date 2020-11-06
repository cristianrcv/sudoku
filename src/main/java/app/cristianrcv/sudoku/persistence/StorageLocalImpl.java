package app.cristianrcv.sudoku.persistence;

import app.cristianrcv.sudoku.game.SudokuGame;

import java.io.*;


/**
 * JSON is a simple language which is commonly used for storage and data transfer in Desktop, Web, and Mobile
 * programming. By having one simple language which can be understood by a wide variety of different platforms and
 * operating systems, this makes life easier for us programmers to have our programs communicate with each other, and
 * work on more devices.
 */
public class StorageLocalImpl implements Storage {

    private static final String GAME_DATA_FILE_PATH = System.getProperty("user.home") + File.separator + "gamedata.txt";

    private final File gameData;

    StorageLocalImpl() {
        gameData = new File(GAME_DATA_FILE_PATH);
    }

    @Override
    public void updateGameData(SudokuGame game) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(gameData);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new IOException("Unable to access Game Data");
        }
    }

    @Override
    public SudokuGame getGameData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(gameData);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            SudokuGame gameState = (SudokuGame) objectInputStream.readObject();
            objectInputStream.close();
            return gameState;
        } catch (ClassNotFoundException e) {
            throw new IOException("File Not Found");
        }
    }

}
