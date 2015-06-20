/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Field;
import View.MainFrame;

/**
 *
 * @author admin
 */
public class GameProcess {
    
    public static  void startApp(int snakeLenght, int frogCount){
     
    Field field = new Field(Field.gorizontalSize, Field.verticalSize);// сначала нарисовали пустое поле
        int[][] fieldCells = field.getCells();
        MainFrame mainFrame = new MainFrame(fieldCells);
        mainFrame.gCells.setCells(fieldCells);
//MainFrame  mainFrame=new MainFrame(Field.getCells());
    
    }

   public static void gameBegin() {
        
        //запускается процессы змеи и лягушки; 
        
    }
void initView(){}
void gameCicle(){}


void turnSnakeUp(){}
void turnSnakeDown(){}
void turnSnakeLeft(){}
void turnSnakeRight(){}}