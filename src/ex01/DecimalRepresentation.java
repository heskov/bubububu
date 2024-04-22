package ex01;


import java.util.Scanner;
import ex04.CommandHistory;
import java.io.FileWriter;
import java.io.IOException;

public class DecimalRepresentation {
    private static final CommandHistory commandHistory = new CommandHistory();
    private static String currentTable = "";

    public static void main(String[] args) {
        String restoredTable = TableHandler.restoreTable();
        System.out.println("Відновлена таблиця:");
        System.out.println(restoredTable);
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("Меню:");
            System.out.println("1. Введення числа");
            System.out.println("2. Зберегти таблицю");
            System.out.println("3. Відновити таблицю");
            System.out.println("4. Скасувати останню команду");
            System.out.println("5. Вийти");
            System.out.print("Вибір: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введіть число: ");
                    int number = scanner.nextInt();
                    currentTable = decimalRepresentation(number);
                    break;
                case 2:
                    TableHandler.saveTable(currentTable);
                    break;
                case 3:
                    restoredTable = TableHandler.restoreTable();
                    System.out.println("Відновлена таблиця:");
                    System.out.println(restoredTable);
                    break;
                case 4:
                    currentTable = commandHistory.pop();
                    System.out.println("Минула команда скасована.");
                    break;
                case 5:
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Невірний вибір. Будь ласка, виберіть знову.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static String decimalRepresentation(int number) {
        StringBuilder result = new StringBuilder();
        int divisor = 1;
        int[] qwe = new int[10];

        if (number == 0) {
            System.out.println("Таблиця ще не була збережена.");
            return "";
        }

        while (number / divisor >= 10) {
            divisor *= 10;
        }

        while (divisor != 0) {
            int digit = number / divisor;

            if (digit != 0) {
                result.append(digit).append(" * 10^").append((int) Math.log10(divisor)).append(" + ");
            }
            number %= divisor;
            divisor /= 10;
        }
        for (int i = 0; i < result.toString().length(); i++) {
            char c = result.charAt(i);

            if (!Character.isDigit(c)) {
                continue;
            }

            int d = Character.getNumericValue(c);

            qwe[d]++;
        }
        System.out.println("+" + "-".repeat(8) + "+-" + "-".repeat(12) + "+");
        System.out.printf("| %-7s| %-11s |\n", "Число", "Кількість");
        for (int i = 0; i < 10; i++) {
            System.out.println("+" + "-".repeat(8) + "+-" + "-".repeat(12) + "+");
            System.out.printf("| %-7d| %-11d |\n", i, qwe[i]);
        }
        System.out.println("+" + "-".repeat(8) + "+-" + "-".repeat(12) + "+");
        System.out.println(" ");

        if (result.length() > 0) {
            result.delete(result.length() - 3, result.length());
        }

        // Зберегти виведену таблицю у файл
        saveTableToFile(result.toString());

        // Зберегти поточну таблицю в історію команд
        commandHistory.push(result.toString());

        return result.toString();

    }

    public static void saveTableToFile(String table) {
        try (FileWriter writer = new FileWriter("output_table.txt")) {
            writer.write(table);
            System.out.println("Таблицю успішно збережено у файлі 'output_table.txt'.");
        } catch (IOException e) {
            System.err.println("Помилка при збереженні таблиці в файл: " + e.getMessage());
        }

    }
}
