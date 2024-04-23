package ex01;

import java.io.*;

public class FileTableHandler implements TableHandler {
    private static final String TABLE_FILE = "table.txt";

    @Override
    public void saveTable(String table) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TABLE_FILE))) {
            oos.writeObject(table);
            System.out.println("Таблицю збережено успішно.");
        } catch (IOException e) {
            System.err.println("Помилка при збереженні таблиці: " + e.getMessage());
        }
    }

    @Override
    public String restoreTable() {
        String restoredTable = "";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TABLE_FILE))) {
            restoredTable = (String) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при відновленні таблиці: " + e.getMessage());
        }
        return restoredTable;
    }

    @Override
    public void saveTableToFile(String table) {
        try (FileWriter writer = new FileWriter("output_table.txt")) {
            writer.write(table);
            System.out.println("Таблицю успішно збережено у файлі 'output_table.txt'.");
        } catch (IOException e) {
            System.err.println("Помилка при збереженні таблиці в файл: " + e.getMessage());
        }
    }
}
