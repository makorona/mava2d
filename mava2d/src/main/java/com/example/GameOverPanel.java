package com.example;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class GameOverPanel extends JPanel {
    private JLabel gameOverLabel;

    public GameOverPanel(int screenWidth, int screenHeight) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent background

        gameOverLabel = new JLabel("YOU LOST!", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 40));
        gameOverLabel.setForeground(Color.RED);
        gameOverLabel.setBounds(0, screenHeight / 2 - 50, screenWidth, 100);
        this.add(gameOverLabel);
        
        this.setVisible(false); // Initially hidden
    }

    public void showGameLoss() {
        this.setVisible(true);
    }

    public void hideGameLoss() {
        this.setVisible(false);
    }
}