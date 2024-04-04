package ex02;

import java.io.Serializable;

public class zavdanya_2_2 implements Serializable {
    private double x;
    private double y;

    // Конструктори, геттери та сеттери...

    // Метод для підрахунку кількості входжень кожної цифри
    public int[] countDigits() {
        int[] counts = new int[10]; // Масив для збереження кількості входжень кожної цифри (від 0 до 9)
        String numString = String.valueOf((int)x); // Перетворення числа x на рядок

        // Перетворення числа на рядок та підрахунок кількості цифр
        for (int i = 0; i < numString.length(); i++) {
            char digitChar = numString.charAt(i);
            if (Character.isDigit(digitChar)) {
                int digit = Character.getNumericValue(digitChar);
                counts[digit]++; // Інкремент кількості для цифри
            }
        }

        return counts;
    }

    // Приклад використання методу підрахунку кількості цифр
    public static void main(String[] args) {
        zavdanya_2_2 example = new zavdanya_2_2(); // Приклад числа
        int[] counts = example.countDigits();

        // Вивід кількості входжень кожної цифри
        for (int i = 0; i < counts.length; i++) {
            System.out.println("Кількість входжень цифри " + i + ": " + counts[i]);
        }
    }
}
