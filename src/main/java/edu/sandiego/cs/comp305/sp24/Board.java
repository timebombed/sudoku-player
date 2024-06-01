package edu.sandiego.cs.comp305.sp24;

import java.util.ArrayList;

public class Board implements BoardInterface{
    // grouped as Arraylist<Object> to allow different groups to contain their own instances
    ArrayList<Row> rows = new ArrayList<>();
    ArrayList<Column> columns = new ArrayList<>();
    ArrayList<Block> blocks = new ArrayList<>();

    public int numRows = 9;
    public int numColumns = 9;
    public int numBlocks = 9;
    public int numCellsPerGroup = 9;

    public Board() {
    }

    public void initBoard() {
        // calls each group separately to split logic
        initColumns();
        initRows();
        initBlocks();
    }

    public void initColumns() {
        for (int colIdx = 0; colIdx < numColumns; colIdx++) {
            Column newColumn = new Column();
            for (int cellIdx = 0; cellIdx < numCellsPerGroup; ++cellIdx) {
                // initializes 9 cells to value of 0 as 0 is considered not filled
                newColumn.getCells().add(new Cell());
            }
            columns.add(newColumn);
        }
    }

    public void initRows() {
        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            Row newRow = new Row();
            for (int cellIdx = 0; cellIdx < numCellsPerGroup; ++cellIdx) {
                // initializes 9 cells to value of 0 as 0 is considered not filled
                newRow.getCells().add(new Cell());
            }
            rows.add(newRow);
        }
    }

    public void initBlocks() {
        for (int blockIdx = 0; blockIdx < numBlocks; blockIdx++) {
            Block newBlock = new Block();
            for (int cellIdx = 0; cellIdx < numCellsPerGroup; ++cellIdx) {
                // initializes 9 cells to value of 0 as 0 is considered not filled
                newBlock.getCells().add(new Cell());
            }
            blocks.add(newBlock);
        }
    }

    public void copyBoard(ArrayList<int[]> csvFileArrayList) {
        // calls each group separately as logic between them differs a lot
        copyRows(csvFileArrayList);
        copyColumns(csvFileArrayList);
        copyBlocks(csvFileArrayList);
    }

    public void copyColumns(ArrayList<int[]> csvFileArrayList) {
        // iterates through rows and cells and saves csvFile element to corresponding column
        for (int rowIdx = 0; rowIdx < numColumns; ++rowIdx) {
            for (int colIdx = 0; colIdx < numCellsPerGroup; ++colIdx) {
                int cellValue = csvFileArrayList.get(rowIdx)[colIdx];
                columns.get(colIdx).setCell(rowIdx, cellValue);
            }
        }
    }

    public void copyRows(ArrayList<int[]> csvFileArrayList) {
        // simple nested for loop because csvFile contents are saved as rows
        for (int rowIdx = 0; rowIdx < numRows; ++rowIdx) {
            for (int cellIdx = 0; cellIdx < numCellsPerGroup; ++cellIdx) {
                int cellValue = csvFileArrayList.get(rowIdx)[cellIdx];
                rows.get(rowIdx).setCell(cellIdx, cellValue);
            }
        }
    }

    public void copyBlocks(ArrayList<int[]> csvFileArrayList) {
        int blockIdx = 0;
        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int cellIdx = 0; cellIdx < numCellsPerGroup; cellIdx++) {
                // grabs cellValue as (row, column) because it's the simplest way
                int cellValue = csvFileArrayList.get(rowIdx)[cellIdx];

                // if element is on the left 3 cells, this saves all cells within that block
                if(cellIdx < 3) {
                    if(rowIdx % 3 == 0) {
                        blocks.get(blockIdx).setCell(cellIdx, cellValue);
                    } else if(rowIdx % 3 == 1) {
                        blocks.get(blockIdx).setCell(cellIdx + 3, cellValue);
                    } else {
                        blocks.get(blockIdx).setCell(cellIdx + 6, cellValue);
                    }
                }
                // if element is on the middle 3 cells, this saves all cells within that block
                else if(cellIdx < 6) {
                    if(rowIdx % 3 == 0) {
                        blocks.get(blockIdx + 1).setCell(cellIdx - 3, cellValue);
                    } else if(rowIdx % 3 == 1) {
                        blocks.get(blockIdx + 1).setCell(cellIdx, cellValue);
                    } else {
                        blocks.get(blockIdx + 1).setCell(cellIdx + 3, cellValue);
                    }
                }
                // if element is on the right 3 cells, this saves all cells within that block
                else {
                    if(rowIdx % 3 == 0) {
                        blocks.get(blockIdx + 2).setCell(cellIdx - 6, cellValue);
                    } else if(rowIdx % 3 == 1) {
                        blocks.get(blockIdx + 2).setCell(cellIdx - 3, cellValue);
                    } else {
                        blocks.get(blockIdx+ 2).setCell(cellIdx, cellValue);
                    }
                }
            }
            // iterates to next 3 blocks
            if(rowIdx % 3 == 2) {
                blockIdx = blockIdx + 3;
            }
        }
    }

    public boolean isSolved() {
        for (Row row : rows) {
            for (Cell cell : row.getCells()) {
                // there shouldn't be any 0s in a finished board
                if (cell.getCellValue() == 0)
                    return false;
            }
        }
        // if there are no zeros, that means all numbers entered are valid and board is finished
        return true;
    }

    public void clearBoard() {
        for (int i = 0; i < 9; ++i) {
            for (int cellIdx = 0; cellIdx < numCellsPerGroup; ++cellIdx) {
                // if the user wants to reset the game and play another, this is useful to reset all the values to empty
                rows.get(i).getCells().get(cellIdx).setCellValue(0);
                columns.get(i).getCells().get(cellIdx).setCellValue(0);
                blocks.get(i).getCells().get(cellIdx).setCellValue(0);
            }
        }
    }
}
