package sokobon;

import java.io.File;

/**
 * The Red circle that the boxes must come to or occur
 * @author aliab
 *
 */
// RedDots
public class Goal extends GameObject{
	
	public Goal() {
		setIconGameObject(new File("src/sokobon/resources/imgs/sokoban_icons/blankmarked.png"));
	}
	
	public void notifyObserver() {}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	};
}
