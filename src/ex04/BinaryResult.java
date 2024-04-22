package ex04;

public class BinaryResult implements CalculationResult {
    private int[] count;

    public BinaryResult(int[] count) {
        this.count = count;
    }

    @Override
    public void displayResult() {
        System.out.println("Binary Result:");
        System.out.println("Number | Count");
        System.out.println("--------------");
        for (int i = 0; i < count.length; i++) {
            System.out.printf("%-6s | %-5d\n", Integer.toBinaryString(i), count[i]);
        }
    }
}
