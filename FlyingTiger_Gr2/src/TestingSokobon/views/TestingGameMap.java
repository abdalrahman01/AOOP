package TestingSokobon.views;
import sokobon.views.*;

public class TestingGameMap {
	public static void main(String[] args) {
	GameMap map = new GameMap();
	System.out.println(map);
	map.addPlayer(1,1);
	System.out.println(map);
	map.addMovingBox(3, 2);
	System.out.println(map);
	map.addWall(4, 1);
	System.out.println(map);
	
}
}
