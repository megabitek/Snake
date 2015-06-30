/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Field;
import Model.Frog;
import Model.Snake;
import Model.Snake.MoveDirections;
import Model.SnakeGame;
import View.MainFrame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class GameProcess {

   
    static MainFrame mainFrame;
    public static Snake snake;
    static boolean gameOn;
    static ArrayList<Frog> frogs= new ArrayList<Frog>();
 ///   Thread frogFactory; 

    public static void startApp(int snakeLenght, int frogCount) {

        Field field = Field.getField();
        int[][] fieldCells = field.getCells();
        snake = new Snake(SnakeGame.snakeLength, field);
        //frog = new Frog[SnakeGame.frogCount]; 
        for (int i = 0; i < SnakeGame.frogCount; i++) {
            frogs.add(new Frog(field));
        }
        //gameOn = true;
        mainFrame = new MainFrame(fieldCells);
        mainFrame.gCells.setCells(fieldCells);

//MainFrame  mainFrame=new MainFrame(Field.getCells());
    }

    public static void gameCycle() throws InterruptedException {
        // Thread.sleep(3000);

        if (gameOn) {
            System.out.println("game on: "+gameOn);
            Field field = Field.getField(); 
                
                for (int i = 0; i < SnakeGame.frogCount; i++) {
                frogs.get(i).makeMove();
                // System.out.println;
//                 if (!field.checkFrog(snake, frogs.get(i))) { 
//                } else {
//                     frogs.remove(i);
//                     frogs.add(new Frog(field)); 
//                }
                  snake.makeMove();
                   if (!field.checkFrog(snake, frogs.get(i))) { 
                } else {
                     frogs.remove(i);
                     frogs.add(new Frog(field)); 
                     
                }
                  if (snake.snakeDies) gameOn=false;
                  System.out.println("snake dies "+snake.snakeDies);
                  System.out.println("game on: "+gameOn);
                }
                
                
               
                field.printField();
                int count = snake.getLength();
              
                int[][] fieldCells2 = field.getCells();
                mainFrame.gCells.setCount(count);
                mainFrame.gCells.setCells(fieldCells2);
            }

        }
    

    public static void turnSnake(KeyEvent e) {
        System.out.println(e.getKeyCode() + " нажата клавиша");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT: {
                snake.setMoveDirection(MoveDirections.RIGHT);
                break;
            }
            case KeyEvent.VK_DOWN: {
                snake.setMoveDirection(MoveDirections.DOWN);
                break;
            }
            case KeyEvent.VK_UP: {
                snake.setMoveDirection(MoveDirections.UP);
                break;
            }
            case KeyEvent.VK_LEFT: {
                snake.setMoveDirection(MoveDirections.LEFT);
                break;
            }
        }
    }

//        snake.makeMove();
    //    int[][] fieldCells2 = field.getCells();
    //   mainFrame.gCells.setCells(fieldCells2);
        /*snake.makeMove();
     int [][] fieldCells2 =  field.getCells(); 
         
     */
    public static void turnGame() {
        gameOn = true;
    }

 
}
