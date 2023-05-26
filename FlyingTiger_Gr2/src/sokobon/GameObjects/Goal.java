package sokobon.GameObjects;

import java.io.File;

import sokobon.GameObject;

/**
 * The Red circle that the boxes must come to or occur
 * 
 * @author aliab
 *
 */
// RedDots
public class Goal extends GameObject {

	/**
	 * Defines the id and the icon of the Goal object
	 */
	public Goal() {
		id = 'g';
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/blankmarked.png"));
	}

	/**
	 * the row and col refers to the position in GameMap.java
	 * 
	 * @param row the y position
	 * @param col the x position
	 */
	public Goal(int row, int col) {
		this();
		posCol = col;
		posRow = row;
	}

	public boolean moveUp() {
		return true;
	}

	public boolean moveDown() {
		return true;
	}

	public boolean moveLeft() {
		return true;
	}

	public boolean moveRight() {
		return true;
	}

}
