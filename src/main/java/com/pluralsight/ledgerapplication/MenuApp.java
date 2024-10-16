package com.pluralsight.ledgerapplication;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MenuApp {

    public static void main(String[] args) {
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
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "D":
                    // runs add deposit class
                    return;
                case "P":
                    // runs make payment class
                    return;
                case "L":
                    // runs ledger class
                    return;

                case "X":
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

    private static void writeToFile(Transaction transaction) {
        //this logic can always be the same because the result will always be the same
        //adding a new line to the csv file
    }


    // you may need multiple methods to ready from the file..  mainly for the ledger menu
    private static List<Transaction> readAllFromFile() {

        List<Transaction> result = new ArrayList<>();

        try {
            FileReader filereader = new FileReader("transactions.csv");

            BufferedReader bufReader = new BufferedReader(filereader);

            String input;

            while ((input = bufReader.readLine()) != null) {
                System.out.println(input);
            }
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
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


