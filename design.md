# Our Design
-----------------------------------------------------------------------------------------------------------
- What classes do I need? Would it be helpful to have any interfaces or abstract classes and for what?
  - Interfaces:
    - boardInterface
  - Abstract Classes:
    - board
  - Concrete Classes:
    - row
    - column
    - block
    - cell
    - solver
    - simulator
    - userInterface
-----------------------------------------------------------------------------------------------------------


## boardInterface
- What are the promised actions (methods) of anything that implements this interface?
  - initBoard()
  - createPuzzle()
  - initColumns()
  - initRows()
  - initBlocks()
  - copyColumns()
  - copyRows()
  - copyBlocks()
  - isSolved()
  - clear()
  
- What are the parameters needed?
  - initBoard(String level)
    - String with that indicates whether user wants easy, medium, or hard board
  - createPuzzle(String level)
    - String with that indicates whether user wants easy, medium, or hard board
  - initColumns()
  - initRows()
  - initBlocks()
  - copyColumns(ArrayList<int> columns)
    - List of columns from puzzle to be copied to ArrayList of column instances
  - copyRows(ArrayList<int> rows)
    - List of rows from puzzle to be copied to ArrayList of row instances
  - copyBlocks(ArrayList<int> blocks)
    - List of blocks from puzzle to be copied to ArrayList of block instances
  - isSolved()
  - clear()
  
- What will they return?
  - void initializeBoard()
    - modifies the instance of an empty board
  - int[][] createPuzzle()
    - returns 2d array filled board that will be copied over to board instance
  - void initColumns()
    - instantiates 9 column objects
  - void initRows()
    - instantiates 9 row objects
  - void initBlocks()
    - instantiates 9 block objects
  - void copyColumns()
    - copies puzzle columns to column instances
  - void copyRows()
    - copies puzzle rows to rows instances
  - void copyBlocks()
    - copies puzzle blocks to block instances
  - boolean isSolved()
    - returns true if the board is entirely filled with valid inputs AND therefore solved
    - returns false otherwise
  - void clear()
    - sets all cells of board to null
- Which of these should be concrete and which abstract?
  - abstract isValidInput
  - all other methods will be concrete
-----------------------------------------------------------------------------------------------------------


## board
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - board will implement boardInterface
- What is the information (instance variables) that this class has that will be similar across child classes?
  - rows
  - columns
  - blocks
- What are the types, should they have any default values?
  - ArrayList<row> rows
    - null
  - ArrayList<columns> columns
    - null
  - ArrayList<block> blocks
    - null
- What are the promised actions (methods) for this class?
  - initBoard()
  - createPuzzle()
  - initColumns()
  - initRows()
  - initBlocks()
  - copyColumns()
  - copyRows()
  - copyBlocks()
  - isValidInput()
  - isSolved()
  - clear()
- What are the parameters needed?
  - initBoard(String level)
    - String with that indicates whether user wants easy, medium, or hard board
  - createPuzzle(String level)
    - String with that indicates whether user wants easy, medium, or hard board
  - initColumns()
  - initRows()
  - initBlocks()
  - copyColumns(ArrayList<int> columns)
    - List of columns from puzzle to be copied to ArrayList of column instances
  - copyRows(ArrayList<int> rows)
    - List of rows from puzzle to be copied to ArrayList of row instances
  - copyBlocks(ArrayList<int> blocks)
    - List of blocks from puzzle to be copied to ArrayList of block instances
  - isValidInput(int input)
    - Integer that the user input in specific cell
  - isSolved()
  - clear()
- What will they return?
  - void initializeBoard()
    - modifies the instance of an empty board
  - int[][] createPuzzle()
    - returns 2d array filled board that will be copied over to board instance
  - void initColumns()
    - instantiates 9 column objects
  - void initRows()
    - instantiates 9 row objects
  - void initBlocks()
    - instantiates 9 block objects
  - void copyColumns()
    - copies puzzle columns to column instances
  - void copyRows()
    - copies puzzle rows to rows instances
  - void copyBlocks()
    - copies puzzle blocks to block instances
  - boolean isValidInput()
    - returns true if the input is a valid integer AND it cooperates with board entity
  - boolean isSolved()
    - returns true if the board is entirely filled with valid inputs AND therefore solved
    - returns false otherwise
  - void clear()
    - sets all cells of board to null
- Which of these should be concrete and which abstract?
  - abstract isValidInput()
  - all other methods will be concrete

## row
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - implements boardInterface, extends board
- What is the information (instance variables) that this class has?
  - row
- What are the types?
  - ArrayList<cell> row
- What are the actions (methods) for this class? Which of these methods do other classes need access to?
  - initRow()
  - copyRow()
  - isValidInput()
- What are the parameters needed?
  - initRow()
  - copyRow(int[] puzzleRow)
  - isValidInput(int input)
    - Integer value that the user attempted to input into cell
- What will they return?
  - void initRow()
  - ArrayList<cell> copyRow()
    - returns instance of filled row
  - boolean isValidInput()
    - returns true if the input is a valid integer AND it cooperates with board row

## column
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - implements boardInterface, extends board
- What is the information (instance variables) that this class has?
  - column
- What are the types?
  - ArrayList<cell> column
- What are the actions (methods) for this class? Which of these methods do other classes need access to?
  - initColumn()
  - copyColumn()
  - isValidInput()
- What are the parameters needed?
  - initColumn()
  - copyColumn(int[][] puzzle)
  - isValidInput(int input)
    - Integer value that the user attempted to input into cell
- What will they return?
  - void initColumn()
  - ArrayList<cell> copyColumn()
    - returns instance of filled column
  - boolean isValidInput()
    - returns true if the input is a valid integer AND it cooperates with board column

## block
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - implements boardInterface, extends board
- What is the information (instance variables) that this class has?
  - block
- What are the types?
  - ArrayList<cell> block
- What are the actions (methods) for this class? Which of these methods do other classes need access to?
  - initBlock()
  - copyBlock()
  - isValidInput()
- What are the parameters needed?
  - initBlock()
  - copyBlock(int[] puzzleRow)
  - isValidInput(int input)
    - Integer value that the user attempted to input into cell
- What will they return?
  - void initBlock()
  - ArrayList<cell> copyBlock()
    - returns instance of filled block
  - boolean isValidInput()
    - returns true if the input is a valid integer AND it cooperates with board block

## cell
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - implements boardInterface, extends row, extends column, extends block
- What is the information (instance variables) that this class has?
  - isOccupied
  - value
- What are the types?
  - boolean isOccupied
  - int value
- What are the actions (methods) for this class? Which of these methods do other classes need access to?
- What are the parameters needed?
- What will they return?

## solver
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
- What is the information (instance variables) that this class has?
- What are the types?
- What are the actions (methods) for this class? Which of these methods do other classes need access to?
  - solvePuzzle()
- What are the parameters needed?
  - solvePuzzle(Board board)
- What will they return?
  - Board solvePuzzle()
    - returns solved Puzzle as a Board object

## simulator
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
- What is the information (instance variables) that this class has?
- What are the types?
- What are the actions (methods) for this class? Which of these methods do other classes need access to?
  - main()
  - runSimulation()
- What are the parameters needed?
  - main(String[] args)
    - String of command line args
  - runSimulation()
- What will they return?
  - void main()
  - void runSimulation()

## userInterface
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
- What is the information (instance variables) that this class has?
  - frame
  - panel
  - buttons
- What are the types?
  - JFrame frame
  - JPanel panel
  - JButton button
- What are the actions (methods) for this class? Which of these methods do other classes need access to?
  - initUI()
- What are the parameters needed?
  - initUI()
- What will they return?
  - void initUI()
-----------------------------------------------------------------------------------------------------------
  

## initBoard()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check there is an empty board object

## createPuzzle()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check the puzzle is a 9x9 2d int array
  - test2: check the puzzle is non-empty
  - test3: check the puzzle has removed the correct amount of cells

## initColumns()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check there are 9 arraylists of column objects

## initRows()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check there are 9 arraylists of row objects

## initBlocks()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check there are 9 arraylists of block objects
  
## copyColumns()
- What are your test cases that you need and what inputs and outputs will you test for each?

## copyRows()
- What are your test cases that you need and what inputs and outputs will you test for each?

## copyBlocks()
- What are your test cases that you need and what inputs and outputs will you test for each?

## isValidInput()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: invalid row input
    - expect false
  - test2: valid row input
    - expect true
  - test3: invalid column input
    - expect false
  - test4: valid column input
    - expect true
  - test5: invalid block input
    - expect false
  - test6: valid block input
    - expect true

## isSolved()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: unfinished board
    - expect false
  - test2: finished but incorrectly solved board
    - expect false
  - test3: finished and correctly solved board
    - expect true

## clear()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check the board object still exists
  - test2: check the board still has instance of arraylist of rows
  - test3: check the board still has instance of arraylist of columns
  - test4: check the board still has instance of arraylist of blocks
  - test2: check the cells in each row are set to 0
  - test3: check the cells in each column are set to 0
  - test4: check the cells in each block are set to 0
## initColumn()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check there is an arraylist of cell objects
  - test2: check the cells are set to 0

## initRow()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check there is an arraylist of cell objects
  - test2: check the cells are set to 0

## initBlock()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check there is an arraylist of cell objects
  - test2: check the cells are set to 0

## copyColumn()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check the cells of the column match the values of the corresponding column

## copyRow()
- What are your test cases that you need and what inputs and outputs will you test for each?
  - test1: check the cells of the row match the values of the corresponding row

## copyBlock()
- test1: check the cells of the block match the values of the corresponding block

## solvePuzzle()
- test1: check the puzzle's rows, cols, and blocks are valid, meaning the puzzle has been solved

## initUI()
- test1: check the frame is displayed correctly
- test2: check the panels are displayed correctly
- test3: check the buttons are displayed correctly
- test4: check the buttons work as intended
-----------------------------------------------------------------------------------------------------------