package dsl.trading.nestedfunction;

import domain.trading.stock.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dsl.trading.nestedfunction.NestedFunctionOrderBuilder.*;

/**
 * 중첩 함수(Nested Function)를 이용한 DSL 구현
 *   함수 안에 함수를 이용해서 간단하게 DSL을 구현할 수 있다.
 */
public class NestedFunctionOrderBuilderTest {

    @Test
    void nestedFunctionBuilderTest() {
        Order order = order("CustomerNM",
                buy(100, 100, stock("APPLE","NASDAQ")),
                sell(80, 100, stock("IBM","KOSDAQ"))
        );

        Assertions.assertEquals("CustomerNM", order.getCustomer());

        Assertions.assertEquals(18000, order.getValue());
    }
}
