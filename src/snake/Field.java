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
public static int gorizontalSize; 
public static int verticalSize; 
Cell[][] cells; 


// если координата хвоста змеи пуста, ну то есть в этой ячейке не стоит код змеи, 
//то следовательно, змея появилась первый раз, рисуем ее горизонтальную,с началом в правом верхнем углу  
// с хвостом в координате 0,0, 
//иначе, меняем координату головы змеи и координату хвоста змеи оставляем пустой ячейкой. 
void drawSnake (Snake snake){
    if (cells[snake.tailCoordinates[0]][snake.tailCoordinates[1]].getCode()!= Snake.cellCode)
    {
        for (int i=0; i<snake.length; i++){
         cells[0][i].code=Snake.cellCode;    
        }
    } 
    else cells[snake.headCoordinates[0]][snake.headCoordinates[1]].setCode(Snake.cellCode); 
        

}


}
