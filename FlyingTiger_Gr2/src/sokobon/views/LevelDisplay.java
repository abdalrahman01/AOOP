package sokobon.views;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.models.DataModel;

public class LevelDisplay extends JLabel implements ChangeListener {

	DataModel dataModel;

	public LevelDisplay(DataModel dataModel) {
		attach(dataModel);
		setSize(WIDTH, HEIGHT);
		setText("current level [" + (dataModel.getCurrnetLevel()+1) + " / " + dataModel.getLevelCount() +  "]");
		
	}

	public void attach(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public void stateChanged(ChangeEvent e) {
		setText("current level [" + (dataModel.getCurrnetLevel()+1) + " / " + dataModel.getLevelCount() +  "]");
	}

}
