/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class Frame {
    
    Frame(){
    JFrame mainFrame = new JFrame("Java Snake");
    mainFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize (500, 200);
    mainFrame.add (new GraphicCell());
    mainFrame.setVisible (true);}
    
}
