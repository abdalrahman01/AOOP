package sokobon.views;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.GameObject;
import sokobon.GameObjects.MovingBox;
import sokobon.GameObjects.Player;
import sokobon.GameObjects.Wall;
import sokobon.models.*;;

public class GameMap extends JComponent implements ChangeListener {

	private GameObject[][] map;
	public Player player;
	private int width, height;

	public JLabel gameMap;
	private DataModel dataModel;
	// private GraphicalView graphicalView;

	public GameMap(DataModel model) {
		dataModel = model;
		player = new Player();
		dataModel.addGameMap(this);
		setMap(model.getData());
		gameMap = new JLabel(toMultiLineHTML(map));
	}

	public void setDataModel(DataModel dm) {
		dataModel = dm;
	}

	public GameObject getGameObject(int row, int col) {
		if (row < 0 || col < 0)
			return null;
		return map[row][col];
	}

	public void setGameObject(int row, int col, GameObject gameObject) {
		update(row, col, gameObject);
	}

	public boolean isEmpty(int row, int col) {
		if (!isInRange(row, col))
			return false;
		return map[row][col].getID() == ' ';
	}

	public boolean isWall(int row, int col) {
		if (!isInRange(row, col))
			return false;
		return map[row][col].getID() == '#';
	}

	public boolean isInRange(int row, int col) {
		if (row >= height)
			return false;

		if (col >= width)
			return false;

		if (row < 0 || col < 0)
			return false;

		return true;

	}

	public boolean isMovingBox(int row, int col) {
		if (!isInRange(row, col))
			return false;
		return map[row][col].getID() == 'o';
	}

	public boolean isPlayer(int row, int col) {
		return player.getPosRow() == row && player.getPosCol() == col;
	}

	public void addPlayer(int row, int col) {

		if (!isInRange(row, col))
			return;

		if (!isEmpty(row, col))
			return;

		if (isWall(row, col))
			return;

		if (isMovingBox(row, col))
			return;

		player.setPosCol(col);
		player.setPosRow(row);
		map[row][col] = player;

		player.setPosRow(row);
		player.setPosCol(col);
		update(row, col, player);
	}

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

	public boolean isMarked(int row, int col) {
		return map[row][col].getID() == 'g' || map[row][col].getID() == 'm';
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {

		String result = "";

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				result += map[row][col] + " ";
			}
			result += "\n";
		}
		return result;

	};

	public void setMap(GameObject[][] map) {
		width = map[0].length;
		height = map.length;
		this.map = new GameObject[height][width];

		// store the map
		for (int h = 0; h < map.length; h++) {
			for (int w = 0; w < map[0].length; w++) {
				this.map[h][w] = map[h][w];
			}
		}
	}

	public void stateChanged(ChangeEvent arg) {
		setMap(dataModel.getData());
		gameMap.setText(toMultiLineHTML(map));
		repaint();
	}

	private void update(GameObject[][] map) {
		dataModel.update(map);
	}

	private void update(int row, int col, GameObject gameObject) {
		dataModel.update(row, col, gameObject);
	}

	private String toMultiLineHTML(GameObject[][] text) {
		String result = "<html><pre>";

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				result += map[row][col] + " ";
			}
			result += "<br>";
		}

		return result + "<pre><html/>";
	}

}
