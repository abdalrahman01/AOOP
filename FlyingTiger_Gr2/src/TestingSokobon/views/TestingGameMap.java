package TestingSokobon.views;
import sokobon.views.*;
public class TestingGameMap {
//	char[][] map = {
//	        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
//	        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//	        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//	        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//	        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//	        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//	        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//	        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//	        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//	        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
//	    };
//	
	public static void main(String[] args) {
	GameMap map = new GameMap();
	System.out.println(map);
	map.addPlayer(1,1);
	System.out.println(map);
	map.addMovingBox(10, 10);
	System.out.println(map);
	map.addWall(4, 1);
	System.out.println(map);
	
}
}
