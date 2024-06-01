package edu.sandiego.cs.comp305.sp24;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

public class SudokuBoardState extends JFrame implements DashboardState{
    private JPanel sudokuBoardPanel;
    // Row 1 cells
    private JTextArea cell1_1 = new JTextArea();
    private JTextArea cell1_2 = new JTextArea();
    private JTextArea cell1_3 = new JTextArea();
    private JTextArea cell1_4 = new JTextArea();
    private JTextArea cell1_5 = new JTextArea();
    private JTextArea cell1_6 = new JTextArea();
    private JTextArea cell1_7 = new JTextArea();
    private JTextArea cell1_8 = new JTextArea();
    private JTextArea cell1_9 = new JTextArea();
    // Row 2 cells
    private JTextArea cell2_1 = new JTextArea();
    private JTextArea cell2_2 = new JTextArea();
    private JTextArea cell2_3 = new JTextArea();
    private JTextArea cell2_4 = new JTextArea();
    private JTextArea cell2_5 = new JTextArea();
    private JTextArea cell2_6 = new JTextArea();
    private JTextArea cell2_7 = new JTextArea();
    private JTextArea cell2_8 = new JTextArea();
    private JTextArea cell2_9 = new JTextArea();
    // Row 3 cells
    private JTextArea cell3_1 = new JTextArea();
    private JTextArea cell3_2 = new JTextArea();
    private JTextArea cell3_3 = new JTextArea();
    private JTextArea cell3_4 = new JTextArea();
    private JTextArea cell3_5 = new JTextArea();
    private JTextArea cell3_6 = new JTextArea();
    private JTextArea cell3_7 = new JTextArea();
    private JTextArea cell3_8 = new JTextArea();
    private JTextArea cell3_9 = new JTextArea();
    // Row 4 cells
    private JTextArea cell4_1 = new JTextArea();
    private JTextArea cell4_2 = new JTextArea();
    private JTextArea cell4_3 = new JTextArea();
    private JTextArea cell4_4 = new JTextArea();
    private JTextArea cell4_5 = new JTextArea();
    private JTextArea cell4_6 = new JTextArea();
    private JTextArea cell4_7 = new JTextArea();
    private JTextArea cell4_8 = new JTextArea();
    private JTextArea cell4_9 = new JTextArea();
    // Row 5 cells
    private JTextArea cell5_1 = new JTextArea();
    private JTextArea cell5_2 = new JTextArea();
    private JTextArea cell5_3 = new JTextArea();
    private JTextArea cell5_4 = new JTextArea();
    private JTextArea cell5_5 = new JTextArea();
    private JTextArea cell5_6 = new JTextArea();
    private JTextArea cell5_7 = new JTextArea();
    private JTextArea cell5_8 = new JTextArea();
    private JTextArea cell5_9 = new JTextArea();
    // Row 6 cells
    private JTextArea cell6_1 = new JTextArea();
    private JTextArea cell6_2 = new JTextArea();
    private JTextArea cell6_3 = new JTextArea();
    private JTextArea cell6_4 = new JTextArea();
    private JTextArea cell6_5 = new JTextArea();
    private JTextArea cell6_6 = new JTextArea();
    private JTextArea cell6_7 = new JTextArea();
    private JTextArea cell6_8 = new JTextArea();
    private JTextArea cell6_9 = new JTextArea();
    // Row 7 cells
    private JTextArea cell7_1 = new JTextArea();
    private JTextArea cell7_2 = new JTextArea();
    private JTextArea cell7_3 = new JTextArea();
    private JTextArea cell7_4 = new JTextArea();
    private JTextArea cell7_5 = new JTextArea();
    private JTextArea cell7_6 = new JTextArea();
    private JTextArea cell7_7 = new JTextArea();
    private JTextArea cell7_8 = new JTextArea();
    private JTextArea cell7_9 = new JTextArea();
    // Row 8 cells
    private JTextArea cell8_1 = new JTextArea();
    private JTextArea cell8_2 = new JTextArea();
    private JTextArea cell8_3 = new JTextArea();
    private JTextArea cell8_4 = new JTextArea();
    private JTextArea cell8_5 = new JTextArea();
    private JTextArea cell8_6 = new JTextArea();
    private JTextArea cell8_7 = new JTextArea();
    private JTextArea cell8_8 = new JTextArea();
    private JTextArea cell8_9 = new JTextArea();
    // Row 9 cells
    private JTextArea cell9_1 = new JTextArea();
    private JButton solveButton = new JButton("Check");
    private JButton returnMainMenuButton = new JButton("Main Menu");
    private JButton clearBoardButton = new JButton("Clear");
    private JTextArea cell9_2 = new JTextArea();
    private JTextArea cell9_3 = new JTextArea();
    private JTextArea cell9_4 = new JTextArea();
    private JTextArea cell9_5 = new JTextArea();
    private JTextArea cell9_6 = new JTextArea();
    private JTextArea cell9_7 = new JTextArea();
    private JTextArea cell9_8 = new JTextArea();
    private JTextArea cell9_9 = new JTextArea();
    private JPanel sudokuGridPanel_1 = new JPanel(new GridLayout(3,3));
    private JPanel sudokuGridPanel_3 = new JPanel(new GridLayout(3,3));
    private JPanel sudokuGridPanel_2 = new JPanel(new GridLayout(3, 3));
    private JPanel sudokuGridPanel_4 = new JPanel(new GridLayout(3,3));
    private JPanel sudokuGridPanel_5 = new JPanel(new GridLayout(3,3));
    private JPanel sudokuGridPanel_6 = new JPanel(new GridLayout(3,3));
    private JPanel sudokuGridPanel_7 = new JPanel(new GridLayout(3,3));
    private JPanel sudokuGridPanel_8 = new JPanel(new GridLayout(3,3));
    private JPanel sudokuGridPanel_9 = new JPanel(new GridLayout(3,3));
    private JLabel resultLabel = new JLabel();
    public ArrayList<JTextArea[]> textAreaBoard = new ArrayList<>();
    public ArrayList<int[]> intTextAreaBoard = new ArrayList<>();
    private boolean foundInvalidInput;
    private boolean whitespaceInCells;
    private JPanel buttonPanel = new JPanel();

    public SudokuBoardState() {
        // Initialize textAreaBoard to use as a comparison of the user inputs to the solution board.
        for (int i=0; i<9; i++) {
            JTextArea[] row = new JTextArea[9];
            textAreaBoard.add(row);
        }
        // Assign textArea row 1
        textAreaBoard.get(0)[0] = cell1_1;
        textAreaBoard.get(0)[1] = cell1_2;
        textAreaBoard.get(0)[2] = cell1_3;
        textAreaBoard.get(0)[3] = cell1_4;
        textAreaBoard.get(0)[4] = cell1_5;
        textAreaBoard.get(0)[5] = cell1_6;
        textAreaBoard.get(0)[6] = cell1_7;
        textAreaBoard.get(0)[7] = cell1_8;
        textAreaBoard.get(0)[8] = cell1_9;
        // Assign textArea row 2
        textAreaBoard.get(1)[0] = cell2_1;
        textAreaBoard.get(1)[1] = cell2_2;
        textAreaBoard.get(1)[2] = cell2_3;
        textAreaBoard.get(1)[3] = cell2_4;
        textAreaBoard.get(1)[4] = cell2_5;
        textAreaBoard.get(1)[5] = cell2_6;
        textAreaBoard.get(1)[6] = cell2_7;
        textAreaBoard.get(1)[7] = cell2_8;
        textAreaBoard.get(1)[8] = cell2_9;
        // Assign textArea row 3
        textAreaBoard.get(2)[0] = cell3_1;
        textAreaBoard.get(2)[1] = cell3_2;
        textAreaBoard.get(2)[2] = cell3_3;
        textAreaBoard.get(2)[3] = cell3_4;
        textAreaBoard.get(2)[4] = cell3_5;
        textAreaBoard.get(2)[5] = cell3_6;
        textAreaBoard.get(2)[6] = cell3_7;
        textAreaBoard.get(2)[7] = cell3_8;
        textAreaBoard.get(2)[8] = cell3_9;
        // Assign textArea row 4
        textAreaBoard.get(3)[0] = cell4_1;
        textAreaBoard.get(3)[1] = cell4_2;
        textAreaBoard.get(3)[2] = cell4_3;
        textAreaBoard.get(3)[3] = cell4_4;
        textAreaBoard.get(3)[4] = cell4_5;
        textAreaBoard.get(3)[5] = cell4_6;
        textAreaBoard.get(3)[6] = cell4_7;
        textAreaBoard.get(3)[7] = cell4_8;
        textAreaBoard.get(3)[8] = cell4_9;
        // Assign textArea row 5
        textAreaBoard.get(4)[0] = cell5_1;
        textAreaBoard.get(4)[1] = cell5_2;
        textAreaBoard.get(4)[2] = cell5_3;
        textAreaBoard.get(4)[3] = cell5_4;
        textAreaBoard.get(4)[4] = cell5_5;
        textAreaBoard.get(4)[5] = cell5_6;
        textAreaBoard.get(4)[6] = cell5_7;
        textAreaBoard.get(4)[7] = cell5_8;
        textAreaBoard.get(4)[8] = cell5_9;
        // Assign textArea row 6
        textAreaBoard.get(5)[0] = cell6_1;
        textAreaBoard.get(5)[1] = cell6_2;
        textAreaBoard.get(5)[2] = cell6_3;
        textAreaBoard.get(5)[3] = cell6_4;
        textAreaBoard.get(5)[4] = cell6_5;
        textAreaBoard.get(5)[5] = cell6_6;
        textAreaBoard.get(5)[6] = cell6_7;
        textAreaBoard.get(5)[7] = cell6_8;
        textAreaBoard.get(5)[8] = cell6_9;
        // Assign textArea row 7
        textAreaBoard.get(6)[0] = cell7_1;
        textAreaBoard.get(6)[1] = cell7_2;
        textAreaBoard.get(6)[2] = cell7_3;
        textAreaBoard.get(6)[3] = cell7_4;
        textAreaBoard.get(6)[4] = cell7_5;
        textAreaBoard.get(6)[5] = cell7_6;
        textAreaBoard.get(6)[6] = cell7_7;
        textAreaBoard.get(6)[7] = cell7_8;
        textAreaBoard.get(6)[8] = cell7_9;
        // Assign textArea row 8
        textAreaBoard.get(7)[0] = cell8_1;
        textAreaBoard.get(7)[1] = cell8_2;
        textAreaBoard.get(7)[2] = cell8_3;
        textAreaBoard.get(7)[3] = cell8_4;
        textAreaBoard.get(7)[4] = cell8_5;
        textAreaBoard.get(7)[5] = cell8_6;
        textAreaBoard.get(7)[6] = cell8_7;
        textAreaBoard.get(7)[7] = cell8_8;
        textAreaBoard.get(7)[8] = cell8_9;
        // Assign textArea row 9
        textAreaBoard.get(8)[0] = cell9_1;
        textAreaBoard.get(8)[1] = cell9_2;
        textAreaBoard.get(8)[2] = cell9_3;
        textAreaBoard.get(8)[3] = cell9_4;
        textAreaBoard.get(8)[4] = cell9_5;
        textAreaBoard.get(8)[5] = cell9_6;
        textAreaBoard.get(8)[6] = cell9_7;
        textAreaBoard.get(8)[7] = cell9_8;
        textAreaBoard.get(8)[8] = cell9_9;

        setSize(1080, 1080);
        // setup sudoku grid
        setLayout(null);
        add(sudokuGridPanel_1);
        add(sudokuGridPanel_2);
        add(sudokuGridPanel_3);
        add(sudokuGridPanel_4);
        add(sudokuGridPanel_5);
        add(sudokuGridPanel_6);
        add(sudokuGridPanel_7);
        add(sudokuGridPanel_8);
        add(sudokuGridPanel_9);

        sudokuGridPanel_1.setBounds(165, 0, 200, 200);
        sudokuGridPanel_1.add(cell1_1);
        sudokuGridPanel_1.add(cell1_2);
        sudokuGridPanel_1.add(cell1_3);
        sudokuGridPanel_1.add(cell2_1);
        sudokuGridPanel_1.add(cell2_2);
        sudokuGridPanel_1.add(cell2_3);
        sudokuGridPanel_1.add(cell3_1);
        sudokuGridPanel_1.add(cell3_2);
        sudokuGridPanel_1.add(cell3_3);

        sudokuGridPanel_2.setBounds(365, 0, 200, 200);
        sudokuGridPanel_2.add(cell1_4);
        sudokuGridPanel_2.add(cell1_5);
        sudokuGridPanel_2.add(cell1_6);
        sudokuGridPanel_2.add(cell2_4);
        sudokuGridPanel_2.add(cell2_5);
        sudokuGridPanel_2.add(cell2_6);
        sudokuGridPanel_2.add(cell3_4);
        sudokuGridPanel_2.add(cell3_5);
        sudokuGridPanel_2.add(cell3_6);

        sudokuGridPanel_3.setBounds(565, 0, 200, 200);
        sudokuGridPanel_3.add(cell1_7);
        sudokuGridPanel_3.add(cell1_8);
        sudokuGridPanel_3.add(cell1_9);
        sudokuGridPanel_3.add(cell2_7);
        sudokuGridPanel_3.add(cell2_8);
        sudokuGridPanel_3.add(cell2_9);
        sudokuGridPanel_3.add(cell3_7);
        sudokuGridPanel_3.add(cell3_8);
        sudokuGridPanel_3.add(cell3_9);

        sudokuGridPanel_4.setBounds(165, 200, 200, 200);
        sudokuGridPanel_4.add(cell4_1);
        sudokuGridPanel_4.add(cell4_2);
        sudokuGridPanel_4.add(cell4_3);
        sudokuGridPanel_4.add(cell5_1);
        sudokuGridPanel_4.add(cell5_2);
        sudokuGridPanel_4.add(cell5_3);
        sudokuGridPanel_4.add(cell6_1);
        sudokuGridPanel_4.add(cell6_2);
        sudokuGridPanel_4.add(cell6_3);

        sudokuGridPanel_5.setBounds(365, 200, 200, 200);
        sudokuGridPanel_5.add(cell4_4);
        sudokuGridPanel_5.add(cell4_5);
        sudokuGridPanel_5.add(cell4_6);
        sudokuGridPanel_5.add(cell5_4);
        sudokuGridPanel_5.add(cell5_5);
        sudokuGridPanel_5.add(cell5_6);
        sudokuGridPanel_5.add(cell6_4);
        sudokuGridPanel_5.add(cell6_5);
        sudokuGridPanel_5.add(cell6_6);

        sudokuGridPanel_6.setBounds(565, 200, 200, 200);
        sudokuGridPanel_6.add(cell4_7);
        sudokuGridPanel_6.add(cell4_8);
        sudokuGridPanel_6.add(cell4_9);
        sudokuGridPanel_6.add(cell5_7);
        sudokuGridPanel_6.add(cell5_8);
        sudokuGridPanel_6.add(cell5_9);
        sudokuGridPanel_6.add(cell6_7);
        sudokuGridPanel_6.add(cell6_8);
        sudokuGridPanel_6.add(cell6_9);

        sudokuGridPanel_7.setBounds(165, 400, 200, 200);
        sudokuGridPanel_7.add(cell7_1);
        sudokuGridPanel_7.add(cell7_2);
        sudokuGridPanel_7.add(cell7_3);
        sudokuGridPanel_7.add(cell8_1);
        sudokuGridPanel_7.add(cell8_2);
        sudokuGridPanel_7.add(cell8_3);
        sudokuGridPanel_7.add(cell9_1);
        sudokuGridPanel_7.add(cell9_2);
        sudokuGridPanel_7.add(cell9_3);

        sudokuGridPanel_8.setBounds(365, 400, 200, 200);
        sudokuGridPanel_8.add(cell7_4);
        sudokuGridPanel_8.add(cell7_5);
        sudokuGridPanel_8.add(cell7_6);
        sudokuGridPanel_8.add(cell8_4);
        sudokuGridPanel_8.add(cell8_5);
        sudokuGridPanel_8.add(cell8_6);
        sudokuGridPanel_8.add(cell9_4);
        sudokuGridPanel_8.add(cell9_5);
        sudokuGridPanel_8.add(cell9_6);

        sudokuGridPanel_9.setBounds(565, 400, 200, 200);
        sudokuGridPanel_9.add(cell7_7);
        sudokuGridPanel_9.add(cell7_8);
        sudokuGridPanel_9.add(cell7_9);
        sudokuGridPanel_9.add(cell8_7);
        sudokuGridPanel_9.add(cell8_8);
        sudokuGridPanel_9.add(cell8_9);
        sudokuGridPanel_9.add(cell9_7);
        sudokuGridPanel_9.add(cell9_8);
        sudokuGridPanel_9.add(cell9_9);

        for (JTextArea[] row : textAreaBoard){
            for (JTextArea cellTextArea : row){
                cellTextArea.setSize(66,66);
                cellTextArea.setFont(new Font("Arial", Font.PLAIN, 50));
            }
        }

        // Initialize button
        buttonPanel.setBackground(Color.cyan);
        buttonPanel.setVisible(true);
        buttonPanel.setBounds(0, 760, 1080, 300);
        add(buttonPanel, BorderLayout.SOUTH);


        resultLabel.setBounds(350, 760, 400, 150);
        returnMainMenuButton.setBounds(90,965,280, 60);
        clearBoardButton.setBounds(400,965,280,60);
        solveButton.setBounds(710,965,280,60);

        resultLabel.setFont(new Font("Arial", Font.BOLD, 36));
        returnMainMenuButton.setFont(new Font("Arial", Font.ITALIC, 24));
        clearBoardButton.setFont(new Font("Arial", Font.ITALIC, 24));
        solveButton.setFont(new Font("Arial", Font.ITALIC, 24));

        returnMainMenuButton.setBackground(Color.CYAN);
        clearBoardButton.setBackground(Color.CYAN);
        solveButton.setBackground(Color.CYAN);

        returnMainMenuButton.setFocusPainted(false);
        clearBoardButton.setFocusPainted(false);
        solveButton.setFocusPainted(false);

        buttonPanel.add(resultLabel);
        buttonPanel.add(returnMainMenuButton);
        buttonPanel.add(clearBoardButton);
        buttonPanel.add(solveButton);

        // Create a timer to make the resultLabel disappear after 3 seconds
        Timer threeSecondTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                resultLabel.setVisible(false); // Hide the label
            }
        });

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Simulator.userInputBoard = new Board();
                Simulator.userInputBoard.initBoard();
                foundInvalidInput = false;
                whitespaceInCells = false;
                intTextAreaBoard.clear();
                /*Converting textAreaBoard from an ArrayList<JTextArea[]> to ArrayList<int[]> so that it can
                be checked for validInputs in userInputBoard
                 */
                for (int i=0; i<9; i++){
                    int[] row = new int[9];
                    intTextAreaBoard.add(row);
                }
                for (int i=0;i<9;i++){
                    for (int j=0;j<9;j++){
                        try {
                            if (textAreaBoard.get(i)[j].getText().isBlank()){
                                whitespaceInCells = true;
                                intTextAreaBoard.get(i)[j] = 9999;
                            }
                            else{
                                intTextAreaBoard.get(i)[j] = Integer.parseInt(textAreaBoard.get(i)[j].getText());
                            }
                        }
                        catch (NumberFormatException invalidInputException) {
                            resultLabel.setText("Invalid symbol in a cell");
                            resultLabel.setVisible(true);
                            threeSecondTimer.setRepeats(false);
                            threeSecondTimer.start();
                            return;
                        }
                        catch (Exception invalidInputException){
                            resultLabel.setText("An error occurred");
                            resultLabel.setVisible(true);
                            threeSecondTimer.setRepeats(false);
                            threeSecondTimer.start();
                            return;
                        }
                    }
                }

                // Add values to userInputBoard
                Simulator.userInputBoard.copyBoard(intTextAreaBoard);

                // Check if board is valid when unfinished
                if (whitespaceInCells) {
                    // Checks each row, block, column if there are invalid inputs
                    // Checks each row, block, column if there are invalid inputs
                    for (Row row: Simulator.userInputBoard.rows){
                        if (!row.isValidInput()){
                            resultLabel.setText("Invalid row input");
                            resultLabel.setVisible(true);
                            foundInvalidInput = true;
                            threeSecondTimer.setRepeats(false);
                            threeSecondTimer.start();
                        }
                    }
                    for (Column column: Simulator.userInputBoard.columns){
                        if (!column.isValidInput()){

                            resultLabel.setText("Invalid column input");
                            resultLabel.setVisible(true);
                            foundInvalidInput = true;
                            threeSecondTimer.setRepeats(false);
                            threeSecondTimer.start();
                        }
                    }
                    for (Block block: Simulator.userInputBoard.blocks){
                        if (!block.isValidInput()){
                            resultLabel.setText("Invalid block input");
                            resultLabel.setVisible(true);
                            foundInvalidInput = true;
                            threeSecondTimer.setRepeats(false);
                            threeSecondTimer.start();
                        }
                    }
                    if (!foundInvalidInput){
                        resultLabel.setText("Board is valid");
                        resultLabel.setVisible(true);
                        threeSecondTimer.setRepeats(false);
                        threeSecondTimer.start();
                    }
                }

                // Checks each row, block, column if there are invalid inputs
                for (Row row: Simulator.userInputBoard.rows){
                    if (!row.isValidInput()){
                        resultLabel.setText("Invalid row input");
                        resultLabel.setVisible(true);
                        foundInvalidInput = true;
                        threeSecondTimer.setRepeats(false);
                        threeSecondTimer.start();
                    }
                }
                for (Column column: Simulator.userInputBoard.columns){
                    if (!column.isValidInput()){

                        resultLabel.setText("Invalid column input");
                        resultLabel.setVisible(true);
                        foundInvalidInput = true;
                        threeSecondTimer.setRepeats(false);
                        threeSecondTimer.start();
                    }
                }
                for (Block block: Simulator.userInputBoard.blocks){
                    if (!block.isValidInput()){
                        resultLabel.setText("Invalid block input");
                        resultLabel.setVisible(true);
                        foundInvalidInput = true;
                        threeSecondTimer.setRepeats(false);
                        threeSecondTimer.start();
                    }
                }

                // Correct solution
                if (!foundInvalidInput && !whitespaceInCells){
                    resultLabel.setText("Board is solved!");
                    resultLabel.setVisible(true);
                    threeSecondTimer.setRepeats(false);
                    threeSecondTimer.start();
                }
            }
        });
        returnMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Simulator.applicationWindow.changeState(Simulator.applicationWindow.mainMenuWindow);
            }
        });
        clearBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 9; i++) {
                    for(int j = 0; j < 9; j++) {
                        if (textAreaBoard.get(i)[j].isEditable()){
                            textAreaBoard.get(i)[j].setText("");
                        }
                    }
                }

            }
        });
    }

    public void render(){
        setTitle("Sudoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080, 1080);
        setVisible(true);
        resultLabel.setVisible(false);
        // read selected csv file and parse the csv file into ArrayList<int[]>
        /* for loop to iterate through ArrayList<int[]> and make cell non-editable if there's
        a number or make cell editable and blank if its null/0
         */
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++){
                if (Simulator.parsedFile.get(i)[j] == 0){
                    textAreaBoard.get(i)[j].setText("");
                    textAreaBoard.get(i)[j].setEditable(true);
                    textAreaBoard.get(i)[j].setBackground(Color.white);
                }
                else {
                    textAreaBoard.get(i)[j].setText(String.valueOf(Simulator.parsedFile.get(i)[j]));
                    textAreaBoard.get(i)[j].setEditable(false);
                    textAreaBoard.get(i)[j].setBackground(Color.gray);
                }
            }
        }

    }
    public void clear(){

        dispose();
    }
    public JPanel getPanel(){
        return sudokuBoardPanel;
    }

}
