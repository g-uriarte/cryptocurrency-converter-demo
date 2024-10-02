package com.guriarte.cryptocurrencyconverter.mappers;

import com.guriarte.cryptocurrencyconverter.models.Ticker;
import com.guriarte.cryptocurrencyconverter.service.TickerResponse;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class TickerMapper {


    public static Ticker fromTickerResponse(TickerResponse tickerResponse) {
        var quoteMap = tickerResponse.quotes().entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> QuoteMapper.fromQuoteResponse(entry.getValue()))
                );

        return new Ticker(
                tickerResponse.id(), tickerResponse.name(), tickerResponse.symbol(),
                tickerResponse.rank(), tickerResponse.circulatingSupply(), tickerResponse.totalSupply(),
                tickerResponse.maxSupply(), Instant.parse(tickerResponse.lastUpdated()), quoteMap
        );
    }

}
