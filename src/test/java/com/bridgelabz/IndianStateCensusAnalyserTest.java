package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IndianStateCensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "D:\\GitProgram\\Day29\\src\\main\\resources\\IndianStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "D:\\GitProgram\\Day29\\src\\main\\resources\\IndianStateCensusData.csv";

    private static final String WRONG_CSV_FILE_TYPE_PATH = "D:\\GitProgram\\Day29\\src\\main\\resources\\IndianStateCensusData.csv\\src\\Resource\\IndiaStateCensusData.txt";

    @Test
    public void givenIndianCensusDataCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyzer censusAnalyser = new CensusAnalyzer();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException e) {
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
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndianCensusDataCSVFile_whenWithWrongFileType_shouldThrowException() {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try {
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_TYPE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
    }
}