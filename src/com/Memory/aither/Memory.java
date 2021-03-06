package com.Memory.aither;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import Jeu.CarteJeu;
import java.util.Timer;

public class Memory {

	JFrame frame;
	ArrayList<CarteJeu> jeuCarte = new ArrayList<CarteJeu>();
	int cpt_clic = 0;
	int cpt_carte_trouve = 0;
	CarteJeu Memoire = null;
	private static final int nombreCombinaison = 6;
	Timer chronoJeu = new Timer();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre demandetaille = new Fenetre();
					demandetaille.setVisible(true);					
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
	@SuppressWarnings("null")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 288, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		/*
		int[] tabNumeroImage = {0};
		int compteur=1;
		for(int i=0;i<11;i++){
			tabNumeroImage[i]=compteur;
			if(i%2 == 0) {
				compteur ++;
			}
		}
		*/
		int[] tabNumeroImage = {1,1,2,2,3,3,4,4,5,5,6,6};
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
	 * Lecture des �v�nements sur le bouton
	 */
	public ActionListener btnClickListener =  new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			CarteJeu jbutton = (CarteJeu)arg0.getSource();
			if(jbutton.getEtat() != (CarteJeu.ETAT_DEFAULT)) return;
			jbutton.setEtat1(CarteJeu.ETAT_RETOURNE);
			if(cpt_clic == 0) {
				//chronoJeu.start();
			}
			// 1�re ou seconde carte ?
			if( cpt_clic %2 == 1 ){
				// Carte identique (image) ?
				if(jbutton.getNumImage() == Memoire.getNumImage()) {
					jbutton.setVisible(false);
					Memoire.setVisible(false);
					cpt_carte_trouve++;
					testGagnant(cpt_carte_trouve);
				} else {
					try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					jbutton.setEtat1(CarteJeu.ETAT_DEFAULT);
					Memoire.setEtat1(CarteJeu.ETAT_DEFAULT);
				}
			}
			cpt_clic++;
			Memoire= jbutton;
		}


	};
	
	// M�lange les valeurs du tableau
	private void melangerTableau(int t[]) {
	    for (int i = 0; i < 10; i++) {    // On m�lange 10 fois
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

	private void testGagnant(int carteTrouve) {
		if(carteTrouve == nombreCombinaison) {
			javax.swing.JOptionPane.showMessageDialog(null, "Vous avez gagn� en "+ cpt_clic /2+" essais !");
			System.exit(0);
		}
		
	}
}
