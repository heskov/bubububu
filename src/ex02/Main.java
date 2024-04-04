package ex02;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<DecimalNumberAnalysis> history = new ArrayList<>();
        int number;

        while (true) {
            System.out.println("Введіть десяткове число (або -1, щоб вийти або -2, щоб переглянути історію):");
            number = scanner.nextInt();

            if (number == -1) {
                break; // Виходимо з циклу, якщо користувач ввів -1
            } else if (number == -2) {
                // Виводимо історію аналізу
                if (history.isEmpty()) {
                    System.out.println("Історія порожня.");
                } else {
                    System.out.println("Історія аналізу:");
                    for (int i = 0; i < history.size(); i++) {
                        System.out.println("Результати для числа " + (i + 1) + ":");
                        System.out.println(history.get(i).getAnalysisResult());
                    }
                }
                continue;
            }

            DecimalNumberAnalysis analysis = new DecimalNumberAnalysis(number);
            analysis.countDigits();
            history.add(analysis);

            // Вивід результатів аналізу
            System.out.println("Результати аналізу десяткового числа " + number + ":");
            System.out.println(analysis.getAnalysisResult());
        }

        scanner.close();
        System.out.println("Програма завершила роботу.");
    }
}
