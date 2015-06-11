/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import graphic.GraphicCell;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class SnakeGame {
    
    
    
    
     public static void main(String[] args) {
        // TODO code application logic here
        /*JFrame mainFrame = new JFrame("Java Snake");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1100, 600);
        mainFrame.add(new GraphicCell());
        mainFrame.setVisible(true);
  */
     Field field = new Field(5, 6); 
     field.printField();
     Snake snake = new Snake(3);
     field.addSnake(snake);
     field.printField();
     
     snake.moveDown();
     field.addSnake(snake);
     field.printField();
     
     snake.moveLeft();     
     field.addSnake(snake);
     field.printField();
     
     snake.moveRight();     
     field.addSnake(snake);
     field.printField();
     
     snake.moveDown();     
     field.addSnake(snake);
     field.printField();
     
     snake.moveRight();     
     field.addSnake(snake);
     field.printField();
     
     snake.moveDown();
     int[] frogCoordinates = field.findRandomCell(); 
    Frog frog= new Frog(frogCoordinates);
    field.addFrog(frog);
    field.printField();
    
}}
