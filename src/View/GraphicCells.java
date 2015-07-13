/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import static Model.Field.gorizontalSize;
import static Model.Field.verticalSize;
import Model.SnakeGame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author admin
 */
public class GraphicCells extends JPanel implements ActionListener {

    Timer mainTimer = new Timer(SnakeGame.snakeDelay / 10, this);
    int cells[][];
    Image img;
    int x;
    int y;
    int count;
    public boolean newGame;
    private ArrayList<int[]> changeCells;

    GraphicCells(int cells[][]) {
        this.cells = cells;
        addKeyListener(new MyKeyAdapter());
        mainTimer.start();
        changeCells = new ArrayList<>();
        setFocusable(true);

    }

    public void setCells(int[][] cells, ArrayList<int[]> changeCells) {
        this.cells = cells;
        this.changeCells = changeCells;
        repaint();
    }

    public void setCount(int count) {
        this.count = count;

    }

    @Override
    public void paint(Graphics g) {

        if (newGame) {
            drawField((Graphics2D) g);
        } else {
            reDrawField(changeCells, (Graphics2D) g);
        }
        g.setColor(Color.red);
        Font f = new Font("Arial", Font.BOLD, 25);
        g.setFont(f);
        g.clearRect(50, 420, 500, 500);
        g.drawString("Game's count: " + count, 50, 450);

    }

    void drawField(Graphics2D g) {

        for (int i = 0; i < gorizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                img = new ImageIcon(findImage(cells[i][j])).getImage();
                g.drawImage(img, j * View.CELL_SIZE, i * View.CELL_SIZE, null);
            }

        }
    }

    public void reDrawField(ArrayList< int[]> changeCells, Graphics g) {
        for (int[] changeCell : changeCells) {
            img = new ImageIcon(findImage(cells[changeCell[0]][changeCell[1]])).getImage();
            g.drawImage(img, changeCell[1] * View.CELL_SIZE, changeCell[0] * View.CELL_SIZE, null);
        }
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

            Controller.gameCycle();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private static class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            Controller.turnSnake(e);
        }
    }

}
