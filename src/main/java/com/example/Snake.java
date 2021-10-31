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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.awt.Component;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.util.Random;
import java.util.Arrays;
public class Snake extends Component implements KeyListener{
    public int posX=0;
    public int posY=0;
    public Integer[] position= new Integer[]{posX,posY};
    public int length=3;
    public int velocity=1;
    //private Date datetime;
    public Color color;
    public Date date;
    public Integer score = 0;
    //public Integer[][] foodPos;
    public final int MAXLENGTH= Grid.LENGTH;
    public static Integer[] direction = new Integer[]{1,0};
    public static Integer[] DIRECTION = new Integer[]{1,-1};
    public Integer[][] var1 = new Integer[length+1][2];
   //Grid grid = new Grid();
    public boolean isAlive;
    Random rand = new Random();
    public Snake(){
        super();
        this.spawn();
        this.transverse();
        this.live();
        //this.paint();
        //this.update()
        //this.Respawn();
        //this.paint(Graphics.create());
        //this.update();
    }

    public synchronized void transverse(){
        try{
        this.position[0]+=(direction[0]*this.velocity*Grid.VGAP);
        Thread.sleep(50);
        this.position[1]+=(direction[1]*this.velocity*Grid.HGAP);
        Thread.sleep(50);
        if(this.posX==Food.currentPosX&&this.posY==Food.currentPosY&&this.length<Grid.LENGTH){
            grow();
        }
           for(int i=0;i<length;i++){
             //   for(int j=0;j<2;j++){
                //Thread.sleep(200);
                var1[i][0]=position[0]-i*direction[0]*Grid.HGAP;
                var1[i][1]=position[1]-i*direction[1]*Grid.VGAP;
                //Thread.sleep(200);
               // }
            }
        
    }catch(InterruptedException E){
        E.printStackTrace();
    }
    }
    public synchronized void spawn(){

    }
    public synchronized void live(){
        this.position[0]+=direction[0]*this.velocity;
        this.position[1]+=direction[1]*this.velocity;
    }
    public synchronized void respawn(){
        this.position[0]=8;
        this.position[1]=8;
        this.velocity = 1;
    }
    public Integer[] getPos(){
        return this.position;
    }
    public int getLength(){
        return this.length;
    }
    public int getVelocity(){
        return this.velocity;
    }
    public Color getColor(){
        return this.color;
    }
    public synchronized void impose(){

    }
    public void grow(){
        this.length++;
        this.score++;
        
    }
    public void eat(){
        if(this.posX==Food.currentPosX&&this.posY==Food.currentPosY&&this.length<Grid.LENGTH){
            grow();
        }
    }
    public void paint(Graphics g){
        //g=this.getParent().getGraphics();
        //var1.add()
        this.color = new  Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        g.setColor(this.color);
        for(int i=0;i<length;i++){
            g.fillRect(var1[i][1]+i*direction[0]*Grid.HGAP,
            position[1]+i*direction[1]*Grid.VGAP,Grid.HGAP,Grid.VGAP);
            g.drawRect(var1[i][0]+i*direction[0]*Grid.HGAP,
            this.position[1]+i*direction[1]*Grid.VGAP,Grid.HGAP,Grid.VGAP);
            //g.drawLine()
        }
        //g.fillRect(this.position[0],this.position[1],Grid.HGAP,;Grid.VGAP);
    }
    public void update(Graphics g1){
        this.transverse();
        //this.paint(g);
        Graphics g2=g1.create();
        this.color = new  Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        g2.setColor(this.color);
        if(this.isAlive==false){
            g1.dispose();
        }
        paint(g2);
        //g.drawRect(this.position[0],this.position[1],Grid.HGAP,Grid.VGAP);
    }
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            direction[0]=0;
            direction[1]=-1;
            break;
            case KeyEvent.VK_DOWN:
            direction[0]=0;
            direction[1]=1;
            break;
            case KeyEvent.VK_LEFT:
            direction[0]=-1;
            direction[1]=0;
            break;
            case KeyEvent.VK_RIGHT:
            direction[0]=1;
            direction[1]=0;
            break;
            default:
            break;
        }
    }
    //@Override
    public void keyTyped(KeyEvent e){
        System.out.println(e.getKeyCode());
    } 
    //@Override
     public void keyReleased(KeyEvent e){
        System.out.println(e.getKeyCode());
    }

    //public static void main(String[] args){

    //}
}
