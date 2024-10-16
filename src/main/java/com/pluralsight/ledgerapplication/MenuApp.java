package com.pluralsight.ledgerapplication;
import java.io.*;
import java.util.Scanner;

public class MenuApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

    while(isRunning){
        System.out.println("""
                Welcome to the Transactions Home Screen!
                
                Please choose one of the following:
                
                D. Add deposit
                
                P. Make Payment
                
                L. Ledger
                
                X. Exit
                """);
        String userInput = scanner.nextLine();

        switch(userInput){
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
        }
        }

    }
}
