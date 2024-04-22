package ex04;

public class Result {
    private final int[] count = new int[10];
    private String strNumber = "1";

    public Result() { }

    public Result(int number) {
        this.strNumber = String.valueOf(number);
        init();
    }

    public void setNumber(int number) {
        this.strNumber = String.valueOf(number);
        init();
    }

    private void init() {
        for (char c : strNumber.toCharArray()) {
            int number = Integer.parseInt(String.format("%c", c));

            count[number]++;
        }
    }

    public int[] getResult() {
        return count;
    }
}
