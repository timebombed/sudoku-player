package edu.sandiego.cs.comp305.sp24;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class DifficultyState extends JFrame implements DashboardState {
    private JButton hardDifficultyButton;
    private JButton mediumDifficultyButton;
    private JButton easyDifficultyButton;
    private JLabel difficultyStateTitle;
    private JPanel difficultyPanel;

    public DifficultyState() {
        easyDifficultyButton = new JButton("Easy");
        mediumDifficultyButton = new JButton("Medium");
        hardDifficultyButton = new JButton("Hard");
        difficultyPanel = new JPanel();
        difficultyStateTitle = new JLabel("Select your difficulty!");

        this.setLayout(null);
        setSize(1080,1080);
        difficultyPanel.setLayout(null);

        difficultyStateTitle.setBounds(320,270,800,80);
        easyDifficultyButton.setBounds(90, 380, 280, 80);
        mediumDifficultyButton.setBounds(400, 380, 280, 80);
        hardDifficultyButton.setBounds(710, 380, 280, 80);

        difficultyStateTitle.setFont(new Font("Arial", Font.BOLD, 44));
        easyDifficultyButton.setFont(new Font("Arial", Font.ITALIC, 24));
        mediumDifficultyButton.setFont(new Font("Arial", Font.ITALIC, 24));
        hardDifficultyButton.setFont(new Font("Arial", Font.ITALIC, 24));

        difficultyPanel.setBackground(Color.WHITE);
        easyDifficultyButton.setBackground(Color.CYAN);
        mediumDifficultyButton.setBackground(Color.CYAN);
        hardDifficultyButton.setBackground(Color.CYAN);

        easyDifficultyButton.setFocusPainted(false);
        mediumDifficultyButton.setFocusPainted(false);
        hardDifficultyButton.setFocusPainted(false);

        difficultyPanel.add(difficultyStateTitle);
        difficultyPanel.add(easyDifficultyButton);
        difficultyPanel.add(mediumDifficultyButton);
        difficultyPanel.add(hardDifficultyButton);

        add(difficultyPanel);


        easyDifficultyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // simulator.pickBoard randomly out of easy boards
                try {
                    String csvBoard = String.valueOf(Simulator.pickBoard("easy"));

                    ArrayList<String> fileContents = Simulator.readFile(csvBoard);
                    Simulator.parsedFile = Simulator.parseFile(fileContents);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                Simulator.applicationWindow.changeState(Simulator.applicationWindow.sudokuBoardWindow);
            }
        });
        mediumDifficultyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // simulator.pickBoard randomly out of medium boards
                try {
                    String csvBoard = String.valueOf(Simulator.pickBoard("medium"));

                    ArrayList<String> fileContents = Simulator.readFile(csvBoard);
                    Simulator.parsedFile = Simulator.parseFile(fileContents);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                Simulator.applicationWindow.changeState(Simulator.applicationWindow.sudokuBoardWindow);
            }
        });
        hardDifficultyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // simulator.pickBoard randomly out of hard boards
                try {
                    String csvBoard = String.valueOf(Simulator.pickBoard("hard"));

                    ArrayList<String> fileContents = Simulator.readFile(csvBoard);
                    Simulator.parsedFile = Simulator.parseFile(fileContents);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                Simulator.applicationWindow.changeState(Simulator.applicationWindow.sudokuBoardWindow);
            }
        });
    }

    public JPanel getPanel(){
        return difficultyPanel;
    }
    public void render(){
        setContentPane(difficultyPanel);
        setTitle("Difficulty Selection");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080, 1080);
        setVisible(true);
    }
    public void clear(){
        dispose();
    }
}
