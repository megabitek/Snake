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
public class Field {
public  int gorizontalSize; 
public  int verticalSize; 
Cell[][] cells; 

Field(int gorizontalSize, int verticalSize){
    cells = new Cell[gorizontalSize][verticalSize]; 
    for (int i = 0; i<gorizontalSize; i++){
    for(int j=0; j<verticalSize; j++){
    cells[i][j]=new Cell(); 
    }
    }
    this.gorizontalSize=gorizontalSize; 
    this.verticalSize=verticalSize;
    
}

void addSnake(Snake snake){
for (int[] coors:snake.snakeCoordinates){
cells[coors[0]][coors[1]].setCode(Snake.CELL_CODE);
}}




void printField( ){
    for (int i = 0; i<gorizontalSize; i++){
    for(int j=0; j<verticalSize; j++){
    System.out.print(cells[i][j]); 
    }
    System.out.println();}
}
}
