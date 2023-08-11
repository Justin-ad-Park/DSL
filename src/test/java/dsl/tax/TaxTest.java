package dsl.tax;

import domain.tax.Tax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaxTest {
    @Test
    void TaxTest() {
        double totalPrice = Tax.calculate(9000, true, true, false);

        Assertions.assertEquals(10395.0, totalPrice);
    }

}