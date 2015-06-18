
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.Random;

/**
 *
 * @author admin
 */
public class Frog extends FieldObject {
    
    public static int frogCount;
    final static int CELL_CODE = 1;
    private int[] mainCoords;
    
    Frog(int[] coords) {
        mainCoords = coords;
    }
   boolean eatFrog(){
       
 return ((field.findFrog)&&((mainCoords[0]==field.frogCoords[0])||(mainCoords[1]==field.frogCoords[1])));
 
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
    
    void addOnField(Field field) {
        
        int[] frogCoords = getMainCoords();
        
        field.cells[frogCoords[0]][frogCoords[1]].code = Frog.CELL_CODE;
        
    }
    
    @Override
    void moveUp() {
        super.moveUp();
    }
    
    ;
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
        if (eatFrog()) super.died();
        deleteFromField(field);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
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
        addOnField(field);
      
    }
//field.addFrog(frog);



int findDirection() {
        Random rand = new Random();
        return rand.nextInt(3);
    }
    } 

