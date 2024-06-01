package edu.sandiego.cs.comp305.sp24;

import java.util.ArrayList;

public class Cell extends Board{
    private int cellValue;

    public Cell() {
        this.cellValue = 0;
    }

    public Cell(int value) {
        this.cellValue = value;
    }

    public int getCellValue() {
        // returns cell's value, not cell object
        return this.cellValue;
    }

    public void setCellValue(int value) {
        // sets cell's value, not cell object
        this.cellValue = value;
    }
}
