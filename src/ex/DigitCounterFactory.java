package ex;

public class DigitCounterFactory {
    public DigitCounter createDigitCounter(int number) {
        return new DigitCounter(number);
    }
}
