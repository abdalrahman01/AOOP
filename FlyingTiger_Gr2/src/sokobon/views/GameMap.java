package sokobon.views;


import java.util.Arrays;

public class GameMap {
	String[][] map;
	private int width, hieght;
	public void addPlayer(int x, int y) {}; 
	public void addMovingBox(int x, int y) {}; 
	public void addWall(int x, int y) {}; 
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
	public String toString() {return Arrays.toString(map);}; 
	
}
