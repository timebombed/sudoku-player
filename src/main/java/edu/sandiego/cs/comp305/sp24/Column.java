package edu.sandiego.cs.comp305.sp24;

import java.util.ArrayList;
import java.util.Arrays;

public class Column extends Board{
    private ArrayList<Cell> cells = new ArrayList<>();

    public Column() {
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public Cell getCell(int index) {
        return this.cells.get(index);
    }

    public void setCell(int index, int value) {
        this.cells.get(index).setCellValue(value);
    }

    public boolean isValidInput() {
        // checks whether column's values occur more than once and whether they're between 1 and 9
        // it was easiest to use a separate boolean array to track whether a value has already occurred
        Boolean[] numIsPresent = new Boolean[9];
        Arrays.fill(numIsPresent, false);
        for (Cell cell : this.getCells()) {
            int value = cell.getCellValue();
            // 9999 represents blank cell
            if (value == 9999)
                continue;
            if (value < 1 || value > 9)
                return false;
            if (numIsPresent[value - 1])
                return false;
            numIsPresent[value - 1] = true;
        }
        return true;
    }
}
