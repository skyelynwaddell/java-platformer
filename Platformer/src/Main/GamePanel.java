package Main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import Inputs.KeyboardInputs;
import Inputs.MouseInputs;


public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MouseInputs mouseInputs;
	private Game game;

	public GamePanel(Game game) {
		mouseInputs = new MouseInputs(this);
		this.game = game;
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	private void setPanelSize() {
		int screenWidth  = 800;
		int screenHeight = 480;
		
		Dimension size = new Dimension(screenWidth,screenHeight);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}

	public void updateGame() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}
	
	public Game getGame() {
		return game;
	}
}
