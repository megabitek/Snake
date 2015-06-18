/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import graphic.GraphicCell;
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
    static int fieldSizeGorizontal;
    static int fieldSizeVertical;
    static boolean snakeAlive= true; 
    
    public static void main(String[] args) throws IOException, InterruptedException {

       
        Field field = new Field(5, 6);
        field.printField();
       
     
       
        
    }

    
}
