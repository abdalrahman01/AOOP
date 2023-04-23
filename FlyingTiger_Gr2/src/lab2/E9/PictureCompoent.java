package lab2.E9;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class PictureCompoent extends JComponent {

	private BufferedImage displayedImage;
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	
	public PictureCompoent() {
		super();
	}
	
	public void paint(Graphics g) {
		
	}

	public BufferedImage getDisplayedImage() {
		return displayedImage;
	}

	public void setDisplayedImage(BufferedImage displayedImage) {
		this.displayedImage = displayedImage;
	}

	
	
	
	

}
