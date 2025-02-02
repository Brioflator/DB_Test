package org.example.Trading;

import java.time.LocalTime;


public record Trade(String ticker, LocalTime time, double price) {
}
