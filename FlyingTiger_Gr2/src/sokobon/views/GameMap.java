package sokobon.views;

import java.util.Arrays;

public class GameMap {

	char[][] map;

	private int width, hieght;

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

	private int playerRow, playerCol;

	public void addPlayer(int row, int col) {
		if (row >= 0 && row < map[0].length && col >= 0 && col < map.length && map[col][row] == ' ') {
			map[row][col] = 'P';
			playerRow = row;
			playerCol = col;
		}
	};

	public void addMovingBox(int row, int col) {

		if (map[row][col] != ' ') {
			System.out.println("Non empty space!");
		} else {
			map[row][col] = 'o';
		}
	};

	public void addWall(int row, int col) {
		if (row >= 0 && row < map[0].length && col >= 0 && col < map.length) {
			map[col][row] = '#';
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

	public boolean mPL() {
		return playerCol - 1 > 0 && map[playerRow][playerCol - 1] == ' ';
	}

	public boolean isBoxLeft() {
		return map[playerRow][playerCol - 1] == 'o';
	}

	public boolean isWallLeft() {
		return map[playerRow][playerCol - 1] == 'x';
	}

	public void movePlayerleft() {
		if (mPL()) {
			map[playerRow][playerCol] = ' ';
			map[playerRow][playerCol - 1] = 'P';
			playerCol--;
		} else if (isBoxLeft()) {
			if (playerCol - 2 > 0 && map[playerRow][playerCol - 2] == ' ') {
				map[playerRow][playerCol] = ' ';
				map[playerRow][playerCol - 1] = 'P';
				map[playerRow][playerCol - 2] = 'o';
				playerCol--;
			} else {
				return;
			}
		} else if (isWallLeft()) {
			return;
		}
	}

	public boolean mPD() {
		return playerRow + 1 < hieght && map[playerRow + 1][playerCol] == ' ';
	}

	public boolean isBoxDown() {
		return map[playerRow + 1][playerCol] == 'o';
	}

	public boolean isWallDown() {
		return map[playerRow + 1][playerCol] == 'x';
	}

	public void movePlayerDown() {
		if (mPD()) {
			map[playerRow][playerCol] = ' ';
			map[playerRow + 1][playerCol] = 'P';
			playerRow++;
		} else if (isBoxDown()) {
			if (playerCol - 2 > 0 && map[playerRow + 2][playerCol] == ' ') {
				map[playerRow][playerCol] = ' ';
				map[playerRow + 1][playerCol] = 'P';
				map[playerRow + 2][playerCol] = 'o';
				playerRow++;
			} else {
				return;
			}
		} else if (isWallDown()) {
			return;
		}
	}

	public boolean mPR() {
		return playerCol < width && map[playerRow][playerCol + 1] == ' ';
	}

	public boolean isBoxRight() {
		return map[playerRow][playerCol + 1] == 'o';
	}

	public boolean isWallRight() {
		return map[playerRow][playerCol + 1] == 'x';
	}

	public void movePlayerRight() {
		if (mPR()) {
			map[playerRow][playerCol] = ' ';
			map[playerRow][playerCol + 1] = 'P';
			playerCol++;
		} else if (isBoxRight()) {
			if (playerCol + 2 < width && map[playerRow][playerCol + 2] == ' ') {
				map[playerRow][playerCol] = ' ';
				map[playerRow][playerCol + 1] = 'P';
				map[playerRow][playerCol + 2] = 'o';
				playerCol++;
			} else {
				return;
			}
		} else if (isWallRight()) {
			return;
		}
	}

	public boolean mPU() {
		return playerRow > 0 && map[playerRow - 1][playerCol] == ' ';
	}

	public boolean isBoxUp() {
		return playerRow - 1 >= 0 && map[playerRow - 1][playerCol] == 'o';

	}

	public boolean isWallUp() {
		return map[playerRow - 1][playerCol] == 'x';
	}

	public void movePlayerUp() {
		if (mPU()) {
			map[playerRow][playerCol] = ' ';
			map[playerRow - 1][playerCol] = 'P';
			playerRow--;
		} else if (isBoxUp()) {
			if (playerRow - 2 >= 0 && map[playerRow - 2][playerCol] == ' ') {
				map[playerRow][playerCol] = ' ';
				map[playerRow - 1][playerCol] = 'P';
				map[playerRow - 2][playerCol] = 'o';
				playerRow--;
			} else {
				return;
			}
		} else if (isWallUp()) {
			return;
		}
	}

	public void pullBoxDown() {

		if (map[playerRow - 1][playerCol] == 'o' && map[playerRow + 1][playerCol] == 'o') {
			return;
		} else if (isBoxUp()) {
			map[playerRow - 1][playerCol] = ' ';
			map[playerRow][playerCol] = 'o';
			map[playerRow + 1][playerCol] = 'P';
			playerRow++;
		}

		else {
			return;
		}
	}

	public void pullBoxLeft() {
		if (map[playerRow][playerCol + 1] == 'o' && map[playerRow][playerCol - 1] == 'o') {
			return;
		} else if (isBoxRight()) {
			map[playerRow][playerCol + 1] = ' ';
			map[playerRow][playerCol] = 'o';
			map[playerRow][playerCol - 1] = 'P';
			playerCol--;
		} else {
			return;
		}
	}

	public void pullBoxUp() {
		if (map[playerRow - 1][playerCol] == 'o' && map[playerRow + 1][playerCol] == 'o') {
			return;
		} else if (isBoxDown()) {
			map[playerRow + 1][playerCol] = ' ';
			map[playerRow][playerCol] = 'o';
			map[playerRow - 1][playerCol] = 'P';
			playerRow--;
		} else {
			return;
		}
	}

	public void pullBoxRight() {
		if (map[playerRow][playerCol + 1] == 'o' && map[playerRow][playerCol - 1] == 'o') {
			return;
		} else if (isBoxLeft()) {
			map[playerRow][playerCol - 1] = ' ';
			map[playerRow][playerCol] = 'o';
			map[playerRow][playerCol + 1] = 'P';
			playerRow--;
		} else {
			return;
		}
	}
}
