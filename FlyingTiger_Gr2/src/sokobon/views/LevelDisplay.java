package sokobon.views;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sokobon.models.DataModel;

public class LevelDisplay extends JLabel implements ChangeListener {

	DataModel dataModel; 
	
	
	
	public void attach(DataModel dataModel) {
		this.dataModel = dataModel;
	}
	
	public void stateChanged(ChangeEvent e) {
//		setText(dataModel.get);
	}

}
