package sokobon.GameObjects;

import java.io.File;

import sokobon.GameObject;

public class MovingBox extends GameObject {

	/**
	 * Defines the id and the icon of the MovingBox object
	 */
	public MovingBox() {
		id = 'o';
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/crate.png"));
	}

	/**
	 * the row and col refers to the position in GameMap.java
	 * 
	 * @param row the y position
	 * @param col the x position
	 */
	public MovingBox(int row, int col) {
		this();
		setPosCol(col);
		setPosRow(row);
	}

	public boolean moveUp() {
		return move(0);
	};

	public boolean moveDown() {
		return move(1);
	};

	public boolean moveLeft() {
		return move(3);
	};

	public boolean moveRight() {
		return move(2);
	};

	/**
	 * moves the box in a chose direction
	 * 
	 * @param direction choose between {0: Up, 1: Down, 2: Right, 3: Left}
	 * @return true if GameObject has moved
	 */
	public boolean move(int direction) {
		int oldPosRow = posRow;
		int oldPosCol = posCol;

		switch (direction) {
			case 0: // moveUp
				posRow--;
				break;
			case 1: // move Down
				posRow++;
				break;
			case 2: // move Right
				posCol++;
				break;
			case 3: // move Left
				posCol--;
				break;

			default:
				break;
		}

		GameObject gameObjectInNewPosition = gameMap.getGameObject(posRow, posCol);
		GameObject gameObjectInOldPosition = gameMap.getGameObject(oldPosRow, oldPosCol);
		if (!gameMap.isInRange(posRow, posCol)) { // if new position is outside of range
			posRow = oldPosRow; // go back to place
			posCol = oldPosCol;
			return false;
		}
		if (gameMap.isMarked(posRow, posCol)) { // if new position is marked

			// if crate was marked (i.e moved from marker to marker)
			if (gameMap.isMarked(oldPosRow, oldPosCol)) { // if old position was marked
				gameMap.setGameObject(oldPosRow, oldPosCol, new Goal()); // old position
			} else {
				gameMap.setGameObject(oldPosRow, oldPosCol, new Floor()); // old position
			}
			convertToMarked();

		} else if (gameMap.isEmpty(posRow, posCol)) { // if new position is empty

			// (if moved from marked to unmarked )
			if (gameMap.getGameObject(oldPosRow, oldPosCol).getID() == 'm') { // if old position was marked
				gameMap.setGameObject(oldPosRow, oldPosCol, new Goal());// old position
			} else {
				gameMap.setGameObject(oldPosRow, oldPosCol, new Floor());// old position
			}
			convertToUnMarked();

		} else {
			// go back to place and do nothing
			posRow = oldPosRow;
			posCol = oldPosCol;
			return false;
		}
		gameMap.setGameObject(posRow, posCol, this);
		return true;
	}

	/**
	 * Change the type of the MovingBox when it reached a Goal destination. It
	 * chages the icon for the GameObject and its id.
	 */
	private void convertToMarked() {
		setIconGameObject(
				new File("src\\sokobon\\resources\\imgs\\sokoban_icons\\cratemarked.png"));
		setID('m');
	}

	/**
	 * Change the type of the MovingBox when it step out of a Goal destination. It
	 * chages the icon for the GameObject and its id.
	 */
	private void convertToUnMarked() {
		setIconGameObject(
				new File("src\\sokobon\\resources\\imgs\\sokoban_icons\\crate.png"));
		setID('o');
	}

}
