/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author admin
 */
public class FieldObject implements Runnable {

    Field field;
    Field Object;
    private int[] mainCoords;
    static int CELL_CODE;

    void addOnField(Field field) {
    }

    void deleteFromField(Field field) {
        
    }
   int[] getMainCoords() {
        return mainCoords;
    }

    void setMainCoords(int[] frogCoords) {
        this.mainCoords = frogCoords;
    }

    void moveUp() {
        if  (checkOnWall(mainCoords)) return;
        int[] newCoords = new int[]{mainCoords[0] - 1, mainCoords[1]};
        this.mainCoords = newCoords;
    }

    void moveDown() {
        if  (checkOnWall(mainCoords)) return;
        int[] newCoords = new int[]{mainCoords[0] + 1, mainCoords[1]};
        this.mainCoords = newCoords;
    }

    void moveLeft() {
    if  (checkOnWall(mainCoords)) return;
        int[] newCoords = new int[]{mainCoords[0], mainCoords[1]-1};
        this.mainCoords = newCoords;
    }

    void moveRight() {
        if  (checkOnWall(mainCoords)) return;
        int[] newCoords = new int[]{mainCoords[0], mainCoords[1]+1};
        this.mainCoords = newCoords;
    
    }

    boolean checkOnWall(int[] coords) {
        int vertSize = field.verticalSize;
        int gorSize = field.gorizontalSize;

        return (coords[0] >= vertSize || coords[0] < 0) || (coords[1] >= gorSize || coords[1] < 0);

    }

    @Override
    public void run() {
        
    }
    public void died(){
    //нужно остановить поток
    }


}
