package sokobon.models;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sokobon.GameObject;
import sokobon.GameObjects.*;
import sokobon.views.GameMap;
import sokobon.Level;

/**
 * This class is used to store the data of the game. and to update the observers
 * whenever the data changes.
 * 
 */
public class DataModel {

    /**
     * saves all listners. for observer pattern.
     * 
     */
    ArrayList<ChangeListener> listeners;

    /**
     * Saves the current state of the game
     */
    private GameObject[][] map; // data

    /**
     * the size of the current game.
     */
    private int cols, rows;

    /**
     * How many level the has
     */
    private int levelCount;

    /**
     * indecates the index of current game.
     */
    private int currnetLevel;

    /**
     * To get access to the actual levels
     */
    private Level levels;

    /**
     * The interface between DataModel and the GameObjects
     */
    private GameMap gameMap;

    /**
     * Contructs the DataModel from Level
     * 
     * @param lvls
     */
    public DataModel(Level lvls) {
        listeners = new ArrayList<ChangeListener>();
        addLevels(lvls);
        char[][] firstLevel = lvls.getMapLevel(currnetLevel);

        cols = firstLevel[0].length;
        rows = firstLevel.length;
        // store the map
        convertCharMatrixToGameObjectMatrix(firstLevel);
    }

    /**
     * Save a reference to GameMap
     * 
     * @param gameMap GameMap.java
     */
    public void addGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
        attachGameMapToGameObjects();
    }

    /**
     * saves the Level object, gets the number of levels, clears the curentLevel
     * 
     * @param lvls Level Object
     */
    public void addLevels(Level lvls) {
        levels = lvls;
        levelCount = levels.countLevel();
        currnetLevel = 0;
    }

    /**
     * Loops through the matrix of GameObjects and save reference to GameMap in each
     * GameObject
     */
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

    /**
     * @return how many levels in this dataModel.
     */
    public int getLevelCount() {
        return levelCount;
    }

    /**
     * @return the current level in int
     */
    public int getCurrnetLevel() {
        return currnetLevel;
    }

    /**
     * converts a char[][] map to GameObject[][] each char in map corresonds to an
     * ID for a GameObject. Then stores GameObject map[][].
     * 
     * @param map matrix[row][col]
     */
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
     * The data is returned, it's called be the oberservs
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

    /**
     * Get a new map. It is used when switching levels.
     * 
     * @param map GameObjects[][]. The
     */
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

    public void checkIfListnerExists(ChangeListener l) {

    }

    /**
     * 
     * @return the number of columns in the map, i.e the width
     */
    public int getCols() {
        return cols;
    }

    /**
     * 
     * @return the number of rows in the map, i.e the height
     */
    public int getRows() {
        return rows;
    }

    /**
     * Checks if the player has won the game
     * It returns true if there are no empty goals left.
     * 
     * @return true if the player has won the game
     */
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

    /**
     * Notifies the observers that the data has changed
     */
    private void notifyObservers() {
        for (ChangeListener l : listeners) {
            l.stateChanged(new ChangeEvent(this));
        }
    }

    /**
     * Updates the level if the player has won the game
     */
    private void updateLevel() {
        if (!checkWin())
            return;

        currnetLevel = (currnetLevel + 1) % levelCount;
        convertCharMatrixToGameObjectMatrix(levels.getMapLevel(currnetLevel));

    }

    public void loadState(String reletivePath) {
        // read the first line of the file, it has the number of rows and cols seperated
        // by a comma
        // using Scanner
        Scanner scanner = new Scanner(reletivePath);
        String[] rowsAndCols = scanner.nextLine().split(",");
        int newRows = Integer.parseInt(rowsAndCols[0]);
        int newCols = Integer.parseInt(rowsAndCols[1]);

        // read the rest of the file, it has the map
        // convert the map to GameObjects using a swith case
        this.map = new GameObject[newRows][newCols];
        for (int row = 0; row < newRows; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < newCols; col++) {
                switch (line.charAt(col)) {
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
        scanner.close();
        updateLevel();
        notifyObservers();

    }
}
