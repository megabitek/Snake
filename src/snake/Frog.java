
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
public class Frog {

    public static int frogCount;
    final static int CELL_CODE_FROG = 1;
    private int[] frogCoords;

    Frog(int[] coords) {
        frogCoords = coords;
    }

    int[] getFrogCoords() {
        return frogCoords;
    }

    void setFrogCoords(int[] frogCoords) {
        this.frogCoords = frogCoords;
    }

    void jumpUp() {
    }

    ;
    void jumpDown() {
    }

    ;
    void jumpRight() {
    }

    void jumpLeft() {
    }
}
