/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GameProcess;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class MainFrame extends JPanel {

    public int[][] field;

    public GraphicCells gCells;
    JFrame mainFrame;
    public static final int CELL_SIZE = 22;

    public MainFrame(int[][] cells) {
        this.field = cells;
        mainFrame = new JFrame("Java Snake");

       
        JButton start = new JButton("Start");
        start.setLocation(420, 10);
        start.setSize(70, 40);
        mainFrame.add(start);
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                try {
                   GameProcess.turnGame();
                   gCells.requestFocusInWindow();
                   
                   
                   
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
            }
        });
        JButton exit = new JButton("Exit");
        exit.setLocation(420, 80);
        exit.setSize(70, 40);
        mainFrame.add(exit);

        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(exit, "Goodbye!", "OK", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        });

        mainFrame.setSize(500, 500);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gCells = new GraphicCells(field);
        mainFrame.add(gCells);

        mainFrame.setVisible(true);

    }
}
