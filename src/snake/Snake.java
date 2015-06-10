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
public class Snake {

    final static int cellCode = 2;

    int[] headCoordinates;
    //first element of array  - gorizontal coordinate; 
    // second element - vertical coordinate; 

    int[] tailCoordinates;
    int length;

    Snake() {

    }

    ;
    
    int[] getHeadCoordinates() {
        return headCoordinates;
    }
    void setHeadCoordinates(int [] newCoordinates){
    headCoordinates[0]=newCoordinates[0];
    headCoordinates[1]=newCoordinates[1];
    }
    int[] getTailCoordinates() {
        return tailCoordinates;
    }
    void setTailCoordinates(int [] newCoordinates){
    tailCoordinates[0]=newCoordinates[0];
    tailCoordinates[1]=newCoordinates[1];
    }
    

    ;
    /*when snake moves up, movedown not avaliable*/
    void moveUp() {
        headCoordinates[1]--;
    }

    ;
    
    
    void moveDown() {
        headCoordinates[1]++;
    }

    ;
    
    /*when snake moves left, moveRight not avaliable*/
    void moveLeft() {
        headCoordinates[0]--;
    }

    ;
    void moveRight() {
        headCoordinates[0]++;
    }

    ;
    /*snake grow when eat frog*/
    void grow(int[] frogCoordinates) {
        
    }

    /**
     * @param args the command line arguments
     */
}
