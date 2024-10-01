package com.guriarte.cryptocurrencyconverter.service;

import com.google.gson.annotations.SerializedName;

public record QuoteResponse(
        double price,
        @SerializedName("volume_24h") double volume24h,
        @SerializedName("volume_24h_change_24h") double volume24hChange24h,
        @SerializedName("market_cap") double marketCap,
        @SerializedName("market_cap_change_24h") double marketCapChange24h,
        @SerializedName("ath_price") double athPrice,
        @SerializedName("ath_date") String athDate,
        @SerializedName("percent_from_price_ath") double percentFromPriceAth
) {}
