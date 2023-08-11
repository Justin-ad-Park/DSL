package dsl.tax;

import java.util.function.DoubleUnaryOperator;

/**
 * LF : Lambda Function(FunctionalInterface)
 * *
 */
public class TaxCalculatorByLF {
    public DoubleUnaryOperator taxFunction = d -> d;    //1개의 double 매개변수로 double을 리턴하는 함수형 인터페이스

    public TaxCalculatorByLF andThen(DoubleUnaryOperator f) {
        taxFunction = taxFunction.andThen(f);
        return this;
    }

    public double calculate(double value) {
        return taxFunction.applyAsDouble(value);
    }
}
