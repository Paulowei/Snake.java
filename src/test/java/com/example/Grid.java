package com.example;
import java.util.Scanner; 
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
import java.util.Random;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Label;

public class Grid extends JPanel{
    public static final Integer LENGTH=16;
    public static final Integer WIDTH=16;
    public static final Integer HGAP=25 ;
    public static final Integer VGAP = 25;
    public static Color foreColor;
    public static Color backColor;
    public Snake snake = new Snake();
    public Food food = new Food(); 
    public Label label = new Label();
    //public Grid(Snake sn1){
    //    //Jpanel panel = new Jpanel();
    //    super(new GridLayout(WIDTH,LENGTH,10,10));
    //    this.add(sn1,GridLayout.CENTER);
    //    this.add(new Food(),GridLayout.CENTER);
    //}
    public Grid(){
        super();
        BufferedImage image = new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB); 
        Graphics g=image.getGraphics();
        //this.add(new Snake());
        //this.add(snake);
        //snake.paint(g);
        String str = new String("Score: ").concat((snake.score).toString());
        //g.drawString(str,350,0);
        label.setText(str);
        label.setLocation(new Point(160,160));
        label.setBounds(new Rectangle(380,10,100,80));
        add(label,0);
        this.paint(g);
    }
    public static void spawn(){

    }
    //public void update(Snake sn1, Food food){
    //    Food fd1 = new Food();
    //    fd1.spawn();
    //    sn1.grow();
    //    this.add(fd1);
    //    this.add(sn1);
    //}
    //public static void adjust(){
    //    
   // }
    @Override 
    public void paint(Graphics g){
        //g=this.getParent().getGraphics();
        foreColor = new Color(192,192,192);
        this.setForeground(foreColor);
        for(int i = 0;i<WIDTH;i++){
            for(int j = 0;j<LENGTH;j++){
                if((i+j)%2==0){
                    backColor = new Color(0,50,50);
                    g.setColor(backColor);
                    g.drawRect(HGAP*i,VGAP*j,HGAP,VGAP);
                    g.fillRect(HGAP*i,VGAP*j,HGAP,VGAP);
                    //this.add(new Snake(),BorderLayout.CENTER,0);
                }
                if((i+j)%2==1){
                    backColor = new Color(50,50,0);
                    g.setColor(backColor);
                    g.drawRect(HGAP*i,VGAP*j,HGAP,VGAP);
                    g.fillRect(HGAP*i,VGAP*j,HGAP,VGAP);
                }
            //g.drawRect(i,j,Grid.HGAP,Grid.VGAP);
            }
        }
        if(g.getColor()!=snake.color){
            g.setColor(snake.color);
        }
        snake.paint(g);
        food.posY=1;
        food.paint(g);
        //layeredPane.setLayer(label,JLayeredPane.MODAL_LAYER,0);
        ///ayeredPane.add(label,0);
    }
    @Override
    public void update(Graphics g){
        //this.paint(g);
        snake.update(g);
        //food.update(g);
        if(snake.position[0]==food.posX&&snake.position[1]==food.posY){
            food.update(g);
        }
    }
    
}
