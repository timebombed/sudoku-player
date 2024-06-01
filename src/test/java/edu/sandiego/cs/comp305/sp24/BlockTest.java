package edu.sandiego.cs.comp305.sp24;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {
    int[] blockArray = { 1, 2, 3,
                         4, 5, 6,
                         7, 8, 9 };

    @Test
    void getCellsTestNotNull() {
        // checks that 9 cell objects exist
        Block testBlock = new Block();
        for (int i = 0; i < 9; ++i) {
            Cell cell = new Cell(i);
            testBlock.getCells().add(cell);
        }
        assertNotNull(testBlock.getCells());
    }

    @Test
    void getCellTestCheckValuesMatch() {
        // checks getCell returns correct cell
        Block testBlock = new Block();
        for (int i = 1; i < 10; ++i) {
            Cell cell = new Cell(i);
            testBlock.getCells().add(cell);
        }
        int cellIdx = 0;
        for (Cell cell : testBlock.getCells()) {
            assertEquals(cell.getCellValue(), blockArray[cellIdx++]);
        }
    }

    @Test
    void setCellTestCheckCellValueMatches() {
        // checks setCell actually changes cell value
        Block testBlock = new Block();
        testBlock.getCells().add(new Cell());
        testBlock.setCell(0, 3);
        assertEquals(testBlock.getCell(0).getCellValue(), 3);
    }

    @Test
    void isValidInputBlockTest1NegativeInputFalse() {
        // input out of bounds of 1-9
        int[] arrayBlock = { 1, 2, 3,
                             4, 5, 6,
                             7, 8, -1 };
        Block testBlock = new Block();
        for (int cell : arrayBlock) {
            testBlock.getCells().add(new Cell(cell));
        }
        assertFalse(testBlock.isValidInput());
    }

    @Test
    void isValidInputBlockTest2CorrectInputTrue() {
        // one instance of each digit
        int[] arrayBlock = { 1, 2, 3,
                             4, 5, 6,
                             7, 8, 9 };
        Block testBlock = new Block();
        for (int cell : arrayBlock) {
            testBlock.getCells().add(new Cell(cell));
        }
        assertTrue(testBlock.isValidInput());
    }

    @Test
    void IsValidInputBlockTest3CorrectInputFalse() {
        // duplicate input, invalid
        int[] arrayBlock = { 1, 2, 3,
                             4, 5, 6,
                             7, 9, 9 };
        Block testBlock = new Block();
        for (int cell : arrayBlock) {
            testBlock.getCells().add(new Cell(cell));
        }
        assertFalse(testBlock.isValidInput());
    }
}