package dsl.trading.methodchaining;

import domain.trading.stock.Trade;

public class TradeBuilder4Price {
    private MethodChainingOrderBuilder orderBuilder;
    private Trade trade;

    public TradeBuilder4Price(MethodChainingOrderBuilder orderBuilder, Trade trade, double price) {

        this.orderBuilder = orderBuilder;
        this.trade = trade;
        this.trade.setPrice(price);
    }

    public double getPrice() {
        return trade.getPrice();
    }

    public StockBuilder stock(String stockNM) {
        return new StockBuilder(orderBuilder, trade, stockNM);
    }
}
