package lab2.E9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Picture2Component extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private BufferedImage displayedImage;
	
	@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		g2.fillRect(10, 10, 50, 50);
		if (displayedImage == null)
			g2.draw(new Rectangle.Double(0,0,200,200));
			
		else 
			g2.drawImage(displayedImage, null, 0,0);
	}
	
	public void setDisplayedImage(File fileName) {
		try {
			displayedImage = ImageIO.read(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
}
