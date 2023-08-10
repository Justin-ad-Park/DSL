package dsl.trading.methodchaining;

import domain.trading.stock.Order;
import domain.trading.stock.Trade;

public class MethodChainingOrderBuilder {
    private Order order = new Order();

    private MethodChainingOrderBuilder(String customerNM) {
        order.setCustomer(customerNM);
    }

    public static MethodChainingOrderBuilder forCustomer(String customerNM) {
        return new MethodChainingOrderBuilder(customerNM);
    }

    public TradeBuilder buy(int quantity) {
        return new TradeBuilder(this, order, Trade.Type.BUY, quantity);
    }

    public TradeBuilder sell(int quantity) {
        return new TradeBuilder(this, order, Trade.Type.SELL, quantity);
    }

    public Order end() {
        return order;
    }
}
