package com.pluralsight.ledgerapplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;




public class Ledger {
    private static ArrayList<Transaction> transactions;

    // reads from csv file and displays all the transactions
    public static void allTransaction(ArrayList<Transaction> allTransactions) {
        for (Transaction t : allTransactions) {
            System.out.println(t);
        }
    }


    // reads from csv file and displays all the deposits
    public static void allDeposits(ArrayList<Transaction> allDeposits) {
        for (Transaction d : transactions) {
            if (d.getAmount() > 0) {
                System.out.println(d);

            }
        }
    }


    // // reads from csv file and displays all the payments
    public static void allPayments(ArrayList<Transaction> allPayment) {
        for (Transaction p : transactions) ;
        if (p.getAmount() < 0) {
            System.out.println(p);
        }
    }

    // hey paul if you see this i fixed a good amount of my errors i was missing a curly brace, took me two hours to realize it ~_~
// i couldnt fix the error above and theres something wrong with my reports im going to sleep but gonna wake back up at 6 to work on it
    public static void allReports(ArrayList<Transaction> allReports) {
        for (Transaction r : allReports) ;
        System.out.println();
    }


    // reports

    public static void monthToDate(ArrayList<Transaction> monthToDate) {
        for (Transaction mtd : transactions) ;
        if (transactions.getDate().getMonth() == LocalDate.now().getMonth() && transactions.getDate().getYear() == LocalDate.now().getYear()) {
            System.out.print(transactions);

        }
    }

        public static void previousMonth(ArrayList<Transaction>previousMonth) {
            for (Transaction pm : transactions)
                ;
        }


    }

    public static void yearToDate(ArrayList<Transaction>yearToDate) {
        for (Transaction ytd : yearToDate) ;
        if ((LocalDate.now().getYear() - 1) == Transaction.getDate().getYear()) ;
    }


    public static void previousYear(ArrayList<Transaction> previousYear) {
        for (Transaction py : previousYear) ;
    }


    public static void searchVendor(ArrayList<Transaction> searchVendor) {
        for (Transaction sv : searchVendor) {
            {


            }


        }


    }
