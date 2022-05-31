package com.code;

import javax.swing.*;

public class GameWindow {
    GameWindow(){
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
