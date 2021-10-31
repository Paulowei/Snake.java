package com.example;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.example.Snake;
public class KeyList extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            Snake.direction[0]=0;
            Snake.direction[1]=-1;
            break;
            case KeyEvent.VK_DOWN:
            Snake.direction[0]=0;
            Snake.direction[1]=1;
            break;
            case KeyEvent.VK_LEFT:
            Snake.direction[0]=-1;
            Snake.direction[1]=0;
            break;
            case KeyEvent.VK_RIGHT:
            Snake.direction[0]=1;
            Snake.direction[1]=0;
            break;
            default:
            break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
        System.out.println(e.getKeyCode());
    } 
    @Override
     public void keyReleased(KeyEvent e){
        System.out.println(e.getKeyCode());
    }
}
