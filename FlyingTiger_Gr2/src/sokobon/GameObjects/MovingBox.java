package sokobon.GameObjects;

import java.io.File;

import sokobon.GameBox;
import sokobon.GameObject;

public class MovingBox extends GameObject implements GameBox {

	private char id;

	public MovingBox() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/crate.png"));
	}

	public MovingBox(int row, int col) {
		this();
		setPosCol(col);
		setPosRow(row);
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

	public char getID() {
		return id;
	}

	public void setID(char id) {
		this.id = id;
	}
}
