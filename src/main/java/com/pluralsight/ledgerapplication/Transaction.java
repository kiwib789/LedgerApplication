package com.pluralsight.ledgerapplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Transaction extends ArrayList<Transaction> {

    //fields aka variables - they hold the data for the class

    LocalTime time;
    static LocalDate date;
    double amount;
    static String vendor;
    String description;


    //constructors - allow us to create instances of our class
    //when we create an instance of the class then we've created an object

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

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public static LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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







