import java.util.*;
import java.io.*;

public class JavaApplication3 {

    public static double calculateTemperature(double[] coefficients, double time) {
        return coefficients[0] * time * time + coefficients[1] * time + coefficients[2];
    }

    public static void displayWeatherModel(double[] coefficients, double time, double temperature) {
        System.out.printf(
            "Weather Model: For coefficients a=%.3f, b=%.3f, c=%.3f at hour %.1f, temperature = %.2f°C%n",
            coefficients[0], coefficients[1], coefficients[2], time, temperature
        );
    }

    public static void runFromFileMultiple(String fileName) {
        System.out.println("=== Weather Model: Multiple File Inputs ===");
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNext()) {
                double[] coefficients = new double[3];
                coefficients[0] = fileScanner.nextDouble();
                coefficients[1] = fileScanner.nextDouble();
                coefficients[2] = fileScanner.nextDouble();
                double time = fileScanner.nextDouble();
                double temperature = calculateTemperature(coefficients, time);
                displayWeatherModel(coefficients, time, temperature);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to locate the file. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String multipleInputFile = "multiple_inputs.txt";
        runFromFileMultiple(multipleInputFile);
    }
}



Output:
=== Weather Model: Multiple File Inputs ===
Weather Model: For coefficients a=0.010, b=-0.200, c=30.000 at hour 5.0, temperature = 29.25°C
Weather Model: For coefficients a=0.015, b=-0.100, c=25.000 at hour 10.0, temperature = 25.50°C
Weather Model: For coefficients a=0.020, b=-0.250, c=20.000 at hour 15.0, temperature = 20.75°C
