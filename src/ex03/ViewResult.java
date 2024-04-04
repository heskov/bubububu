package ex03;

import java.util.HashMap;
import java.util.Map;

public class ViewResult implements View {
    private int number;
    private Map<Character, Integer> digitCount;

    public ViewResult() {
        this.digitCount = new HashMap<>();
    }

    @Override
    public void viewInit() {
        number = 123456789; // Приклад вхідного десяткового числа
        countDigits();
    }

    private void countDigits() {
        String numString = String.valueOf(number);
        for (int i = 0; i < numString.length(); i++) {
            char digit = numString.charAt(i);
            if (Character.isDigit(digit)) {
                int count = digitCount.getOrDefault(digit, 0);
                digitCount.put(digit, count + 1);
            }
        }
    }

    @Override
    public void viewShow() {
        System.out.println("Digit Counts:");
        for (char digit : digitCount.keySet()) {
            System.out.println(digit + ": " + digitCount.get(digit));
        }
    }
}
