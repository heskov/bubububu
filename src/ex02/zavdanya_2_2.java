package ex02;

import java.io.Serializable;

public class zavdanya_2_2 implements Serializable {
    private double x;
    private double y;

    public zavdanya_2_2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Додані методи для доступу до полів x і y
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Додаткові методи, які можуть знадобитися
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Метод для встановлення значення x і y одночасно
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Головний метод, який виконує тестування
    public static void main(String[] args) {
        int number = 345345; // Вхідне десяткове число
        int count16 = 0; // Лічильник 16-річних цифр
        int count8 = 0; // Лічильник 8-річних цифр

        // Перетворення числа на рядок
        String numString = String.valueOf(number);

        // Проходимо через кожен символ рядка
        for (int i = 0; i < numString.length(); i++) {
            char digit = numString.charAt(i);
            if (isHexadecimal(digit)) {
                count16++;
            }
            // Перевірка, чи є поточний символ 8-річною цифрою
            if (isOctal(digit)) {
                count8++;
            }
        }
        System.out.println("Кількість 16-річних цифр: " + count16);
        System.out.println("Кількість 8-річних цифр: " + count8);
    }

    // Метод для перевірки, чи є символ 16-річною цифрою
    public static boolean isHexadecimal(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    // Метод для перевірки, чи є символ 8-річною цифрою
    public static boolean isOctal(char c) {
        return (c >= '0' && c <= '7');
    }
}
