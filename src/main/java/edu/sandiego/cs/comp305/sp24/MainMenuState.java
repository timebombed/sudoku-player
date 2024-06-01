package edu.sandiego.cs.comp305.sp24;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuState extends JFrame implements DashboardState {
    private JButton mainMenuStartButton;
    private JPanel mainMenuPanel;
    private JLabel mainMenuTitle;
    private JFrame mainMenuFrame;
    private JLabel mainMenuSubtitle;

    public MainMenuState(){
        mainMenuStartButton = new JButton("Start");
        mainMenuTitle = new JLabel("Sudoku");
        mainMenuPanel = new JPanel();
        mainMenuFrame = new JFrame("Sudoku");
        mainMenuSubtitle = new JLabel("Press here to play Sudoku!");


        this.setLayout(null);
        setSize(1080,1080);
        mainMenuPanel.setLayout(null);

        mainMenuTitle.setBounds(380, 230, 400, 80);
        mainMenuStartButton.setBounds(90, 380, 900, 80);
        mainMenuSubtitle.setBounds(440, 310, 500 , 40);

        mainMenuTitle.setFont(new Font("Arial", Font.BOLD, 86));
        mainMenuSubtitle.setFont(new Font("Arial", Font.ITALIC, 16));
        mainMenuStartButton.setFont(new Font("Arial", Font.BOLD, 24));

        mainMenuTitle.setForeground(Color.BLACK);
        mainMenuPanel.setBackground(Color.WHITE);
        mainMenuStartButton.setBackground(Color.CYAN);

        mainMenuStartButton.setFocusPainted(false);

        mainMenuPanel.add(mainMenuStartButton);
        mainMenuPanel.add(mainMenuTitle);
        mainMenuPanel.add(mainMenuSubtitle);

        add(mainMenuPanel);


        mainMenuStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Simulator.applicationWindow.changeState(Simulator.applicationWindow.difficultyWindow);
            }
        });
    }

    public JPanel getPanel(){
        return mainMenuPanel;
    }
    public void render(){
        setContentPane(mainMenuPanel);
        setTitle("Main Menu");
        mainMenuPanel.add(mainMenuStartButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080, 1080);
        setVisible(true);
    }

    public void clear(){
        dispose();
    }
}
