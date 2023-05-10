package sokobon.models;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.GameBox;
import sokobon.GameObject;
import sokobon.views.GameMap;
import sokobon.views.GraphicalView;

public class DataModel {
    ArrayList<ChangeListener> listeners;
    private GameObject[][] map; // data
    private int width;
    private int hieght;

    private GameMap gameMap;
    private GraphicalView graphicalView;

    public DataModel(GameObject[][] map) {
        listeners = new ArrayList<ChangeListener>();
        width = map[0].length;
        hieght = map.length;
        this.map = new GameObject[hieght][width];

        // store the map
        for (int h = 0; h < map.length; h++) {
            for (int w = 0; w < map[0].length; w++) {
                this.map[h][w] = map[h][w];
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
                this.map[h][w] = map[h][w].clone();
            }
        }
        for (ChangeListener l : listeners) {
            l.stateChanged(new ChangeEvent(this));
        }

    }

    public void update(int row, int col, GameObject gameObject) {
        map[row][col] = gameObject.clone();
        for (ChangeListener l : listeners) {
            l.stateChanged(new ChangeEvent(this));
        }
    }
}
