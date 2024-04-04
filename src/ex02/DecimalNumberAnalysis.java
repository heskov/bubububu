package ex02;

import java.util.HashMap;

public class DecimalNumberAnalysis {
    private int number;
    private HashMap<Character, Integer> digitCounts;

    public DecimalNumberAnalysis(int number) {
        this.number = number;
        this.digitCounts = new HashMap<>();
    }

    public void countDigits() {
        String numberStr = String.valueOf(number);
        for (int i = 0; i < numberStr.length(); i++) {
            char digit = numberStr.charAt(i);
            digitCounts.put(digit, digitCounts.getOrDefault(digit, 0) + 1);
        }
    }

    public String getAnalysisResult() {
        StringBuilder result = new StringBuilder();
        result.append("+--------+-----------+\n");
        result.append("| Цифра  | Кількість |\n");
        result.append("+--------+-----------+\n");
        for (char digit : digitCounts.keySet()) {
            result.append(String.format("| %6c | %9d |\n", digit, digitCounts.get(digit)));
        }
        result.append("+--------+-----------+\n");
        return result.toString();
    }
}
