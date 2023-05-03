package sokobon;


import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Player extends GameObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Player() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/player.png"));
	}
	
	public void moveUp() {};
	public void moveDown() {};
	public void moveLeft() {};
	public void moveRight() {};
	
	/**
	 * Push the object using the player  
	 */
	public void push() {};
	
	/**
	 * Pull the object using the player 
	 */
	public void pull() {};
	
	

	

}
