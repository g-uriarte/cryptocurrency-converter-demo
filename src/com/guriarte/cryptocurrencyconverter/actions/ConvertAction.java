package com.guriarte.cryptocurrencyconverter.actions;

import com.guriarte.cryptocurrencyconverter.http.exceptions.HttpUnexpectedError;
import com.guriarte.cryptocurrencyconverter.messages.TokenListMessage;
import com.guriarte.cryptocurrencyconverter.models.Coin;
import com.guriarte.cryptocurrencyconverter.models.Ticker;
import com.guriarte.cryptocurrencyconverter.service.CoinPaprikaApi;

import java.util.List;
import java.util.Scanner;

public class ConvertAction implements Action {

    public static int OPTION = 1;

    private final List<Coin> coins;
    private final CoinPaprikaApi coinPaprikaApi;
    private final Scanner sc;

    public ConvertAction(
        List<Coin> coins, CoinPaprikaApi coinPaprikaApi,
        Scanner sc
    ) {
        this.coins = coins;
        this.coinPaprikaApi = coinPaprikaApi;
        this.sc = sc;
    }

    @Override
    public int option() {
        return 1;
    }

    @Override
    public String description() {
        return "Try cryptocurrency converter Calculator";
    }

    @Override
    public void perform() throws HttpUnexpectedError {
        var tokenIn = selectToken();
        System.out.print("Enter the amount: ");
        double amount1 = sc.nextDouble();

        var tokenOut = selectToken();

        var tokenInUsdPrice = tokenIn.getQuote("USD").getPrice();
        var tokenOutUsdPrice = tokenOut.getQuote("USD").getPrice();

        var expectedOutput = (amount1 * tokenInUsdPrice) / tokenOutUsdPrice;

        System.out.println("Result: Token in (" + tokenIn.getSymbol() + ") amount: " + amount1 + " -> token out: (" + tokenOut.getSymbol() + ") amount: " + expectedOutput);
    }

    private Ticker selectToken() throws HttpUnexpectedError {
        boolean validId = false;
        String tokenId;
        var coinIds = coins.stream().map(Coin::getId).toList();
        TokenListMessage tokenListMessage = TokenListMessage.create(coins);
        do {
            System.out.println("Select a token in (enter the id): ");
            System.out.println(tokenListMessage);
            System.out.print("token id: ");
            tokenId = sc.next();
            if (coinIds.contains(tokenId)) {
                validId = true;
            }
        } while (!validId);

        return this.coinPaprikaApi.getTicker(tokenId);
    }

}
