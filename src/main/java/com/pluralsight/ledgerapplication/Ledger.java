package com.pluralsight.ledgerapplication;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Scanner;


public class Ledger {
    private static ArrayList<Transaction> transactions;
    private static Object ArrayList;

    // reads from csv file and displays all the transactions
    public static void allTransaction(ArrayList<Transaction> allTransactions) {
        for (Transaction t : allTransactions) {
            System.out.println(t);
        }
    }


    // reads from csv file and displays all the deposits
    public static void allDeposits(ArrayList<Transaction> allDeposits) {
        for (Transaction d : allDeposits) {
            if (d.getAmount() > 0) {
                System.out.println(d);

            }
        }
    }


    // // reads from csv file and displays all the payments
    public static void allPayments(ArrayList<Transaction> allPayment) {
        for (Transaction p : allPayment) {
            if (p.getAmount() < 0) {
                System.out.println(p);
            }
        }
    }

    // // reads from csv file and displays all the reports
    public static void allReports(ArrayList<Transaction> allReports) {
        for (Transaction r : allReports) ;
        System.out.println();
    }


    // methods for reports
    public static void monthToDate(ArrayList<Transaction> monthToDate) {
        for (Transaction mtd : monthToDate) {
            if (Transaction.date.getMonth() == LocalDate.now().getMonth()) ;
            System.out.println(monthToDate);

        }
    }

    // filters to display the transactions from the previous month
    public static void previousMonth(ArrayList<Transaction> previousMonth) {
        for (Transaction pm : previousMonth) {
            if ((Transaction.date.getMonth()-1) == LocalDate.now().getMonth()) {
                System.out.println("Previous month:" + transactions);

            }

        }
    }


    public static void yearToDate(ArrayList<Transaction> yearToDate) {
        for (Transaction ytd : yearToDate) ;
        if (Transaction.date.getYear() == LocalDate.now().getYear()) ;
        System.out.println(yearToDate);
    }


    // filters to display the transactions from the previous year
    public static void previousYear(ArrayList<Transaction> previousYear) {
        for (Transaction py : previousYear) ;
            if ((Transaction.date.getYear() - 1) == LocalDate.now().getYear()) ;
        System.out.println("Previous year: " + previousYear);
    }


    public static void searchVendor(ArrayList<Transaction> searchVendor) {
        Scanner searchVendorScanner = new Scanner(System.in);

        System.out.println("Enter the name of the vendor ");
        String search = searchVendorScanner.nextLine().trim().toLowerCase();


    }
}




