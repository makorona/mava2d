package com.example;

import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    Random random = new Random();

    // Screen settings
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;
    int points = 0;
    Color bgColor = new Color(5, 50, 32);

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Player attributes
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    int enemyX = 300;
    int enemyY = 300;
    int enemySpeed = 3;

    // Target position
    int targetX;
    int targetY;

    ScorePanel scorePanel; // Reference to Score Panel

    public GamePanel(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(bgColor);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        generateNewTarget();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        if(!isGameOver){ 
            if(keyH.up && playerY > 0) {
            playerY -= playerSpeed;
        } 
        if (keyH.down && playerY < screenHeight - tileSize) {
            playerY += playerSpeed;
        } 
        if (keyH.left && playerX > 0) {
            playerX -= playerSpeed;
        } 
        if (keyH.right && playerX < screenWidth - tileSize) {
            playerX += playerSpeed;
        }
        checkTargetCollision();
        checkEnemyCollision();
        }
        if(keyH.restart){
            restartGame();
        }
        enemyMovement();
    }

    private void restartGame(){
        points = 0;
        playerX = 100;
        playerY = 100;

        enemyX = 400;
        enemyY = 400;
        generateNewTarget();
        isGameOver = false;
    }

    public void enemyMovement(){
        if (random.nextBoolean()) {
            if (enemyX < playerX) enemyX += enemySpeed;
            else if (enemyX > playerX) enemyX -= enemySpeed;
        } else {
            if (enemyY < playerY) enemyY += enemySpeed;
            else if (enemyY > playerY) enemyY -= enemySpeed;
        }
    }

    private void checkTargetCollision() {
        if (playerX < targetX + originalTileSize && playerX + tileSize > targetX &&
            playerY < targetY + originalTileSize && playerY + tileSize > targetY) {
            
            generateNewTarget();
            points++;

            // Update score panel label
            scorePanel.updateScore(points);
            System.out.println("Points: " + points);
        }
    }

    private void checkEnemyCollision(){
        if (playerX < enemyX + tileSize && playerX + tileSize > enemyX &&
            playerY < enemyX + tileSize && playerY + tileSize > enemyY){
                isGameOver = true;
            }
    }

    boolean isGameOver = false;

    private void generateNewTarget() {
        targetX = random.nextInt(screenWidth - originalTileSize);
        targetY = random.nextInt(screenHeight - originalTileSize);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw player
        g2.setColor(Color.WHITE);
        g2.fillRect(playerX, playerY, tileSize, tileSize);

        // Draw target
        g2.setColor(Color.CYAN);
        g2.fillRect(targetX, targetY, originalTileSize, originalTileSize);

        g2.setColor(Color.RED);
        g2.fillRect(enemyX, enemyY, tileSize, tileSize);

        

        g2.dispose();
    }
}