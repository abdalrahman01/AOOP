package sokobon;

import java.io.File;

public class Wall extends GameObject implements GameBox {

	private static final long serialVersionUID = 1L;

	public Wall() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/wall.png"));
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
