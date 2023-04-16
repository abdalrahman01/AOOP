package lab2.E9;

import javax.swing.JComponent;

public class TestPresenter extends Presenter {

	static TestPresenter p;

	@Override
	public JComponent createCenterComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void northButtonPressed() {
		// TODO Auto-generated method stub
		System.out.println("north");
		p.showText("north");

	}

	@Override
	public void eastButtonPressed() {
		// TODO Auto-generated method stub
		System.out.println("east");
		p.showText("east");

	}

	@Override
	public void southButtonPressed() {
		// TODO Auto-generated method stub
		System.out.println("south");
		p.showText("south");

	}

	@Override
	public void westButtonPressed() {
		// TODO Auto-generated method stub
		System.out.println("west");
		p.showText("west");
		

	}

	public static void main(String[] args) {
		p = new TestPresenter();

	}

}
