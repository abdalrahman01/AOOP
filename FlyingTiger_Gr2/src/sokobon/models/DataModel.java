package sokobon.models;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class DataModel {
    ArrayList<ChangeListener> listeners;
    private char[][] map; // data
    private int width;
    private int hieght;

    public DataModel(char[][] map) {
        listeners = new ArrayList<ChangeListener>();
        width = map[0].length;
        hieght = map.length;
        this.map = new char[hieght][width];

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
    public char[][] getData() {
        return (char[][]) (map.clone());
    }

    /**
     * Attach a listener to the Model
     * 
     * @param c the listener
     */
    public void attach(ChangeListener c) {
        listeners.add(c);
    }

    // public void update(int location, double value) {
    // data.set(location, new Double(value));
    // for (ChangeListener l : listeners) {
    // l.stateChanged(new ChangeEvent(this));
    // }
    // }

    // TODO add movePlayerUp, movePlayerDown, movePlayerRight, movePlayerLeft
    // instead of update.
}
