package sokobon.views;

import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.models.*;;

public class GameMap extends JComponent implements ChangeListener {

	private char[][] map;

	private int width, hieght;

	private JLabel textField;
	private DataModel dataModel;
	private GraphicalView graphicalView;

	public GameMap(DataModel model) {
		dataModel = model;
		JFrame frame = new JFrame("Game Map");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setMap(model.getData());
		textField = new JLabel(toMultiLineHTML(map));
		frame.add(textField);
		frame.pack();
		frame.setVisible(true);

	}

	private int playerRow, playerCol;

	public void addPlayer(int row, int col) {
		if (row >= 0 && row < map[0].length && col >= 0 && col < map.length && map[col][row] == ' ') {
			map[row][col] = 'P';
			playerRow = row;
			playerCol = col;
		}
		update(map);
	};

	public void addMovingBox(int row, int col) {

		if (map[row][col] != ' ') {
			System.out.println("Non empty space!");
		} else {
			map[row][col] = 'O';
		}
		update(map);

	};

	public void addWall(int row, int col) {
		if (row >= 0 && row < map[0].length && col >= 0 && col < map.length) {
			map[col][row] = '#';
		}
		update(map);
	};

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHieght() {
		return hieght;
	}

	public void setHieght(int hieght) {
		this.hieght = hieght;
	}

	public String toString() {

		String result = "";

		for (int i = 0; i < map.length; i++) {

			result += Arrays.toString(map[i]) + "\n";

		}

		return result;

	};

	public void movePlayerleft() {

	}

	public void movePlayerDown() {

	}

	public void movePlayerRight() {

	}

	public void movePlayerUp() {

	}

	public void setMap(char[][] map) {
		width = map[0].length;
		hieght = map.length;
		this.map = new char[hieght][width];

		// store the map
		for (int h = 0; h < map.length; h++) {
			for (int w = 0; w < map[0].length; w++) {
				this.map[h][w] = map[h][w];
			}
		}
	}

	public void stateChanged(ChangeEvent arg) {
		setMap(dataModel.getData());
		textField.setText(toMultiLineHTML(map));
		repaint();
	}

	private void update(char[][] map) {
		dataModel.update(map);
	}

	private void update(int oldX, int oldY, int newX, int newY) {
		dataModel.update(oldX, oldY, newX, newY);
	}

	private String toMultiLineHTML(char[][] text) {
		String result = "<html>";

		for (int i = 0; i < text.length; i++) {
			result += Arrays.toString(text[i]) + "<br>";
		}

		return result + "<html/>";
	}
}
