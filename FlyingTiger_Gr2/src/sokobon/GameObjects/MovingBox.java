package sokobon.GameObjects;

import java.io.File;

import sokobon.GameBox;
import sokobon.GameObject;

public class MovingBox extends GameObject implements GameBox {

	private char id;

	public MovingBox() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/crate.png"));
	}

	public MovingBox(int row, int col) {
		this();
		setPosCol(col);
		setPosRow(row);
	}

	public void moveUp() {
		move(0);
	};

	public void moveDown() {
		move(1);
	};

	public void moveLeft() {
		move(3);
	};

	public void moveRight() {
		move(2);
	};

	/**
	 * moves the box in a chose direction
	 * 
	 * @param direction choose between {0: Up, 1: Down, 2: Right, 3: Left}
	 */
	public void move(int direction) {
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
			return;
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
			if (gameMap.isMarked(oldPosRow, oldPosCol)) { // if old position was marked
				gameMap.setGameObject(oldPosRow, oldPosCol, new Goal());// old position
			} else {
				gameMap.setGameObject(oldPosRow, oldPosCol, new Floor());// old position
			}
			convertToUnMarked();

		} else {
			// go back to place and do nothing
			posRow = oldPosRow;
			posCol = oldPosCol;
			return;
		}
		gameMap.setGameObject(posRow, posCol, this);
	}

	private void convertToMarked() {
		setIconGameObject(
				new File("FlyingTiger_Gr2\\src\\sokobon\\resources\\imgs\\sokoban_icons\\cratemarked.png"));
		setID('m');
	}

	private void convertToUnMarked() {
		setIconGameObject(
				new File("FlyingTiger_Gr2\\src\\sokobon\\resources\\imgs\\sokoban_icons\\crate.png"));
		setID('o');
	}

	// /**
	// * If the box has Reached the the right place
	// *
	// * @return
	// */
	// public boolean hasReachedRedDot() {
	// return true;
	// }

	public char getID() {
		return id;
	}

	public void setID(char id) {
		this.id = id;
	}
}
