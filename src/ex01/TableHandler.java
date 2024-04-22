package ex01;

import java.io.*;

public class TableHandler implements Serializable {
    private static final String TABLE_FILE = "table.txt";

    public static void saveTable(String table) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TABLE_FILE))) {
            oos.writeObject(table);
            System.out.println("Таблицю збережено успішно.");
        } catch (IOException e) {
            System.err.println("Помилка при збереженні таблиці: " + e.getMessage());
        }
    }

    public static String restoreTable() {
        String restoredTable = "";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TABLE_FILE))) {
            restoredTable = (String) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при відновленні таблиці: " + e.getMessage());
        }
        return restoredTable;
    }
}
