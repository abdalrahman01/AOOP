package lab2.E9;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(displayedImage, null, 0,0);
	}

	public BufferedImage getDisplayedImage() {
		return displayedImage;
	}

	public void setDisplayedImage(File fileName) {
		try {
			displayedImage = ImageIO.read(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	

}
