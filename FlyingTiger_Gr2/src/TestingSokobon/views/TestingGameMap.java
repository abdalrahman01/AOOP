package TestingSokobon.views;

import sokobon.models.DataModel;
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
		DataModel dataModel = new DataModel(map);

		GameMap gMap = new GameMap(dataModel);

		dataModel.attach(gMap);
		gMap.addPlayer(4, 1);
		System.out.println(gMap);

		gMap.addMovingBox(3, 4);
		System.out.println(gMap);

		gMap.addWall(3, 5);
		System.out.println(gMap);
	}

	public void TestingAddPlayers() {
		//
	}
}
