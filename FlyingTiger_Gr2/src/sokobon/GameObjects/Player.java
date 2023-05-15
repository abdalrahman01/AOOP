package sokobon.GameObjects;

import java.io.File;

import sokobon.GameBox;
import sokobon.GameObject;

public class Player extends GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char PLAYER_STANDING_ON_GOAL = 'p' + 'g';
	private final int UP = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int LEFT = 3;

	public Player() {
		id = 'p';
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
			case UP: // moveUp
				posRow--;
				break;
			case DOWN: // move Down
				posRow++;
				break;
			case RIGHT: // move Right
				posCol++;
				break;
			case LEFT: // move Left
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

		GameObject gameObjectInNewPosition = gameMap.getGameObject(posRow, posCol);
		GameObject gameObjectInOldPosition = gameMap.getGameObject(oldPosRow, oldPosCol);
		// if new position has a crate (marked/unmarked) m: marked crate
		if (gameObjectInNewPosition.getID() == 'o' || gameObjectInNewPosition.getID() == 'm') {
			boolean isMoved = false;
			switch (direction) {
				case UP: // moveUp
					isMoved = gameObjectInNewPosition.moveUp();
					break;
				case DOWN: // move Down
					isMoved = gameObjectInNewPosition.moveDown();
					break;
				case RIGHT: // move Right
					isMoved = gameObjectInNewPosition.moveRight();
					break;
				case LEFT: // move Left
					isMoved = gameObjectInNewPosition.moveLeft();
					break;
				default:
					break;
			}
			gameObjectInOldPosition = gameMap.getGameObject(oldPosRow, oldPosCol);
			gameObjectInNewPosition = gameMap.getGameObject(posRow, posCol);
			if (!isMoved) // if crate has not moved
			{
				posRow = oldPosRow; // go back to place
				posCol = oldPosCol;
				return false;
			}
		}
		if (gameObjectInOldPosition.getID() == (PLAYER_STANDING_ON_GOAL)) // if the player was // standing on a marker
		{
			gameMap.setGameObject(oldPosRow, oldPosCol, new Goal());
			setID('p');
		} else {
			gameMap.setGameObject(oldPosRow, oldPosCol, new Floor());
		}
		if (gameObjectInNewPosition.getID() == 'g')       // player now is stepping on marked floor
		{                                                  // change the id of the player, because we need an indecation that are tow
			setID(PLAYER_STANDING_ON_GOAL);                // objets are at the same postion
			gameMap.setGameObject(posRow, posCol, this);
			return true;
		}	 
											


		if (!gameMap.isEmpty(posRow, posCol)) // if new pos is not empty
		{
			posRow = oldPosRow; // go back to place
			posCol = oldPosCol;
			return false;
		}
		gameMap.setGameObject(posRow, posCol, this);
		return true;

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

	public boolean moveUp() {
		return move(UP);
	}

	public boolean moveDown() {
		return move(DOWN);
	}

	public boolean moveLeft() {
		return move(LEFT);
	}

	public boolean moveRight() {
		return move(RIGHT);
	};

}
