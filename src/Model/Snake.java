/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Snake extends FieldObject {

    public enum MoveDirections {

        LEFT, RIGHT, UP, DOWN
    };

    final static int CELL_CODE_TAIL = 4;
    final static int CELL_CODE = 3;
    final static int CELL_CODE_HEAD = 2;

    MoveDirections moveDirection;
    public boolean snakeDies; 
    // private int[] mainCoords;
    private ArrayList<int[]> snakeCoordinates;

    public Snake(int snakeLength, Field field) {
        //новая змея создается в правом верхнем углу
        snakeCoordinates = new ArrayList();
        for (int i = 0; i < snakeLength; i++) {
            int[] coors = new int[]{0, i};
            snakeCoordinates.add(coors);

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

    @Override
    void addOnField(Field field) {

        int[] snakeHeadCoords = getHeadCoords();
        
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
        /* Field field = Field.getField();
         // cleanTailOnField();
         if (canMove(MoveDirections.UP)) {
         */ super.moveUp();/*
         if (!field.findFrog) {
         snakeCoordinates.remove(0);
         }
         field.findFrog = false;

         snakeCoordinates.add(mainCoords);
         moveDirection = MoveDirections.UP;
         } else {

         System.out.println("can't go up!");
         return;
         }

         //  addOnField(field*/

    }

    @Override
    void moveDown() {
        /*  Field field = Field.getField();
         //  cleanTailOnField();
         if (canMove(MoveDirections.DOWN)) {*/
        super.moveDown();/*
         if (!field.findFrog) {
         snakeCoordinates.remove(0);
         }
         field.findFrog = false;

         snakeCoordinates.add(mainCoords);
         moveDirection = MoveDirections.DOWN;
         } else {

         System.out.println("can't go down!");
         return;
         }

         //    addOnField(field);*/

    }

    void cleanTailOnField() {

    }

    @Override
    void moveLeft() {
     //   Field field = Field.getField();
        //   cleanTailOnField();
        // if (canMove(MoveDirections.LEFT)) {
        super.moveLeft();
         //   if (!field.findFrog) {
        //     snakeCoordinates.remove(0);
        //}
        //field.findFrog = false;
        // cleanCell(snakeCoordinates.get(0));

            //snakeCoordinates.add(mainCoords);
        //moveDirection = MoveDirections.LEFT;
        /*} else {

         System.out.println("can't go down!");
         return;
         }

         /// addOnField(field);*/
    }

    @Override
    void moveRight() {
        //Field field = Field.getField();
        //  cleanTailOnField();
        // if (canMove(MoveDirections.RIGHT)) {
        super.moveRight();
            //field.cleanCell(snakeCoordinates.get(0));
        //   if (!field.findFrog) {
        // snakeCoordinates.remove(0);
        // }
            /*field.findFrog = false;

         snakeCoordinates.add(mainCoords);
         moveDirection = MoveDirections.RIGHT;
         } else {

         System.out.println("can't go down!");
         return;
         }*/

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
        if (field.checkOnWall(mainCoords) ){
            snakeDies=true; 
            System.out.println("Snake dies");
            return;}
        snakeCoordinates.add(mainCoords);
        if (!field.findFrog) 
        snakeCoordinates.remove(0);
       // else 
         //   JOptionPane.showMessageDialog(null, "snake eat frog");
     
        addOnField(field);
        field.findFrog=false; 

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
