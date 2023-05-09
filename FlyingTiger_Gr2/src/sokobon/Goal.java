package sokobon;

import java.io.File;

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

	public void moveUp() {
	}

	public void moveDown() {
	}

	public void moveLeft() {
	}

	public void moveRight() {
	}

	public char getID() {
		return 'g';
	};
}
