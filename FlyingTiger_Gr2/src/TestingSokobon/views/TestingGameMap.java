package TestingSokobon.views;

import sokobon.models.DataModel;
import sokobon.views.GameMap;

public class TestingGameMap {
	private static final char X = '#';
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

	}

	public void TestingAddPlayers() {
		//
	}
}
