package sokobon.models;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.GameBox;
import sokobon.GameObject;
import sokobon.GameObjects.*;

import sokobon.views.GameMap;
import sokobon.views.GameController;

public class DataModel {
    ArrayList<ChangeListener> listeners;
    private GameObject[][] map; // data
    private int width;
    private int hieght;

    private GameMap gameMap;
    private GameController gameController;

    public DataModel(char[][] map) {
        listeners = new ArrayList<ChangeListener>();
        // store the map
        convertCharMatrixToGameObjectMatrix(map);
    }
    
    public void addGameMap(GameMap gameMap, char[][] map)
    {
    	this.gameMap = gameMap;
    	width = map[0].length;
        hieght = map.length;
        attachGameMapToGameObjects();
        
    }

    private void attachGameMapToGameObjects() {
		for (int row = 0; row < width-1; row++) {
			for (int col = 0; col < hieght-1; col++) {
				if (map[row][col].getID() == 'p') {
					gameMap.player = new Player(row, col);
					map[row][col] = gameMap.player;
				}
				map[row][col].gameMap = gameMap; // rediculas, I know					
				
			}
		}
		
	}

	private void convertCharMatrixToGameObjectMatrix(char[][] map) {
        int rows = map.length;
        int cols = map[0].length;

        this.map = new GameObject[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                switch (map[row][col]) {
                    case 'p':
                        this.map[row][col] = new Player(row, col);
                        this.map[row][col].gameMap = gameMap;
                        break;
                    case '#':
                        this.map[row][col] = new Wall(row, col);
                        this.map[row][col].gameMap = gameMap;
                        break;
                    case ' ':
                        this.map[row][col] = new Floor(row, col);
                        this.map[row][col].gameMap = gameMap;
                        break;
                    case 'o':
                        this.map[row][col] = new MovingBox(row, col);
                        this.map[row][col].gameMap = gameMap;
                        break;
                    case 'g':
                        this.map[row][col] = new Goal(row, col);
                        this.map[row][col].gameMap = gameMap;
                        break;
                    default:
                        break;
                }
            }
        }

    }

    /**
     * Constructs a DataModel object
     * 
     * @return the map in an char[][]
     */
    public GameObject[][] getData() {
        return (GameObject[][]) (map.clone());
    }

    /**
     * Attach a listener to the Model
     * 
     * @param c the listener
     */
    public void attach(ChangeListener c) {
        listeners.add(c);
    }

    public void update(int oldX, int oldY, int newX, int newY) {

        map[newY][newX] = map[oldY][oldX];

        for (ChangeListener l : listeners) {
            l.stateChanged(new ChangeEvent(this));
        }
    }

    public void update(GameObject[][] map) {
        width = map[0].length;
        hieght = map.length;
        this.map = new GameObject[hieght][width];

        // store the map
        for (int h = 0; h < map.length; h++) {
            for (int w = 0; w < map[0].length; w++) {
                this.map[h][w] = map[h][w];
            }
        }
        for (ChangeListener l : listeners) {
            l.stateChanged(new ChangeEvent(this));
        }

    }

    public void update(int row, int col, GameObject gameObject) {
        map[row][col] = gameObject;
        map[row][col].gameMap = gameMap;
        for (ChangeListener l : listeners) {
            l.stateChanged(new ChangeEvent(this));
        }
    }
}
