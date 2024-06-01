package edu.sandiego.cs.comp305.sp24;

import javax.swing.*;

public interface DashboardState {
    void render();
    void clear();
    JPanel getPanel();
}
