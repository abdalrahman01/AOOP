package sokobon.GameObjects;

import java.io.File;

import sokobon.GameBox;
import sokobon.GameObject;

public class Player extends GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Player() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/player.png"));
	}

	public void moveUp() {
		posRow++;
	};

	public void moveDown() {
		posRow--;
	};

	public void moveLeft() {
		posCol--;
	};

	public void moveRight() {
		posCol++;
	};

	/**
	 * Push the object using the player
	 */
	public void push(GameBox box) {

	};

	/**
	 * Pull the object using the player
	 */
	public void pull() {
	}

	@Override
	public char getID() {
		return 'p';
	};

}
