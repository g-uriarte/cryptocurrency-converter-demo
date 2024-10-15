package com.guriarte.cryptocurrencyconverter.actions;

public enum TokenType {
    IN("in"),
    OUT("out");

    private final String value;

    private TokenType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
