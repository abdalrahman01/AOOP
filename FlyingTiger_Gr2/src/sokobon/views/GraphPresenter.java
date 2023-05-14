package sokobon.views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.models.DataModel;
import sokobon.GameObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


public class GraphPresenter extends JPanel implements ChangeListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameObject[][] gameObjects;
    private DataModel dataModel;
    private int ICON_width, ICON_height;
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

    public void stateChanged(ChangeEvent e) {
    	setMap(this.dataModel.getData());
        repaint();
    
    }
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

  
    
    public void paintComponent(Graphics g) {
        // Let UI Delegate paint first, which 
        // includes background filling since 
        // this component is opaque.
    	Graphics2D g2 = (Graphics2D) g;
    	for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
            	g2.drawImage((Image) gameObjects[row][col].getBufferedImage(),col * ICON_width, row * ICON_height, ICON_width, ICON_height, null );
            }
        }
        
//        g.drawImage(null, ICON_height, ICON_height, ICON_height, ICON_height, rows, cols, ICON_width, ICON_height, getFocusCycleRootAncestor())
    } 

}
