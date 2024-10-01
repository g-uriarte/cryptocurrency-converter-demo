package com.guriarte.cryptocurrencyconverter.service;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record TickerResponse(
        String id,
        String name,
        String symbol,
        int rank,
        @SerializedName("circulating_supply") int circulatingSupply,
        @SerializedName("total_supply") int totalSupply,
        @SerializedName("max_supply") int maxSupply,
        @SerializedName("last_updated") String lastUpdated,
        Map<String, QuoteResponse> quotes
) { }