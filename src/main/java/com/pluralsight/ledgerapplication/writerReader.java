package com.pluralsight.ledgerapplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class writerReader {
    public static void main(String[] args) {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("transactions.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedReader bufReader = new BufferedReader(fileReader);

    }



ArrayList<String[]> data = new ArrayList<>();
}
