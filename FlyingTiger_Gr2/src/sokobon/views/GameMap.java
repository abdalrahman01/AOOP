package sokobon.views;

import java.util.Arrays;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.models.*;;

public class GameMap implements ChangeListener {

	private char[][] map;

	private int width, hieght;

	private DataModel dataModel;
	private GraphicalView graphicalView;

	public GameMap(char[][] map) {

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

	private int playerX, playerY;

	public void addPlayer(int x, int y) {
		if (x >= 0 && x < map[0].length && y >= 0 && y < map.length && map[y][x] == ' ') {
			map[x][y] = 'P';
			playerX = x;
			playerY = y;
		}
	};

	public void addMovingBox(int x, int y) {

		if (map[x][y] != ' ') {
			System.out.println("Non empty space!");
		} else {
			map[x][y] = 'O';
		}
	};

	public void addWall(int x, int y) {
		if (x >= 0 && x < map[0].length && y >= 0 && y < map.length) {
			map[y][x] = '#';
		}
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

	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'stateChanged'");
	}
}
