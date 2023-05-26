package sokobon.GameObjects;

import java.io.File;

import sokobon.GameObject;

/**
 * The Player object that the user controls. this class is used to define the
 * Player object, inherits from GameObject.java
 * with two ids {p: player, x: player standing on goal} and icon = player.png
 */
public class Player extends GameObject {

	private char PLAYER_STANDING_ON_GOAL = 'x';
	private final int UP = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int LEFT = 3;

	/**
	 * Defines the id and the icon of the Player object
	 */
	public Player() {
		id = 'p';
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/player.png"));
	}

	/**
	 * the row and col refers to the position in GameMap.java
	 * 
	 * @param row the y position
	 * @param col the x position
	 */
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

		if (!gameMap.isInRange(posRow, posCol) || gameMap.isWall(posRow, posCol)) { // if new position is outside of
																					// range
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
		if (gameObjectInNewPosition.getID() == 'g') // player now is stepping on marked floor
		{ // change the id of the player, because we need an indecation that are tow
			setID(PLAYER_STANDING_ON_GOAL); // objets are at the same postion
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
	}

	public void moveLeftAndPull() {
		pull(LEFT);

	}

	public void moveRightAndPull() {
		pull(RIGHT);

	}

	public void moveUpAndPull() {
		pull(UP);

	}

	public void moveDownAndPull() {
		pull(DOWN);

	}

	/**
	 * turns on pull mode, if there is a box behind it will pull it and Player
	 * moves, or Player moves only.
	 * 
	 * @param direction int {0: Up, 1: Down, 2; Rightm 3: left}
	 * @return true if box pulled successfully.
	 */
	private boolean pull(int direction) {
		int oldPosRow = posRow;
		int oldPosCol = posCol;
		boolean hasMoved = false;

		GameObject movingBoxInOldPos = null;

		switch (direction) {
			case UP: // moveUp
				movingBoxInOldPos = gameMap.getGameObject(oldPosRow + 1, oldPosCol);
				break;
			case DOWN: // move Down
				movingBoxInOldPos = gameMap.getGameObject(oldPosRow - 1, oldPosCol);
				break;
			case RIGHT: // move Right
				movingBoxInOldPos = gameMap.getGameObject(oldPosRow, oldPosCol - 1);
				break;
			case LEFT: // move Left
				movingBoxInOldPos = gameMap.getGameObject(oldPosRow, oldPosCol + 1);
				break;

			default:
				break;
		}

		if (movingBoxInOldPos == null)
			return move(direction);

		if (movingBoxInOldPos.getID() != 'm' && movingBoxInOldPos.getID() != 'o')
			return move(direction);
		if (move(direction)) {
			hasMoved = ((MovingBox) movingBoxInOldPos).move(direction);
			return hasMoved;
		}
		return false;

	}

}
