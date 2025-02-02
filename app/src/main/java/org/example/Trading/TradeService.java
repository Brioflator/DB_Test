package org.example.Trading;

import java.util.*;
import java.util.logging.Logger;


public class TradeService {

    private static final Logger logger = Logger.getLogger(TradeService.class.getName());

    public void printMarketOpenClosePrices(Iterator<Trade> trades) {
        if (trades == null || !trades.hasNext()) {
            throw new NullPointerException("Trades iterator is null or empty");
        }

        Map<String, FirstLast> priceMap = new HashMap<>();

        while (trades.hasNext()) {
            Trade trade = trades.next();
            try {
                priceMap.computeIfAbsent(trade.ticker(), k -> new FirstLast())
                        .update(trade);
            } catch (IllegalArgumentException e) {
                logger.severe("Error updating trade: " + e.getMessage());
            }
        }

        priceMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s: Open=%.2f, Close=%.2f%n",
                        e.getKey(), e.getValue().firstTrade.price(), e.getValue().lastTrade.price()));
    }
}
