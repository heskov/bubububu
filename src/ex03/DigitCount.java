package ex03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DigitCount {
    private static Map<Integer, Map<Character, Integer>> resultsMap = new HashMap<>();
    private static Map<Character, Integer> previousDigitCountMap = new HashMap<>();
    private static Map<Character, Integer> beforePreviousDigitCountMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ввести число і показати таблицю");
            System.out.println("2. Вивести передостанню таблицю результатів");
            System.out.println("3. Вийти");

            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введіть ціле число: ");
                    int number = scanner.nextInt();
                    Map<Character, Integer> digitCountMap = countDigits(number);
                    printDigitCountTable(digitCountMap);
                    beforePreviousDigitCountMap = previousDigitCountMap; // оновлюємо передостанній результат
                    previousDigitCountMap = digitCountMap; // оновлюємо попередній результат
                    resultsMap.put(number, digitCountMap);
                    break;
                case 2:
                    if (beforePreviousDigitCountMap.isEmpty()) {
                        System.out.println("Не було введено жодного числа або немає передостанньої таблиці результатів.");
                    } else {
                        System.out.println("Попередня таблиця результатів:");
                        printDigitCountTable(beforePreviousDigitCountMap);
                    }
                    break;
                case 3:
                    System.out.println("Програма завершує роботу.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некоректний вибір.");
            }
        }
    }

    private static Map<Character, Integer> countDigits(int number) {
        Map<Character, Integer> digitCountMap = new HashMap<>();
        String numberString = String.valueOf(number);

        for (char digit : numberString.toCharArray()) {
            if (Character.isDigit(digit)) {
                digitCountMap.put(digit, digitCountMap.getOrDefault(digit, 0) + 1);
            }
        }
        return digitCountMap;
    }

    private static void printDigitCountTable(Map<Character, Integer> digitCountMap) {
        System.out.println("+---------+----------+");
        System.out.println("| Цифра   |Кількість |");
        System.out.println("+---------+----------+");

        for (Map.Entry<Character, Integer> entry : digitCountMap.entrySet()) {
            System.out.printf("|    %c    |    %d     |%n", entry.getKey(), entry.getValue());
            System.out.println("+---------+----------+");
        }
        System.out.println();
    }
}
