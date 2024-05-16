package Main;

import java.awt.Graphics;

import entities.Player;

public class Game implements Runnable {
	
	private GameWindow gameWindow;
	private GamePanel  gamePanel;
	private Thread     gameThread;
	
	private final int  FPS_SET = 60;
	private final int  UPS_SET = 200;
	
	private Player player;
	
	public Game() {
		initClasses(); //first execution
		gamePanel  = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		
		//Last item in game 
		StartGameLoop();
	}
	
	private void initClasses() {
		// TODO Auto-generated method stub
		player = new Player(200,200);
		
	}

	private void StartGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public void update() {
		player.update();
	}
	
	public void render(Graphics g) {
		player.render(g);
	}

	@Override
	public void run() {
		
		double timePerFrame  = 1000000000 / FPS_SET;
		double timePerUpdate = 1000000000 / UPS_SET;
		
		int frames        = 0;
		int updates       = 0;
		double deltaU     = 0;
		double deltaF     = 0;
		
		long lastCheck    = System.currentTimeMillis();
		long previousTime = System.nanoTime();				
		
		while(true) {
			
			long currentTime = System.nanoTime();
			
			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			
			previousTime = currentTime;
			
			if(deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}
			
			if (deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			
			
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				
				System.out.println("FPS: " + frames + " | Update: " + updates);
				frames    = 0;
				updates   = 0;
			};
		}
	}
	
	public Player getPlayer() {
		return player;
	}
}
