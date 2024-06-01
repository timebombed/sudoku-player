package edu.sandiego.cs.comp305.sp24;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class Dashboard {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton changeStateButton;
    NullDashBoardState nullDashBoardWindow = new NullDashBoardState();
    MainMenuState mainMenuWindow = new MainMenuState();
    SudokuBoardState sudokuBoardWindow = new SudokuBoardState();
    DifficultyState difficultyWindow = new DifficultyState();
    private DashboardState dashboardState = nullDashBoardWindow;

    public Dashboard(){
    }

    public void changeState(DashboardState state){
        dashboardState.clear();
        dashboardState = state;
        state.render();
        mainPanel = state.getPanel();
        // if conditions to set changeStateButton = to the changeStateButton in specific state
    }

    public JFrame getMainFrame(){
        return mainFrame;
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public JButton getChangeStateButton(){
        return changeStateButton;
    }
}
