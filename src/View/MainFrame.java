/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Field;
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
int [][] field; 
GraphicCells gCells; 
JFrame mainFrame;
    public static final int CELL_SIZE = 22;

    public MainFrame(int[][] cells) {
        this.field = cells; 
        mainFrame = new JFrame("Java Snake");
    //mainFrame.setLayout(null);
        //  mainFrame.add(new MainFrame()); 
        JButton GO = new JButton("Start");
        GO.setLocation(400, 30);
        GO.setSize(80, 40);
        mainFrame.add(GO);

        JButton exit = new JButton("Exit");
        exit.setLocation(400, 80);
        exit.setSize(80, 40);
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

  //  JPanel board = new JPanel();
        //   mainFrame.setLayout(null);
               // mainFrame.add(board);
        // GraphicField gField = new GraphicField(cells); 
//    mainFrame.add(gField); 
        // mainFrame.add (gField.paint(null));mainFrame.setSize (500, 500);
//    GraphicCell gCell = new GraphicCell(1, 30, 80);
//     mainFrame.add(gCell); 
//        JButton GO = new JButton("Start");
//        GO.setLocation(400, 30);
//        GO.setSize(80, 40);
//        mainFrame.add(GO);
        //GraphicField gField = new GraphicField(cells); 
        //  mainFrame.add (gField.paint(null));
        /*final JButton exit = new JButton("Exit");
         exit.setLocation(400, 80);
         exit.setSize(80, 40);
         mainFrame.add(exit);
  
         exit.addActionListener(new ActionListener() {
 
         public void actionPerformed(ActionEvent event) {
         JOptionPane.showMessageDialog(exit, "Goodbye!", "OK", JOptionPane.WARNING_MESSAGE);
         System.exit(0);
         }
         });*/
        mainFrame.setVisible(true);
    }

    public void reDrawField(int[][] field) {
       /* gField = mainFrame.r
        mainFrame.remove(gField);*/
               gCells = new GraphicCells(field);
       mainFrame.add(gCells);
    }
}
