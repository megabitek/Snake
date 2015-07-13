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
public class Field {

    public static int gorizontalSize;
    public static int verticalSize;
    Cell[][] cells;
    public static Field field;
    public boolean findFrog;

    private Field(int gorizontalSize, int verticalSize) {

        cells = new Cell[gorizontalSize][verticalSize];
        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                cells[i][j] = new Cell();
            }
        }
        this.gorizontalSize = gorizontalSize;
        this.verticalSize = verticalSize;

    }

    public static synchronized Field getField() {
        if (field == null) {
            field = new Field(gorizontalSize, verticalSize);
        }
        return field;
    }

    public void deleteAll() {
        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                cells[i][j].code = 0;
            }
        }
    }

    public synchronized void checkField(Snake snake, Frog frog) {
        int[] frogCoords = frog.getMainCoords();
        int[] snakeCoords = snake.getHeadCoords();

        if ((frogCoords[0] == snakeCoords[0]) & (snakeCoords[1] == frogCoords[1])) {
            frog.dies = true;
            findFrog = true;
        }

    }

    synchronized int[] findRandomCell() {
        Random rand = new Random();
        int gorizontalCoord;
        int verticalCoord;
        do {
            gorizontalCoord = rand.nextInt(gorizontalSize);
            verticalCoord = rand.nextInt(verticalSize);
        } while (cells[gorizontalCoord][verticalCoord].code != Cell.EMPTY_CELL_CODE);
        int[] randomCell = new int[]{gorizontalCoord, verticalCoord};

        return randomCell;

    }

    synchronized boolean checkOnWall(int[] coords) {

        int vertSize = verticalSize;
        int gorSize = gorizontalSize;

        return (coords[0] >= gorSize || coords[0] < 0) || (coords[1] >= vertSize || coords[1] < 0);

    }

    public int[][] getCells() {
        int[][] cellsArray = new int[gorizontalSize][verticalSize];
        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                cellsArray[i][j] = cells[i][j].code;
            }
        }
        return cellsArray;
    }

    public void printField() {
        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                if (cells[i][j].code == 0 && 1 == 1) {
                    System.out.print("\u00B7");
                } else {
                    System.out.print(cells[i][j]);
                }
            }
            System.out.println();
        }
    }

}
