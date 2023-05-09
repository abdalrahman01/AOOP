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

	public void moveUp() {
	}

	public void moveDown() {
	}

	public void moveLeft() {
	}

	public void moveRight() {
	}

}
