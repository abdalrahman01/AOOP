package sokobon.views;


import java.util.Arrays;


public class GameMap {
	String[][] map = new String [][] {
		{}
	};
	
	private int width, hieght;
	private String p ="p";
	private String o ="o";
	private String w ="w";
	
	public void addPlayer(int x, int y) {
		for(int i = 0; i < map.length; i ++) { 
			for(int j= 0; j < map[0].length; j ++) {
				if(map[x][y] == p);
					
		}
	}
	map[x][y]=p;

	};
	
	public void addMovingBox(int x, int y) {
		for(int i = 0; i < map.length; i ++) { 
			for(int j= 0; j < map[0].length; j ++) {
				if(map[x][y] == o);
					
		}
	}
	map[x][y]=o;
		
	}; 
	public void addWall(int x, int y) {
		for(int i = 0; i < map.length; i ++) { 
			for(int j= 0; j < map[0].length; j ++) {
				if(map[x][y] == w);
					
		}
	}
	map[x][y]=w;
		
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
	
	public String toString() {String result = "";

	 for (int i = 0; i < map.length; i++) {

	 result += Arrays.toString(map[i]) + "\n";

	 }

	 return result;
	 
	 }; 
	
}
