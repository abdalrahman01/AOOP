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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {

		String result = "";

		for (int i = 0; i < map.length; i++) {

			result += Arrays.toString(map[i]) + "\n";

		}

		return result;

	};

	public void movePlayerleft() {
		if(playerY-1 > 0 && map[playerX][playerY-1] == ' ') {
			map[playerX][playerY] = ' ';
			map[playerX][playerY-1] = 'P';
			playerY--;
		}
	}

	public void movePlayerDown() {
		if(playerX+1 < height && map[playerX+1][playerY] == ' ') {
			map[playerX][playerY] = ' ';
			map[playerX+1][playerY] = 'P';
			playerX++;
		}
	}

	public void movePlayerRight() {
		if(playerY < width && map[playerX][playerY+1] == ' ') {
			map[playerX][playerY] = ' ';
			map[playerX][playerY+1] = 'P';
			playerY++;
		}
	}

	public void movePlayerUp() {
		if(playerX > 0 && map[playerX-1][playerY] == ' ') {
			map[playerX][playerY] = ' ';
			map[playerX-1][playerY] = 'P';
			playerX--;
		}
		
	}
	
	public void moveBoxLeft(int boxX, int boxY) {
	    if (playerX == boxX && playerY > boxY) {
	        if (boxY - 1 >= 0 && map[boxX][boxY - 1] == ' ') {
	            map[boxX][boxY] = ' ';
	            map[boxX][boxY - 1] = 'O';
	        }
	    }
	}

	
	public void moveBoxRight(int boxX, int boxY) {
	    if (playerX == boxX && playerY < boxY) {
	        if (boxY + 1 < width && map[boxX][boxY + 1] == ' ') {
	            map[boxX][boxY] = ' ';
	            map[boxX][boxY + 1] = 'O';
	        }
	    }
	}

	public void moveBoxUp(int boxX, int boxY) {
	    if (playerY == boxY && playerX > boxX) {
	        if (boxX - 1 >= 0 && map[boxX - 1][boxY] == ' ') {
	            map[boxX][boxY] = ' ';
	            map[boxX - 1][boxY] = 'O';
	        }
	    }
	}

	public void moveBoxDown(int boxX, int boxY) {
	    if (playerY == boxY && playerX < boxX) {
	        if (boxX + 1 < height && map[boxX + 1][boxY] == ' ') {
	            map[boxX][boxY] = ' ';
	            map[boxX + 1][boxY] = 'O';
	        }
	    }
	}



}
