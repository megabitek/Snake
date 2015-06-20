/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.GameProcess;
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

    static int snakeLength;
    static int frogCount;

    static boolean snakeAlive = true;

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            if (args.length == 4) {
                int gorSize = Integer.parseInt(args[0]);
                if ((gorSize > 1) & (gorSize < 19)) {
                    Field.gorizontalSize = gorSize;
                } else {
                    Field.gorizontalSize = 18;
                }

                int verSize = Integer.parseInt(args[1]);
                if ((verSize > 1) & (verSize < 19)) {
                    Field.verticalSize = verSize;
                } else {
                    Field.verticalSize = 18;
                }

                int snLength = Integer.parseInt(args[2]);
                if ((snLength > 1) & (snLength < Field.verticalSize)) {
                    snakeLength = snLength;
                } else {
                    snakeLength = 2;
                }
                int frCt = Integer.parseInt(args[3]);
                if (frCt > 0 & frCt < Field.verticalSize * Field.gorizontalSize / 4) {
                    frogCount = Integer.parseInt(args[3]);
                } else {
                    frogCount = 1;
                }
            } else {
                System.out.println("not enough args!!");
                Field.gorizontalSize = 18;
                Field.verticalSize = 18;
                snakeLength = 2;
                frogCount = 1;

            }
        } catch (NumberFormatException e) {
            System.out.println("you type non-integer number");
            Field.gorizontalSize = 18;
            Field.verticalSize = 18;
            snakeLength = 2;
            frogCount = 1;

        }

        GameProcess.startApp(snakeLength, frogCount);

        /*Snake snake = new Snake(3);
         snake.addOnField(field);
         fieldCells = field.getCells();
         field.printField();

         Thread.sleep(1000);
         mainFrame.gCells.setCells(fieldCells);

         // 
         Thread.sleep(1000);
         snake.cleanTailOnField(field, snake.getSnakeCoordinates().get(0));
         snake.moveDown();
       
         snake.addOnField(field);
        
         field.printField();
         fieldCells = field.getCells();
         mainFrame.gCells.setCells(fieldCells);*/
    }

}
