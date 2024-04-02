package ex02;

import java.io.IOException;

/** Creator
 * (шаблон проектирования
 * Factory Method)<br>
 * Объявляет метод,
 * "фабрикующий" объекты
 * @author xone
 * @version 1.0
 * @see Viewable#getView()
 */
public class BasicCalculationResult extends View {
    /**
     * Конструктор для створення об'єкта BasicCalculationResult з вказаною масою та швидкістю.
     *
     * @param number ціле число
     */
    /**
     * Відображає результат обчислень у текстовому вигляді.
     */
    @Override
    public void displayResult() {
        System.out.println("Кількість входжень кожної цифри у десятковому поданні числа:");
        int[] digitCounts = countDigits();
        for (int i = 0; i < digitCounts.length; i++) {
            System.out.println("Цифра " + i + ": " + digitCounts[i]);
        }
    }

    /**
     * Підраховує кількість входжень кожної цифри у десятковому поданні числа.
     *
     * @return масив, де кожний елемент відповідає кількості входжень цифри з індексом у десятковому числі
     */
    private int[] countDigits() {
        int[] digitCounts = new int[10]; // масив для підрахунку кількості входжень кожної цифри
        char[] number;
        String numString = String.valueOf(number); // перетворення числа на рядок
        // Проходимо через кожен символ рядка
        for (int i = 0; i < numString.length(); i++) {
            char digit = numString.charAt(i);
            if (Character.isDigit(digit)) {
                int digitValue = Character.getNumericValue(digit);
                digitCounts[digitValue]++;
            }
        }
        return digitCounts;
    }
}