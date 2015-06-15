/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import graphic.GraphicCell;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class SnakeGame {

    static int snakeFirstLenght;
    static int frogCount;
    static int fieldSizeGorizontal;
    static int fieldSizeVertical;

    public static void main(String[] args) throws IOException, InterruptedException {

        // TODO code application logic here
        /*JFrame mainFrame = new JFrame("Java Snake");
         mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainFrame.setSize(1100, 600);
         mainFrame.add(new GraphicCell());
         mainFrame.setVisible(true);
         */
        Field field = new Field(5, 6);
        field.printField();
        /*Snake snake = new Snake(3);
         field.addSnake(snake);
         field.printField();
     
         snake.moveDown();
         field.addSnake(snake);
         field.printField();
     
         snake.moveLeft();     
         field.addSnake(snake);
         field.printField();
     
         snake.moveRight();     
         field.addSnake(snake);
         field.printField();
     
         snake.moveDown();     
         field.addSnake(snake);
         field.printField();
     
         snake.moveRight();     
         field.addSnake(snake);
         field.printField();
     
         snake.moveDown();
         int[] frogCoordinates = field.findRandomCell(); 
         Frog frog= new Frog(frogCoordinates);
         field.addFrog(frog);
         field.printField();
         */
        Snake snake = new Snake(2);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
       //     char command = (char) in.read();
//            switch (command) {
//                case 'w': {
//                    snake.setMoveDirection(Snake.MoveDirections.UP);
//
//                    break;
//
//                }
//                case 'a': {
//                    snake.setMoveDirection(Snake.MoveDirections.LEFT);
//
//                    break;
//                }
//                case 'd': {
//                    snake.setMoveDirection(Snake.MoveDirections.RIGHT);
//                    break;
//                }
//                case 's': {
//                    snake.setMoveDirection(Snake.MoveDirections.DOWN);
//                }
//                default:{
//                    makeMove(snake);
//                    break; 
//                }
//            }
            Thread.sleep(1000);
            makeMove(snake); 
            field.addSnake(snake);
            field.printField();

        }
    }

    public static void makeMove(Snake snake) {
        if (snake.moveDirection == Snake.MoveDirections.DOWN) {
            snake.moveDown();
        } else if (snake.moveDirection == Snake.MoveDirections.UP) {
            snake.moveUp();
        } else if (snake.moveDirection == Snake.MoveDirections.RIGHT) {
            snake.moveRight();
        } else if (snake.moveDirection == Snake.MoveDirections.LEFT) {
            snake.moveLeft();
        }
    }
}
