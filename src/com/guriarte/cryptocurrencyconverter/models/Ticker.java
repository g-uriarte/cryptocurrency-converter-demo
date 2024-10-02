package com.guriarte.cryptocurrencyconverter.models;

import java.time.Instant;
import java.util.Map;

public class Ticker {
    private final String id;
    private final String name;
    private final String symbol;
    private final int rank;
    private final double circulatingSupply;
    private final double totalSupply;
    private final double maxSupply;
    private final Instant lastUpdated;
    private final Map<String, Quote> quotes;

    public Ticker(
            String id, String name, String symbol,
            int rank, double circulatingSupply, double totalSupply,
            double maxSupply, Instant lastUpdated, Map<String, Quote> quotes
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

    public double getCirculatingSupply() {
        return circulatingSupply;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public double getMaxSupply() {
        return maxSupply;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public Quote getQuote(String id) {
        return this.quotes.get(id);
    }

}
