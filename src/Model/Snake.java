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

    Field field;

    public enum MoveDirections {

        LEFT, RIGHT, UP, DOWN
    };

    final static int CELL_CODE_TAIL = 4;
    final static int CELL_CODE = 3;
    final static int CELL_CODE_HEAD = 2;

    MoveDirections moveDirection;

    // private int[] mainCoords;
    private ArrayList<int[]> snakeCoordinates;

    public Snake(int snakeLength, Field field) {
        //новая змея создается в правом верхнем углу
        snakeCoordinates = new ArrayList();
        for (int i = 0; i < snakeLength; i++) {
            int[] coors = new int[]{0, i};
            snakeCoordinates.add(coors);

        }
        this.field = field;
        mainCoords = snakeCoordinates.get((int) snakeLength - 1);
        moveDirection = MoveDirections.RIGHT;
        addOnField(field);
    }

    @Override
    void addOnField(Field field) {
        
        field = this.field;
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

    public void setMoveDirection(MoveDirections moveDirection) {
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
        addOnField(field);
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

        addOnField(field);
    }

    void cleanTailOnField() {
        int [] tailCoords = snakeCoordinates.get(0); 
        field = this.field;
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

        addOnField(field);
    }

    @Override
    void moveRight() {
        cleanTailOnField(); 
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

        addOnField(field);
    }

    void grow(int[] frogCoordinates) {
        this.mainCoords = frogCoordinates;
        addOnField(field);
    }

    @Override
    public void run() {

        /*  addOnField(field);
         field.change=true;
         makeMove; 
         field.change=true; 
         */
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
