/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GameProcess;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author admin
 */
public class GraphicCells extends JPanel implements ActionListener{
Timer mainTimer = new Timer(1000, this);  
int cells[][]; 
Image img; 
int x;
int y; 
GraphicCells(int cells[][]){
 this.cells = cells;  
 mainTimer.start();
    

}


    public void setCells(int[][] cells){
    this.cells=cells; 
    repaint();}

    @Override
    public void paint(Graphics g) {
        g = (Graphics2D) g;
        
         for (int i = 0; i < cells.length; i++) {
            int[] arrayRow = cells[i];
            x=(i*MainFrame.CELL_SIZE)+7; 
           
            for (int j = 0; j < arrayRow.length; j++) {
                y=(j*MainFrame.CELL_SIZE)+5;
                img= new ImageIcon(findImage(arrayRow[j])).getImage();
                g.drawImage(img, y, x, null);
               
            }

        }
        
    }

    final String findImage(int cellCode) {
        switch (cellCode){
            case 1: {
                return "res/frog.gif";
               
            }
            case 2: {
                return "res/snake_head.gif";
                
            }
            case 3:
            {return "res/snake_body.gif";
            
            }
            case 4:{
            return "res/snake_tail.gif";
            
            }
            default:{
            return "res/empty_cell.gif";
             }
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    try {
        GameProcess.gameCycle();
    } catch (InterruptedException ex) {
       ex.printStackTrace();
    }
}

   
}
