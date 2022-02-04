package com.example.exchangecurrencyapp.utils;


import com.example.exchangecurrencyapp.Constants;

public class BureauDeChange {

    public static double currencyExchange(String originalCurrency, String targetCurrency, double currencySize) {
        if (currencySize <= Constants.COMMISSION_SIZE)
            return -1.0;

        boolean isCommission = currencySize <= Constants.COMMISSION_LIMIT && currencySize > Constants.COMMISSION_SIZE;
        double finalCurrencySize;
        if (isCommission) {
            finalCurrencySize = currencySize - Constants.COMMISSION_SIZE;
        } else {
            finalCurrencySize = currencySize;
        }

        if (originalCurrency.equals(Constants.CurrencyType.GBP) && targetCurrency.equals(Constants.CurrencyType.EUR)) {
            return finalCurrencySize * Constants.ExchangeRatios.GBP_TO_EUR;
        } else if (originalCurrency.equals(Constants.CurrencyType.GBP) && targetCurrency.equals(Constants.CurrencyType.USD)) {
            return  finalCurrencySize * Constants.ExchangeRatios.GBP_TO_USD;
        } else if (originalCurrency.equals(Constants.CurrencyType.GBP) && targetCurrency.equals(Constants.CurrencyType.CAD)) {
            return  finalCurrencySize * Constants.ExchangeRatios.GBP_TO_CAD;
        } else if (originalCurrency.equals(Constants.CurrencyType.EUR) && targetCurrency.equals(Constants.CurrencyType.GBP)) {
            return  finalCurrencySize * Constants.ExchangeRatios.EUR_TO_GBP;
        } else if (originalCurrency.equals(Constants.CurrencyType.USD) && targetCurrency.equals(Constants.CurrencyType.GBP)) {
            return  finalCurrencySize * Constants.ExchangeRatios.USD_TO_GBP;
        } else if (originalCurrency.equals(Constants.CurrencyType.CAD) && targetCurrency.equals(Constants.CurrencyType.GBP)) {
            return  finalCurrencySize * Constants.ExchangeRatios.CAD_TO_GBP;
        }
        else {
            return -1.0;
        }
    }

}
