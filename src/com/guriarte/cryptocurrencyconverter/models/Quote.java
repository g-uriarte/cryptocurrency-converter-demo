package com.guriarte.cryptocurrencyconverter.models;

import java.time.LocalDate;

public class Quote {
    private double price;
    private double volume24h;
    private double volume24hChange24h;
    private double marketCap;
    private double marketCapChange24h;
    private double athPrice;
    private LocalDate athDate;
    private double percentFromPriceAth;

    public Quote(
        double price, double volume24h, double volume24hChange24h,
        double marketCap, double marketCapChange24h, double athPrice,
        LocalDate athDate, double percentFromPriceAth
    ) {
        this.price = price;
        this.volume24h = volume24h;
        this.volume24hChange24h = volume24hChange24h;
        this.marketCap = marketCap;
        this.marketCapChange24h = marketCapChange24h;
        this.athPrice = athPrice;
        this.athDate = athDate;
        this.percentFromPriceAth = percentFromPriceAth;
    }
}
