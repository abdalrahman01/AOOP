package sokobon.views;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.GameObject;
import sokobon.GameObjects.Floor;
import sokobon.GameObjects.MovingBox;
import sokobon.GameObjects.Player;
import sokobon.GameObjects.Wall;
import sokobon.models.*;;

/**
 * Thi GameMap is an interface between the GameObjects and the DataModel. It is
 * an observer of the DataModel. it let's the GameObjects to update the
 * DataModel
 */
public class GameMap extends JComponent implements ChangeListener {

	/**
	 * Stores the current state of the game
	 */
	private GameObject[][] map;

	/**
	 * The player object. This is the object that the user controls
	 */
	public Player player;

	/**
	 * the size of the current game.
	 */
	private int cols, rows;

	/**
	 * a view to show the current state of the game
	 */
	public JLabel gameMap;

	/**
	 * the data model
	 */
	private DataModel dataModel;

	/**
	 * Contructs the GameMap from DataModel, also adds itself to the GameObjects in
	 * DataModel
	 * 
	 * @param model the data model
	 */
	public GameMap(DataModel model) {
		dataModel = model;
		player = new Player();
		dataModel.addGameMap(this);
		setMap(model.getData());
		gameMap = new JLabel(toMultiLineHTML(map));
	}

	/**
	 * gets the datamodel
	 * 
	 * @param dm datamodel
	 */
	public void setDataModel(DataModel dm) {
		dataModel = dm;
	}

	/**
	 * Gets the gameobjects in the given row and column
	 * 
	 * @param row the row
	 * @param col the column
	 * @return the gameobject in the given row and column
	 */
	public GameObject getGameObject(int row, int col) {
		if (row < 0 || col < 0)
			return null;
		return map[row][col];
	}

	/**
	 * Sets a new GameObject in the given row and column. and updates the data
	 * model. the datamodel will then notify the observers
	 * 
	 * @param row        the row, must be in range less than rows
	 * @param col        the column, must be in range less than cols
	 * @param gameObject the new gameobject
	 */
	public void setGameObject(int row, int col, GameObject gameObject) {
		update(row, col, gameObject);
	}

	/**
	 * Checks if the given row and column is Floor(), which means it's empty it has
	 * no obstacles
	 * 
	 * @param row the row
	 * @param col the column
	 * @return true if the given row and column is Floor()
	 *
	 */
	public boolean isEmpty(int row, int col) {
		if (!isInRange(row, col))
			return false;
		return map[row][col].getID() == ' ';
	}

	/**
	 * Checks if the given row and column is Wall(), which means it's a wall
	 * 
	 * @param row the row
	 * @param col the column
	 * @return true if the given row and column is Wall()
	 */
	public boolean isWall(int row, int col) {
		if (!isInRange(row, col))
			return false;
		return map[row][col].getID() == '#';
	}

	/**
	 * Checks if the given row and column is in range of the current map.
	 * 
	 * @param row the row
	 * @param col the column
	 * @return true if the given row and column is in range
	 */
	public boolean isInRange(int row, int col) {
		if (row >= rows)
			return false;

		if (col >= cols)
			return false;

		if (row < 0 || col < 0)
			return false;

		return true;

	}

	/**
	 * Checks if the given row and column is MovingBox(), which means it's a crate.
	 * 
	 * @param row the row
	 * @param col the column
	 * @return true if the given row and column is MovingBox()
	 */
	public boolean isMovingBox(int row, int col) {
		if (!isInRange(row, col))
			return false;
		return map[row][col].getID() == 'o';
	}

	/**
	 * Checks if the given row and column is Player(), which means it's the player.
	 * 
	 * @param row the row
	 * @param col the column
	 * @return true if the given row and column is Player()
	 */
	public boolean isPlayer(int row, int col) {
		return player.getPosRow() == row && player.getPosCol() == col;
	}

	/**
	 * Updates the Player position and notifies the observers;
	 * 
	 * @param row
	 * @param col
	 */
	public void addPlayer(int row, int col) {

		if (!isInRange(row, col))
			return;

		if (!isEmpty(row, col))
			return;

		if (isWall(row, col))
			return;

		if (isMovingBox(row, col))
			return;

		update(player.getPosRow(), player.getPosCol(), new Floor());

		player.setPosCol(col);
		player.setPosRow(row);
		map[row][col] = player;

		player.setPosRow(row);
		player.setPosCol(col);
		update(row, col, player);
	}

	/**
	 * adds a MovingBox to the given row and column. and update the datamodel
	 * 
	 * @param row the row
	 * @param col the column
	 */
	public void addMovingBox(int row, int col) {
		if (!isInRange(row, col))
			return;

		if (!isEmpty(row, col))
			return;

		if (isWall(row, col))
			return;
		if (isPlayer(row, col))
			return;

		update(row, col, new MovingBox(row, col));

	};

	/**
	 * Adds a Wall to the given row and column. and update the datamodel
	 * 
	 * @param row the row
	 * @param col the column
	 */
	public void addWall(int row, int col) {
		if (!isInRange(row, col))
			return;

		if (!isEmpty(row, col))
			return;

		if (isMovingBox(row, col))
			return;
		if (isPlayer(row, col))
			return;

		map[row][col] = new Wall(row, col);
		update(map);
	}

	/**
	 * Checks if the given row and column is Marked(), which means it's a goal
	 * 
	 * @param row the row
	 * @param col the column
	 * @return true if the given row and column is Marked()
	 */
	public boolean isMarked(int row, int col) {
		return map[row][col].getID() == 'g' || map[row][col].getID() == 'm';
	}

	/**
	 * Get the cols, the width of the map
	 * 
	 * @return the cols
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Get the rows, the height of the map
	 * 
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	public String toString() {

		String result = "";

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				result += map[row][col] + " ";
			}
			result += "\n";
		}
		return result;

	};

	/**
	 * Copies the given map to the current map
	 * 
	 * @param map the map to copy
	 */
	public void setMap(GameObject[][] map) {
		cols = map[0].length;
		rows = map.length;
		this.map = new GameObject[rows][cols];

		// store the map
		for (int h = 0; h < map.length; h++) {
			for (int w = 0; w < map[0].length; w++) {
				this.map[h][w] = map[h][w];
			}
		}
	}

	/**
	 * On state changed. Update the map and repaint the gameMap.label
	 */
	public void stateChanged(ChangeEvent arg) {
		setMap(dataModel.getData());
		gameMap.setText(toMultiLineHTML(map));
		repaint();
	}

	/**
	 * Updates the datamodel with the given map
	 * 
	 * @param map the map to update
	 */
	private void update(GameObject[][] map) {
		dataModel.update(map);
	}

	/**
	 * Updates the datamodel with the given row, column and gameObject
	 * 
	 * @param row        the row
	 * @param col        the column
	 * @param gameObject the gameObject
	 */
	private void update(int row, int col, GameObject gameObject) {
		dataModel.update(row, col, gameObject);
	}

	/**
	 * Converts the given map to a multi line html string, which is used to display
	 * in JLabel.
	 * 
	 * @param text the map to convert
	 * @return the converted map
	 */
	private String toMultiLineHTML(GameObject[][] text) {
		String result = "<html><pre>";

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				result += map[row][col] + " ";
			}
			result += "<br>";
		}

		return result + "<pre><html/>";
	}

}
