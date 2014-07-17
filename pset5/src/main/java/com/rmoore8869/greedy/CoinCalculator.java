package com.rmoore8869.greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * rmoore8869
 * 7/12/2014
 */

public class CoinCalculator {

    private int decimalAmount;
    private ArrayList<Integer> coinDenominations;
    private String[] names;
    private CoinCurrency coinCurrency;

    private CoinCurrency getCoinCurrency(){
        return coinCurrency;
    }

    public CoinCalculator(CoinCurrency coinCurrency){
        this.coinCurrency = coinCurrency;
    }

    public String createMessage(double userAmount) {
        names = coinCurrency.theseCoinNames();
        coinDenominations = coinCurrency.theseCoinDenominations();
        changeCalculator(userAmount);
        StringBuilder message = new StringBuilder();
        message.append("You receive: ");
        if (changeDoesNotExist()) {
            message.append("no change.");
        } else {
            for (int i = 0; i < names.length; i++) {
                message.append(changeOutput(i, coinDenominations.get(i)));
            }
        }
        return message.toString();
    }

    public void changeCalculator(Double userAmount) {
        decimalAmount = decimalConverter(userAmount);
        for(int i = coinDenominations.size()-1; i >= 0; i--){
            minusCoin(coinDenominations.get(i));
        }
    }

    private String changeOutput(int coinLevel, int coinType) {
        if (elementFrequency(coinType) > 0) {
            return String.format("\n%s : %s", elementFrequency(coinType), names[coinLevel]);
        } else
            return "";
    }

    private int elementFrequency(int coinType){
        return Collections.frequency(coinDenominations,coinType)-1;
    }

    private int decimalConverter(double changeAmount){
        return (int)(changeAmount * 100);
    }

    private void minusCoin(int coinType) {
        while (decimalAmount >= coinType) {
            decimalAmount -= coinType;
            coinDenominations.add(coinType);
        }
    }

    private boolean changeDoesNotExist(){
        int totalCoins = 0;
        for(int i =0; i < coinDenominations.size();i++){
            totalCoins += elementFrequency(coinDenominations.get(i));
            }
        if(totalCoins == 0){
            return true;
        }
        return false;
    }

}
