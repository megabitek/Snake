/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class View extends JPanel {

    public int[][] field;

    public GraphicCells gCells;
    public JButton start;
    public JButton stop;
    JButton exit;
    public static final int CELL_SIZE = 23;

    public View(int[][] cells) {
        this.field = cells;
        JFrame mainFrame = new JFrame("Java Snake");

        start = new JButton("Start");
        start.setLocation(420, 10);
        start.setSize(70, 40);
        mainFrame.add(start);
        start.addActionListener((ActionEvent e) -> {

            Controller.turnGame();
            gCells.requestFocusInWindow();

        });
        stop = new JButton("Stop");
        stop.setLocation(420, 80);
        stop.setSize(70, 40);
        mainFrame.add(stop);
        stop.addActionListener((ActionEvent e) -> {
            Controller.stopGame();
            
        });
        exit = new JButton("Exit");
        exit.setLocation(420, 160);
        exit.setSize(70, 40);
        mainFrame.add(exit);
        exit.addActionListener((ActionEvent event) -> {
            JOptionPane.showMessageDialog(exit, "Goodbye!", "OK", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        });

        mainFrame.setSize(500, 500);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gCells = new GraphicCells(field);
        gCells.newGame = true;
        mainFrame.add(gCells);

        mainFrame.setVisible(true);

    }
    
}
