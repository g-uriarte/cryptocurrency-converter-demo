package com.guriarte.cryptocurrencyconverter.models;

import java.time.Instant;
import java.time.LocalDate;

public class Quote {
    private double price;
    private double volume24h;
    private double volume24hChange24h;
    private double marketCap;
    private double marketCapChange24h;
    private double athPrice;
    private Instant athDate;
    private double percentFromPriceAth;

    public Quote(
        double price, double volume24h, double volume24hChange24h,
        double marketCap, double marketCapChange24h, double athPrice,
        Instant athDate, double percentFromPriceAth
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

    public double getPrice() {
        return price;
    }

    public double getVolume24h() {
        return volume24h;
    }

    public double getVolume24hChange24h() {
        return volume24hChange24h;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public double getMarketCapChange24h() {
        return marketCapChange24h;
    }

    public double getAthPrice() {
        return athPrice;
    }

    public Instant getAthDate() {
        return athDate;
    }

    public double getPercentFromPriceAth() {
        return percentFromPriceAth;
    }
}
