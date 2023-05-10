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

	public Goal() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/blankmarked.png"));
	}

	public void notifyObserver() {
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

	public char getID() {
		return 'g';
	};
}
