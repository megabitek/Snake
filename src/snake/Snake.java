/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Snake {

    static int snakeFirstLenght;
    final static int CELL_CODE = 2;
    int[] headCoords; 

    ArrayList<int[]> snakeCoordinates;

    Snake(int snakeLength) {
        //новая змея создается в правом верхнем углу
        snakeCoordinates=new ArrayList();
        for (int i = 0; i < snakeLength; i++) {
            int[] coors = new int[]{0, i};
            snakeCoordinates.add(coors);

        }
        headCoords=snakeCoordinates.get((int)snakeLength-1); 
    }

    ;
    
    
    

    ;
    /*when snake moves up, movedown not avaliable*/
    void moveUp() {
     int[] newCoords=new int[]{headCoords[0]-1, headCoords[1]};  
    if (canMove(newCoords)){
     snakeCoordinates.remove(0);
     snakeCoordinates.add(newCoords); 
    }
    this.headCoords=newCoords; 
    }

    ;
    
    
    void moveDown() {
        

    }

    ;
    
    /*when snake moves left, moveRight not avaliable*/
    void moveLeft() {

    }

    ;
    void moveRight() {

    }

    ;
    /*snake grow when eat frog*/
    void grow(int[] frogCoordinates) {

    }
    
   boolean canMove(int [] newCoords){
       
        return (!snakeCoordinates.contains(newCoords));
           
        
        
        
   }

    /**
     * @param args the command line arguments
     */
}
