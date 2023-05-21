package sokobon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class KeyBoardListner implements KeyListener {
	
	
    /**
     * Moves player in direction of arrow keys
     * @param e KeyEvent
     */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode) {
            case KeyEvent.VK_LEFT:
            	//moveplayerLeft
                break;
            case KeyEvent.VK_RIGHT:
            	//moveplayerRight
                break;
            case KeyEvent.VK_UP:
            	//moveplayerUP
                break;
            case KeyEvent.VK_DOWN:
            	//moveplayerDown
                break;
            case KeyEvent.VK_SPACE :
              
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
    	 int keyCode = e.getKeyCode();
    	    switch(keyCode) {
    	        case KeyEvent.VK_LEFT:
    	           // moveplayerLeft = false;
    	            break;
    	        case KeyEvent.VK_RIGHT:
    	           // moveplayerRight = false;
    	            break;
    	        case KeyEvent.VK_UP:
    	           // moveplayerUp = false;
    	            break;
    	        case KeyEvent.VK_DOWN:
    	           // moveplayerDown = false;
    	            break;
    	    }
    }

 
    public static void main(String[] args) {
		JFrame frame = new JFrame("Sokobon");	
		KeyBoardListner listener = new KeyBoardListner();
		frame.addKeyListener(listener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
