package sokobon.views;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.models.DataModel;
import sokobon.GameObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class GraphPresenter extends JPanel implements ChangeListener {

    private static final long serialVersionUID = 1L;

    /**
     * Stores the current state of the game
     */
    private GameObject[][] gameObjects;

    /**
     * the data model
     */
    private DataModel dataModel;

    /**
     * a size for all icons
     */
    private int ICON_width, ICON_height;

    /**
     * the size of the current game.
     */
    private int cols, rows;

    public GraphPresenter(DataModel dataModel) {
        ICON_width = 30;
        ICON_height = 30;
        this.dataModel = dataModel;
        cols = this.dataModel.getCols();
        rows = this.dataModel.getRows();
        setSize(ICON_width * cols + 3, ICON_height * rows + 3);
        setLayout(null);
        this.gameObjects = new GameObject[rows][cols];
        setMap(this.dataModel.getData());
        repaint();

    }

    /**
     * on state change, update the map. and repaint
     */
    public void stateChanged(ChangeEvent e) {
        setMap(this.dataModel.getData());
        repaint();

    }

    /**
     * Copy the given map to the map in this class
     * 
     * @param map the map to copy
     */
    public void setMap(GameObject[][] map) {
        cols = map[0].length;
        rows = map.length;

        // store the map
        for (int h = 0; h < map.length; h++) {
            for (int w = 0; w < map[0].length; w++) {
                this.gameObjects[h][w] = map[h][w];
            }
        }
    }

    /**
     * Paint the map
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                g2.drawImage((Image) gameObjects[row][col].getBufferedImage(), col * ICON_width, row * ICON_height,
                        ICON_width, ICON_height, null);
            }
        }
    }

}
