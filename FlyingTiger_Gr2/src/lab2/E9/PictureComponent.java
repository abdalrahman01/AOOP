package lab2.E9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class PictureComponent extends JComponent {

	private BufferedImage displayedImage;
	private int size;
	private int x, y;
	private Color color;
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	
	public PictureComponent() {
		super();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(displayedImage, null, 0,0);
	}

	public BufferedImage getDisplayedImage() {
		return displayedImage;
	}
	
	public void setDisplayedImage(File fileName) throws IOException {
		displayedImage = ImageIO.read(fileName);
		repaint();
	}

	
	
	
	

}
