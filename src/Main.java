import com.guriarte.cryptocurrencyconverter.actions.Action;
import com.guriarte.cryptocurrencyconverter.actions.ConvertAction;
import com.guriarte.cryptocurrencyconverter.models.Coin;
import com.guriarte.cryptocurrencyconverter.service.CoinPaprikaApi;
import com.guriarte.cryptocurrencyconverter.service.CoinPaprikaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final int EXIT = 0;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        final CoinPaprikaApi coinPaprikaApi = new CoinPaprikaService("https://api.coinpaprika.com/v1");

        try {
            // We only show 10 coins for convenience at the terminal. This is also a demo.
            var coins = coinPaprikaApi.getCoins().subList(0, 10);
            Map<Integer, Coin> coinMap = IntStream.range(0, coins.size()).boxed().collect(Collectors.toMap(i -> i, coins::get));

            int option;
            Map<Integer, Action> actions = new HashMap<>();
            actions.put(ConvertAction.OPTION, new ConvertAction(coinMap, coinPaprikaApi, sc));
            var options = new ArrayList<>(actions.values()
                    .stream()
                    .map(action -> action.option() + ". " + action.description())
                    .toList());
            options.add("0. Exit");

            do {
                options.forEach(System.out::println);
                System.out.print("Select an option: ");
                option = sc.nextInt();

                if (option != EXIT) {
                    actions.get(option).perform();
                }
            } while (option != EXIT);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}