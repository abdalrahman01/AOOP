package sokobon.views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.models.DataModel;
import sokobon.GameObject;

public class GraphPresenter extends JPanel implements ChangeListener {
    private GameObject[][] gameObjects;
    private DataModel dataModel;
    private int ICON_width, ICON_height;
    private int cols, rows;

    public GraphPresenter(DataModel dataModel) {
        ICON_width = 20;
        ICON_height = 20;
        this.dataModel = dataModel;
        cols = this.dataModel.getCols();
        rows = this.dataModel.getRows();
        setSize(ICON_width * cols + 3, ICON_height * rows + 3);
        setLayout(null);
        plotIcons();

    }

    public void stateChanged(ChangeEvent arg0) {
        plotIcons();
    }

    private void plotIcons() {
        gameObjects = this.dataModel.getData();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                JLabel temp = gameObjects[row][col].getIcon();
                temp.setSize(ICON_width, ICON_height);
                temp.setLocation(row * ICON_width, col * ICON_height);
                add(temp);
            }
        }
        repaint();
    }

}
