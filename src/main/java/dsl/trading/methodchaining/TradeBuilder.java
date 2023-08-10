package dsl.trading.methodchaining;

import domain.trading.stock.Order;
import domain.trading.stock.Trade;

public class TradeBuilder {
    private MethodChainingOrderBuilder orderBuilder;
    private Order order;
    private Trade trade = new Trade();

    public TradeBuilder(MethodChainingOrderBuilder orderBuilder, Order order, Trade.Type type, int quantity) {
        this.orderBuilder = orderBuilder;
        this.order = order;

        trade.setType(type);
        trade.setQuantity(quantity);

        this.order.addTrade(trade);
    }

    public Trade getTrade() {
        return trade;
    }

    public TradeBuilder4Price price(double price) {
        return new TradeBuilder4Price(orderBuilder, trade, price);
    }
}
