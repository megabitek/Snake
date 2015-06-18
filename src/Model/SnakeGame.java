/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.GraphicCells;
import View.MainFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class SnakeGame {

    static int snakeLenght ;
    static int frogCount;
    
    static boolean snakeAlive= true; 
    
    public static void main(String[] args) throws IOException, InterruptedException {

       
        Field field = new Field(15, 16);
        int[][] fieldCells= field.getCells();
        
        MainFrame mainFrame= new MainFrame(fieldCells); 
        
       
     
       
        
    }

    
}
