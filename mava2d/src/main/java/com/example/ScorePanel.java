package com.example;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class ScorePanel extends JPanel {
    private JLabel scoreLabel;

    public ScorePanel() {
        this.setBackground(new Color(30, 30, 30)); // Dark background
        scoreLabel = new JLabel("Points: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setForeground(Color.WHITE);
        
        this.add(scoreLabel);
    }

    public void updateScore(int points) {
        scoreLabel.setText("Points: " + points);
    }
}