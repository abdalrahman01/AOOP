package sokobon;

import javax.swing.JLabel;

public abstract class GameObject {
	private int posX, posY;
	private int width, height;
	private JLabel icon;
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public JLabel getIcon() {
		return icon;
	}
	public void setIcon(JLabel icon) {
		this.icon = icon;
	}
	
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	
	
	
}
