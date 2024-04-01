public class zavdanya_2_1 {
    public static void main(String[] args) {
        int decimalNumber = 654; // Задане десяткове число
        String binaryString = Integer.toBinaryString(decimalNumber); // Перетворюємо у двійкове представлення

        int countZeros = 0;
        int countOnes = 0;

        // Підрахунок кількості нулів і одиниць у двійковому рядку
        for (char c : binaryString.toCharArray()) {
            if (c == '0') {
                countZeros++;
            } else if (c == '1') {
                countOnes++;
            }
        }

        // Виведення результатів
        System.out.println("Двійкове представлення числа " + decimalNumber + ": " + binaryString);
        System.out.println("Кількість нулів: " + countZeros);
        System.out.println("Кількість одиниць: " + countOnes);
    }
}
