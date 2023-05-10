/**
 * 
 */
package sokobon.GameObjects;

import java.io.File;

import sokobon.GameObject;

/**
 * @author Abd Alrahman
 *
 */
public class Floor extends GameObject {

	public Floor() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/floor.png"));
	}

	public char getID() {
		return ' ';
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
