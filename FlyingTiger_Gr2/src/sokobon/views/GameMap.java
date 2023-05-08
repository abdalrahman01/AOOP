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
	
	public boolean mPL(){
		return playerY-1 > 0 && map[playerX][playerY-1]== ' ';
	}
	public boolean isBoxLeft(){
		return map[playerX][playerY-1]== 'O';
	}
	public boolean isWallLeft(){
		return map[playerX][playerY-1]== 'x';
	}
	
	public void movePlayerleft() {
	    if (mPL()) {
	        map[playerX][playerY] = ' ';
	        map[playerX][playerY - 1] = 'P';
	        playerY--;
	    } else if (isBoxLeft()) {
	        if (playerY - 2 > 0 && map[playerX][playerY - 2] == ' ') {
	            map[playerX][playerY] = ' ';
	            map[playerX][playerY - 1] = 'P';
	            map[playerX][playerY - 2] = 'O';
	            playerY--;
	        } else {
	            return;
	        }
	    } else if (isWallLeft()) {
	        return;
	    }
	}
	
	
	
	public boolean mPD(){
		return playerX+1 < hieght && map[playerX+1][playerY] == ' ';
	}
	public boolean isBoxDown(){
		return map[playerX+1][playerY]== 'O';
	}
	public boolean isWallDown(){
		return map[playerX+1][playerY]== 'x';
	}

	public void movePlayerDown() {
		if(mPD()) {
			map[playerX][playerY] = ' ';
			map[playerX+1][playerY] = 'P';
			playerX++;
		}
		else if (isBoxDown()) {
	        if (playerY - 2 > 0 && map[playerX + 2][playerY] == ' ') {
	            map[playerX][playerY] = ' ';
	            map[playerX + 1][playerY] = 'P';
	            map[playerX + 2][playerY] = 'O';
	            playerX++;
	        } else {
	            return;
	        }
	    } else if (isWallDown()) {
	        return;
	    }
	}
	
	
	public boolean mPR(){
		return playerY < width && map[playerX][playerY+1] == ' ';
	}
	public boolean isBoxRight(){
		return map[playerX][playerY + 1]== 'O';
	}
	public boolean isWallRight(){
		return map[playerX][playerY + 1]== 'x';
	}

	public void movePlayerRight() {
	    if (mPR()) {
	        map[playerX][playerY] = ' ';
	        map[playerX][playerY+1] = 'P';
	        playerY++;
	    } else if (isBoxRight()) {
	        if (playerY + 2 < width && map[playerX][playerY + 2] == ' ') {
	            map[playerX][playerY] = ' ';
	            map[playerX][playerY + 1] = 'P';
	            map[playerX][playerY + 2] = 'O';
	            playerY++;
	        } else {
	            return;
	        }
	    } else if (isWallRight()) {
	        return;
	    }
	}
	
	
	
	public boolean mPU(){
		return playerX > 0 && map[playerX-1][playerY] == ' ';
	}
	public boolean isBoxUp(){
		return playerX - 1 >= 0 && map[playerX-1][playerY] == 'O';
		
	}
	public boolean isWallUp(){
		return map[playerX- 1][playerY]== 'x';
	}
	public void movePlayerUp() {
	    if (mPU()) {
	        map[playerX][playerY] = ' ';
	        map[playerX-1][playerY] = 'P';
	        playerX--;
	    }
	    else if (isBoxUp()) {
	        if (playerX - 2 >= 0 && map[playerX - 2][playerY] == ' ') {
	            map[playerX][playerY] = ' ';
	            map[playerX - 1][playerY] = 'P';
	            map[playerX - 2][playerY] = 'O';
	            playerX--;
	        } else {
	            return;
	        }
	    } else if (isWallUp()) {
	        return;
	    }
	}
	

	public void pullBoxDown() {
		if(isBoxUp()){
			map[playerX-1][playerY] = ' ';
			map[playerX][playerY] = 'O';
			map[playerX + 1][playerY] = 'P';
			playerX++;
		}
		else {
			return;
			}
	}
	
	
	public void pullBoxLeft() {
		if(isBoxRight()){
			map[playerX][playerY + 1] = ' ';
			map[playerX][playerY] = 'O';
			map[playerX][playerY - 1] = 'P';
			playerY--;
		}
		else {
			return;
			}
	}
	
	
	public void pullBoxUp() {
		if(isBoxDown()){
			map[playerX + 1][playerY] = ' ';
			map[playerX][playerY] = 'O';
			map[playerX - 1][playerY] = 'P';
			playerX--;
		}
		else {
			return;
			}
	}
	
	public void pullBoxRight() {
		if(isBoxLeft()){
			map[playerX][playerY - 1] = ' ';
			map[playerX][playerY] = 'O';
			map[playerX][playerY + 1] = 'P';
			playerX--;
		}
		else {
			return;
			}
	}
}
