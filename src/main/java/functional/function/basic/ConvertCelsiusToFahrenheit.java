package functional.function.basic;

import java.util.function.Function;

public class ConvertCelsiusToFahrenheit {
    public static void main(String[] args) {
        // Problem 4: Convert Celsius to Fahrenheit.
        // This function takes a Double (Celsius) and returns a Double (Fahrenheit).
        Function<Double, Double> celsiusToFahrenheit = celsius -> (celsius * 9 / 5) + 32;

        double celsius = 25.0;
        double fahrenheit = celsiusToFahrenheit.apply(celsius);

        System.out.println(celsius + "°C is equal to " + fahrenheit + "°F");
    }
}
