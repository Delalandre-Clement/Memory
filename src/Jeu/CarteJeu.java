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
	private Image imgDefault;
	
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
		
		URL ressourceDefault;
		URL ressourceImage;
		
		ressourceDefault = getClass().getResource("/ressources/0.png");
		ressourceImage = getClass().getResource("/ressources/" + numImage + ".png");
		
		try {
			imgDefault = ImageIO.read(ressourceDefault);
			imgCache = ImageIO.read(ressourceImage);
		} catch (IOException e) {
		}
		
		this.setVisible(true);
		this.setIcon(null);
	}
	
	
	public void setEtat1(int etat){
		this.etat = etat;
		switch (etat) {
		case ETAT_DEFAULT:
			setIcon(new ImageIcon(imgDefault));
			break;
		case ETAT_RETOURNE : 
			setIcon(new ImageIcon(imgCache));
			break;
		default:
			setIcon(null);
			break;
		}
	}
	
	
	/*
	 * Getter and Setter
	 */
	
	public Image getImgDefault() {
		return imgDefault;
	}
	public void setImgDefault(Image imgDefault) {
		this.imgDefault = imgDefault;
	}
	public Image getImgCache() {
		return imgCache;
	}
	public void setImgCache(Image imgCache) {
		this.imgCache = imgCache;
	}

	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
}
