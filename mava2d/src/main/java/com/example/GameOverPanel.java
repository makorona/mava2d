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
        this.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black
        
        gameOverLabel = new JLabel("YOU LOST!", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 40));
        gameOverLabel.setForeground(Color.RED);
        gameOverLabel.setBounds(0, screenHeight / 2 - 50, screenWidth, 100);
        
        this.add(gameOverLabel);
        this.setVisible(false);
    }

    public void showGameLoss() {
        System.out.println("🔴 showGameLoss() called!"); // Debugging
        System.out.println("📏 Panel size: " + this.getWidth() + "x" + this.getHeight());
        System.out.println("👀 Visibility before: " + this.isVisible());

        this.setVisible(true);
        this.revalidate();
        this.repaint();
        this.getParent().revalidate();
        this.getParent().repaint();
        System.out.println("👀 Visibility after: " + this.isVisible());
    }

    public void hideGameLoss() {
        System.out.println("🟢 hideGameLoss() called!"); // Debugging
        this.setVisible(false);
        this.revalidate();
        this.repaint();
    }
}