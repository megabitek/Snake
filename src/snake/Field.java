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
public class Field {

    public int gorizontalSize;
    public int verticalSize;
    Cell[][] cells;
    boolean findFrog; 
    int[] frogCoords;  

    Field(int gorizontalSize, int verticalSize) {

        cells = new Cell[gorizontalSize][verticalSize];
        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                cells[i][j] = new Cell();
            }
        }
        this.gorizontalSize = gorizontalSize;
        this.verticalSize = verticalSize;

    }

    void deleteAll() {
        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                cells[i][j].code = 0;
            }
        }
    }
   void snakeFindFrog(int []snakeHeadCoords){
       this.findFrog=true;
       frogCoords=snakeHeadCoords;  
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
    
   
    void printField() {
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
