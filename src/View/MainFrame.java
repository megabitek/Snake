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
public class MainFrame extends JPanel{
    
    JFrame mainFrame; 
    public static final int CELL_SIZE = 22; 
    public MainFrame(int [][] cells){
    JFrame mainFrame = new JFrame("Java Snake");
    //mainFrame.setLayout(null);
  //  mainFrame.add(new MainFrame()); 
   // mainFrame.removeAll();
    mainFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
   GraphicCells gCells = new GraphicCells(cells); 
   mainFrame.add(gCells); 
   
  //  JPanel board = new JPanel();
 //   mainFrame.setLayout(null);
    
               // mainFrame.add(board);
   // GraphicField gField = new GraphicField(cells); 
//    mainFrame.add(gField); 
  // mainFrame.add (gField.paint(null));mainFrame.setSize (500, 500);
//    GraphicCell gCell = new GraphicCell(1, 30, 80);
//     mainFrame.add(gCell); 
    
/*    final JButton GO = new JButton("Start");
        GO.setLocation(400, 30);
        GO.setSize(80, 40);
        mainFrame.add(GO);
        //GraphicField gField = new GraphicField(cells); 
  //  mainFrame.add (gField.paint(null));
     
    
    final JButton exit = new JButton("Exit");
        exit.setLocation(400, 80);
        exit.setSize(80, 40);
        mainFrame.add(exit);
  
            exit.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(exit, "Goodbye!", "OK", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        });*/
    
    mainFrame.setVisible (true);
    }
    public  void drawField(int[][] field){
    

        
    }}