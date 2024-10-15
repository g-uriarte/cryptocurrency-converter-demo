package com.guriarte.cryptocurrencyconverter.messages;

import com.guriarte.cryptocurrencyconverter.models.Coin;

import java.util.List;
import java.util.Map;

public class TokenListMessage {

    String message;
    private static final String FORMAT_ITEM_MESSAGE = "%s.   %s (%s)\n";

    private TokenListMessage(Map<Integer, Coin> coins) {
        this.message = generateMessage(coins);
    }

    private String generateMessage(Map<Integer, Coin> coins) {
        var sb = new StringBuilder();
        sb.append("*****Tokens*****\n");
        sb.append("id | name(symbol)\n");
        coins.forEach((id, coin) ->
            sb.append(String.format(FORMAT_ITEM_MESSAGE, id, coin.getName(), coin.getSymbol()))
        );
        return sb.toString();
    }

    public static TokenListMessage create(Map<Integer, Coin> coins) {
        return new TokenListMessage(coins);
    }

    @Override
    public String toString() {
        return message;
    }
}
