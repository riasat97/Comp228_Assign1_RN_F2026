package com.rn.week1.assign1.Driver;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.rn.week1.assign1.CadToUsd;
import com.rn.week1.assign1.GradeCalculation;
import com.rn.week1.assign1.LitersToGallons;
import com.rn.week1.assign1.MilesToKm;

/**
 * Interactive driver for Assignment 1.
 * Instantiates objects for Tasks A through D and routes execution via switch-case.
 * @author Riasat Noor
 * @since 2026-09-22
 */
public class DriverMain {
	public static void main(String[] args) {
        // Instantiate using object per requirement
        GradeCalculation gc = new GradeCalculation();
        MilesToKm milesConverter = new MilesToKm();
        LitersToGallons volumeConverter = new LitersToGallons();
        CadToUsd cadConverter = new CadToUsd();
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the choice for operation: ");
            System.out.println("1 - Grade Calculation");
            System.out.println("2 - Miles to Kms");
            System.out.println("3 - Liters to Gallons");
            System.out.println("4 - CAD to USD");
            System.out.print("Your choice: ");

            int choice = sc.nextInt();
            // Menu selection validation
            if (choice < 1 || choice > 4) {
                System.out.println("Error: Invalid option. Please select a number between 1 and 4.");
                return;
            }

            // Call methods using object instances
            switch (choice) {
                case 1:
                    System.out.println("\nDoing Grade Calculation...");
                    gc.GradeCalc(sc); 
                    break;
                case 2:
                    System.out.println("\nDoing Miles to Kilometers Conversion...");
                    milesConverter.convertMilesToKm(sc); 
                    break;
                case 3:
                    System.out.println("\nDoing Liters to Gallons Conversion...");
                    volumeConverter.convertLitersToGallons(sc); 
                    break;
                case 4:
                    System.out.println("\nDoing CAD to USD Conversion...");
                    cadConverter.convertCadToUsd(sc);
                    break;
            }
        }catch (InputMismatchException e) {
            System.out.println("\n[!] Input Error: Choice must be an integer (1 to 4).");
            System.out.println("Exception Message:           " + e.getMessage());
            System.out.println("Exception Localized Message: " + e.getLocalizedMessage());
            System.out.println("Exception Hashcode:          " + e.hashCode());
        }
    }
}
