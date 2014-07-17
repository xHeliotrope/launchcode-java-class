package com.rmoore8869.greedy.CurrencyType;

import com.rmoore8869.greedy.CoinCurrency;

import java.util.ArrayList;

/**
 * rmoore8869
 * 7/15/2014
 */
public class American implements CoinCurrency {
    private final ArrayList<Integer> coinDenominations;
    private final String[] coinNames;

    private ArrayList<Integer> getCoinDenominations(){
        return coinDenominations;
    }
    private String[] getCoinNames(){
        return coinNames;
    }

    private American(ArrayList<Integer> CoinDenominations, String[] coinNames){
        this.coinDenominations=CoinDenominations;
        this.coinNames=coinNames;
    }
    public ArrayList<Integer> theseCoinDenominations(){
        return coinDenominations;
    }
    public String[] theseCoinNames(){
        return coinNames;
    }

}
