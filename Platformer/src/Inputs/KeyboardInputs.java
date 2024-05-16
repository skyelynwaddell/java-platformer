package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utils.Constants.Directions.*;

import Main.GamePanel;

public class KeyboardInputs implements KeyListener{
	
	private GamePanel gamePanel;
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		//up
		case KeyEvent.VK_W: 
			gamePanel.getGame().getPlayer().setUp(1); 
			
		break;
		
		//down
		case KeyEvent.VK_S: gamePanel.getGame().getPlayer().setDown(1); break;
		
		//left
		case KeyEvent.VK_A: 
			gamePanel.getGame().getPlayer().setLeft(1); 
			gamePanel.getGame().getPlayer().setImageXscale(-1);
		
		break;
		
		//right
		case KeyEvent.VK_D: 
			gamePanel.getGame().getPlayer().setRight(1); 
			gamePanel.getGame().getPlayer().setImageXscale(1);
		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		//up
		case KeyEvent.VK_W: gamePanel.getGame().getPlayer().setUp(0); break;
		
		//down
		case KeyEvent.VK_S: gamePanel.getGame().getPlayer().setDown(0); break;
		
		//left
		case KeyEvent.VK_A: gamePanel.getGame().getPlayer().setLeft(0); break;
		
		//right
		case KeyEvent.VK_D: gamePanel.getGame().getPlayer().setRight(0); break;
		}
	}

}
