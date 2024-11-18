import java.util.*;

public class tempraturecalculator {    
public static final String RESET = "\u001B[0m";
public static final String RED = "\u001B[31m";
public static final String GREEN = "\u001B[32m";
public static final String YELLOW = "\u001B[33m";
public static final String BLUE= "\u001B[34m";
public static final String CYAN= "\u001B[36m";  
public static final String WHITE= "\u001B[37m";
public static final String BLACK= "\u001B[30m";
public static final String MAGENTA= "\u001B[35m";


    public static void convertFromCelsius(double celsius) {
        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
        double kelvin = celsius + 273.15;

        System.out.println(MAGENTA+"Entered Temperature in fahrenheit: " + String.format("%.3f",fahrenheit) + " °F"+RESET);
        System.out.println(YELLOW+"Entered Temperature in kelvn: " + String.format("%.3f",kelvin) + " K"+RESET);
    }

    public static void convertFromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
        double kelvin = celsius + 273.15;

        System.out.println(CYAN+"Entered Temperature in celsius: " + String.format("%.3f",celsius) + " °C"+RESET);
        System.out.println(YELLOW+"Entered Temperature in kelvin: " + String.format("%.3f",kelvin) + " K"+RESET);
    }

    public static void convertFromKelvin(double kelvin) {
        double celsius = kelvin - 273.15;
        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;

        System.out.println(CYAN+"Entered Temperature in celsius: " + String.format("%.3f",celsius) + " °C"+RESET);
        System.out.println(MAGENTA+"Entered Temperature in fahrenheit: " + String.format("%.3f",fahrenheit) + " °F"+RESET);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(GREEN+"Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print(BLUE+"Enter the unit (C for Celsius, F for Fahrenheit, K for Kelvin): "+RESET);
        char unit = scanner.next().charAt(0);

        switch (unit) {
            case 'C', 'c' -> convertFromCelsius(temperature);
            case 'F', 'f' -> convertFromFahrenheit(temperature);
            case 'K', 'k' -> convertFromKelvin(temperature);
            default -> System.out.println("Invalid unit entered. Please use C, F, or K.");
        }

        scanner.close();
    }
}

