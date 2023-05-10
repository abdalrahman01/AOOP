package sokobon.GameObjects;

import java.io.File;

import sokobon.GameBox;
import sokobon.GameObject;

public class Wall extends GameObject implements GameBox {

	private static final long serialVersionUID = 1L;

	public Wall() {
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
	public void moveUp() {
	}

	/*
	 * Wall is stationary doesn't move
	 */
	public void moveDown() {
	}

	/*
	 * Wall is stationary doesn't move
	 */
	public void moveLeft() {
	}

	/*
	 * Wall is stationary doesn't move
	 */
	public void moveRight() {
	}

	public char getID() {
		return '#';
	}

}
