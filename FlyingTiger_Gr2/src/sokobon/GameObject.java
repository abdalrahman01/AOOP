package sokobon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
Super class for the whole code
 */

import sokobon.views.GameMap;

public abstract class GameObject {
	private static final long serialVersionUID = 1L;

	/**
	 * store the postion of the game object from game map. the row = y position, the
	 * col = x position
	 */
	protected int posRow, posCol;

	/**
	 * Each game object has a reference to game map. This will make the game object
	 * aware of its neighbors.
	 */
	public GameMap gameMap;

	/**
	 * The GraphPresenter.java need a BufferedImage to paint the GameObject.
	 */
	private BufferedImage bufferedImage;

	/**
	 * Only used by GraphPresenter.java to paint the GameObject with swing
	 * framework.
	 * 
	 * @return the bufferedImage
	 */
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	/**
	 * Very important! this is used by the whole game engine and logic to
	 * distinguish between GameObject without the need of use (instancof)
	 */
	protected char id;

	/**
	 * GameMap acts as the interface between GameObject and DataModel.java
	 * 
	 * @param gameMap A GameMap.java object
	 */
	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	/**
	 * the row number = the position in the y-axes
	 * 
	 * @return the row number
	 */
	public int getPosRow() {
		return posRow;
	}

	/**
	 * Set the y coordinate for the GameObject
	 * 
	 * @param posRow int must be between (0-[height/rows])
	 */
	public void setPosRow(int posRow) {
		this.posRow = posRow;
	}

	/**
	 * get the x coordinate for the object
	 * 
	 * @return the col number
	 */
	public int getPosCol() {
		return posCol;
	}

	/**
	 * Set the x coordinate for the GameObject
	 * 
	 * @param posCol int must be between (0-[width/cols])
	 */
	public void setPosCol(int posCol) {

		this.posCol = posCol;
	}

	/**
	 * Set the icon and bufferd image for the GameObject
	 * 
	 * @param the file should be of type .png or .jpeg
	 */
	public void setIconGameObject(File img) {

		bufferedImage = null;
		try {

			bufferedImage = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return "" + getID();
	}

	/**
	 * @return the id of the GameObject of type char
	 */
	public char getID() {
		return id;
	}

	/**
	 * change id of GameObject
	 * 
	 * @param id char value:
	 */
	public void setID(char id) {
		this.id = id;
	}

	/**
	 * must return true if GameObject has moved in that direction, the
	 * movement is defined by the user.
	 * 
	 * @return true if GameObject has moved
	 *         false otherwise
	 */
	public abstract boolean moveUp();

	/**
	 * must return true if GameObject has moved in that direction, the
	 * movement is defined by the user.
	 * 
	 * @return true if GameObject has moved
	 *         false otherwise
	 */
	public abstract boolean moveDown();

	/**
	 * must return true if GameObject has moved in that direction, the
	 * movement is defined by the user.
	 * 
	 * @return true if GameObject has moved
	 *         false otherwise
	 */
	public abstract boolean moveLeft();

	/**
	 * must return true if GameObject has moved in that direction, the
	 * movement is defined by the user.
	 * 
	 * @return true if GameObject has moved
	 *         false otherwise
	 */
	public abstract boolean moveRight();

}
