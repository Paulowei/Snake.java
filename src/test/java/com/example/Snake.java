package com.example;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
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
import java.util.Collections;
import java.awt.Robot;
import java.awt.AWTException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ListIterator;
import java.lang.Math;
public class Snake extends Component implements KeyListener{
    public int posX=8;
    public int posY=8;
    public Integer[] position= new Integer[]{posX,posY};
    public static int length=3;
    public int velocity=1;
    //private Date datetime;
    public Color color;
    public Date date;
    public static Integer score = 0;
    public static int count = 2;
    //public Integer[][] foodPos;
    public static final int MAXLENGTH= Grid.LENGTH;
    public static   Integer[] direction=new Integer[]{1,0};
    public static Integer[] DIRECTION = new Integer[]{1,-1};
    public int[][] var1 = new int[40][2];
    public ArrayList<Integer[]> list1 = 
    new ArrayList<Integer[]>(Collections.synchronizedList(new ArrayList<Integer[]>()));
    ListIterator<Integer[]> iterator1 = list1.listIterator();
    ListIterator<Integer[]> iterator2  = list1.listIterator();
    public int dateCount;
    //ArrayList arrayList = new ArrayBlockingQueue<>(capacity, fair)
   //Grid grid = new Grid();
   ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public boolean isAlive;
    Random rand = new Random();
    public KeyListener listener;
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
        date = new Date();
    }

    public synchronized void transverse(){
        Date date_=new Date();
        if((date_.getTime()-date.getTime())/(dateCount*1000)>=1){
        dateCount++;
        this.position[0]+=(direction[0]*this.velocity);
        //Thread.sleep(50);
        this.position[1]+=(direction[1]*this.velocity);
        //Thread.sleep(50);
        if(this.posX==Food.currentPosX&&this.posY==Food.currentPosY&&this.length<Grid.LENGTH){
            grow();
        }
    }else{
        return;
    }
        //Robot robot = new Robot();
        /*for(int i=0;i<length;i++){
            robot.delay(100);
            var1[i][0]=var1[i][0]=position[0]-i*direction[0];
            var1[i][1]=var1[i][0]=position[0]-i*direction[0];
        }*/
           /*for(int i=0;i<length;i++){
             //   for(int j=0;j<2;j++){
                //Thread.sleep(200);
                 if(i!=0){
                //if(var1[i-1]>0){
                var1[i][0]=var1[i-1][0]*direction[0];
                var1[i][1]=var1[i-1][1]*direction[1];
                
                //Thread.sleep(200);
               // }
            }
        }*/
        
    /*}catch(AWTException E){
        E.printStackTrace();
    }*/
    }
    public synchronized void spawn(){

    }
    public synchronized void live(){
        this.position[0]+=(direction[0]*this.velocity)/20;
        this.position[1]+=(direction[1]*this.velocity)/20;
    }
    public synchronized void respawn(){
        this.position[0]=8;
        this.position[1]=8;
        this.velocity = 1;
    }
    public Integer[] getPos(){
        return this.position;
    }
    public int getPos1(){
        return this.position[0]; 
    }
    public int getPos2(){
        return this.position[1];
    }
    public int getLength(){
        return length;
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
    @Override
    public synchronized void paint(Graphics g){
        //direction = new Integer[length];
        //g=this.getParent().getGraphics();
        //var1.add()
        //arrayList.add(4);
        //arrayList.add(6);
        //System.out.println(arrayList);
        //System.out.println(Arrays.deepToString(var1));
        //System.out.println(Arrays.toString(position));
        this.color = new  Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        g.setColor(this.color);
        for(int i=0;i<=length;i++){
            int var2 = Math.round(position[0]/5000);
            int var3 = Math.round(position[1]/5000);
            //System.out.println(i);
            g.drawRect(var2%Grid.LENGTH *Grid.VGAP-i*direction[0]*Grid.HGAP,
            var3%Grid.WIDTH*Grid.HGAP-i*direction[1]*Grid.VGAP,Grid.HGAP,Grid.VGAP);
            g.fillRect(var2%Grid.LENGTH*Grid.HGAP-i*direction[0]*Grid.HGAP,
            var3%Grid.WIDTH*Grid.VGAP-i*direction[1]*Grid.VGAP,Grid.HGAP,Grid.VGAP);
            //g.drawLine()
        }
        //g.fillRect(this.position[0],this.position[1],Grid.HGAP,;Grid.VGAP);
    }
    @Override
    public synchronized void update(Graphics g1){
        //this.paint(g);
        //count++;
        var1[0][0]=position[0]/20;
        var1[0][1]=position[1]/20;
        count+=1;
        var1[count%var1.length][0]=Math.round(position[0]/20);
        var1[count%var1.length][1]=Math.round(position[1]/20);
        while(iterator2.hasPrevious()==true){
            iterator2.previous();
        }
        if(!iterator1.hasNext()){
        //iterator1.add(getPos());
        }
        if(list1.size()>Grid.LENGTH){
            iterator2.remove();
            iterator2.next();
        }
        //System.out.println(list1.toString());
        transverse();
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
        //System.out.println(e.getKeyCode());
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            //count++;
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
        //System.out.println(e.getKeyCode());
    } 
    //@Override
     public void keyReleased(KeyEvent e){
        //System.out.println(e.getKeyCode());
    }

    //public static void main(String[] args){

    //}
}
