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
        System.out.println("All Reports");
        for (Transaction r : allReports) {
            System.out.println(r.toString());
        }
    }


    // methods for reports
    public static void monthToDate(ArrayList<Transaction> monthToDate) {
        System.out.println("Month to date:");
        for (Transaction mtd : monthToDate) {
            if (mtd.getDate().getMonth() == LocalDate.now().getMonth()) ;
            System.out.println(monthToDate);

        }
    }

    // filters to display the transactions from the previous month
    public static void previousMonth(ArrayList<Transaction> previousMonth) {
        System.out.println("Previous month:");
        System.out.println();
        for (Transaction pm : previousMonth) {
            if ((pm.getDate().getMonth().getValue() - 1) == LocalDate.now().getMonth().getValue() - 1) {
                System.out.println(pm);

            }

        }
    }


    public static void yearToDate(ArrayList<Transaction> yearToDate) {
        System.out.println("Year to date:");
        for (Transaction ytd : yearToDate) {
            if (ytd.getDate().getYear() == LocalDate.now().getYear()) {
            System.out.println(ytd);
        }

    }
}



    // filters to display the transactions from the previous year
    public static void previousYear(ArrayList<Transaction> previousYear) {
        for (Transaction py : previousYear) {
            if (py.getDate().getYear()-1 == LocalDate.now().getYear()-1) {
     //   System.out.println("Previous year: " + previousYear);
                System.out.println(py);
    }
        }
    }


    public static void searchVendor(ArrayList<Transaction> searchVendor) {
        Scanner searchVendorScanner = new Scanner(System.in);

        System.out.println("Enter the name of the vendor ");
        String search = searchVendorScanner.nextLine().trim().toLowerCase();


    }
}
//




