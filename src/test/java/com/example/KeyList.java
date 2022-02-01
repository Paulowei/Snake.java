package com.example;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.example.Snake;
public class KeyList extends KeyAdapter{
    @Override
    public Snake snake;
    public KeyList(Snake sn1){
        this.snake = sn1;
    }
    public void keyPressed(KeyEvent e){
        //System.out.println(e.getKeyCode());
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            this.snake.direction[0]=0;
            this.snake.direction[1]=-1;
            break;
            case KeyEvent.VK_DOWN:
            this.snake.direction[0]=0;
            this.snake.direction[1]=1;
            break;
            case KeyEvent.VK_LEFT:
            this.snake.direction[0]=-1;
            this.snake.direction[1]=0;
            break;
            case KeyEvent.VK_RIGHT:
            this.snake.direction[0]=1;
            this.snake.direction[1]=0;
            break;
            default:
            break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){
        //System.out.println(e.getKeyCode());
    } 
    @Override
     public void keyReleased(KeyEvent e){
        //System.out.println(e.getKeyCode());
    }
}
