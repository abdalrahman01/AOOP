
package sokobon.views;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.models.DataModel;

/**
 * @author: Abd Alrahman Atieh
 * 
 *          this class is used to display the current level, and the total
 *          number of levels in a JLabel.
 */
public class LevelDisplay extends JLabel implements ChangeListener {

	/**
	 * the data model
	 */
	DataModel dataModel;

	/**
	 * constructor for the level display. attaches the data model to the level
	 * display. and shows the current level and.
	 * 
	 * @param dataModel the data model
	 */
	public LevelDisplay(DataModel dataModel) {
		this.dataModel = dataModel;
		setSize(WIDTH, HEIGHT);
		setText("current level [" + (dataModel.getCurrnetLevel() + 1) + " / " + dataModel.getLevelCount() + "]");

	}

	/**
	 * on state change, update the level display. with current level and total
	 * number of levels.
	 */
	public void stateChanged(ChangeEvent e) {
		setText("current level [" + (dataModel.getCurrnetLevel() + 1) + " / " + dataModel.getLevelCount() + "]");
	}

}
