package sokobon.views;

import java.io.File;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;

import lab2.E9.Presenter;
import sokobon.models.DataModel;

public class GameController extends Presenter {
	private DataModel dataModel;
	private GameMap gMap;

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

	public GameController() {
		changeNorthButtonIcon(new File("src/sokobon/resources/imgs/sokoban_icons/up.png"));
		changeSouthButtonIcon(new File("src/sokobon/resources/imgs/sokoban_icons/down.png"));
		changeEastButtonIcon(new File("src/sokobon/resources/imgs/sokoban_icons/höger.png"));
		changeWestButtonIcon(new File("src/sokobon/resources/imgs/sokoban_icons/vänster.png"));
	}

	public void attach(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void attach(GameMap gameMap) {
		this.gMap = gameMap;
	}

	@Override
	public JComponent createCenterComponent() {
		dataModel = new DataModel(map);

		gMap = new GameMap(dataModel);

		dataModel.attach((ChangeListener) gMap);
//		dataModel.addGameMap(gMap, map);
		gMap.addPlayer(2, 2);
		System.out.println(gMap);
		return null;
		// return gMap.textField;
	}

	@Override
	public void northButtonPressed() {
		gMap.player.moveUp();
		// System.out.println(gMap);

	}

	@Override
	public void eastButtonPressed() {
		gMap.player.moveRight();
		// System.out.println(gMap);

	}

	@Override
	public void southButtonPressed() {
		gMap.player.moveDown();
		// System.out.println(gMap);

	}

	@Override
	public void westButtonPressed() {
		gMap.player.moveLeft();
		// System.out.println(gMap);

	}

}
