package sokobon.views;

import java.util.Arrays;

public class GameMap {

	char[][] map;

	private int width, height;

	public GameMap(char[][] map) {

		width = map[0].length;
		height = map.length;
		this.map = new char[height][width];

		// store the map
		for (int h = 0; h < map.length; h++) {
			for (int w = 0; w < map[0].length; w++) {
				this.map[h][w] = map[h][w];
			}
		}
	}

	private int playerRow, playerCol;

	private boolean isEmpty(int row, int col) {
		return map[row][col] == ' ';
	}

	private boolean isWall(int row, int col) {
		return map[row][col] == '#';
	}

	private boolean isInRange(int row, int col) {
		if (row >= height)
			return false;

		if (col >= width)
			return false;

		if (row < 0 || col < 0)
			return false;

		return true;

	}

	private boolean isMovingBox(int row, int col) {
		return map[row][col] == 'o';
	}

	private boolean isPlayer(int row, int col) {
		return playerCol == col && playerRow == row;
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

		map[row][col] = 'P';
		playerRow = row;
		playerCol = col;

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

		map[row][col] = 'o';

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

		map[row][col] = '#';

	};

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

	public void movePlayerleft() {
		if (playerCol - 1 > 0 && map[playerRow][playerCol - 1] == ' ') {
			map[playerRow][playerCol] = ' ';
			map[playerRow][playerCol - 1] = 'P';
			playerCol--;
		}
	}

	public void movePlayerDown() {
		if (playerRow + 1 < height && map[playerRow + 1][playerCol] == ' ') {
			map[playerRow][playerCol] = ' ';
			map[playerRow + 1][playerCol] = 'P';
			playerRow++;
		}
	}

	public void movePlayerRight() {
		if (playerCol < width && map[playerRow][playerCol + 1] == ' ') {
			map[playerRow][playerCol] = ' ';
			map[playerRow][playerCol + 1] = 'P';
			playerCol++;
		}
	}

	public void movePlayerUp() {
		if (playerRow > 0 && map[playerRow - 1][playerCol] == ' ') {
			map[playerRow][playerCol] = ' ';
			map[playerRow - 1][playerCol] = 'P';
			playerRow--;
		}

	}

	public void moveBoxLeft(int boxRow, int boxCol) {
		
		if (!isInRange(boxRow, boxCol))
			return;

		if (isEmpty(boxRow, boxCol))
			return;

		if (isWall(boxRow, boxCol))
			return;
		if (isPlayer(boxRow, boxCol))
			return;
		if (isMovingBox(boxRow, boxCol))
		{
			int newBoxRow = boxRow;
			int newBoxCol = boxCol - 1;
			if (!isInRange(newBoxRow, newBoxCol))
				return;

			if (!isEmpty(newBoxRow, newBoxCol))
				return;

			map[boxRow][boxCol] = ' ';
			map[newBoxRow][newBoxCol] = 'o';
			
		}
		
		
	}

	public void moveBoxRight(int boxRow, int boxCol) {
		
		
		if (!isInRange(boxRow, boxCol))
			return;

		if (isEmpty(boxRow, boxCol))
			return;

		if (isWall(boxRow, boxCol))
			return;
		if (isPlayer(boxRow, boxCol))
			return;
		if (isMovingBox(boxRow, boxCol))
		{
			int newBoxRow = boxRow;
			int newBoxCol = boxCol + 1;
			if (!isInRange(newBoxRow, newBoxCol))
				return;

			if (!isEmpty(newBoxRow, newBoxCol))
				return;

			map[boxRow][boxCol] = ' ';
			map[newBoxRow][newBoxCol] = 'o';
			
		}
		
		
		
		if (playerRow == boxRow && playerCol < boxCol) {
			if (boxCol + 1 < width && map[boxRow][boxCol + 1] == ' ') {
				map[boxRow][boxCol] = ' ';
				map[boxRow][boxCol + 1] = 'O';
			}
		}
	}

	public void moveBoxUp(int boxRow, int boxCol) {
		if (playerCol == boxCol && playerRow > boxRow) {
			if (boxRow - 1 >= 0 && map[boxRow - 1][boxCol] == ' ') {
				map[boxRow][boxCol] = ' ';
				map[boxRow - 1][boxCol] = 'O';
			}
		}
	}

	public void moveBoxDown(int boxRow, int boxCol) {
		if (playerCol == boxCol && playerRow < boxRow) {
			if (boxRow + 1 < height && map[boxRow + 1][boxCol] == ' ') {
				map[boxRow][boxCol] = ' ';
				map[boxRow + 1][boxCol] = 'O';
			}
		}
	}

	public String toString() {

		String result = "";

		for (int i = 0; i < map.length; i++) {

			result += Arrays.toString(map[i]) + "\n";

		}

		return result;

	};
}
