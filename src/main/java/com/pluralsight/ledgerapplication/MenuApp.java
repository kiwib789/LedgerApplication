package com.pluralsight.ledgerapplication;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class MenuApp {

    private static ArrayList<Transaction> transactions;

    public static void main(String[] args) throws IOException {
        transactions = readAllFromFile();
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    
                    Welcome to the Transactions Home Screen!
                    
                    Please choose one of the following:
                    
                    D. Add deposit
                    
                    P. Make Payment
                    
                    L. Ledger
                    
                    X. Exit
                    """);
            String userInput = scanner.nextLine().toUpperCase();


            switch (userInput) {
                case "D":
                    System.out.println("Please enter deposit. ");
                    // runs add deposit class
                    addDeposit();
                    break;
                case "P":
                    // runs make payment class
                    makePayment();
                    break;
                case "L":
                    // runs ledger class
                    displayLedgerMenu();
                    break;

                case "X":
                    isRunning = false;
                    break;
                // runs exit class
                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;


            }


        }

    }



    private static void writeToFile(Transaction transaction) {
        try {
            FileWriter writer = new FileWriter("transactions.csv");
// here write single transaction and make sure it matches format of csv file

            String input;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //this logic can always be the same because the result will always be the same
        //adding a new line to the csv file
    }




    // you may need multiple methods to ready from the file..  mainly for the ledger menu
    private static ArrayList<Transaction> readAllFromFile() {

        ArrayList<Transaction> result = new ArrayList<>();

        try {
            FileReader filereader = new FileReader("transactions.csv");
            BufferedReader bufReader = new BufferedReader(filereader);

            String input;
            bufReader.readLine();
            // skip the first line
            while ((input = bufReader.readLine()) != null) {
                String[] entry = input.split("\\|");
                String date = entry[0];
                String time = entry[1];
                String description = entry[2];
                String vendor = entry[3];
                double amount = Double.parseDouble(entry[4]);
                Transaction transaction = new Transaction(LocalDate.parse(date, formatDate), LocalTime.parse(time, formatTime), description, vendor, amount);
                result.add(transaction);
            }

            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return result;
    }




    public static void addDeposit() {
        // get amount
        System.out.println("How much you would like to deposit? ");
        Scanner addScanner = new Scanner(System.in);

        double amount = addScanner.nextDouble();
        addScanner.nextLine();

        System.out.println("Please enter vendor: ");
        String vendor = addScanner.nextLine();

        System.out.println("Please enter description");
        String description = addScanner.nextLine();

        System.out.println("Your deposit was:" + amount);
        LocalDateTime now = LocalDateTime.now();
        Transaction t = new Transaction(now.toLocalDate(), now.toLocalTime(), description, vendor, amount);
        transactions.add(t);

    }




    public static void makePayment() {
        System.out.println("How much would you like to pay? ");
        Scanner paymentScanner = new Scanner(System.in);

        double amount = paymentScanner.nextDouble();
        paymentScanner.nextLine();
        System.out.println("Please enter vendor ");
        String vendor = paymentScanner.nextLine();

        System.out.println("Please enter description ");
        String description = paymentScanner.nextLine();

        System.out.println("Thank you your payment of " + amount + " was successful.");
        LocalDateTime now = LocalDateTime.now();
        Transaction t = new Transaction(now.toLocalDate(), now.toLocalTime(), description, vendor, -amount);
        //payment negative numbers
        transactions.add(t);
        // add vendor
    }



    public static void displayLedgerMenu() {
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
                    System.out.println("View all entries ");
                    //all
                    showAllEntries();
                    break;
                case "D":
                    // deposits
                    System.out.println("View all deposits ");
                    showAllDeposits();
                    break;
                case "P":
                    // payments
                    System.out.println("View all payments");
                    showAllPayments();
                    break;
                case "R":
                    // reports
                    System.out.println("View all Reports");
                    showAllReports();
                    break;
                case "H":
                    // return to home screen
                    isRunning = false;
                    break;
                // runs exit class
                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;
//
            }
        }

    }




    public static void showAllEntries() {
        System.out.println("All entries:");
        Ledger.allTransaction(transactions);
    }

    public static void showAllDeposits() {
        System.out.println("All deposits: ");
    }

    public static void showAllPayments() {
        System.out.println("All payments: ");
    }

    public static void showAllReports() {
        System.out.println("All reports: ");


    }

    LocalDateTime dateTime = LocalDateTime.now();
    static DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static void makeTransactions() throws IOException {
        FileReader filereader = new FileReader("transactions.csv");
        BufferedReader bufReader = new BufferedReader(filereader);

        String input;

        while ((input = bufReader.readLine()) != null) {
            String[] entry = input.split("\\|");
            String date = entry[0];
            String time = entry[1];
            String description = entry[2];
            String vendor = entry[3];
            double amount = Double.parseDouble(entry[4]);
            Transaction transaction = new Transaction(LocalDate.parse(date, formatDate), LocalTime.parse(time, formatTime), description, vendor, amount);
        }

    }

    public static void reportsDisplay() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    Welcome to the Reports screen
                    
                    Please choose one of the following 
                    
                    1. Month
                    
                    2. Previous Month
                    """);

        }
    }
}


