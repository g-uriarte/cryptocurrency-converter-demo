package com.guriarte.cryptocurrencyconverter.models;

public class Coin {

    private final String id;
    private final String name;
    private final String symbol;

    public Coin(String id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
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
}
