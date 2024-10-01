package com.guriarte.cryptocurrencyconverter.mappers;

import com.guriarte.cryptocurrencyconverter.models.Coin;
import com.guriarte.cryptocurrencyconverter.service.CoinResponse;

public class CoinMapper {

    public static Coin fromCoinResponse(CoinResponse coinResponse) {
        return new Coin(coinResponse.id(), coinResponse.name(), coinResponse.symbol());
    }

}
