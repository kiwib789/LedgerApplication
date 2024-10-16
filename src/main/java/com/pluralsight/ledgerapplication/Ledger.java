package com.pluralsight.ledgerapplication;

import java.util.ArrayList;
import java.util.List;

public class Ledger {

    public List<Transaction> transactions;

    public Ledger(){
        transactions = new ArrayList<>();
    }

    //might need a method to read from the file and populate this arraylist with the trascations

    public void populateTransactionArray(){
        //read from csv file and create a Transaction object for each time in the file.


        //"split" the line - every "|" symbol will be a new field on our object
        //linArr = split("")
      //  2024-04-15 0  10:13:25 1   ergonomic keyboard 2   Amazon 3   -89.50 4

        //transaction.setDate(linArr[0])
        //transaction.setTime(linArr[1])
    }


    //view all transactions

    //view deposits

    //view payments

    //reports

}
