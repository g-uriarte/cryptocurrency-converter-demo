package com.guriarte.cryptocurrencyconverter.actions;

public interface Action {

    int option();

    String description();

    void perform() throws Exception;

}
