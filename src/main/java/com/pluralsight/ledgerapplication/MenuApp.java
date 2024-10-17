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
                    ledgerDisplay();
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
            FileWriter writer  = new FileWriter("Transactions.java");

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
            while ((input = bufReader.readLine()) != null){
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




    public static void addDeposit(){
        // get amount
        System.out.println("How much you would like to deposit? ");
        Scanner addScanner = new Scanner(System.in);

        double amount = addScanner.nextDouble();
        addScanner.nextLine();

        System.out.println("Please enter vendor: ");
        String vendor = addScanner.nextLine();

        System.out.println("Please enter description");
        String description = addScanner.nextLine();

        System.out.println("Your deposit was:" + amount );
        LocalDateTime now = LocalDateTime.now();
        Transaction t = new Transaction(now.toLocalDate(), now.toLocalTime(), description, vendor, amount);
        transactions.add(t);

     }



    public static void makePayment(){
        System.out.println("How much would you like to pay? ");
        Scanner paymentScanner = new Scanner(System.in);

        double amount = paymentScanner.nextDouble();
        paymentScanner.nextLine();
        System.out.println("Please enter vendor ");
        String vendor = paymentScanner.nextLine();

        System.out.println("Please enter description ");
        String description =paymentScanner.nextLine();

        System.out.println("Thank you your payment of "+ amount + " was successful.");
        LocalDateTime now = LocalDateTime.now();
        Transaction t = new Transaction(now.toLocalDate(), now.toLocalTime(), description, vendor, -amount);
        //payment negative numbers
        transactions.add(t);
        // add vendor
    }
    public static void ledgerDisplay(){
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
                addAllEntries();
                break;
            case "D":
                // deposits
                System.out.println("View all deposits ");
                addAllDeposits();
                break;
            case "P":
                // payments
                System.out.println("View all payments");
                addAllPayments();
                break;
            case "R":
                // reports
                System.out.println("View all Reports");
                addAllReports();
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
    public static void addAllEntries() {
        System.out.println("All entries:");
        Ledger.allTransaction(transactions);
    }

    public static void addAllDeposits() {
        System.out.println("All deposits: ");
    }
    public static void addAllPayments() {
    System.out.println("All payments: ");
}

    public static void addAllReports() {
        System.out.println("All reports: ");



    }

    LocalDateTime dateTime = LocalDateTime.now();
     static DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");


     public static void makeTransactions() throws IOException {
         FileReader filereader = new FileReader("transactions.csv");
         BufferedReader bufReader = new BufferedReader(filereader);

         String input;

         while ((input = bufReader.readLine()) != null){
             String[] entry = input.split("\\|");
             String date = entry[0];
             String time = entry[1];
             String description = entry[2];
             String vendor = entry[3];
             double amount = Double.parseDouble(entry[4]);
             Transaction transaction = new Transaction(LocalDate.parse(date, formatDate), LocalTime.parse(time, formatTime), description, vendor, amount);
         }

     }
     public static void reportsDisplay(){
         Scanner scanner = new Scanner(System.in);
         boolean isRunning = true;

         while (isRunning){
             System.out.println("""
                     Welcome to the Reports screen
                     
                     Please choose one of the following 
                     
                     1. Month
                     
                     2. Previous Month
                     """);

         }
     }
}
//here is where you would read a line from the file and
                //create a Transaction Object from the line

                //read from csv file and create a Transaction object for each time in the file.


                //"split" the line - every "|" symbol will be a new field on our object
                //linArr = split("")
                //  2024-04-15 0  10:13:25 1   ergonomic keyboard 2   Amazon 3   -89.50 4

                //transaction.setDate(linArr[0])
                //transaction.setTime(linArr[1])


