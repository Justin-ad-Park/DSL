package dsl.trading.lambda;

import domain.trading.stock.Stock;
import domain.trading.stock.Trade;

import java.util.function.Consumer;

public class TradeBuilder {
    private Trade trade = new Trade();

    public void type(Trade.Type type) {
        trade.setType(type);
    }

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

    public Trade getTrade() {
        return trade;
    }

}