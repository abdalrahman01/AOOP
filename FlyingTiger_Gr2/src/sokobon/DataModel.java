package sokobon;

/**
  keeps track of the current level (board)
  state of the game
  accepts controlling events to update the state
  checks for end-of-game / winning conditions
  notifies observers whenever necessary
 
 @author aliab
 */

public class DataModel {
	Level currentLevel;
	GameState state;
	
	public boolean checkForWin() {
		return true;
	}
	
	public boolean checkForLose() {
		return true;
	}
	
	public void notifyObsever() {
		
	}
}
