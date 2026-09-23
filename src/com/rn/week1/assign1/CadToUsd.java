package com.rn.week1.assign1;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Task D: Converts Canadian Dollars (CAD) to United States Dollars (USD).
 * Utilizes BigDecimal for precise monetary calculations, validates non-negative amounts,
 * and formats the output using US and Canadian currency formatters.
 * 
 * @author Riasat
 * @since 2026-09-22
 */
public class CadToUsd {

    // Exchange rate reference (e.g., 1 CAD = 0.74 USD)
    private final BigDecimal CAD_TO_USD_RATE = new BigDecimal("0.74");

    //@param scanner active Scanner instance passed from DriverMain
    public void convertCadToUsd(Scanner scanner) {
        System.out.println("\n=================================");
        System.out.println("          CAD TO USD             ");
        System.out.println("=================================");

        try {
            System.out.print("Enter amount in Canadian Dollars (CAD): ");
            BigDecimal cadAmount = scanner.nextBigDecimal();

            // Validation: amount cannot be negative
            if (cadAmount.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("Error: Currency amount cannot be negative.");
                return;
            }

            // Calculation using BigDecimal with standard financial rounding
            BigDecimal usdAmount = cadAmount.multiply(CAD_TO_USD_RATE)
                                            .setScale(2, RoundingMode.HALF_UP);

            // Format as currency strings
            NumberFormat cadFormat = NumberFormat.getCurrencyInstance(Locale.CANADA);
            NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);

            System.out.println("---------------------------------");
            System.out.println("Rate used:       1 CAD = $" + CAD_TO_USD_RATE + " USD");
            System.out.println("Original amount: " + cadFormat.format(cadAmount));
            System.out.println("Converted amount:" + usdFormat.format(usdAmount));
            System.out.println("=================================");

        } catch (InputMismatchException e) {
            System.out.println("\n[!] Input Error: Amount must be a valid numerical value.");
            System.out.println("Exception Message:           " + e.getMessage());
            System.out.println("Exception Localized Message: " + e.getLocalizedMessage());
            System.out.println("Exception Hashcode:          " + e.hashCode());
            scanner.nextLine(); // Clear bad input from buffer
        }
    }
}