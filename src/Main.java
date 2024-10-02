import com.guriarte.cryptocurrencyconverter.actions.Action;
import com.guriarte.cryptocurrencyconverter.actions.ConvertAction;
import com.guriarte.cryptocurrencyconverter.service.CoinPaprikaApi;
import com.guriarte.cryptocurrencyconverter.service.CoinPaprikaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final int EXIT = 0;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        final CoinPaprikaApi coinPaprikaApi = new CoinPaprikaService("https://api.coinpaprika.com/v1");

        try {
            // We only show 10 coins for convenience at the terminal. This is also a demo.
            var coins = coinPaprikaApi.getCoins().subList(0, 10);
            int option;
            Map<Integer, Action> actions = new HashMap<>();
            actions.put(ConvertAction.OPTION, new ConvertAction(coins, coinPaprikaApi, sc));
            var options = new ArrayList<>(actions.values()
                    .stream()
                    .map(action -> action.option() + ". " + action.description())
                    .toList());
            options.add("0. Exit");

            do {
                System.out.println("Select an option:");
                options.forEach(System.out::println);
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