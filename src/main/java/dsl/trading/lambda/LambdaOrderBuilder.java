package dsl.trading.lambda;

import domain.trading.stock.Order;
import domain.trading.stock.Trade;

import java.util.function.Consumer;

public class LambdaOrderBuilder {
    private Order order = new Order();

    /**
     *
     * @param consumer : 자기 자신을  소비하는
     * @return
     */
    public static Order order(Consumer<LambdaOrderBuilder> consumer) {
        LambdaOrderBuilder builder = new LambdaOrderBuilder();
        consumer.accept(builder);

        return builder.order;
    }

    public void forCustomer(String customerNM) {
        order.setCustomer(customerNM);
    }

    public void buy(Consumer<TradeBuilder> consumer) {
        trade(consumer, Trade.Type.BUY);
    }

    public void sell(Consumer<TradeBuilder> consumer) { trade(consumer, Trade.Type.SELL); }

    private void trade(Consumer<TradeBuilder> consumer, Trade.Type type) {
        TradeBuilder builder = new TradeBuilder();
        builder.trade.setType(type);
        consumer.accept(builder);
        order.addTrade(builder.trade);
    }

}
