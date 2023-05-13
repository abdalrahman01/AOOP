package sokobon;
import java.io.File;

import javax.swing.JComponent;

import lab2.E9.Presenter;

public class ButtonView extends Presenter {
	public ButtonView (){
		changeNorthButtonIcon(new File ("src/sokobon/resources/imgs/sokoban_icons/up.png"));
		changeSouthButtonIcon(new File ("src/sokobon/resources/imgs/sokoban_icons/down.png"));
		changeEastButtonIcon(new File ("src/sokobon/resources/imgs/sokoban_icons/höger.png"));
		changeWestButtonIcon(new File ("src/sokobon/resources/imgs/sokoban_icons/vänster.png"));
	}

	@Override
	public JComponent createCenterComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void northButtonPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eastButtonPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void southButtonPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void westButtonPressed() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args){
		ButtonView button = new ButtonView();
		
		
	}
	

}
