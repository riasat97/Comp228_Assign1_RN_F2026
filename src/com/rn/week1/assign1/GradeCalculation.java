package com.rn.week1.assign1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculates grades for semester courses based on standard percentage cutoffs.
 * Demonstrates exception handling, input validation, and object method invocation.
 * 
 * @author Riasat Noor
 * @since 2026-09-22
 */
public class GradeCalculation {
	/**
     * Reads marks for 6 subjects, validates them, and displays the final letter grade.
     * Takes the active console Scanner instance from the driver.
     * @param scanner active Scanner object
     */
	public void GradeCalc(Scanner scanner) {
		final int NUM_SUBJECTS= 6;
		int[] marks= new int[NUM_SUBJECTS];
		float total=0;
		float avg;
		
		System.out.println("\n=================================");
        System.out.println("       GRADE CALCULATION         ");
        System.out.println("=================================");
        
        try {
        	for (int i=0; i< NUM_SUBJECTS; i++) {
            	System.out.println("Enter Marks of Subject "+ (i+1)+" (0-100): ");
            	int mark= scanner.nextInt();
            	
            	// Validation Check
            	if (mark<0 || mark > 100) {
            		System.out.println("Error: Marks must be be between 0 and 100.");
            	}
            	marks[i]=mark;
            	total+=marks[i];
            }
            // Calculating average
            avg= total/ NUM_SUBJECTS;
            System.out.println("---------------------------------");
            System.out.printf("Total Marks: %.2f / %d%n",total, (NUM_SUBJECTS*100));
            System.out.printf("Average: %.2f%%%n",avg);
            System.out.print("The Student Grade is: ");
            
            // Complete grade range mapping (A,B,C,D,F)
            if (avg>=80) {
            	System.out.println("A");
            }
            else if (avg >= 70) {
                System.out.println("B");
            } else if (avg >= 60) {
                System.out.println("C");
            } else if (avg >= 50) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }
            System.out.println("=================================");
        } catch (InputMismatchException e) {
        	System.out.println("\n[!] Input Error: Marks must be entered as whole integers.");
            System.out.println("Exception Message:           " + e.getMessage());
            System.out.println("Exception Localized Message: " + e.getLocalizedMessage());
            System.out.println("Exception Hashcode:          " + e.hashCode());
            scanner.nextLine(); // Clear invalid input from the buffer
        }
        
	}
	
}
