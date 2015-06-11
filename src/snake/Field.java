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
    void deleteAll(){
        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                cells[i][j].code=0;
            }
        }
    }

    void addSnake(Snake snake) {
        deleteAll(); 
        if (isWall(snake)) {
            System.out.println("Wall");
        } else {
            for (int[] coords : snake.getSnakeCoordinates()) {
                cells[coords[0]][coords[1]].setCode(Snake.CELL_CODE_BODY);
            }
            int[] snakeHeadCoords =snake.getHeadCoords();
            cells[snakeHeadCoords[0]][snakeHeadCoords[1]].code=Snake.CELL_CODE_HEAD;
            int[] tailCoords = snake.getSnakeCoordinates().get(0);
            cells[tailCoords[0]][tailCoords[1]].code=Snake.CELL_CODE_TAIL;
            
        }
    }
    
     int [] findRandomCell(){
         Random rand = new Random(); 
         int gorizontalCoord; 
         int verticalCoord; 
         do {
         gorizontalCoord= rand.nextInt(gorizontalSize+1)-1;
         verticalCoord= rand.nextInt(verticalSize+1)-1; }
         while (cells[gorizontalCoord][verticalCoord].code != Cell.EMPTY_CELL_CODE) ;
        int[] randomCell = new int[]{gorizontalCoord, verticalCoord};
         
       return randomCell ;
      
  }

     void addFrog(Frog frog) {
         cells[frog.frogCoords[0]][frog.frogCoords[1]].code=Frog.CELL_CODE_FROG;
     }
             
    boolean isWall(Snake snake) {
        int [] snakeHeadCoords= snake.getHeadCoords(); 
        return (snakeHeadCoords[0] >= verticalSize || snakeHeadCoords[0] < 0) || (snakeHeadCoords[1] >= gorizontalSize & snakeHeadCoords[1] < 0);
    }


void printField() {
        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                 if (cells[i][j].code == 0 && 1==1) {
                    System.out.print("\u00B7");
                }
                else{
                    System.out.print(cells[i][j]);
                }
            }
        System.out.println();
        }
}}
    