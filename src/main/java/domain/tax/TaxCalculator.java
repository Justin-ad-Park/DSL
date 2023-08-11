package domain.tax;

import java.util.function.DoubleUnaryOperator;

public class TaxCalculator {
    //1개의 double 매개변수로 double을 리턴하는 함수형 인터페이스
    private DoubleUnaryOperator taxFunction = d -> d;
    private double value = 0.0;

    private TaxCalculator(double value) {
        this.value = value;
    }

    public static TaxCalculator initCalculator(double value) {
        return new TaxCalculator(value);
    }

    public TaxCalculator applyTax(DoubleUnaryOperator f) {
        taxFunction = taxFunction.andThen(f);
        return this;
    }

    public double calculate() {
        return taxFunction.applyAsDouble(value);
    }

}
