package com.pluralsight.ledgerapplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Ledger {


    public static void allTransaction(ArrayList<Transaction> allTransactions) {
        for (Transaction t : allTransactions) {
            System.out.println(t);
        }
    }


    public static void allDeposits(ArrayList<Transaction> allDeposits) {
        for (Transaction d : allDeposits) {
            if (d.getAmount() > 0) {
                System.out.println(d);

            }
        }
    }

    public static void allPayments(ArrayList<Transaction> allPayments) {
        for (Transaction p : allPayments) ;
                if (p.getAmount() < 0) {
            System.out.println(p);
        }
    }


    public static void allReports(ArrayList<Transaction> allReports) {
        for (Transaction r : allReports) ;
        System.out.println();
    }


    // reports
    public static void monthToDate(ArrayList<Transaction> monthToDate) {
        for (Transaction mtd : Ledger) ;
        if (mtd.getDate().getMonth().equals(LocalDate.now().getMonth())) {
            System.out.println(mtd.toStringForConsole());


        }

        public static void previousMonth (ArrayList < Transaction > previousMonth) {
            for (Transaction pm : previousMonth) ;


        }

        public static void yearToDate (ArrayList < Transaction > yearToDate) {
            for (Transaction ytd : yearToDate) ;
            if ((LocalDate.now().getYear() - 1) == Transaction.getDate().getYear());
        }


        public static void previousYear (ArrayList < Transaction > previousYear) {
            for (Transaction py : previousYear) ;
        }


        public static void searchVendor (ArrayList < Transaction > searchVendor) {
            for (Transaction sv : searchVendor) {
                if (sv.getVendor().equals(searchVendor)) {
                    result.add(sv);
                }
            }
            return result;


                }


            }

        }

