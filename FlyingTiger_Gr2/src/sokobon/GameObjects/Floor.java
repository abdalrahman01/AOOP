/**
 * @author Abd Alrahman
 *
 */
package sokobon.GameObjects;

import java.io.File;
import sokobon.GameObject;

public class Floor extends GameObject {

	/**
	 * Defines the id and the icon of the Floor object
	 */
	public Floor() {
		id = ' ';
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/blank.png"));
	}

	/**
	 * the row and col refers to the position in GameMap.java
	 * 
	 * @param row the y position
	 * @param col the x position
	 */
	public Floor(int row, int col) {
		this();
		posCol = col;
		posRow = row;
	}

	public char getID() {
		return id;
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
