package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.rules.ExpectedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IndianStateCensusAnalyserTest {
    
    private static final String INDIA_CENSUS_CSV_FILE_PATH= "D:\\GitProgram\\Day29\\src\\main\\resources\\IndianStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH= "D:\\GitProgram\\Day2\\src\\main\\resources\\IndianStateCensusData.csv";

    @Test
    public void givenIndianCensusDataCSVFileReturnsCorrectRecords()
    {
        try
        {
            CensusAnalyzer censusAnalyser = new CensusAnalyzer();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            assertEquals(29,numOfRecords);
        }
        catch (CensusAnalyserException e) {
            System.out.println("File not found");
        }
    }
    @Test
    public void givenIndianCensusDataCSVFile_whenWithWrongPath_shouldThrowException() {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();

        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try {
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

}

