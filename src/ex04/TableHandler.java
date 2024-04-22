package ex04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TableHandler {
    private static final String FILENAME = "table.txt";

    public static void saveTable(String table) {
        // Реалізація методу збереження таблиці без змін
    }

    public static String restoreTable() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILENAME));
            StringBuilder builder = new StringBuilder();
            for (String line : lines) {
                builder.append(line+"\n");
            }
            return builder.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}    