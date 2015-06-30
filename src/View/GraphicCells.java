/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GameProcess;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author admin
 */
public class GraphicCells extends JPanel implements ActionListener {

    Timer mainTimer = new Timer(1000, this);
    int cells[][];
    Image img;
    int x;
    int y;
    int count;
    //int [] frog; 

    GraphicCells(int cells[][]) {
        this.cells = cells;
        this.addKeyListener(new MyKeyAdapter());
        mainTimer.start();
        setFocusable(true);

    }

    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //     System.out.println("graphic cells Key pressed");
            GameProcess.turnSnake(e);
        }
    }

    public void setCells(int[][] cells) {
        this.cells = cells;

       repaint();
    }
    
    public void setCount (int count ){
    this.count= count; 
   // repaint();
    }

    @Override
    public void paint(Graphics g) {
       
        g = (Graphics2D) g;
        for (int i = 0; i < cells.length; i++) {
            int[] arrayRow = cells[i];
            x = (i * MainFrame.CELL_SIZE) + 7;

            for (int j = 0; j < arrayRow.length; j++) {
                y = (j * MainFrame.CELL_SIZE) + 5;
                img = new ImageIcon(findImage(arrayRow[j])).getImage();
                g.drawImage(img, y, x, null);

            }

        }
       
        g.setColor(Color.red);
        Font f = new Font("Arial",Font.BOLD, 25 );
        g.setFont(f);        
         g.clearRect(50, 300, 500, 500);
        g.drawString("Game's count: " +count, 50 , 400);
       
        
    }

    final String findImage(int cellCode) {
        switch (cellCode) {
            case 1: {
                return "res/frog.gif";

            }
            case 2: {
                return "res/snake_head.gif";

            }
            case 3: {
                return "res/snake_body.gif";

            }
            case 4: {
                return "res/snake_tail.gif";

            }
            default: {
                return "res/empty_cell.gif";
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            setFocusable(true);
            GameProcess.gameCycle();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
