/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Controller;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class SnakeGame {

    /**
     * поле для хранения длинны змеи и текущего счета.
     */
    public static int snakeLength;
    public static int frogCount;
    public static int snakeDelay;

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            if (args.length == 5) {
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
                double snDelay = Integer.parseInt(args[4]);
                if (snDelay > 0.1 & snDelay < 5) {
                    snakeDelay = Integer.parseInt(args[4]);
                } else {
                    snakeDelay = 1000;
                }

            } else {
                System.out.println("not enough args!!");
                setDefaultArgs();
            }
        } catch (NumberFormatException e) {
           setDefaultArgs();
        }

        Controller.startApp(snakeLength, frogCount);
    }

    static void setDefaultArgs() {
        Field.gorizontalSize = 18;
        Field.verticalSize = 18;
        snakeLength = 2;
        frogCount = 1;
        snakeDelay = 1000;
    }

}
