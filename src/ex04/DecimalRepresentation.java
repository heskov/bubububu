package ex04;

import java.util.Scanner;

public class DecimalRepresentation {
    public static void main(String[] args) {
        // Створення об'єкта Scanner для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);

        // Запит у користувача на введення числа
        System.out.print("Введіть ціле число: ");
        int number = scanner.nextInt();

        // Перетворення числа у десяткове подання та вивід результату
        System.out.println(decimalRepresentation(number));

        // Закриття об'єкта Scanner
        scanner.close();
    }

    // Метод для перетворення цілого числа у десяткове подання
    public static String decimalRepresentation(int number) {
        StringBuilder result = new StringBuilder();
        int divisor = 1;
        int qwe[] = new int[10];
        // Визначення дільника для першої цифри числа
        while (number / divisor >= 10) {
            divisor *= 10;
        }

        // Перетворення числа у десяткове подання
        while (divisor != 0) {
            int digit = number / divisor; // Отримання поточної цифри

            

            if (digit != 0) {
                result.append(digit).append(" * 10^").append((int) Math.log10(divisor)).append(" + ");
            }
            number %= divisor; // Видалення поточної цифри
            divisor /= 10; // Перехід до наступної цифри
        }
        for (int i = 0; i < result.toString().length(); i++) {
            char c = result.charAt(i);

            if (!Character.isDigit(c)) { continue; }

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
        // Видалення зайвих символів (" + ") з кінця рядка
        if (result.length() > 0) {
            result.delete(result.length() - 3, result.length());
        }

        return result.toString();
    }
}