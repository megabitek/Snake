/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Snake extends FieldObject {

    enum MoveDirections {

        LEFT, RIGHT, UP, DOWN
    };

    final static int CELL_CODE_TAIL = 4;
    final static int CELL_CODE = 3;
    final static int CELL_CODE_HEAD = 2;

    MoveDirections moveDirection;

   // private int[] mainCoords;

    private ArrayList<int[]> snakeCoordinates;

    Snake(int snakeLength) {
        //новая змея создается в правом верхнем углу
        snakeCoordinates = new ArrayList();
        for (int i = 0; i < snakeLength; i++) {
            int[] coors = new int[]{0, i};
            snakeCoordinates.add(coors);

        }
        mainCoords = snakeCoordinates.get((int) snakeLength - 1);
        moveDirection = MoveDirections.RIGHT;
    }

    @Override
    void addOnField(Field field) {
         int[] snakeHeadCoords = getHeadCoords();
//        if ((field.cells[snakeHeadCoords[0]][snakeHeadCoords[1]].code)==1)
//            field.snakeFindFrog(snakeHeadCoords);
        

        for (int[] coords : getSnakeCoordinates()) {
            field.cells[coords[0]][coords[1]].setCode(Snake.CELL_CODE);
        }
       

        field.cells[snakeHeadCoords[0]][snakeHeadCoords[1]].code = Snake.CELL_CODE_HEAD;
        int[] tailCoords = getSnakeCoordinates().get(0);
        field.cells[tailCoords[0]][tailCoords[1]].code = Snake.CELL_CODE_TAIL;

    }
    
    

    

    MoveDirections getMoveDirection() {
        return moveDirection;
    }

    void setMoveDirection(MoveDirections moveDirection) {
        this.moveDirection = moveDirection;
    }

    void setHeadCoords(int[] coords) {
        this.mainCoords = coords;
    }

    void setSnakeCoordinates(ArrayList<int[]> snakeCoords) {
        this.snakeCoordinates = snakeCoords;
    }

    int[] getHeadCoords() {
        return mainCoords;
    }

    ArrayList<int[]> getSnakeCoordinates() {
        return snakeCoordinates;
    }

    @Override
    void moveUp() {
        if (canMove(MoveDirections.UP)) {
            super.moveUp();
            snakeCoordinates.remove(0);
            //field.cleanCell(snakeCoordinates.get(0));
            snakeCoordinates.add(mainCoords);
        } else {

            System.out.println("can't go up!");
            return;
        }
        moveDirection = MoveDirections.UP;
    }

    ;

    @Override
    void moveDown() {
        if (canMove(MoveDirections.DOWN)) {
            super.moveDown();
          //  cleanTailOnField(field, snakeCoordinates.get(0));
            snakeCoordinates.remove(0);
            
            snakeCoordinates.add(mainCoords);
        } else {

            System.out.println("can't go down!");
            return;
        }
        moveDirection = MoveDirections.DOWN;
    }
    
  void   cleanTailOnField(Field field, int [] tailCoords){
        field.cells[tailCoords[0]][tailCoords[1]].code = Cell.EMPTY_CELL_CODE; 
    }

    @Override
    void moveLeft() {
        if (canMove(MoveDirections.LEFT)) {
            super.moveLeft();
           // cleanCell(snakeCoordinates.get(0));
            snakeCoordinates.remove(0);
            
            snakeCoordinates.add(mainCoords);
        } else {

            System.out.println("can't go down!");
            return;
        }
        moveDirection = MoveDirections.LEFT;
    }

    @Override
    void moveRight() {
        if (canMove(MoveDirections.RIGHT)) {
            super.moveRight();
            //field.cleanCell(snakeCoordinates.get(0));
            snakeCoordinates.remove(0);
            
            snakeCoordinates.add(mainCoords);
        } else {

            System.out.println("can't go down!");
            return;
        }
        moveDirection = MoveDirections.RIGHT;
    }

    void grow(int[] frogCoordinates) {
        this.mainCoords = frogCoordinates;

    }

    @Override
     public void run(){
      //  while (true){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        makeMove();
        addOnField(field);
        
        //System.out.println("snake makes move");}

    }//}

    public void makeMove() {
        if (moveDirection == MoveDirections.DOWN) {
            moveDown();
        } else if (moveDirection == MoveDirections.UP) {
            moveUp();
        } else if (moveDirection == MoveDirections.RIGHT) {
            moveRight();
        } else if (moveDirection == MoveDirections.LEFT) {
            moveLeft();
        }
    }
   

    
    boolean canMove(MoveDirections moveDir) {
        return (!(moveDirection == MoveDirections.DOWN & moveDir == MoveDirections.UP) || (moveDirection == MoveDirections.UP & moveDir == MoveDirections.DOWN) || (moveDirection == MoveDirections.LEFT & moveDir == MoveDirections.RIGHT) || (moveDirection == MoveDirections.RIGHT & moveDir == MoveDirections.LEFT));

    }
}
