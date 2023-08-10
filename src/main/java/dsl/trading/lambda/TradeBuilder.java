package dsl.trading.lambda;

import domain.trading.stock.Stock;
import domain.trading.stock.Trade;

import java.util.function.Consumer;

public class TradeBuilder {
    protected Trade trade = new Trade();

    public void quantity(int quantity) {
        trade.setQuantity(quantity);
    }

    public void price(double price) {
        trade.setPrice(price);
    }

    public void stock(Consumer<StockBuilder> consumer) {
        StockBuilder builder = new StockBuilder();
        consumer.accept(builder);
        trade.setStock(builder.stock);
    }

    public static class StockBuilder {
        private Stock stock = new Stock();

        public void symbol(String stockNM) {
            stock.setSymbol(stockNM);
        }

        public void market(String market) {
            stock.setMarket(market);
        }
    }
}