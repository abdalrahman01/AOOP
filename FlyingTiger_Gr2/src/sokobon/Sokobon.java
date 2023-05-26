package sokobon;

/**
 * @author Abd Alrahman
 * The starting point of the Game Sokobon
 * 
 */

import sokobon.models.DataModel;
import sokobon.views.GameMap;
import sokobon.views.GraphPresenter;
import sokobon.views.LevelDisplay;
import sokobon.views.menuBarView;
import sokobon.views.ControllerWindow;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * The starting point of the Game Sokobon
 */
public class Sokobon {
    private static int numlevels = 0;

    /**
     * starts the game
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        Level levels = new Level();
        numlevels = levels.countLevel();
        menuBarView gameWindow = new menuBarView("Sokoban");
        gameWindow.setPreferredSize(new Dimension(700, 700));
        gameWindow.setLayout(null);

        DataModel dataModel = new DataModel(levels);

        GameMap gMap = new GameMap(dataModel);

        gameWindow.setDataModel(dataModel);
        ControllerWindow controllerWindow = new ControllerWindow();
        LevelDisplay levelDisplay = new LevelDisplay(dataModel);

        GraphPresenter graphPresenter = new GraphPresenter(dataModel);

        dataModel.attach(gMap);
        dataModel.attach(graphPresenter);
        dataModel.attach(levelDisplay);
        controllerWindow.attachGameMap(gMap);

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameWindow.add(gMap.gameMap);
        gameWindow.add(graphPresenter);
        gameWindow.add(controllerWindow);
        gameWindow.add(levelDisplay);

        gMap.gameMap.setBounds(0, 0, 200, 200);
        controllerWindow.setBounds(0, 300, 600, 400);
        graphPresenter.setLocation(300, 0);
        levelDisplay.setBounds(50, 200, 150, 20);
        gameWindow.pack();
        gameWindow.setVisible(true);

    }

    @Override
    public String toString() {
        String session = "the game window has Dimension(700, 700) \nthe number of levels: " + numlevels;
        return session;
    }
}
