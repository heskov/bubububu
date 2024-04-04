package ex03;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int number = 111111; // Вхідне десяткове число
        
        Map<Character, Integer> decimalDigitCounts = countDigitOccurrences(number, 10);
        Map<Character, Integer> hexadecimalDigitCounts = countDigitOccurrences(number, 16);
        Map<Character, Integer> octalDigitCounts = countDigitOccurrences(number, 8);

        System.out.println("Counts of decimal digits:");
        printDigitCounts(decimalDigitCounts);
        System.out.println("Counts of hexadecimal digits:");
        printDigitCounts(hexadecimalDigitCounts);
        System.out.println("Counts of octal digits:");
        printDigitCounts(octalDigitCounts);
    }

    private static Map<Character, Integer> countDigitOccurrences(int number, int base) {
        Map<Character, Integer> digitCounts = new HashMap<>();
        
        String numberString = Integer.toString(number, base);
        
        for (int i = 0; i < numberString.length(); i++) {
            char digit = numberString.charAt(i);
            digitCounts.put(digit, digitCounts.getOrDefault(digit, 0) + 1);
        }
        
        return digitCounts;
    }

    private static void printDigitCounts(Map<Character, Integer> digitCounts) {
        for (Map.Entry<Character, Integer> entry : digitCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
