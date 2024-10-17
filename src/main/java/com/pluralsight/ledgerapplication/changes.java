package com.pluralsight.ledgerapplication;

import java.util.Scanner;

public class changes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    
                    Welcome to the Ledger Home Screen!
                    
                    Please choose one of the following:
                    
                    A. View all entries
                    
                    D. View deposits
                    
                    R. Reports
                    
                    H. Exit to home screen
                    """);
            String userInput = scanner.nextLine().toUpperCase();


            switch (userInput) {
                case "A":
                    System.out.println("All Entries: ");
                    //all
                    addAllEntries();
                case "D":
                    // deposits
                    addAllDeposits();
                case "P":
                    // payments
                  addAllPayments();
                case "R":
                    // reports
                    addAllReports();

                case "H":
                    // return to home screen
                    isRunning = false;
                    break;
                // runs exit class
                default:
                    System.out.println("Invalid input, please choose correct input.");
                    return;
//
            }
        }

    }

    private static void addAllReports() {
    }

    private static void addAllPayments() {
    }

    private static void addAllDeposits() {
    }

    private static void addAllEntries() {
    }
}