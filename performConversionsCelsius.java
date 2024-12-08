import java.util.Scanner;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Method to convert Fahrenheit to Kelvin
    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    // Method to convert Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Method to convert Kelvin to Fahrenheit
    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Converter!");
        System.out.print("Enter the number of conversions you'd like to test (minimum of 3): ");
        int numConversions = in.nextInt();

        if (numConversions < 3) {
            System.out.println("Please enter at least three inputs.");
            return;
        }

        for (int i = 0; i < numConversions; i++) {
            System.out.println("\nConversion #" + (i + 1));
            System.out.print("Enter the temperature value: ");
            double value = in.nextDouble();
            System.out.print("Enter the scale (C for Celsius, F for Fahrenheit, K for Kelvin): ");
            char scale = in.next().toUpperCase().charAt(0);

            switch (scale) {
                case 'C':
                    performConversionsCelsius(value);
                    break;
                case 'F':
                    performConversionsFahrenheit(value);
                    break;
                case 'K':
                    if (value < 0) {
                        System.out.println("Kelvin temperature cannot be negative.");
                    } else {
                        performConversionsKelvin(value);
                    }
                    break;
                default:
                    System.out.println("Invalid scale input. Please enter C, F, or K.");
            }
        }

        in.close();
    }

    public static void performConversionsCelsius(double celsius) {
        double fahrenheit = celsiusToFahrenheit(celsius);
        double kelvin = celsiusToKelvin(celsius);

        System.out.println(celsius + "°C is equivalent to:");
        System.out.println("Fahrenheit: " + fahrenheit + "°F");
        System.out.println("Kelvin: " + kelvin + "K");
    }

    public static void performConversionsFahrenheit(double fahrenheit) {
        double celsius = fahrenheitToCelsius(fahrenheit);
        double kelvin = fahrenheitToKelvin(fahrenheit);

        System.out.println(fahrenheit + "°F is equivalent to:");
        System.out.println("Celsius: " + celsius + "°C");
        System.out.println("Kelvin: " + kelvin + "K");
    }

    public static void performConversionsKelvin(double kelvin) {
        double celsius = kelvinToCelsius(kelvin);
        double fahrenheit = kelvinToFahrenheit(kelvin);

        System.out.println(kelvin + "K is equivalent to:");
        System.out.println("Celsius: " + celsius + "°C");
        System.out.println("Fahrenheit: " + fahrenheit + "°F");
    }
}
