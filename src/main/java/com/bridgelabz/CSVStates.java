package com.bridgelabz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

import com.opencsv.CSVReader;

public class CSVStates {
    static String CVSfile = "D:\GitProgram\Day29\src\main\resources\IndianStateCode.csve.csv";
    static int count = 0;

    public static void getDataFromCSVfile(String fileURl) {
        try {
            Reader r = new BufferedReader(new FileReader(fileURl));
            @SuppressWarnings("resource")
            CSVReader c = new CSVReader(r);

            String[] records;
            CSVStateCensus obj = new CSVStateCensus();
            while ((records = c.readNext()) != null) {
                count++;
                obj.setSno(Integer.parseInt(records[0]));
                obj.setName(records[1]);
                obj.setCode(records[2]);
                System.out.println("Name: " + obj.getName());
            }

        } catch (Exception e) {
            try {
                throw new InvalidException();
            } catch (InvalidException E) {
                E.toString();
            }

        }
    }

    public static void main(String[] args) {
        getDataFromCSVfile(CVSfile);
    }
}

