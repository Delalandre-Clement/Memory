package com.Memory.aither;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import Jeu.CarteJeu;


public class Memory {

	private JFrame frame;
	ArrayList<CarteJeu> jeuCarte = new ArrayList<CarteJeu>();
	int cpt_clic = 0;
	int cpt_carte_trouve = 0;
	CarteJeu Memoire = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memory window = new Memory();
					window.frame.setVisible(true);
					window.frame.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Memory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 288, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		int tabNumeroImage[]={1,1,2,2,3,3,4,4,5,5,6,6};
		ArrayList<CarteJeu> jeuCarte = new ArrayList<CarteJeu>();
		melangerTableau(tabNumeroImage);
		
		for(int i=0;i<12;i++) {
			CarteJeu carte = new CarteJeu("",  tabNumeroImage[i]);
			carte.addActionListener(btnClickListener);
			jeuCarte.add(carte);
			frame.getContentPane().add(carte);
		}
	}
	
	/*
	 * Lecture des évènements sur le bouton
	 */
	public ActionListener btnClickListener =  new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			CarteJeu jbutton = (CarteJeu)arg0.getSource();
			if(jbutton.getEtat() != (CarteJeu.ETAT_DEFAULT)) return;
			jbutton.setEtat1(CarteJeu.ETAT_RETOURNE);
			if( cpt_clic %2 == 1 ){
				if(jbutton.getImgCache().equals(Memoire.getImgCache()) ) {
					jbutton.setVisible(false);
					Memoire.setVisible(false);
				} else {
					jbutton.setEtat1(CarteJeu.ETAT_DEFAULT);
					Memoire.setEtat1(CarteJeu.ETAT_DEFAULT);
				}
			}
			cpt_clic++;
			Memoire= jbutton;
		}
	};
	
	// Mélange les valeurs d'un tableau
	private void melangerTableau(int t[]) {
	    for (int i = 0; i < 10; i++) {    // On mélange 10 fois
	        for (int j = 0; j < t.length; j++) {
	            int r = (int) random(0, t.length);
	            int tmp = t[j];
	            t[j] = t[r];
	            t[r] = tmp;
	        }
	    }
	}
	
	private static double random(double min, double max) {
	    return min + Math.random() * (max - min);
	}

}
