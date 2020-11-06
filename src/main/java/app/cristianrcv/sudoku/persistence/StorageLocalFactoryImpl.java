package app.cristianrcv.sudoku.persistence;

public class StorageLocalFactoryImpl {

    public static Storage newStorage() {
        return new StorageLocalImpl();
    }
}
