package edu.sandiego.cs.comp305.sp24;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SimulatorTest {

    String fileName = "src/main/test/resources/testSudoku.csv";
    ArrayList<String> testFileContents = new ArrayList<String>() {{
        add("1 2 3");
        add("4 5 6");
        add("7 8 9");
    }};

    int[] row1 = {1, 2, 3};

    int[] row2 = {4, 5, 6};

    int[] row3 = {7, 8, 9};


    @Test
    void readFileTest() throws Exception {
        // check that file contents are correctly saved as arraylist of strings
        ArrayList<String> fileContents = Simulator.readFile(fileName);
        assertEquals(fileContents, testFileContents);
    }

    @Test
    void parseFileTest() {
        // checks that parsedFile rows correctly match row inputs
        ArrayList<int[]> testParsedFile = new ArrayList<>();

        testParsedFile.add(row1);
        testParsedFile.add(row2);
        testParsedFile.add(row3);

        ArrayList<int[]> parsedFile = new ArrayList<>();
        parsedFile = Simulator.parseFile(testFileContents);
        assertArrayEquals(testParsedFile.get(0), parsedFile.get(0));
        assertArrayEquals(testParsedFile.get(1), parsedFile.get(1));
        assertArrayEquals(testParsedFile.get(2), parsedFile.get(2));
    }


}