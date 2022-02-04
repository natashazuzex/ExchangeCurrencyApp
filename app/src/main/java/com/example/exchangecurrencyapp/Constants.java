package com.example.exchangecurrencyapp;

public class Constants {

    public static final double COMMISSION_LIMIT = 1200;
    public static final double COMMISSION_SIZE = 6;

    public interface CurrencyType {
        String GBP = "GBP";
        String EUR = "EUR";
        String USD = "USD";
        String CAD = "CAD";
    }

    public interface ExchangeRatios {
        double GBP_TO_EUR = 1.19;
        double GBP_TO_USD = 1.35;
        double GBP_TO_CAD = 1.66;
        double EUR_TO_GBP = 0.81;
        double USD_TO_GBP = 0.71;
        double CAD_TO_GBP = 0.57;
    }
}
