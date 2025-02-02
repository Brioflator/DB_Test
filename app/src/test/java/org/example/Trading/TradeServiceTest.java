package org.example.Trading;

import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class TradeServiceTest {

    @Test
    public void printMarketOpenClosePrices_ValidTrades_PrintsCorrectPrices() {
        List<Trade> trades = Arrays.asList(
                new Trade("AAPL", LocalTime.of(9, 30), 150.25),
                new Trade("AAPL", LocalTime.of(16, 0), 152.50),
                new Trade("MSFT", LocalTime.of(9, 30), 280.00),
                new Trade("MSFT", LocalTime.of(16, 0), 285.75)
        );

        TradeService tradeService = new TradeService();
        tradeService.printMarketOpenClosePrices(trades.iterator());
    }

    @Test
    public void printMarketOpenClosePrices_EmptyTrades_ThrowsNullPointerException() {
        List<Trade> trades = Collections.emptyList();

        TradeService tradeService = new TradeService();
        assertThrows(NullPointerException.class, () -> tradeService.printMarketOpenClosePrices(trades.iterator()));
    }

    @Test
    public void printMarketOpenClosePrices_NullTrades_ThrowsNullPointerException() {
        TradeService tradeService = new TradeService();
        assertThrows(NullPointerException.class, () -> tradeService.printMarketOpenClosePrices(null));
    }

    @Test
    public void printMarketOpenClosePrices_DuplicateTradeTimes_LogsError() {
        List<Trade> trades = Arrays.asList(
                new Trade("AAPL", LocalTime.of(9, 30), 150.25),
                new Trade("AAPL", LocalTime.of(9, 30), 151.00)
        );

        TradeService tradeService = new TradeService();
        tradeService.printMarketOpenClosePrices(trades.iterator());
    }
}