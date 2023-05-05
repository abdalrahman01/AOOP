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
		if (x < 0 || x >= width || y < 0 || y >= hieght) {
			return;
		}
		for(int i = 0; i < map.length; i ++) { 
			for(int j= 0; j < map[0].length; j ++) {
				if(map[x][y] == p);
					
		}
	}
	map[x][y]=p;

	};
	
	public void addMovingBox(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= hieght) {
			return;
		}
		
		for(int i = 0; i < map.length; i ++) { 
			for(int j= 0; j < map[0].length; j ++) {
				if(map[x][y] == o);
					
		}
	}
	map[x][y]=o;
		
	}; 
	public void addWall(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= hieght) {
			return;
		}
		for(int i = 0; i < map.length; i ++) { 
			
			for(int j= 0; j < map[0].length; j ++) {
				if(map[x][y] == w);
					
		}
	}
	map[x][y]=w;
		
	}; 
	

	
	public GameMap(String[][] map) {
		
		width = map[0].length;
		hieght= map.length;
		this.map = new String[hieght][width];
		
		// store the map 
		for (int h = 0; h < map.length; h++) {
			for (int w = 0; w < map[0].length; w++) {
				this.map[h][w] = map[h][w];
			}
		}
	}
	
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
	 
	
}
