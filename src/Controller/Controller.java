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
import View.GraphicCells;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author admin
 */
public class Controller {

    static View mainFrame;
    public static Snake snake;
    public static Thread thrSnake;
    static boolean gameOn;
    static ArrayList<Frog> frogs = new ArrayList<Frog>();
    static ArrayList<Thread> thrFrogs = new ArrayList<Thread>();

    ///   Thread frogFactory; 
    public static void startApp(int snakeLenght, int frogCount) {

        Field field = Field.getField();
        int[][] fieldCells = field.getCells();

        mainFrame = new View(fieldCells);

        mainFrame.gCells.setCells(fieldCells);

//MainFrame  mainFrame=new View(Field.getCells());
    }

    public static void gameCycle() throws InterruptedException {

        if (gameOn) {

            Field field = Field.getField();
            if (snake.dies) {
                JOptionPane.showMessageDialog(mainFrame, "Game ends!", "OK", JOptionPane.WARNING_MESSAGE);
                gameOn = false;
                return;
            }

            for (int i = 0; i < SnakeGame.frogCount; i++) {

                if (field.checkField(snake, frogs.get(i))) {
                    System.out.println(field.checkField(snake, frogs.get(i)));
                  

                //    frogs.remove(i);
                    //  thrFrogs.remove(i); 
                    Thread newThreadFrog = new Thread(new Frog(field));
                    newThreadFrog.start();
                    thrFrogs.add(newThreadFrog);
                    continue;
                    // System.out.println("thrFrogs size "+thrFrogs.size());

                }
            }

            //   field.printField();
            int count = snake.getLength();

            int[][] fieldCells2 = field.getCells();
            mainFrame.gCells.setCount(count);
            mainFrame.gCells.setCells(fieldCells2);
        }

    }

    public static void turnSnake(KeyEvent e) {
        //    System.out.println(e.getKeyCode() + " нажата клавиша");
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
        Field field = Field.getField();
        snake = new Snake(SnakeGame.snakeLength, field);
        thrSnake = new Thread(snake);

        for (int i = 0; i < SnakeGame.frogCount; i++) {
            Frog frog = (new Frog(field));
            frogs.add(frog);
            thrFrogs.add(new Thread(frog));
            thrFrogs.get(i).start();
        }
        thrSnake.start();
        gameOn = true;
    }

}
