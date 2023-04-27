package lab2.E9;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class PictureComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private BufferedImage displayedImage;
	
	public PictureComponent() {
		setSize(200,200);
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		g2.fillRect(10, 10, 50, 50);
		if (displayedImage == null)
			g2.draw(new Rectangle.Double(0,0,200,200));
			
		else 
			g2.drawImage(displayedImage, null, 0,0);
	}
	
	public void setDisplayedImage(File fileName) throws IOException {
		displayedImage = ImageIO.read(fileName);
		repaint();
	}
	
	
	
	
	
	

}
