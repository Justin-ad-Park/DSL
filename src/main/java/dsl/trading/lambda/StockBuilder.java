package dsl.trading.lambda;

import domain.trading.stock.Stock;

public class StockBuilder {
    protected Stock stock = new Stock();

    public void symbol(String stockNM) {
        stock.setSymbol(stockNM);
    }

    public void market(String market) {
        stock.setMarket(market);
    }
}
