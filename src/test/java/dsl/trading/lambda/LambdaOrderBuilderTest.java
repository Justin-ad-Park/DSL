package dsl.trading.lambda;

import domain.trading.stock.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LambdaOrderBuilderTest {

    @Test
    void LambdaBuilderTest() {
        Order order = LambdaOrderBuilder.order(o-> {
            o.forCustomer("Justin");
            o.buy(t -> {
                t.quantity(80);
                t.price(100.0);
                t.stock(s -> {
                    s.symbol("APPLE");
                    s.market("NASDAQ");
                });
            });
            o.sell(t -> {
                t.quantity(50);
                t.price(1000.0);
                t.stock(s -> {
                    s.symbol("SAMSUNG");
                    s.market("KOSPI");
                });
            });
        });

        Assertions.assertEquals("Justin", order.getCustomer());

        Assertions.assertEquals(58000, order.getValue());
    }
}
