package sokobon;

/**
Super class for the whole code
 */


import javax.swing.JLabel;

public abstract class GameObject {
	private int posX, posY;
	private int width, height;
	private JLabel icon;
	public int getPosX() {
		return posX;
	}
	
	/**
	 * Set the x coordinate for the object
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	/**
	 * Set the y coordinate for the object
	 * @return
	 */
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	/**
	 * Get the width of the object
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Set the width for the object
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Get the height of the object
	 * @return
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Set the height for the object
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Get the image or icon of the object
	 * @return
	 */
	public JLabel getIcon() {
		return icon;
	}
	
	/**
	 * Set the icon or image for the object
	 * @param icon
	 */
	public void setIcon(JLabel icon) {
		this.icon = icon;
	}
	
	/**
	 * These four class move the object in the four direction
	 */
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	
	
	
}
