/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Snake {

    static int snakeFirstLenght;
    final static int CELL_CODE_TAIL = 4;
    final static int CELL_CODE_BODY = 3;
    final static int CELL_CODE_HEAD = 2;

    private int[] headCoords;

    private ArrayList<int[]> snakeCoordinates;

    Snake(int snakeLength) {
        //новая змея создается в правом верхнем углу
        snakeCoordinates = new ArrayList();
        for (int i = 0; i < snakeLength; i++) {
            int[] coors = new int[]{0, i};
            snakeCoordinates.add(coors);

        }
        headCoords = snakeCoordinates.get((int) snakeLength - 1);
    }

    void setHeadCoords(int[] coords) {
        this.headCoords = coords;
    }

    void setSnakeCoordinates(ArrayList<int[]> snakeCoords) {
        this.snakeCoordinates = snakeCoords;
    }

    int[] getHeadCoords() {
        return headCoords;
    }

    ArrayList<int[]> getSnakeCoordinates() {
        return snakeCoordinates;
    }

    void moveUp() {
        System.out.println("Snake go up");
        int[] newCoords = new int[]{headCoords[0] - 1, headCoords[1]};
        if (canMove(newCoords)) {
            snakeCoordinates.remove(0);
            snakeCoordinates.add(newCoords);
            this.headCoords = newCoords;
        } else {
            System.out.println("can't go up!");
        }
    }

    ;

    void moveDown() {
        System.out.println("Snake go down");

        int[] newCoords = new int[]{headCoords[0] + 1, headCoords[1]};
        if (canMove(newCoords)) {
            snakeCoordinates.remove(0);
            snakeCoordinates.add(newCoords);
            this.headCoords = newCoords;
        } else {
            System.out.println("can't go down!");
        }
    }

    void moveLeft() {
        System.out.println("Snake go left");
        int[] newCoords = new int[]{headCoords[0], headCoords[1] - 1};
        if (canMove(newCoords)) {
            snakeCoordinates.remove(0);
            snakeCoordinates.add(newCoords);
            this.headCoords = newCoords;
        } else {
            System.out.println("can't go left!");
        }

    }

    ;
    void moveRight() {
        System.out.println("Snake go right");
        int[] newCoords = new int[]{headCoords[0], headCoords[1] + 1};
        if (canMove(newCoords)) {
            snakeCoordinates.remove(0);
            snakeCoordinates.add(newCoords);
            this.headCoords = newCoords;
        } else {
            System.out.println("can't go right!");
        }

    }

    ;
  
    void grow(int[] frogCoordinates) {
        this.headCoords = frogCoordinates;

    }

    ;

    
    boolean canMove(int[] newCoords) {
        for (int i = snakeCoordinates.size() - 1; i > 0; i--) {
            if ((newCoords[0] == snakeCoordinates.get(i)[0]) & (newCoords[1] == snakeCoordinates.get(i)[1])) {
                return false;

            }

        }
        return true;
    }
}
