/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GameProcess;
import Model.Field;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
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

        //mainFrame.setLayout(null);
        //  mainFrame.add(new MainFrame()); 
        JButton up = new JButton("up");
        up.setLocation(50, 420);
        up.setSize(50, 40);
        mainFrame.add(up);
        up.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //          GameProcess.class.gameBegin();
            }
        });
        JButton down = new JButton("dw");
        down.setLocation(120, 420);
        down.setSize(50, 40);
        mainFrame.add(down);
        down.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //          GameProcess.class.gameBegin();
            }
        });

        JButton left = new JButton("lf");
        left.setLocation(190, 420);
        left.setSize(50, 40);
        mainFrame.add(left);
        left.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //          GameProcess.class.gameBegin();
            }
        });

        JButton right = new JButton("rg");
        right.setLocation(260, 420);
        right.setSize(70, 40);
        mainFrame.add(right);
        right.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //          GameProcess.class.gameBegin();
            }
        });
        JButton start = new JButton("Start");
        start.setLocation(420, 10);
        start.setSize(70, 40);
        mainFrame.add(start);
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                try {
//               //     GameProcess.gameCycle();
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
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gCells = new GraphicCells(field);
        mainFrame.add(gCells);
        mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ev){
            GameProcess.moveSnake(ev);} ;
        });
        mainFrame.setVisible(true);

    }
}
