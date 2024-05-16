package Main;
import javax.swing.JFrame;

public class GameWindow {
	
	private JFrame jframe;
	public GameWindow(GamePanel gamePanel) {
		
		jframe = new JFrame();
		
		String gameName  = "Platformer";
		
		jframe.setTitle(gameName);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.pack();
		jframe.setVisible(true);
		jframe.setResizable(false);
	}
}
