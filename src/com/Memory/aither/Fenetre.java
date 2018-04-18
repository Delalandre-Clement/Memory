package com.Memory.aither;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class Fenetre extends JFrame {
  private JPanel container = new JPanel();
  private JComboBox<String> combo = new JComboBox<String>();
  private JLabel label = new JLabel("Nombre de paire");

  public Fenetre(){
    this.setTitle("Choix taille plateau");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    String[] tab = {"2 paires", "3 paires", "4 paires", "5 paires", "6 paires"};
    combo = new JComboBox<String>(tab);
    combo.addItemListener(new ItemState());
    JPanel top = new JPanel();
    top.add(label);
    top.add(combo);
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setVisible(true);            
  }
  
  class ItemState implements ItemListener{
	    public void itemStateChanged(ItemEvent e) {
	    	Memory window = new Memory();
			window.frame.setVisible(true);
			window.frame.repaint();
	    }        
  }
}