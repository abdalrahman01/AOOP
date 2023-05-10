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

	public Player(int row, int col) {
		this();
		setPosRow(row);
		setPosCol(col);
	}

	/**
	 * moves the player in a chose direction
	 * 
	 * @param direction choose between {0: Up, 1: Down, 2: Right, 3: Left}
	 */
	private boolean move(int direction) {
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

		if (!gameMap.isInRange(posRow, posCol)) { // if new position is outside of range
			posRow = oldPosRow; // go back to place
			posCol = oldPosCol;
			return false;
		}

		GameObject gameObjectInNewPositon = gameMap.getGameObject(posRow, posCol);

		// if new position has a crate (marked/unmarked)
		if (gameObjectInNewPositon.getID() == 'o' || gameObjectInNewPositon.getID() == 'm') {
			boolean isMoved = false;
			switch (direction) {
				case 0: // moveUp
					isMoved = gameObjectInNewPositon.moveUp();
					break;
				case 1: // move Down
					isMoved = gameObjectInNewPositon.moveDown();
					break;
				case 2: // move Right
					isMoved = gameObjectInNewPositon.moveRight();
					break;
				case 3: // move Left
					isMoved = gameObjectInNewPositon.moveLeft();
					break;
				default:
					break;
			}
			if (!isMoved) // if crate has not moved
			{
				posRow = oldPosRow; // go back to place
				posCol = oldPosCol;
				return false;
			}
		}

		if (!gameMap.isEmpty(posRow, posCol)) // if new pos is not empty
		{
			posRow = oldPosRow; // go back to place
			posCol = oldPosCol;
			return false;
		}

		// if old position //TODO:check where he was standing if it was marked

	}

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
	}

	@Override
	public boolean moveUp() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'moveUp'");
	}

	@Override
	public boolean moveDown() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'moveDown'");
	}

	@Override
	public boolean moveLeft() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
	}

	@Override
	public boolean moveRight() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
	};

}
