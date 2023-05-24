package TestingSokobon.views;

import sokobon.models.DataModel;
import sokobon.views.GameMap;
import sokobon.views.ControllerWindow;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class TestingGameMap {
	private static final char X = '#';
	private static final char P = 'p';
	private static final char O = 'o';

	private static char[][] map = new char[][] { { X, X, X, X, X, X, X, X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', O, 'g', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, ' ', ' ', ' ', ' ', ' ', ' ', X },
			{ X, X, X, X, X, X, X, X } };

	public static void main(String[] args) {
		JFrame gameWindow = new JFrame("Sokoban");
		
		gameWindow.setLayout(new FlowLayout());
		
		DataModel dataModel = new DataModel(map);

		GameMap gMap = new GameMap(dataModel);
		ControllerWindow controllerWindow = new ControllerWindow();

		dataModel.attach(gMap);
//		dataModel.addGameMap(gMap, map);
		controllerWindow.attachGameMap(gMap);
		
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.add(gMap.gameMap);
		gameWindow.add(controllerWindow);		
		gameWindow.pack();
		gameWindow.setVisible(true);
		
//		System.out.println(gMap);
		gMap.addPlayer(2, 2);
//		gMap.player.moveDown(); 
//		gMap.player.moveRight(); 
//		gMap.player.moveRight(); 
//		gMap.player.moveDown(); 
		

	}

	public void TestingToString() {

	}
}
