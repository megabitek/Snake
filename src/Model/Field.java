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
    boolean change;
    public static Field field;
    public boolean findFrog;
    // int[] frogCoords;

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

    public static Field getField() {
        if (field == null) {
            field = new Field(gorizontalSize, verticalSize);
        }
        return field;
    }

    void deleteAll() {
        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                cells[i][j].code = 0;
            }
        }
    }

    public boolean checkField(Snake snake, Frog frog) {
        int[] frogCoords = frog.getMainCoords();
        int[] snakeCoords = snake.getHeadCoords();
        if ((field.cells[snakeCoords[0]][snakeCoords[1]].code == Snake.CELL_CODE_TAIL)
                || (field.cells[snakeCoords[0]][snakeCoords[1]].code == Snake.CELL_CODE)) {
            snake.snakeDies = true;
        }
        findFrog = (frogCoords[0] == snakeCoords[0]) & (snakeCoords[1] == frogCoords[1]);

        return findFrog;
    }

    /*поиск пустой ячейки для добавления лягушки */
    int[] findRandomCell() {
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

    boolean checkOnWall(int[] coords) {

        int vertSize = verticalSize;
        int gorSize = gorizontalSize;

        return (coords[0] >= vertSize || coords[0] < 0) || (coords[1] >= gorSize || coords[1] < 0);

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
