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
import View.View;
import java.awt.event.KeyEvent;
import java.lang.Thread.State;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Controller {

    static View mainFrame;
    public static Snake snake;
    public static Thread thrSnake;
    static boolean gameOn;
    static ArrayList<Frog> frogs = new ArrayList<>();
    static ArrayList<Thread> thrFrogs = new ArrayList<>();

    ///   Thread frogFactory; 
    public static void startApp(int snakeLenght, int frogCount) {

        Field field = Field.getField();
        field.printField();
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
              
               // if (frogs.size() == SnakeGame.frogCount) {
                    field.checkField(snake, frogs.get(i));
                    if (thrFrogs.get(i).getState() == State.TERMINATED) {
                        {
                            frogs.remove(i);
                            thrFrogs.remove(i);
                            checkFrogCount(field); 
                            //checkFrogCount(field);
                            
                            System.out.println("количество лягух" + frogs.size());
                            System.out.println("количество потоков лягух" + thrFrogs.size());
                        }

//                    } else {
//checkFrogCount(field);
//                    }
                }
                //   field.printField();
                int count = snake.getLength();

                int[][] fieldCells2 = field.getCells();
                mainFrame.gCells.setCount(count);
                mainFrame.gCells.setCells(fieldCells2);
            }

        }
    }

    public static void turnSnake(KeyEvent e) {

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

    static void checkFrogCount(Field field) {

        if (thrFrogs.size() < SnakeGame.frogCount) {
            int dif = SnakeGame.frogCount - thrFrogs.size();
            for (int i = 0; i < dif; i++) {
                Frog frog = new Frog(field);
                frogs.add(frog);
                Thread newThreadFrog = new Thread(frog);
                newThreadFrog.start();
                thrFrogs.add(newThreadFrog);
                System.out.println("создаем новую лягушку");
            }
        }

    }

    public static void turnGame() {
        frogs.removeAll(frogs);
        thrFrogs.removeAll(frogs);
        Field field = Field.getField();
        snake = new Snake(SnakeGame.snakeLength, field);
        thrSnake = new Thread(snake);
        thrSnake.setPriority(Thread.MAX_PRIORITY);
        
        for (int i = 0; i < SnakeGame.frogCount; i++) {
            Frog frog = (new Frog(field));
            frogs.add(frog);
            thrFrogs.add(new Thread(frog));
            thrFrogs.get(i).setPriority(Thread.NORM_PRIORITY );
            thrFrogs.get(i).start();
        }
        thrSnake.start();
        gameOn = true;
    }

    public static void stopGame() {
        snake.dies = true;
    }

}
