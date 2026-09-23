package com.rn.week1.assign1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Task B: Converts distance from miles to kilometers.
 * Performs input validation for non-negative values and handles
 * parsing exceptions gracefully.
 * 
 * @author Riasat Noor
 * @since 2026-09-22
 */
public class MilesToKm {
	// 1 statute mile = 1.609344 kilometers
    private final double MILES_TO_KM_FACTOR = 1.609344;

    //@param scanner active Scanner instance passed from DriverMain
    public void convertMilesToKm(Scanner scanner) {
        System.out.println("\n=================================");
        System.out.println("     MILES TO KILOMETERS         ");
        System.out.println("=================================");

        try {
            System.out.print("Enter distance in miles: ");
            double miles = scanner.nextDouble();

            // Distance validation check
            if (miles < 0) {
                System.out.println("Error: Distance cannot be negative.");
                return;
            }

            double kilometers = miles * MILES_TO_KM_FACTOR;

            System.out.println("---------------------------------");
            System.out.printf("%.2f miles is equal to %.2f kilometers.%n", miles, kilometers);
            System.out.println("=================================");

        } catch (InputMismatchException e) {
            System.out.println("\n[!] Input Error: Distance must be a valid numerical value.");
            System.out.println("Exception Message:           " + e.getMessage());
            System.out.println("Exception Localized Message: " + e.getLocalizedMessage());
            System.out.println("Exception Hashcode:          " + e.hashCode());
            scanner.nextLine(); 
        }
    }
}
