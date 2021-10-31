package com.example;
import javax.swing.JPanel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.Date;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.*;
import java.io.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Random;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;
import javax.swing.JRootPane;
import javax.swing.JLayeredPane;
import java.awt.FileDialog;
import javax.swing.JFileChooser;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Label;
import java.util.Arrays;
public class Game extends JFrame implements KeyListener{
    public Snake snake= new Snake();
    public Grid grid= new Grid();
    public Food food= new Food();
    //public Graphics f = new JFrame().getGraphics();
    BufferedImage image = new BufferedImage(50,50,BufferedImage.TYPE_INT_RGB);
    public Graphics g = image.getGraphics();
    public JPanel panel = new JPanel();
    JLayeredPane layeredPane = new JLayeredPane();
    Label label = new Label();
    public Game(LayoutManager manager){
        super();
        this.setLayout(manager);
    }
    public JPanel pane = new JPanel();
    public Game(){
        //this(new BorderLayout());
        super();
        this.setFocusTraversalPolicyProvider(true);
        //grid.snake=snake;
        try{
        this.frameInit();
        //g = this.getGraphics();
        panel.setLayout(new GridLayout());
        panel.add(snake);
        panel.add(food);
        pane.setLayout(new GridLayout());
        snake.paint(g);
        pane.add(grid);
        this.setLocationRelativeTo(null);
        setVisible(true);
        processWindowEvent(new WindowEvent(this,WindowEvent.WINDOW_ACTIVATED));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        setAutoRequestFocus(true);
        setPreferredSize(new Dimension(200,200));
        setEnabled(true);
        setBounds(100, 100, 400, 400);
        setLayout(new GridLayout());
        layeredPane.setLayout(new BorderLayout());
        layeredPane.setLayer(grid,JLayeredPane.MODAL_LAYER,1);
        layeredPane.setLayer(snake,JLayeredPane.MODAL_LAYER,2);
        layeredPane.add(grid,1);
        grid.paint(g);
        snake.paint(g);
        snake.validate();
        snake.repaint();
        if(layeredPane.isVisible()==false){
            layeredPane.setVisible(true);
        }
        layeredPane.setBounds(new Rectangle(0,0,100,100));
        layeredPane.setFocusCycleRoot(true);
        layeredPane.setVisible(true);
        this.setLayeredPane((layeredPane));
        g=this.getGraphics();
        g.drawString("FUN",100,100);
        String str = new String("Score: ").concat((grid.snake.score).toString());
        this.addKeyListener(new KeyList());
        }catch(IllegalArgumentException|NullPointerException e){
            e.printStackTrace();
        }
    }
    public void spawn(){

    }
    public void run(){

    }
    @Override
    public void update(Graphics f){
        while(true){
        layeredPane.update(f);
        String str = new String("Score: ").concat((grid.snake.score).toString());
        layeredPane.repaint();
        grid.update(f);
        f.drawString(str,150,150);
        System.out.println(Arrays.deepToString(grid.snake.var1));
        }
    }
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            grid.snake.direction[0]=0;
            grid.snake.direction[1]=-1;
            break;
            case KeyEvent.VK_DOWN:
            grid.snake.direction[0]=0;
            grid.snake.direction[1]=1;
            break;
            case KeyEvent.VK_LEFT:
            grid.snake.direction[0]=-1;
            grid.snake.direction[1]=0;
            break;
            case KeyEvent.VK_RIGHT:
            grid.snake.direction[0]=1;
            grid.snake.direction[1]=0;
            break;
            default:
            break;
        }
    }
    public void keyTyped(KeyEvent e){
        System.out.println(e.getKeyCode());
    } 
    //@Override
     public void keyReleased(KeyEvent e){
        System.out.println(e.getKeyCode());
    }
    //public static void main(Sting[] args){
    //    //Game game  = new Game = Game(new Grid(new Snake))
     //   Game game = new Game(new Grid());
    //    while(true){
    //        game.update();
    //    }
    //}

}