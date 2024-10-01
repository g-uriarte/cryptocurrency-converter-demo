package com.guriarte.cryptocurrencyconverter.service;

import com.guriarte.cryptocurrencyconverter.http.HttpClient;
import com.guriarte.cryptocurrencyconverter.http.exceptions.HttpUnexpectedError;
import com.guriarte.cryptocurrencyconverter.mappers.CoinMapper;
import com.guriarte.cryptocurrencyconverter.mappers.JsonMapper;
import com.guriarte.cryptocurrencyconverter.mappers.TickerMapper;
import com.guriarte.cryptocurrencyconverter.models.Coin;
import com.guriarte.cryptocurrencyconverter.models.Ticker;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class CoinPaprikaService implements CoinPaprikaApi {

    private final String baseURL;
    private final HttpClient httpClient;
    private final JsonMapper<CoinResponse> jsonMapperCoin;
    private final JsonMapper<TickerResponse> jsonMapperTicker;

    public CoinPaprikaService(String baseURL) {
        this.baseURL = baseURL;
        this.httpClient = new HttpClient();
        this.jsonMapperCoin = new JsonMapper<>(CoinResponse.class);
        this.jsonMapperTicker = new JsonMapper<>(TickerResponse.class);
    }

    public List<Coin> getCoins() throws HttpUnexpectedError {
        final var response = httpClient.get(baseURL + "/coins/");
        final List<CoinResponse> coinsResponse = jsonMapperCoin.fromArrayJson(response.body());
        var coins = coinsResponse.stream()
                .map(CoinMapper::fromCoinResponse)
                .toList();
        return new ArrayList<>(coins);
    }

    @Override
    public Ticker getTicker(String id) throws HttpUnexpectedError {
        final var response = httpClient.get(baseURL + "/tickers/" + URLEncoder.encode(id, StandardCharsets.UTF_8));
        final TickerResponse tickerResponse = jsonMapperTicker.fromJson(response.body());
        return TickerMapper.fromTickerResponse(tickerResponse);
    }
}
