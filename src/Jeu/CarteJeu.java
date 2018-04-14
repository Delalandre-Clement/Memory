package Jeu;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.net.URL;

public class CarteJeu extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int etat;
	private Image imgCache;
	
	public static final int ETAT_DEFAULT = 0;
	public static final int ETAT_RETOURNE = 1;
	public static final int ETAT_TROUVE = 2;
	
	
	/**
	 * Default Constructor
	 */
	public CarteJeu(){
		this.etat = ETAT_DEFAULT;
		this.setVisible(true);
	}
	
	/**
	 * Advance Constructor
	 * @param x
	 * @param y
	 * @param numImage
	 */
	public CarteJeu(String text, int numImage){
		super(text);
		this.etat = ETAT_DEFAULT;
		
		URL ressourceImage;
		
		ressourceImage = getClass().getResource("/ressources/" + numImage + ".png");
		
		try {
			imgCache = ImageIO.read(ressourceImage);
		} catch (IOException e) {
		}
		
		this.setVisible(true);
		this.setIcon(null);
	}
	

	
	
	/*
	 * Getter and Setter
	 */
	
	public Image getImgCache() {
		return imgCache;
	}
	public void setImgCache(Image imgCache) {
		this.imgCache = imgCache;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public int getEtat(){
		return this.etat;
	}
	
	public void setEtat1(int etat){
		this.etat = etat;
		switch (etat) {
		case ETAT_DEFAULT:
			setIcon(null);
			break;
		case ETAT_RETOURNE : 
			setIcon(new ImageIcon(imgCache));
			break;
		default:
			setIcon(null);
			break;
		}
	}
	
}
