/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Field;
import Model.Snake;
import Model.Snake.MoveDirections;
import Model.SnakeGame;
import View.MainFrame;
import java.awt.event.KeyEvent;

/**
 *
 * @author admin
 */
public class GameProcess {

    static Field field;
    static MainFrame mainFrame;
    static Snake snake;
    static boolean gameOn;

    public static void startApp(int snakeLenght, int frogCount) {

        field = new Field(Field.gorizontalSize, Field.verticalSize);// сначала нарисовали пустое поле
        int[][] fieldCells = field.getCells();
        snake = new Snake(SnakeGame.snakeLength, field);
        gameOn = true;
        mainFrame = new MainFrame(fieldCells);
        mainFrame.gCells.setCells(fieldCells);
        
//MainFrame  mainFrame=new MainFrame(Field.getCells());
    }
   

    public static void gameCycle() throws InterruptedException {
        // Thread.sleep(3000);
        System.out.println("змея двигается!");
        if (gameOn) {
            {
                snake.makeMove();
                int[][] fieldCells2 = field.getCells();
                mainFrame.gCells.setCells(fieldCells2);
            }

        }
    }

    public static void moveSnake(KeyEvent ev) {

        switch (ev.getKeyCode()) {
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
        snake.makeMove();
        int[][] fieldCells2 = field.getCells();
        mainFrame.gCells.setCells(fieldCells2);
        /*snake.makeMove();
         int [][] fieldCells2 =  field.getCells(); 
         
         */
    }

    void turnSnakeUp() {
    }

    void turnSnakeDown() {
    }

    void turnSnakeLeft() {
    }

    void turnSnakeRight() {
    }
}
