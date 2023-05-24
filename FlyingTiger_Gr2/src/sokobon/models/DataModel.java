package sokobon.models;

import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sokobon.GameObject;
import sokobon.GameObjects.*;
import sokobon.views.GameMap;
import sokobon.Level;

public class DataModel {
    ArrayList<ChangeListener> listeners; // for observer pattern
    private GameObject[][] map; // data
    private int cols;
    private int rows;
    private int levelCount;
    private int currnetLevel;

    private Level levels;
    private GameMap gameMap;

    public DataModel(Level lvls) {
        listeners = new ArrayList<ChangeListener>();
        addLevels(lvls);
        char[][] firstLevel = lvls.getMapLevel(currnetLevel);

        cols = firstLevel[0].length;
        rows = firstLevel.length;
        // store the map
        convertCharMatrixToGameObjectMatrix(firstLevel);
    }

    public void addGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
        attachGameMapToGameObjects();
    }

    public void addLevels(Level lvls) {
        levels = lvls;
        levelCount = levels.countLevel();
        currnetLevel = 0;
    }

    private void attachGameMapToGameObjects() {
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if (map[row][col].getID() == 'p') {
                    gameMap.player = new Player(row, col);
                    map[row][col] = gameMap.player;
                }
                map[row][col].gameMap = gameMap; // rediculas, I know

            }
        }

    }

    public int getLevelCount() {
        return levelCount;
    }

    public int getCurrnetLevel() {
        return currnetLevel;
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
                        if (gameMap != null)
                            gameMap.player = (Player) this.map[row][col];
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
        return (GameObject[][]) (map);
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
        updateLevel();
        notifyObservers();
    }

    public void update(GameObject[][] map) {
        cols = map[0].length;
        rows = map.length;
        this.map = new GameObject[rows][cols];

        // store the map
        for (int h = 0; h < map.length; h++) {
            for (int w = 0; w < map[0].length; w++) {
                this.map[h][w] = map[h][w];
            }
        }
        updateLevel();
        notifyObservers();
    }

    public void update(int row, int col, GameObject gameObject) {
        map[row][col] = gameObject;
        map[row][col].gameMap = gameMap;
        updateLevel();
        notifyObservers();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public boolean checkWin() {
        int cols = gameMap.getCols();
        int rows = gameMap.getRows();
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                GameObject gameObject = map[row][col];
                // There are still boxes or box not put on the goal
                if (gameObject.getID() == 'g' || gameObject.getID() == 'x') {
                    return false;
                }
            }
        }
        // no boxes was found or all boxes put on the goal
        return true;
    }

    private void notifyObservers() {
        for (ChangeListener l : listeners) {
            l.stateChanged(new ChangeEvent(this));
        }
    }

    private void updateLevel() {
        if (!checkWin())
            return;

        currnetLevel = (currnetLevel + 1) % levelCount;
        convertCharMatrixToGameObjectMatrix(levels.getMapLevel(currnetLevel));

    }
}
