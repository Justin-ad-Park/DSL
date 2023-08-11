package dsl.tax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [MethodChaining 방식]
 * 장점 : TaxTest에서 사용한 방식보다 코드를 읽기 쉬워짐
 * 단점 : Tax 종류(Regional, VAT...)가 늘어나면 DSL 코드(Boolean 멤버변수, WithXXX 메소드)도 늘어남
 *  즉, 유지보수 리소스가 들며, 확장성 떨어짐
*/
class TaxCalculatorByMCTest {

    @Test
    void calculate() {
        double totalPrice = new TaxCalculatorByMC().withRegional().withVAT().calculate(9000);

        Assertions.assertEquals(10395.0, totalPrice);
    }
}