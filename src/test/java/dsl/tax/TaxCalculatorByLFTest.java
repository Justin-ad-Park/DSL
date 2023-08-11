package dsl.tax;

import domain.tax.Tax;
import domain.tax.TaxCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleUnaryOperator;

class TaxCalculatorByLFTest {
    @Test
    void doubleUnaryTest() {
        DoubleUnaryOperator f = d -> d;

        double totalPrice = f.andThen(Tax::regional)
                .andThen(Tax::vat)
                .applyAsDouble(9000);

        Assertions.assertEquals(10395.0, totalPrice);
    }

    @Test
    void calculate() {
        double totalPrice = new TaxCalculatorByLF().andThen(Tax::regional)
                .andThen(Tax::vat)
                .calculate(9000);

        Assertions.assertEquals(10395.0, totalPrice);
    }

    @Test
    void TaxCalculatorByLambdaTest() {
        double totalPrice = TaxCalculator.initCalculator(9000)
                .applyTax(Tax::regional)
                .applyTax(Tax::vat)
                .calculate();

        Assertions.assertEquals(10395.0, totalPrice);


        double totalPrice2 = TaxCalculator.initCalculator(9000)
                .calculate();

        Assertions.assertEquals(9000, totalPrice2);


    }

}