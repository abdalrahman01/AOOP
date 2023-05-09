package sokobon;

import java.io.File;

public class Wall extends GameObject implements GameBox {

	private static final long serialVersionUID = 1L;

	public Wall() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/wall.png"));
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public char getID() {
		return '#';
	}

}
