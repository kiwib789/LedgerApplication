package com.pluralsight.ledgerapplication;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.ledgerapplication.Ledger.*;


public class MenuApp {

    private static ArrayList<Transaction> transactions;

    public static void main(String[] args) throws IOException {
        transactions = readAllFromFile();
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // home screen
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

            // Works with user input based on which answer they pick and takes them to the next screen
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

// writes to file
    private static void writeToFile(Transaction transaction) {
        ArrayList<Transaction> result = new ArrayList<>();
        try {
            try {
                FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
                BufferedWriter bufWriter = new BufferedWriter(fileWriter);
                // splits up the format of the csv file in correct order
                bufWriter.write(
                        transaction.getDate() + "|" + transaction.getTime() + "|" +
                                transaction.getDescription() + "|" + transaction.getVendor() + "|" +
                                transaction.getAmount() + "\n");
                bufWriter.close();
            } catch (IOException e) {
                System.out.println("File not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    // read from file
    private static ArrayList<Transaction> readAllFromFile() {

        ArrayList<Transaction> result = new ArrayList<>();

        try {
            FileReader filereader = new FileReader("transactions.csv");
            BufferedReader bufReader = new BufferedReader(filereader);

            String input;
            bufReader.readLine();
            // splits up user input by correct format
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

    // questions for user to answer that adds a deposit with their input
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

    // // questions for user to answer that makes a payment with their input
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
        transactions.add(t);
    }

    // Ledger display screen
    public static void displayLedgerMenu() {
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    
                    Welcome to the Ledger Home Screen!
                    
                    Please choose one of the following:
                    
                    A. View all entries
                    D. View deposits
                    P. View Payments
                    R. Reports
                    H. Exit to home screen
                    """);
            String userInput = scanner.nextLine().toUpperCase();

            // Works wit user input based on which answer they pick and takes them to the next screen
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

    //ledger
    public static void showAllEntries() {
        System.out.println("All entries:");
        Ledger.allTransaction(transactions);

    }

    public static void showAllDeposits() {
        System.out.println("All deposits: ");
        Ledger.allDeposits(transactions);
    }

    public static void showAllPayments() {
        System.out.println("All payments: ");
        Ledger.allPayments(transactions);
    }

    public static void showAllReports() {
        System.out.println("All reports: ");
        Ledger.allReports(transactions);


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

    // reports screen
    public static void reportsDisplay() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    Welcome to the Reports screen!
                    
                    Please choose one of the following 
                    
                    1. Month
                    2. Previous Month
                    3. Year to Date
                    4. Previous Year
                    5. Search by vendor
                    0. Back
                    
                    """);
            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "1":
                    System.out.println("Month to Date ");
                    //all
                    monthToDate();
                    break;
                case "2":
                    // deposits
                    System.out.println("Previous month ");
                    previousMonth();
                    break;
                case "3":
                    // payments
                    System.out.println("Year to Date ");
                    yearToDate();
                    break;
                case "4":
                    // reports
                    System.out.println("Previous Year ");
                    previousYear();
                    break;
                case "5":
                    System.out.println("Search by vendor ");
                    searchVendor();
                case "0":
                    System.out.println("Go back");
                    isRunning = false;
                    break;
                // runs exit class
                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;
            }
        }
    }

    public static void monthToDate() {
        System.out.println("Month to Date");
        Ledger.monthToDate(transactions);
    }

    public static void previousMonth() {
        System.out.println("Previous month");
        Ledger.previousMonth(transactions);
    }

    public static void yearToDate() {
        System.out.println("Year to Date ");
        Ledger.yearToDate(transactions);
    }

    public static void previousYear() {
        System.out.println("Previous year ");
        Ledger.previousYear(transactions);


    }
    private static void searchVendor() {
        System.out.println("Please enter vendor");
        Ledger.searchVendor(transactions);
    }
}