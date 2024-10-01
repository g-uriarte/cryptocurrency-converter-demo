package com.guriarte.cryptocurrencyconverter.service;

import com.guriarte.cryptocurrencyconverter.http.exceptions.HttpUnexpectedError;
import com.guriarte.cryptocurrencyconverter.models.Coin;
import com.guriarte.cryptocurrencyconverter.models.Ticker;

import java.util.List;

public interface CoinPaprikaApi {

    List<Coin> getCoins() throws HttpUnexpectedError;

    Ticker getTicker(String id) throws HttpUnexpectedError;

}
