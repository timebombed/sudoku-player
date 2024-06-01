package edu.sandiego.cs.comp305.sp24;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ColumnTest {
    int[] columnArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    @Test
    void getCellsTestNotNull() {
        // checks that 9 cell objects exist
        Column testColumn = new Column();
        for (int i = 0; i < 9; ++i) {
            Cell cell = new Cell(i);
            testColumn.getCells().add(cell);
        }
        assertNotNull(testColumn.getCells());
    }

    @Test
    void getCellTestCheckValuesMatch() {
        // checks getCell returns correct cell
        Column testColumn = new Column();
        for (int i = 1; i < 10; ++i) {
            Cell cell = new Cell(i);
            testColumn.getCells().add(cell);
        }
        int cellIdx = 0;
        for (Cell cell : testColumn.getCells()) {
            assertEquals(cell.getCellValue(), columnArray[cellIdx++]);
        }
    }

    @Test
    void setCellTestCheckCellValueMatches() {
        // checks setCell actually changes cell value
        Column testColumn = new Column();
        testColumn.getCells().add(new Cell());
        testColumn.setCell(0, 3);
        assertEquals(testColumn.getCell(0).getCellValue(), 3);
    }

    @Test
    void isValidInputColumnTest1NegativeInputFalse() {
        // input out of bounds of 1-9
        int[] arrayColumn = { 1, 2, 3, 4, 5, 6, 7, 8, -1 };
        Column testColumn = new Column();
        for (int cell : arrayColumn) {
            testColumn.getCells().add(new Cell(cell));
        }
        assertFalse(testColumn.isValidInput());
    }

    @Test
    void isValidInputColumnTest2CorrectInputTrue() {
        // one instance of each digit
        int[] arrayColumn = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Column testColumn = new Column();
        for (int cell : arrayColumn) {
            testColumn.getCells().add(new Cell(cell));
        }
        assertTrue(testColumn.isValidInput());
    }

    @Test
    void IsValidInputColumnTest3DuplicateInputFalse() {
        // duplicate input, invalid
        int[] arrayColumn = { 1, 2, 3, 4, 5, 6, 7, 9, 9 };
        Column testColumn = new Column();
        for (int cell : arrayColumn) {
            testColumn.getCells().add(new Cell(cell));
        }
        assertFalse(testColumn.isValidInput());
    }
}