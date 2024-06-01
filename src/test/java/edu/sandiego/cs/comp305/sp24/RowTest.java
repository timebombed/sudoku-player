package edu.sandiego.cs.comp305.sp24;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {
    int[] rowArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    @Test
    void getCellsTestNotNull() {
        // checks that 9 cell objects exist
        Row testRow = new Row();
        for (int i = 0; i < 9; ++i) {
            Cell cell = new Cell(i);
            testRow.getCells().add(cell);
        }
        assertNotNull(testRow.getCells());
    }

    @Test
    void getCellTestCheckValuesMatch() {
        // checks getCell returns correct cell
        Row testRow = new Row();
        for (int i = 1; i < 10; ++i) {
            Cell cell = new Cell(i);
            testRow.getCells().add(cell);
        }
        int cellIdx = 0;
        for (Cell cell : testRow.getCells()) {
            assertEquals(cell.getCellValue(), rowArray[cellIdx++]);
        }
    }

    @Test
    void setCellCheckCellValueMatches() {
        // checks setCell actually changes cell value
        Row testRow = new Row();
        testRow.getCells().add(new Cell());
        testRow.setCell(0, 3);
        assertEquals(testRow.getCell(0).getCellValue(), 3);
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
    void isValidInputRowTest2CorrectInputTrue() {
        // one instance of each digit
        int[] arrayRow = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Row testRow = new Row();
        for (int cell : arrayRow) {
            testRow.getCells().add(new Cell(cell));
        }
        assertTrue(testRow.isValidInput());
    }

    @Test
    void IsValidInputRowTest3DuplicateInputFalse() {
        // duplicate input, invalid
        int[] arrayRow = { 1, 2, 3, 4, 5, 6, 7, 9, 9 };
        Row testRow = new Row();
        for (int cell : arrayRow) {
            testRow.getCells().add(new Cell(cell));
        }
        assertFalse(testRow.isValidInput());
    }
}