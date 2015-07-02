
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author admin
 */
public class Frog extends FieldObject implements Runnable {

    public static int frogCount;
    final static int CELL_CODE = 1;
    boolean dies;

    public Frog(Field field) {

        mainCoords = field.findRandomCell();
        addOnField(field);
        delay = 2000; 

    }

    @Override
    int[] getMainCoords() {
        return mainCoords;
    }

    @Override
    void deleteFromField(Field field) {

        field.cells[mainCoords[0]][mainCoords[1]].setCode(Cell.EMPTY_CELL_CODE);
    }

    @Override
    void setMainCoords(int[] frogCoords) {
        this.mainCoords = frogCoords;
    }

    @Override
    final void addOnField(Field field) {

        System.out.println(mainCoords[0] + mainCoords[1]);
        int[] frogCoords = getMainCoords();

        field.cells[frogCoords[0]][frogCoords[1]].code = Frog.CELL_CODE;

    }

    @Override
    void moveUp() {

        System.out.println("frog move up");
        super.moveUp();

    }

    ;
    @Override
    void moveDown() {

        System.out.println("frog move down");

        super.moveDown();

    }

    @Override
    void moveRight() {

        System.out.println("frog move right");

        super.moveRight();

    }

    @Override
    void moveLeft() {
        System.out.println("frog move left");

        super.moveLeft();

    }

    @Override
    public void run() {
      
       

       
    }

    public void makeMove() {

      //  System.out.println("1: " + mainCoords[0] + "  " + mainCoords[1]);
        Field field = Field.getField();
       
       // System.out.println("2: " + mainCoords[0] + "  " + mainCoords[1]);
        while (field.cells[mainCoords[0]][mainCoords[1]].code != Cell.EMPTY_CELL_CODE) {
            int[] oldCoords = mainCoords;

            int dir = findDirection();
            switch (dir) {
                case 0: {
                    moveDown();
                    break;
                }
                case 1: {
                    moveLeft();
                    break;
                }
                case 2: {
                    moveRight();
                    break;
                }
                case 3: {
                    moveUp();
                    break;
                }

            }
             if (field.checkOnWall(mainCoords)) {
            this.mainCoords = oldCoords;

        };
        //    System.out.println("3: " + mainCoords[0] + "  " + mainCoords[1]);
        }

        addOnField(field);
    }
//field.addFrog(frog);

    int findDirection() {
        Random rand = new Random();
        return rand.nextInt(3);
    }
}
