/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import snake.Snake.*;

/**
 *
 * @author admin
 */
public class SnakeThread implements Runnable {

    @Override
    public void run() {
        try {
            Snake snake = new Snake(2);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            
            while (true) {
                char command = (char) in.read();
                switch (command){ 
                    case 'w': {
                        snake.setMoveDirection(MoveDirections.UP);
                       
                        break;

                    }
                    case 'a':{
                    snake.setMoveDirection(MoveDirections.LEFT);
                    
                    break; 
                    }
                    case 'd':{
                    snake.setMoveDirection(MoveDirections.RIGHT);
                   break;
                    }
                   

                }
                makeMove(snake); 
                
            }
            
            /*  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             char command='';
             switch(command){
             case 'w': {
             snake.moveUp();
             break; }
             case 'a':}
               
             }*/
        } catch (IOException ex) {
            Logger.getLogger(SnakeThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void makeMove(Snake snake) {
        if (snake.moveDirection == MoveDirections.DOWN) {
            snake.moveDown();
        } else if (snake.moveDirection == MoveDirections.UP) {
            snake.moveUp();
        } else if (snake.moveDirection == MoveDirections.RIGHT) {
            snake.moveRight();
        } else if (snake.moveDirection == MoveDirections.LEFT) {
            snake.moveLeft();
        }
    }

}
