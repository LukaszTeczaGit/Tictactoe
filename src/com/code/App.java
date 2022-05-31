package com.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    JPanel panel1;
    private JButton restartButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JLabel turnLabel;
    private JLabel scoreLabel1;
    Logic logic;
    int xWins, oWins, noGame;

    public App() {
        noGame = 0;
        logic = new Logic();
        panel1.setPreferredSize(new Dimension(1000, 1000));
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton chosen = (JButton) whichButton(e);
                if (chosen != restartButton) {
                    setTurnLabel();
                    if (logic.currentPlayer == -1) {
                        xSetter(chosen);
                    } else if (logic.currentPlayer == 1) {
                        oSetter(chosen);
                    }
                    afterClick(chosen);
                } else if (chosen == restartButton) {
                    resetWholeGame();
                    setTurnLabel();
                }
            }
        };
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);
        button6.addActionListener(listener);
        button7.addActionListener(listener);
        button8.addActionListener(listener);
        button9.addActionListener(listener);
        restartButton.addActionListener(listener);
    }

    public JButton whichButton(ActionEvent e) {
        JButton chosen = (JButton) e.getSource();

        if (chosen == button1) {
            logic.click(0, 0);
            return button1;
        } else if (chosen == button2) {
            logic.click(0, 1);
            return button2;
        } else if (chosen == button3) {
            logic.click(0, 2);
            return button3;
        } else if (chosen == button4) {
            logic.click(1, 0);
            return button4;
        } else if (chosen == button5) {
            logic.click(1, 1);
            return button5;
        } else if (chosen == button6) {
            logic.click(1, 2);
            return button6;
        } else if (chosen == button7) {
            logic.click(2, 0);
            return button7;
        } else if (chosen == button8) {
            logic.click(2, 1);
            return button8;
        } else if (chosen == button9) {
            logic.click(2, 2);
            return button9;
        }
        return restartButton;
    }

    public void oSetter(JButton button) {
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setFont(new Font("Arial", Font.PLAIN, 100));
        button.setText("O");

    }

    public void xSetter(JButton button) {
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setFont(new Font("Arial", Font.PLAIN, 100));
        button.setText("X");

    }

    public void afterClick(JButton button) {
        button.setEnabled(false);
        isEndGame(logic.gameStatus());
    }

    public void isEndGame(int stat) {
        if (stat != 0) {
            logic.playing = false;

            if (stat == 1) {
                JOptionPane.showMessageDialog(panel1, "O WINS!!!");
                oWins++;
            } else if (stat == -1) {
                JOptionPane.showMessageDialog(panel1, "X WINS!!!");
                xWins++;
            } else if (stat == 3) {
                JOptionPane.showMessageDialog(panel1, "DRAW");
            }
            resetGame();
        }
    }

    public void setTurnLabel() {
        String text = "Turn:";
        if (logic.currentPlayer == -1) {
            text += " O";
        } else {
            text += " X";
        }
        turnLabel.setText(text);
    }

    public void resetButtons() {
        button1.setText("");
        button1.setEnabled(true);

        button2.setText("");
        button2.setEnabled(true);

        button3.setText("");
        button3.setEnabled(true);

        button4.setText("");
        button4.setEnabled(true);

        button5.setText("");
        button5.setEnabled(true);

        button6.setText("");
        button6.setEnabled(true);

        button7.setText("");
        button7.setEnabled(true);

        button8.setText("");
        button8.setEnabled(true);

        button9.setText("");
        button9.setEnabled(true);
    }

    public void resetGame() {
        noGame++;
        logic = null;
        logic = new Logic();
        resetButtons();
        setScoreLabel();
        startingPlayer();
    }

    public void setScoreLabel() {
        scoreLabel1.setText("X:  " + xWins + "   O: " + oWins);
    }

    public void startingPlayer() {
        if (noGame % 2 == 0) {
            logic.currentPlayer = 1;
        } else logic.currentPlayer = -1;
    }

    public void resetWholeGame() {
        xWins = 0;
        oWins = 0;
        noGame = 0;
        logic = null;
        logic = new Logic();
        resetButtons();
        setScoreLabel();
        startingPlayer();
    }

}

