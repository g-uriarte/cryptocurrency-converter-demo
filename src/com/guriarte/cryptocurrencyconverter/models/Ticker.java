package com.guriarte.cryptocurrencyconverter.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

public class Ticker {
    private final String id;
    private final String name;
    private final String symbol;
    private final int rank;
    private final int circulatingSupply;
    private final int totalSupply;
    private final int maxSupply;
    private final LocalDate lastUpdated;
    private final Map<String, Quote> quotes;

    public Ticker(
            String id, String name, String symbol,
            int rank, int circulatingSupply, int totalSupply,
            int maxSupply, LocalDate lastUpdated, Map<String, Quote> quotes
    ) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.circulatingSupply = circulatingSupply;
        this.totalSupply = totalSupply;
        this.maxSupply = maxSupply;
        this.lastUpdated = lastUpdated;
        this.quotes = quotes;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRank() {
        return rank;
    }

    public int getCirculatingSupply() {
        return circulatingSupply;
    }

    public int getTotalSupply() {
        return totalSupply;
    }

    public int getMaxSupply() {
        return maxSupply;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public Quote getQuote(String id) {
        return this.quotes.get(id);
    }

}
