package edu.sandiego.cs.comp305.sp24;

import java.util.ArrayList;

public interface BoardInterface {
    public void initBoard();
    public void initColumns();
    public void initRows();
    public void initBlocks();
    public void copyColumns(ArrayList<int[]> csvFile);
    public void copyRows(ArrayList<int[]> csvFile);
    public void copyBlocks(ArrayList<int[]> csvFile);
    public boolean isSolved();
    public void clearBoard();
}
