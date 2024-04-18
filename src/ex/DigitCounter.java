package ex; 
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DigitCounter implements Serializable {
    private static final long serialVersionUID = 1L;
    private int number;
    private Map<Character, Integer> digitCounts;

    public DigitCounter(int number) {
        this.number = number;
        this.digitCounts = countDigits(number);
    }

    private Map<Character, Integer> countDigits(int number) {
        Map<Character, Integer> digitCountMap = new HashMap<>();
        String numberString = String.valueOf(number);

        for (char digit : numberString.toCharArray()) {
            if (Character.isDigit(digit)) {
                digitCountMap.put(digit, digitCountMap.getOrDefault(digit, 0) + 1);
            }
        }
        return digitCountMap;
    }

    public int getNumber() {
        return number;
    }

    public Map<Character, Integer> getDigitCounts() {
        return digitCounts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Число: ").append(number).append(", Результати обчислень:\n");
        sb.append("+---------+-----------+\n");
        sb.append("| Цифра   | Кількість |\n");
        sb.append("+---------+-----------+\n");

        for (Map.Entry<Character, Integer> entry : digitCounts.entrySet()) {
            sb.append(String.format("|    %c    |    %d      |\n", entry.getKey(), entry.getValue()));
            sb.append("+---------+-----------+\n");
        }
        
        return sb.toString();
    }
}
