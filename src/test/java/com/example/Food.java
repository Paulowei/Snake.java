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
import java.awt.Component;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Graphics;



 public class Food extends Component{
    //public Integer[][] foodPos = new Integer[posY][posX];
    public Integer posY=8;
    public Integer posX=8;
    public Integer[][] foodPos = new Integer[posY][posX];
    public static Random rand = new Random();
    public static Integer score = 0;
    public Color color;
    public boolean isAlive;
    public static int currentPosX;
    public static int currentPosY;
    public static int[] currentPos=new int[]{currentPosX,currentPosY};
    public Food(){
        super();
        this.setVisible(true);
        this.setName(score.toString());
        this.color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        this.setForeground(this.color);
        this.setSize(new Dimension(1,1));
        KeyAdapter listener = new KeyList();
        //Dimension D1 = new Dimension(rand.nextInt(Grid.WIDTH),rand.nexInt(Grid.LENGTH);
        //this.setLocation(D1);
        this.addKeyListener(listener);
        this.spawn();
        //this.disappear();
    }
    public void spawn(){
        this.posY = rand.nextInt(Grid.WIDTH+1)*Grid.HGAP;
        this.posX= rand.nextInt(Grid.LENGTH+1)*Grid.VGAP;
        this.color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        score++;
        //this.setLocation(new Point(this.posY,this.posX));
        Food.currentPosX= this.posX;
        Food.currentPosY= this.posY;
    }
    public void dissappear(Graphics g){
        this.getParent().remove(this);
        }
    //@Override
    public void paint(Graphics g){
        //Food fd1 = new Food();
        //this.spawn();
        this.color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        g.setColor(this.color);
        g.drawRect(this.posX,this.posY,Grid.HGAP,Grid.VGAP);
        g.fillRect(this.posX,this.posY,Grid.HGAP,Grid.VGAP);
    }
    @Override
    public  void update(Graphics g1){
        this.spawn();
        Graphics g2 = g1.create();
        this.color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        g1.setColor(this.color);
        if(this.isAlive==false){
            g1.dispose();
        }
        //this.spawn();
        this.paint(g2);
    }
}
