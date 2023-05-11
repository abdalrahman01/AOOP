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

import sokobon.views.GameMap;

public abstract class GameObject implements Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int posRow;
	public GameMap gameMap;

	protected int posCol;
	private int width, height;
	private JLabel icon;

	protected static char id;

	public GameMap getGameObjectFromGameMap(int row, int col) {

		return gameMap;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public int getPosRow() {
		return posRow;
	}

	public GameObject() {
		icon = new JLabel("Empty");
	}

	/**
	 * Set the y coordinate for the object
	 * 
	 * @param posRow
	 */
	public void setPosRow(int posRow) {
		this.posRow = posRow;
	}

	/**
	 * Set the x coordinate for the object
	 * 
	 * @return
	 */
	public int getPosCol() {
		return posCol;
	}

	public void setPosCol(int posCol) {

		this.posCol = posCol;
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
	public char getID() {
		return id;
	}

	public void setID(char id) {
		this.id = id;
	}

	public static char id() {
		return id;
	}

	public abstract boolean moveUp();

	public abstract boolean moveDown();

	public abstract boolean moveLeft();

	public abstract boolean moveRight();

	public GameObject clone() {
		try {
			return (GameObject) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
