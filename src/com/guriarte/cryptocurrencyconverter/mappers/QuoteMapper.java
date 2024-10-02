package com.guriarte.cryptocurrencyconverter.mappers;

import com.guriarte.cryptocurrencyconverter.models.Quote;
import com.guriarte.cryptocurrencyconverter.service.QuoteResponse;

import java.time.Instant;
import java.time.LocalDate;

public class QuoteMapper {

    public static Quote fromQuoteResponse(QuoteResponse quoteResponse) {
        return new Quote(
            quoteResponse.price(), quoteResponse.volume24h(), quoteResponse.volume24hChange24h(),
            quoteResponse.marketCap(), quoteResponse.marketCapChange24h(), quoteResponse.athPrice(),
                Instant.parse(quoteResponse.athDate()), quoteResponse.percentFromPriceAth()
        );
    }


}
