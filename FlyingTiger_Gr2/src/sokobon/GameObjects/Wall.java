package sokobon.GameObjects;

import java.io.File;

import sokobon.GameBox;
import sokobon.GameObject;

public class Wall extends GameObject implements GameBox {

	private static final long serialVersionUID = 1L;

	public Wall() {
		id = '#';
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/wall.png"));
	}

	public Wall(int row, int col) {
		this();
		setPosCol(col);
		setPosRow(row);
	}

	/*
	 * Wall is stationary doesn't move
	 */

	public char getID() {
		return id;
	}

	public void setID(char id) {
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
