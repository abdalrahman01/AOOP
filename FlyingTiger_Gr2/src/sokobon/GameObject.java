package sokobon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

/**
Super class for the whole code
 */

import javax.swing.JLabel;

public abstract class GameObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int posX, posY;
	private int width, height;
	private JLabel icon;
	private char id;

	public int getPosX() {
		return posX;
	}

	public GameObject() {
		icon = new JLabel("Empty");
	}

	/**
	 * Set the x coordinate for the object
	 * 
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Set the y coordinate for the object
	 * 
	 * @return
	 */
	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Get the width of the object
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set the width for the object
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Get the height of the object
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set the height for the object
	 * 
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Get the image or icon of the object
	 * 
	 * @return
	 */
	public JLabel getIcon() {
		return icon;
	}

	/**
	 * Set the icon or image for the object
	 * 
	 * @param icon
	 */
	public void setIconGameObject(File img) {

		BufferedImage displayedImage = null;
		try {
			displayedImage = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
		}

		icon.setIcon(new ImageIcon(displayedImage)); // label
		icon.setText("");

	}

	@Override
	public String toString() {
		return "" + getID();
	}

	/**
	 * These four class move the object in the four direction
	 */
	public abstract char getID();

	public abstract void moveUp();

	public abstract void moveDown();

	public abstract void moveLeft();

	public abstract void moveRight();

}
