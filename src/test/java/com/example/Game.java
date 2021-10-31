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
        //panel.add(grid);
        panel.add(snake);//,BorderLayout.CENTER);
        panel.add(food);
        //this.setGlassPane(grid);
        //grid.setVisible(true);
        //panel.addComponentListener(ComponentListener);
        //grid.paint(g);
        pane.setLayout(new GridLayout());
        //pane.setVisible(true);
        snake.paint(g);
        pane.add(grid);
        //pane.add(comp, constraints, index);
        //setContentPane(pane); 
        //food.paint(g);
        //panel.setVisible(true);
        this.setLocationRelativeTo(null);
        //this.getContentPane().add(panel,BorderLayout.CENTER);
        setVisible(true);
        processWindowEvent(new WindowEvent(this,WindowEvent.WINDOW_ACTIVATED));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        setAutoRequestFocus(true);
        setPreferredSize(new Dimension(200,200));
        setEnabled(true);
        setBounds(100, 100, 400, 400);
        setLayout(new GridLayout());
        //getContentPane().add(panel);
        //setContentPane(pane);
        layeredPane.setLayout(new BorderLayout());
        layeredPane.setLayer(grid,JLayeredPane.MODAL_LAYER,1);
        //layeredPane.setLayer(snake,JLayeredPane.MODAL_LAYER,2);
        layeredPane.add(grid,1);
        grid.paint(g);
        snake.paint(g);
        //layeredPane.setLayer(snake,400);
        //layeredPane.add(snake,2);
        //layeredPane.add(grid,0);
        snake.validate();
        snake.repaint();
        //layeredPane.validateOptimizedDrawing();
        //layeredPane.addLayoutComponent();
        //layeredPane.setLayer(snake,JLayeredPane.POPUP_LAYER);
        //layeredPane.setLayer(food,JLayeredPane.DRAG_LAYER);
        //layeredPane.setLayer(snake,400);
        //layeredPane.add(food,200);
        //layeredPane.setLayer(food,400);
        //layeredPane.add(snake,400);
        if(layeredPane.isVisible()==false){
            layeredPane.setVisible(true);
        }
        layeredPane.setBounds(new Rectangle(0,0,100,100));
        layeredPane.setFocusCycleRoot(true);
        layeredPane.setVisible(true);
        this.setLayeredPane((layeredPane));
        //this.createBufferStrategy(numBuffers, caps);
        //this.imageUpdate(img, infoflags, x, y, w, h)
        //this.addKeyListener(snake);
        //.paint(g);
        g=this.getGraphics();
        g.drawString("FUN",100,100);
        //g.drawImage(img, x, y, width, height, observer);
        //g.drawImage(img, x, y, width, height, bgcolor, observer)
        String str = new String("Score: ").concat((grid.snake.score).toString());
        //g.drawString(str,350,0);
        //label.setText(str);
        //label.setLocation(new Point(160,160)); 
        //layeredPane.setLayer(label,JLayeredPane.MODAL_LAYER,0);
        //layeredPane.add(label,0);
        this.addKeyListener(new KeyList());
        //Random rand = new Random();
        //Snake sn1 = new Snake();
        //Food fd1 =   new Food();
        //sn1.color = new Color();
        //Grid grid = new Grid();
        //Grid grid = new Grid();
        //while(sn1.isAlive()){
        //    sn1.live();
        //}
        //this.setLayout(new GridLayout());
        //add(grid);
        //add(sn1);
        //add(fd1);
        //add
        //grid.add(grid.snake);
        //grid.paint(g);
        //snake.paint(g);
        //grid.snake.paint(g);
        //sn1.paint(g);
        ///fd1.paint(g);
        /*FileDialog dialog = new FileDialog(this,new String("Random"));
        dialog.setMode(FileDialog.SAVE);
        dialog.setMultipleMode(true);
        dialog.setDirectory((new File("Game.java").getAbsolutePath()));
        dialog.setFile("Grid.java");
        dialog.setVisible(true);*/
        /*JFileChooser chooser = new JFileChooser((new File("Game.java").getAbsolutePath()));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = (new FileNameExtensionFilter("Java & class", ".java",".class"));
        chooser.setFileFilter(filter);
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        chooser.setAcceptAllFileFilterUsed(true);;
        chooser.setDialogTitle(new  String("Random"));
        chooser.setDragEnabled(true);
        chooser.setBounds(new Rectangle(100,100,400,400));
        chooser.setSelectedFile(new File("Grid.java"));
        int var1 = chooser.showDialog(this, "Random");
        if(var1 == JFileChooser.APPROVE_OPTION){
            System.out.println
            (chooser.getSelectedFile().toString()+chooser.getApproveButtonText()+
            chooser.getDescription(new File("Snake.java")));
            chooser.updateUI();
            System.out.println(chooser.getDialogTitle());
        }
        */
        }catch(IllegalArgumentException|NullPointerException e){
            e.printStackTrace();
        }
    }
    //@Override
     //protected void processwindowEvent(WindowEvent e){   
     //    KeyListener listener = e.getKeyListener()
    //     super(listener);

     //}
    public void spawn(){

    }
    public void run(){

    }
    //@Override
    //public void paint(Graphics g){

    //}
    //public void init(){
        
    //}
    @Override
    public void update(Graphics f){
        while(true){
        layeredPane.update(f);
        //this.snake.update(f);
        //this.panel.update(f);
        //food.update(f);
        //IntFunction<Integer>
        String str = new String("Score: ").concat((grid.snake.score).toString());
        //grid.paint(f); 
        //layeredPane.updateUI();
        layeredPane.repaint();
        //setLayeredPane(layeredPane);
        //grid.paint(f);
        grid.update(f);
        //grid.snake.paint(f);
        //grid.snake.update(f);
        //grid.paint(f);
        //layeredPane.paint(f);
        //System.out.println(grid.snake.position[0]);
        f.drawString(str,150,150);
        System.out.println(Arrays.deepToString(grid.snake.var1));
        //layeredPane.update(f);
            //panel.update(f);
            //pane.update(f);
            //setContentPane(panel);
            //getContentPane().add(pane);
        }
    }
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            this.grid.snake.direction[0]=0;
            this.grid.snake.direction[1]=-1;
            break;
            case KeyEvent.VK_DOWN:
            this.grid.snake.direction[0]=0;
            this.grid.snake.direction[1]=1;
            break;
            case KeyEvent.VK_LEFT:
            this.grid.snake.direction[0]=-1;
            this.grid.snake.direction[1]=0;
            break;
            case KeyEvent.VK_RIGHT:
            this.grid.snake.direction[0]=1;
            this.grid.snake.direction[1]=0;
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