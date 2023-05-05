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
		System.out.println(gMap);
	}
}
