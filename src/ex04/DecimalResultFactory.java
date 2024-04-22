package ex04;

public class DecimalResultFactory implements CalculationResultFactory {
    @Override
    public CalculationResult createCalculationResult(int[] count) {
        return new DecimalResult(count);
    }
}
