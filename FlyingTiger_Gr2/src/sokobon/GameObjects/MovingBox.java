package sokobon.GameObjects;

import java.io.File;

import sokobon.GameBox;
import sokobon.GameObject;

public class MovingBox extends GameObject implements GameBox {

	public MovingBox() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/crate.png"));
	}

	public void moveUp() {
		posRow--;
	};

	public void moveDown() {
		posRow++;
	};

	public void moveLeft() {
		posCol--;
	};

	public void moveRight() {
		posCol++;
	};

	/**
	 * If the box has Reached the the right place
	 * 
	 * @return
	 */
	public boolean hasReachedRedDot() {
		return true;
	}

	@Override
	public char getID() {
		return 'o';
	};
}
