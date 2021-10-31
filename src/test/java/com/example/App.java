package com.example;
import javax.swing.JPanel;
import java.util.Date;
import java.util.ArrayList;
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
import java.util.Random;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;
import javax.swing.WindowConstants;
import java.awt.image.BufferedImage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {      
        BufferedImage image = new BufferedImage(50,50,BufferedImage.TYPE_INT_RGB);
        Graphics g=image.getGraphics();
        System.out.println( "Snake" );
        System.out.println("Game is running");
        Game game = new Game();
        while(true){
            game.update(g);
            //System.out.println("Game is running");
        }
    }
}
