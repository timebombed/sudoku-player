package edu.sandiego.cs.comp305.sp24;

import javax.swing.*;

public class NullDashBoardState extends JFrame implements DashboardState{
    public NullDashBoardState(){}
    public JPanel getPanel(){
        return null;
    }
    @Override
    public void render() {}
    @Override
    public void clear() {}
}
