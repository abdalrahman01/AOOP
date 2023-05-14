package sokobon.views;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.models.DataModel;
import sokobon.GameObject;

public class GraphPresenter extends JPanel implements ChangeListener {
    private GameObject[][] gameObjects;
    private DataModel dataModel;
    private int ICON_WIDTH, ICON_HEIGHT;
    private int width, height;

    public GraphPresenter(DataModel dataModel) {
        ICON_WIDTH = 20;
        ICON_HEIGHT = 20;
        this.dataModel = dataModel;
        width = this.dataModel.getWidth();
        height = this.dataModel.getHeight();

    }

    public void stateChanged(ChangeEvent arg0) {

    }

    private void plotIcons() {

    }

}
