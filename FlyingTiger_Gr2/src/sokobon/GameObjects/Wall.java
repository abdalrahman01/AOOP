package sokobon.GameObjects;

import java.io.File;

import sokobon.GameObject;

public class Wall extends GameObject {

	private static final long serialVersionUID = 1L;

	/**
	 * Defines the id and the icon of the Wall object
	 */
	public Wall() {
		id = '#';
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/wall.png"));
	}

	/**
	 * the row and col refers to the position in GameMap.java
	 * 
	 * @param row the y position
	 * @param col the x position
	 */
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
