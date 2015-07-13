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
import java.util.List;
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
    static ArrayList<int[]> changeCells = new ArrayList<>();
    static int frogDelay;

    public static void startApp(int snakeLenght, int frogCount) {

        Field field = Field.getField();

        int[][] fieldCells = field.getCells();
        mainFrame = new View(fieldCells);
    }

    public static void gameCycle() throws InterruptedException {

        mainFrame.gCells.newGame = false;

        if (gameOn) {

            Field field = Field.getField();
            findChangeCells(changeCells, false);
            if (snake.dies) {
                JOptionPane.showMessageDialog(mainFrame, "Game ends!", "OK", JOptionPane.WARNING_MESSAGE);
                gameOn = false;
                return;
            }
            if (snake.moved) {
                snake.addOnField(field);
            }
            for (int i = 0; i < SnakeGame.frogCount; i++) {
                if (frogs.get(i).moved) {
                    frogs.get(i).addOnField(field);
                }
            }
            findChangeCells(changeCells, false);

            for (int i = 0; i < SnakeGame.frogCount; i++) {

                field.checkField(snake, frogs.get(i));
                if (thrFrogs.get(i).getState() == State.TERMINATED) {
                    {
                        frogs.get(i).deleteFromField(field);
                        frogs.remove(i);

                        thrFrogs.remove(i);
                        checkFrogCount(field);
                    }
                }
                findChangeCells(changeCells, false);
                int count = snake.getLength() - SnakeGame.snakeLength;
                int[][] fieldCells = field.getCells();

                mainFrame.gCells.setCount(count);
                mainFrame.gCells.setCells(fieldCells, changeCells);

            }

        }
        setButtonsEnable();
    }

    static void findChangeCells(ArrayList<int[]> cellsList, boolean newGame) {

        ArrayList<int[]> snakeCoords = snake.getSnakeCoordinates();
        if (newGame) {
            for (int[] coords : snakeCoords) {
                if (!cellsList.contains(coords)) {
                    cellsList.add(coords);
                }
            }
        } else {
            int[] tail = snakeCoords.get(0);
            if (!cellsList.contains(tail)) {
                cellsList.add(tail);
            }
            int[] head = snakeCoords.get(snakeCoords.size() - 1);
            if (!cellsList.contains(head)) {
                cellsList.add(head);
            }
            int[] body = snakeCoords.get(snakeCoords.size() - 2);
            if (!cellsList.contains(body)) {
                cellsList.add(body);
            }
        }
        for (Frog frog : frogs) {
            int[] frogCoor = frog.getMainCoords();
            if (!cellsList.contains(frogCoor)) {
                cellsList.add(frogCoor);
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
                Frog frog = new Frog(field, frogDelay);
                frogs.add(frog);
                Thread newThreadFrog = new Thread(frog);
                newThreadFrog.start();
                thrFrogs.add(newThreadFrog);
            }
        }

    }

    public static void turnGame() {
        frogs.removeAll(frogs);
        thrFrogs.removeAll(thrFrogs);
        Field field = Field.getField();
        field.deleteAll();
        int snakeDelay = SnakeGame.snakeDelay;
        snake = new Snake(SnakeGame.snakeLength, field, snakeDelay);
        thrSnake = new Thread(snake);
        thrSnake.setPriority(Thread.MAX_PRIORITY);
        frogDelay = snakeDelay * 2;
        for (int i = 0; i < SnakeGame.frogCount; i++) {
            Frog frog = new Frog(field, frogDelay);
            frogs.add(frog);
            thrFrogs.add(new Thread(frog));
            thrFrogs.get(i).setPriority(Thread.NORM_PRIORITY);
            thrFrogs.get(i).start();
        }
        gameOn = true;
        thrSnake.start();
        findChangeCells(changeCells, true);
        int[][] fieldCells = field.getCells();
        mainFrame.gCells.setCells(fieldCells, changeCells);
        setButtonsEnable();

    }

    public static void stopGame() {

        gameOn = false;
        for (int i = 0; i < SnakeGame.frogCount; i++) {
            frogs.get(i).dies = true;
        }
        setButtonsEnable();

    }

    public static void setButtonsEnable() {
        mainFrame.start.setEnabled(!gameOn);
        mainFrame.stop.setEnabled(gameOn);
    }

}
