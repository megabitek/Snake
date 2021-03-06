/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin
 */
public class FieldObject implements Runnable {

    int[] mainCoords;
    int delay;
    public boolean moved;
    public boolean dies;
    static int CELL_CODE;

    public void addOnField(Field field) {
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
        Field field = Field.getField();
        deleteFromField(field);

        int[] newCoords = new int[]{mainCoords[0] - 1, mainCoords[1]};
        this.mainCoords = newCoords;

    }

    void moveDown() {

        Field field = Field.getField();
        deleteFromField(field);
        int[] newCoords = new int[]{mainCoords[0] + 1, mainCoords[1]};
        this.mainCoords = newCoords;
    }

    void moveLeft() {
        Field field = Field.getField();
        deleteFromField(field);
        int[] newCoords = new int[]{mainCoords[0], mainCoords[1] - 1};

        this.mainCoords = newCoords;

    }

    void moveRight() {
        Field field = Field.getField();
        deleteFromField(field);
        int[] newCoords = new int[]{mainCoords[0], mainCoords[1] + 1};

        this.mainCoords = newCoords;
    }

    public synchronized void makeMove() {
    }

    ; 

    @Override
    public void run() {

        while (true) {
            try {
                if (dies) {
                    break;
                }

                Thread.sleep(delay);
                makeMove();
                this.moved = true;

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }
}
