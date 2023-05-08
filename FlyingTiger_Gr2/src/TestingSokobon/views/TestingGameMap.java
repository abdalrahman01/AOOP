package TestingSokobon.views;

import sokobon.views.GameMap;

public class TestingGameMap {
	private static final char X = 'x';
	private static final char P = 'p';
	private static final char O = 'o';

	private static char[][] map = new char[][] { { X, X, X, X, X, X, X, X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, X, X, X, X, X, X, X } };

	public static void main(String[] args) {
		GameMap gMap = new GameMap(map);
		gMap.addPlayer(3, 5);
		gMap.addMovingBox(3, 3);
		gMap.addWall(4, 5);
		gMap.moveBoxLeft(3, 3);
		//gMap.moveBoxRight(3, 3);
		//gMap.moveBoxDown(3, 3);
		//gMap.moveBoxUp(3, 3);
	
			System.out.println(gMap);
			
//		gMap.movePlayerUp();
//		System.out.println(gMap);
//		gMap.movePlayerUp();
//		System.out.println(gMap);
//		gMap.movePlayerUp();
//		System.out.println(gMap);
//		gMap.movePlayerUp();
//		System.out.println(gMap);
		
		
	

	}
}
