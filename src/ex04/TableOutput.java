package ex04;

import java.util.Scanner;

public class TableOutput {
    public static void main(String[] args) {
        // Створення об'єкта Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Запит у користувача на введення числа
        System.out.print("Введіть ціле число: ");
        int number = scanner.nextInt();

        // Закриття об'єкта Scanner
        scanner.close();

        // Викликаємо метод для отримання рядка десяткового представлення
        String decimalRepresentation = DecimalRepresentation.decimalRepresentation(number);

        // Викликаємо метод для виведення результату у вигляді таблиці
        printTable(decimalRepresentation);
    }

    // Метод для виведення результату у вигляді таблиці
    public static void printTable(String decimalRepresentation) {
        // Виведення заголовка таблиці
        System.out.println("Десяткове представлення числа:");
        System.out.println("+-------+------------+");
        System.out.println("| Цифра | Частота    |");
        System.out.println("+-------+------------+");

        // Тут розділити рядок decimalRepresentation на окремі числа та їх частоти
        // та вивести їх у вигляді таблиці
        String[] parts = decimalRepresentation.split("\\|");
        for (String part : parts) {
            String[] pair = part.trim().split(":");
            int digit = Integer.parseInt(pair[0]);
            int frequency = Integer.parseInt(pair[1]);
            System.out.printf("|   %d   |     %d      |\n", digit, frequency);
        }

        // Виведення закриваючого рядка таблиці
        System.out.println("+-------+------------+");
    }
}
