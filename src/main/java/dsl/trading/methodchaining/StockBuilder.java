package dsl.trading.methodchaining;

import domain.trading.stock.Stock;
import domain.trading.stock.Trade;

public class StockBuilder {
    private MethodChainingOrderBuilder orderBuilder;
    private Trade trade;
    private Stock stock = new Stock();

    public StockBuilder(MethodChainingOrderBuilder orderBuilder, Trade trade, String stockNM) {

        this.orderBuilder = orderBuilder;
        this.trade = trade;

        stock.setSymbol(stockNM);
        this.trade.setStock(stock);

    }

    public String getStock() {
        return stock.getSymbol();
    }

    public MethodChainingOrderBuilder market(String market) {
        stock.setMarket(market);

        return orderBuilder;
    }
}
