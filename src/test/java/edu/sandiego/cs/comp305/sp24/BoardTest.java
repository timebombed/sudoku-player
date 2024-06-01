package edu.sandiego.cs.comp305.sp24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board testBoard;
    @BeforeEach
    void createBoard(){
        testBoard = new Board();
    }
    @Test
    void initBoard() {
        testBoard.initBoard();
        // Check that board is right size
        assertEquals(9, testBoard.rows.size());
        assertEquals(9, testBoard.columns.size());
        assertEquals(9, testBoard.blocks.size());

        // Check that board is filled with 0s
        for (Row row : testBoard.rows) {
            for (Cell cell : row.getCells()) {
                assertEquals(0, cell.getCellValue());
            }
        }
        // Check that board is filled with 0s
        for (Column column : testBoard.columns) {
            for (Cell cell : column.getCells()) {
                assertEquals(0, cell.getCellValue());
            }
        }
        // Check that board is filled with 0s
        for (Block block : testBoard.blocks) {
            for (Cell cell : block.getCells()) {
                assertEquals(0, cell.getCellValue());
            }
        }
    }

    @Test
    void initColumns() {
        testBoard.initColumns();
        // Check that columns are right size
        for (Column column : testBoard.columns) {
            assertEquals(9, column.getCells().size());
        }

        // Check that columns are filled with 0s
        for (Column column : testBoard.columns){
            for (int i=0; i < column.getCells().size(); i++){
                assertEquals(0, column.getCell(i).getCellValue());
            }
        }
    }

    @Test
    void initRows() {
        Board testBoard = new Board();
        testBoard.initRows();
        for (Row row : testBoard.rows) {
            assertEquals(9, row.getCells().size());
        }

        for (Row row : testBoard.rows) {
            for (Cell cell : row.getCells()) {
                assertEquals(0, cell.getCellValue());
            }
        }
    }

    @Test
    void initBlocks() {
        testBoard.initBlocks();
        // Check that blocks are right size
        for (Block block : testBoard.blocks) {
            assertEquals(9, block.getCells().size());
        }

        // Check that blocks are filled with 0s
        for (Block block : testBoard.blocks){
            for (int i=0; i < block.getCells().size(); i++){
                assertEquals(0, block.getCell(i).getCellValue());
            }
        }
    }

    @Test
    void copyColumns() {
        Board testBoard = new Board();
        testBoard.initColumns();

        ArrayList<int[]> testColumns = new ArrayList<>();
        int[] testColumn = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 9; i++)
            testColumns.add(testColumn);

        testBoard.copyColumns(testColumns);
        for (int colIdx = 0; colIdx < 9; colIdx++) {
            for (int cellIdx = 0; cellIdx < 9; cellIdx++) {
                assertEquals(testBoard.columns.get(colIdx).getCell(cellIdx).getCellValue(),
                        testColumns.get(cellIdx)[colIdx]);
            }
        }
    }

    @Test
    void copyRows() {
        Board testBoard = new Board();
        testBoard.initRows();

        ArrayList<int[]> testRows = new ArrayList<>();
        int[] testRow = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 9; i++)
            testRows.add(testRow);

        testBoard.copyRows(testRows);
        for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
            for (int cellIdx = 0; cellIdx < 9; cellIdx++) {
                assertEquals(testBoard.rows.get(rowIdx).getCell(cellIdx).getCellValue(),
                        testRows.get(rowIdx)[cellIdx]);
            }
        }
    }

    @Test
    void copyBlocks() {
        Board testBoard = new Board();
        testBoard.initBlocks();

        ArrayList<int[]> testRows = new ArrayList<>();
        int[] testRow = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] correctBlock1 = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        int[] correctBlock2 = {4, 5, 6, 4, 5, 6, 4, 5, 6};
        int[] correctBlock3 = {7, 8, 9, 7, 8, 9, 7, 8, 9};
        ArrayList<int[]> correctArray = new ArrayList<>();

        for(int j = 0; j < 3; j++) {
            correctArray.add(correctBlock1);
            correctArray.add(correctBlock2);
            correctArray.add(correctBlock3);
        }

        for (int i = 0; i < 9; i++) {
            testRows.add(testRow);
        }

        testBoard.copyBlocks(testRows);
        for (int blockIdx = 0; blockIdx < 9; blockIdx++) {
            for (int cellIdx = 0; cellIdx < 9; cellIdx++) {
                System.out.println(testBoard.blocks.get(blockIdx).getCell(cellIdx).getCellValue());
                assertEquals(testBoard.blocks.get(blockIdx).getCell(cellIdx).getCellValue(), correctArray.get(blockIdx)[cellIdx]);

            }
        }
    }

    @Test
    void isSolved() {
        Board testBoard = new Board();
        testBoard.initBoard();
        ArrayList<int[]> rows = new ArrayList<>();
        int[][] testBoardValues = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        for (int[] row : testBoardValues) {
            rows.add(row);
        }

        testBoard.copyRows(rows);
        assertTrue(testBoard.isSolved());
    }

    @Test
    void clearBoard() {
        Board testBoard1 = new Board();
        testBoard1.initBoard();
        for (int i = 0; i < 9; ++i) {
            for (int cellIdx = 0; cellIdx < testBoard1.numCellsPerGroup; ++cellIdx) {
                testBoard1.rows.get(i).getCells().get(cellIdx).setCellValue(0);
                testBoard1.columns.get(i).getCells().get(cellIdx).setCellValue(0);
                testBoard1.blocks.get(i).getCells().get(cellIdx).setCellValue(0);
            }
        }
        testBoard1.clearBoard();
        for (int i = 0; i < 9; ++i) {
            for (int cellIdx = 0; cellIdx < testBoard1.numCellsPerGroup; ++cellIdx) {
                assertEquals(0, testBoard1.rows.get(i).getCells().get(cellIdx).getCellValue());
                assertEquals(0, testBoard1.columns.get(i).getCells().get(cellIdx).getCellValue());
                assertEquals(0, testBoard1.blocks.get(i).getCells().get(cellIdx).getCellValue());
            }
        }
    }
}