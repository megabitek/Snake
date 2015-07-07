
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
   

    public Frog(Field field) {

        mainCoords = field.findRandomCell();
        addOnField(field);
        delay = 3000; 

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
    final synchronized void addOnField(Field field) {

       
        int[] frogCoords = getMainCoords();

        field.cells[frogCoords[0]][frogCoords[1]].code = Frog.CELL_CODE;

    }

    @Override
    void moveUp() {

        
        super.moveUp();

    }

    
    @Override
    void moveDown() {

       

        super.moveDown();

    }

    @Override
    void moveRight() {

        

        super.moveRight();

    }

    @Override
    void moveLeft() {
      

        super.moveLeft();

    }

    @Override
    public void run() {
      
          System.out.println("лягушка умирает");
       super.run();
       if (dies) deleteFromField(Field.getField());
       
       

       
    }

    @Override
    public synchronized void makeMove() {

     
        Field field = Field.getField();
       
      
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
      
        }
     if (field.cells[mainCoords[0]][mainCoords[1]].code!=Cell.EMPTY_CELL_CODE){

     Field.field.printField();}
        addOnField(field);
    }


    int findDirection() {
        Random rand = new Random();
        return rand.nextInt(3);
    }
}
