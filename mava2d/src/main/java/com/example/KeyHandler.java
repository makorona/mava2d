package com.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean up, down, left, right, restart;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            up = true;

        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            down = true;
            
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            left = true;
            
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            right = true;
            
        }
        if(code == KeyEvent.VK_R){
            restart = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

    if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
        up = false;
    }
    if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
        down = false;
    }
    if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
        left = false;
    }
    if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
        right = false;
    }
    if (code == KeyEvent.VK_R){
        restart = false;
    }
    }

    
}
