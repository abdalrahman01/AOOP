package sokobon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class MovingBox extends GameObject implements GameBox {
	
	
	public void moveUp() {};
	public void moveDown() {};
	public void moveLeft() {};
	public void moveRight() {};
	
	/**
	 * If the box has Reached the the right place
	 * @return
	 */
	public boolean hasReachedRedDot() {return true;};
	
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		File imageMovingBox = new File ("src/sokobon/resources/imgs/sokoban_icons/crate.png");
		BufferedImage displayedImage = null;
		try {
			displayedImage = ImageIO.read(imageMovingBox);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			g2.drawImage(displayedImage, null, 0,0);
	}
	
}
