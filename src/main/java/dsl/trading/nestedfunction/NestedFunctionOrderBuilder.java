package dsl.trading.nestedfunction;

import domain.trading.stock.Order;
import domain.trading.stock.Stock;
import domain.trading.stock.Trade;

import java.util.stream.Stream;

public class NestedFunctionOrderBuilder {
    public static Order order(String customer, Trade... trades) {
        Order order = new Order();
        order.setCustomer(customer);

        Stream.of(trades).forEach(order::addTrade);

        return order;
    }

    public static Trade buy(int quantity, double price, Stock stock) {
        return tradeBuilder(quantity, price, stock, Trade.Type.BUY);
    }

    public static Trade sell(int quantity, double price, Stock stock) {
        return tradeBuilder(quantity, price, stock, Trade.Type.SELL);
    }

    public static Stock stock(String stockNM, String market) {
        Stock stock = new Stock();
        stock.setSymbol(stockNM);
        stock.setMarket(market);

        return stock;
    }

    private static Trade tradeBuilder(int quantity, double price, Stock stock, Trade.Type type) {
        Trade trade = new Trade();

        trade.setType(type);
        trade.setQuantity(quantity);
        trade.setPrice(price);
        trade.setStock(stock);

        return trade;
    }
}
