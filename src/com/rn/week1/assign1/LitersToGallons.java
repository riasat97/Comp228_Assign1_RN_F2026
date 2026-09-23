package com.rn.week1.assign1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Task C: Converts liquid volume from liters to US gallons.
 * Validates against negative inputs and handles parsing exceptions.
 * 
 * @author Riasat Noor
 * @since 2026-09-22
 */
public class LitersToGallons {

    // 1 liter = 0.2641720524 US gallons
    private final double LITERS_TO_GALLONS_FACTOR = 0.2641720524;

    //@param scanner active Scanner instance passed from DriverMain
    public void convertLitersToGallons(Scanner scanner) {
        System.out.println("\n=================================");
        System.out.println("       LITERS TO GALLONS         ");
        System.out.println("=================================");

        try {
            System.out.print("Enter volume in liters: ");
            double liters = scanner.nextDouble();

            // Input validation: volume cannot be negative
            if (liters < 0) {
                System.out.println("Error: Volume cannot be negative.");
                return;
            }

            double gallons = liters * LITERS_TO_GALLONS_FACTOR;

            System.out.println("---------------------------------");
            System.out.printf("%.2f liters is equal to %.2f gallons.%n", liters, gallons);
            System.out.println("=================================");

        } catch (InputMismatchException e) {
            System.out.println("\n[!] Input Error: Volume must be a valid numerical value.");
            System.out.println("Exception Message:           " + e.getMessage());
            System.out.println("Exception Localized Message: " + e.getLocalizedMessage());
            System.out.println("Exception Hashcode:          " + e.hashCode());
            scanner.nextLine(); // Clear invalid input buffer
        }
    }
}
