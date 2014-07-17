package com.rmoore8869.greedy.CurrencyType;

import com.rmoore8869.greedy.CoinCurrency;

import java.util.ArrayList;

/**
 * rmoore8869
 * 7/15/2014
 */
public class European implements CoinCurrency {
    private ArrayList<Integer> coinDenominations = new ArrayList<>();
    private String[] coinNames = new String[coinDenominations.size()];

    private ArrayList<Integer> getCoinDenominations(){
        return coinDenominations;
    }
    private String[] getCoinNames(){
        return coinNames;
    }

    private European(ArrayList<Integer> CoinDenominations, String[] coinNames){
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
