package ex;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DigitCounterFactory factory = new DigitCounterFactory();
        DigitCounter digitCounter = null;

        while (true) {
            System.out.println("1. Ввести число");
            System.out.println("2. Зберегти стан об'єкта");
            System.out.println("3. Відновити стан об'єкта");
            System.out.println("4. Вийти");

            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введіть ціле число: ");
                    int number = scanner.nextInt();
                    digitCounter = factory.createDigitCounter(number);
                    System.out.println(digitCounter);
                    break;
                case 2:
                    saveObject(digitCounter);
                    break;
                case 3:
                    digitCounter = restoreObject();
                    if (digitCounter != null) {
                        System.out.println("Відновлено об'єкт: " + digitCounter);
                    }
                    break;
                case 4:
                    System.out.println("Програма завершує роботу.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некоректний вибір.");
            }
        }
    }

    private static void saveObject(DigitCounter digitCounter) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("digit_counter.ser"));
            out.writeObject(digitCounter);
            out.close();
            System.out.println("Об'єкт збережено.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static DigitCounter restoreObject() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("digit_counter.ser"));
            DigitCounter restoredCounter = (DigitCounter) in.readObject();
            in.close();
            return restoredCounter;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
