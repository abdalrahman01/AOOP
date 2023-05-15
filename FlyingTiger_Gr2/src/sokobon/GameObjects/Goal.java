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
		id = 'g';
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/blankmarked.png"));
	}

	public Goal(int row, int col) {
		this();
		posCol = col;
		posRow = row;
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

}