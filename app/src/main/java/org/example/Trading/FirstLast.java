package org.example.Trading;

import java.util.logging.Logger;

public class FirstLast {

    private static final Logger logger = Logger.getLogger(FirstLast.class.getName());

    Trade firstTrade;
    Trade lastTrade;

    void update(Trade trade)
    {
        if (firstTrade == null || firstTrade.time().isAfter(trade.time()) || firstTrade.time().equals(trade.time())) {
            if (firstTrade != null && firstTrade.time().equals(trade.time())) {
                logger.warning(String.format("Two trades have the same time: %s. First trade ticker: %s, Second trade ticker: %s", trade.time(), firstTrade.ticker(), trade.ticker()));
                throw new IllegalArgumentException(String.format("Two trades have the same time: %s and %s", firstTrade.ticker(), trade.ticker()));
            }
            firstTrade = trade;
        }

        if (lastTrade == null || lastTrade.time().isBefore(trade.time()) || lastTrade.time().equals(trade.time())) {
            if (lastTrade != null && lastTrade.time().equals(trade.time())) {
                logger.warning(String.format("Two trades have the same time: %s. First trade ticker: %s, Second trade ticker: %s", trade.time(), lastTrade.ticker(), trade.ticker()));
                throw new IllegalArgumentException(String.format("Two trades have the same time: %s and %s", lastTrade.ticker(), trade.ticker()));
            }
            lastTrade = trade;
        }
    }
}
