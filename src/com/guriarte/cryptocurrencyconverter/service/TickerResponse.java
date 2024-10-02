package com.guriarte.cryptocurrencyconverter.service;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record TickerResponse(
        String id,
        String name,
        String symbol,
        int rank,
        @SerializedName("circulating_supply") double circulatingSupply,
        @SerializedName("total_supply") double totalSupply,
        @SerializedName("max_supply") double maxSupply,
        @SerializedName("last_updated") String lastUpdated,
        Map<String, QuoteResponse> quotes
) { }