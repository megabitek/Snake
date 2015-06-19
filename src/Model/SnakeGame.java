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

       
        Field field = new Field(10, 15);
       // int[][] fieldCells= field.getCells();
        
        
        
        Snake snake = new Snake(3); 
        snake.addOnField(field);
        int [][]fieldCells= field.getCells();
        field.printField();
        MainFrame mainFrame= new MainFrame(fieldCells);
     //   fieldCells= field.getCells();
      //  mainFrame.reDrawField(fieldCells);
        
        
       
     
       
        
    }

    
}
