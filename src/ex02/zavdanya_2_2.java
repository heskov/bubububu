package ex02;

public class zavdanya_2_2 {
    public static void main(String[] args) {
        int number = 123456789; // Вхідне десяткове число
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
    public static boolean isHexadecimal(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    // Метод для перевірки, чи є символ 8-річною цифрою
    public static boolean isOctal(char c) {
        return (c >= '0' && c <= '7');
    }
    public void setXY(double d, double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setXY'");
    }
}
