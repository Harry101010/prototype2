package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public boolean upPressed, downPressed, rightPressed, leftPressed,
	wPressed, aPressed, sPressed, dPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
			case KeyEvent.VK_UP    :  	upPressed    = true; break;
			case KeyEvent.VK_DOWN  :  	downPressed  = true; break;
			case KeyEvent.VK_RIGHT :  	rightPressed = true; break;
			case KeyEvent.VK_LEFT  :	leftPressed  = true; break;
			case KeyEvent.VK_W     :  	wPressed    = true; break;
			case KeyEvent.VK_A     :  	aPressed  = true; break;
			case KeyEvent.VK_S     :  	sPressed = true; break;
			case KeyEvent.VK_D     :	dPressed  = true; break;
			default:
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
			case KeyEvent.VK_UP    :  	upPressed    = false; break;
			case KeyEvent.VK_DOWN  :  	downPressed  = false; break;
			case KeyEvent.VK_RIGHT :  	rightPressed = false; break;
			case KeyEvent.VK_LEFT  :	leftPressed  = false; break;
			case KeyEvent.VK_W     :  	wPressed    = false; break;
			case KeyEvent.VK_A     :  	aPressed  = false; break;
			case KeyEvent.VK_S     :  	sPressed = false; break;
			case KeyEvent.VK_D     :	dPressed  = false; break;
			default:
		}
	}
}