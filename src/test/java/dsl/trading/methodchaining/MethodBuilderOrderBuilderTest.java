package dsl.trading.methodchaining;

import domain.trading.stock.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MethodBuilderOrderBuilderTest {
    private final String CUSTOMER_NAME = "Justin";

    @Test
    void ChainingOrderBuilderTest() {
        MethodChainingOrderBuilder b1 = MethodChainingOrderBuilder.forCustomer(CUSTOMER_NAME);

        Assertions.assertNotNull(b1);


        TradeBuilder b2 = MethodChainingOrderBuilder.forCustomer(CUSTOMER_NAME)
                .buy(99);

        Assertions.assertEquals(99,b2.getTrade().getQuantity());

        TradeBuilder4Price b3 = MethodChainingOrderBuilder.forCustomer(CUSTOMER_NAME)
                .buy(99)
                .price(10000.0);

        Assertions.assertEquals(10000, b3.getPrice());

        StockBuilder b4 = MethodChainingOrderBuilder.forCustomer(CUSTOMER_NAME)
                .buy(99)
                .price(10000.0)
                .stock("APPLE")
                ;

        Assertions.assertEquals("APPLE", b4.getStock());

        MethodChainingOrderBuilder b5 = MethodChainingOrderBuilder.forCustomer(CUSTOMER_NAME)
                .buy(99)
                .price(10000.0)
                .stock("APPLE")
                .market("KOSDAQ")
                ;

        Assertions.assertEquals(990000, b5.end().getValue());

        MethodChainingOrderBuilder b6 = MethodChainingOrderBuilder.forCustomer(CUSTOMER_NAME)
                .sell(99)
                .price(10000.0)
                .stock("APPLE")
                .market("KOSDAQ")
                ;


        Order b7 = MethodChainingOrderBuilder.forCustomer(CUSTOMER_NAME)
                .buy(99)
                .price(10000.0)
                .stock("APPLE")
                .market("KOSDAQ")
                .sell(10)
                .price(5000)
                .stock("MS")
                .market("KOSPI")
                .end();

        Assertions.assertEquals(1040000, b7.getValue());

    }


}
