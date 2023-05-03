package sokobon;

public class MovingBox extends GameObject implements GameBox {
	
	
	public void moveUp() {};
	public void moveDown() {};
	public void moveLeft() {};
	public void moveRight() {};
	
	/**
	 * If the box has Reached the the right place
	 * @return
	 */
	public boolean hasReachedRedDot() {return true;};
}
