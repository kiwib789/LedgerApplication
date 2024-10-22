package com.pluralsight.ledgerapplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Transaction {

    //fields aka variables - they hold the data for the class

    private LocalTime time;
    private LocalDate date;
    private double amount;
    private String vendor;
    private String description;


    //constructors - allow us to create instances of our class
    //when we create an instance of the class then we've created an object

    public Transaction(){

    }

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.time = time;
        this.date = date;
        this.amount = amount;
        this.vendor = vendor;
        this.description = description;
    }


    public LocalTime getTime() {
        return time;
    }


    public LocalDate getDate() {
        return date;
    }


    public double getAmount() {
        return amount;
    }


    public String getVendor() {
        return vendor;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "time=" + time +
                ", date=" + date +
                ", amount=" + amount +
                ", vendor='" + vendor + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}







