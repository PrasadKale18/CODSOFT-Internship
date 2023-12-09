import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private static final String BASE_CURRENCY_KEY = "base_currency";
    private static final String TARGET_CURRENCY_KEY = "target_currency";
    private static final String EXCHANGE_RATE_KEY = "exchange_rate";

    private static final Map<String, Map<String, Double>> EXCHANGE_RATES = new HashMap<>();

    static {
        // Fetch real-time exchange rates from a reliable API here
    }

    public static double convert(double amount, String baseCurrency, String targetCurrency) {
        Map<String, Double> exchangeRates = EXCHANGE_RATES.get(baseCurrency);
        if (exchangeRates == null) {
            throw new IllegalArgumentException("Exchange rates for base currency " + baseCurrency + " not found");
        }

        Double exchangeRate = exchangeRates.get(targetCurrency);
        if (exchangeRate == null) {
            throw new IllegalArgumentException("Exchange rates for target currency " + targetCurrency + " not found");
        }

        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        // Currency selection
        String baseCurrency = "USD";
        String targetCurrency = "EUR";

        // Amount input
        double amount = 100;

        // Currency conversion
        double convertedAmount = convert(amount, baseCurrency, targetCurrency);

        // Display result
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
    }
}