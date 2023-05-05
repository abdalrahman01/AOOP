package TestingSokobon.views;

import sokobon.views.GameMap;

public class TestingGameMap{
	private static final String X = "x";
	private static final String P = "p";
	private static final String O = "o";
	
	private static String[][] map = new String[][]{{X,X,X,X,X,X,X,X},
												   {X," "," "," "," "," "," ",X},
												   {X," "," "," "," "," "," ",X},
												   {X," "," "," "," "," "," ",X},
												   {X," "," "," "," "," "," ",X},
												   {X," "," "," "," "," "," ",X},
												   {X,X,X,X,X,X,X,X}};
	public static void main(String[] args) {
		GameMap gMap = new GameMap(map);
		gMap.addPlayer(7, 7);
		gMap.addMovingBox(3, 4);
		gMap.addWall(3, 5);
		System.out.println(gMap);
	}
}