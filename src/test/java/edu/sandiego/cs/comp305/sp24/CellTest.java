package edu.sandiego.cs.comp305.sp24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void getCellValueTest() {
        Cell cell = new Cell(5);
        assertEquals(cell.getCellValue(), 5);
    }

    @Test
    void setCell() {
        Cell cell = new Cell();
        cell.setCellValue(4);
        assertEquals(cell.getCellValue(), 4);
    }
}