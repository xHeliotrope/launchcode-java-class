package com.rmoore8869.greedy;

import java.util.ArrayList;

/**
 * rmoore8869
 * 7/15/2014
 */
public interface CoinCurrency {
    public ArrayList<Integer> coinDenominations = new ArrayList<>();
    public String[] coinNames = new String[coinDenominations.size()];
    public ArrayList<Integer> theseCoinDenominations();
    public String[] theseCoinNames();
}

