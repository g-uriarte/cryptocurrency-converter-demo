package com.guriarte.cryptocurrencyconverter.messages;

import com.guriarte.cryptocurrencyconverter.models.Coin;

import java.util.List;

public class TokenListMessage {

    String message;
    private static final String FORMAT_ITEM_MESSAGE = "\t\t%s\t\t \t\t%s (%s)\t\t\n";

    private TokenListMessage(List<Coin> coins) {
        this.message = generateMessage(coins);
    }

    private String generateMessage(List<Coin> coins) {
        var sb = new StringBuilder();
        sb.append("*****Tokens*****\n");
        sb.append("\t\tid\t\t|\t\tname(symbol)\t\t\n");
        coins.forEach(coin ->
            sb.append(String.format(FORMAT_ITEM_MESSAGE, coin.getId(), coin.getName(), coin.getSymbol()))
        );
        return sb.toString();
    }

    public static TokenListMessage create(List<Coin> coins) {
        return new TokenListMessage(coins);
    }

    @Override
    public String toString() {
        return message;
    }
}
