
package TestingSokobon.views;

import sokobon.models.DataModel;
import sokobon.views.GameMap;
import sokobon.views.GraphPresenter;
import sokobon.views.ControllerWindow;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class TestingGraphPresenter {
    private static final char X = '#';
    private static final char P = 'p';
    private static final char O = 'o';

    private static char[][] map = new char[][] { { X, X, X, X, X, X, X, X },
            { X, ' ', ' ', ' ', ' ', ' ', ' ', X },
            { X, ' ', ' ', ' ', ' ', ' ', ' ', X },
            { X, ' ', P , O , 'g' , X , ' '  , X },
            { X, ' ', ' ', ' ', ' ', ' ', ' ', X },
            { O, ' ', ' ', ' ', ' ', ' ', ' ', X },
            { X, X, X, X, X, X, X, X } };

    public static void main(String[] args) {
        JFrame gameWindow = new JFrame("Sokoban");
        gameWindow.setPreferredSize(new Dimension (700, 700));
        
        gameWindow.setLayout(null);

        DataModel dataModel = new DataModel(map);

        GameMap gMap = new GameMap(dataModel);
        ControllerWindow controllerWindow = new ControllerWindow();

        GraphPresenter graphPresenter = new GraphPresenter(dataModel);

        dataModel.attach(gMap);
        dataModel.attach(graphPresenter);
        dataModel.addGameMap(gMap, map);
        controllerWindow.attachGameMap(gMap);

        
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameWindow.add(gMap.gameMap);
        gameWindow.add(graphPresenter);
        gameWindow.add(controllerWindow);
        
        gMap.gameMap.setBounds(0, 0, 200, 200);
        controllerWindow.setBounds(0,300, 600,400);
        graphPresenter.setLocation(300, 0);
        gameWindow.pack();
        gameWindow.setVisible(true);
        

        // System.out.println(gMap);
//        gMap.addPlayer(2, 2);
        
        
        // gMap.player.moveDown();
        // gMap.player.moveRight();
        // gMap.player.moveRight();
        // gMap.player.moveDown();

    }
}
