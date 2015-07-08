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
public class Snake extends FieldObject implements Runnable {

    public enum MoveDirections {

        LEFT, RIGHT, UP, DOWN
    };

    final static int CELL_CODE_TAIL = 4;
    final static int CELL_CODE = 3;
    final static int CELL_CODE_HEAD = 2;
    MoveDirections moveDirection;
    private ArrayList<int[]> snakeCoordinates;

    public Snake(int snakeLength, Field field) {
        //новая змея создается в правом верхнем углу
        snakeCoordinates = new ArrayList();
        for (int i = 0; i < snakeLength; i++) {
            int[] coors = new int[]{0, i};
            snakeCoordinates.add(coors);
            delay = 1000;
        }

        mainCoords = snakeCoordinates.get((int) snakeLength - 1);
        moveDirection = MoveDirections.RIGHT;
        addOnField(field);
    }

    @Override
    public void deleteFromField(Field field) {
        int[] tailCoords = snakeCoordinates.get(0);

        field.cells[tailCoords[0]][tailCoords[1]].code = Cell.EMPTY_CELL_CODE;
    }

    /**
     *
     * @param field добавляет змею на поле 
     */
    @Override
    public void  addOnField(Field field) {

        int[] snakeHeadCoords = getHeadCoords();

        for (int[] coords : getSnakeCoordinates()) {
            field.cells[coords[0]][coords[1]].setCode(Snake.CELL_CODE);
        }

        field.cells[snakeHeadCoords[0]][snakeHeadCoords[1]].code = Snake.CELL_CODE_HEAD;
        int[] tailCoords = getSnakeCoordinates().get(0);
        field.cells[tailCoords[0]][tailCoords[1]].code = Snake.CELL_CODE_TAIL;
        moved=false; 
    }

    MoveDirections getMoveDirection() {
        return moveDirection;
    }

    public void setMoveDirection(MoveDirections moveDirection) {
        if (checkDir(moveDirection)) {
            this.moveDirection = moveDirection;
        }
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
        super.moveUp();
    }

    @Override
    void moveDown() {

        super.moveDown();

    }

    @Override
    void moveLeft() {
        super.moveLeft();

    }

    @Override
    void moveRight() {
       
        super.moveRight();
       }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public synchronized void makeMove() {

        Field field = Field.getField();
        if (moveDirection == MoveDirections.DOWN) {
            moveDown();
        } else if (moveDirection == MoveDirections.UP) {
            moveUp();
        } else if (moveDirection == MoveDirections.RIGHT) {
            moveRight();
        } else if (moveDirection == MoveDirections.LEFT) {
            moveLeft();
        }
        if (field.checkOnWall(mainCoords)) {
            dies = true;

            return;
        }
        
        if ((field.cells[mainCoords[0]][mainCoords[1]].code == Snake.CELL_CODE_TAIL)
                || (field.cells[mainCoords[0]][mainCoords[1]].code == Snake.CELL_CODE)) {

            dies = true;
        
        }
        snakeCoordinates.add(mainCoords);
        if (!field.findFrog) {
            snakeCoordinates.remove(0);
        } else {
            field.findFrog=false; 
       
        }
        
      //  addOnField(field);
       
    }

    public int getLength() {
        return snakeCoordinates.size();
    }

    boolean checkDir(MoveDirections moveDir) {
        if (moveDirection == MoveDirections.DOWN & moveDir == MoveDirections.UP) {
            return false;
        }
        if (moveDirection == MoveDirections.UP & moveDir == MoveDirections.DOWN) {
            return false;
        }
        if (moveDirection == MoveDirections.LEFT & moveDir == MoveDirections.RIGHT) {
            return false;
        }
        if (moveDirection == MoveDirections.RIGHT & moveDir == MoveDirections.LEFT) {
            return false;
        }
        return true;

    }
   }
