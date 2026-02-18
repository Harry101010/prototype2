package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame("Dodge the Blocks");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		ImageIcon icon = new ImageIcon("icon.png");
		window.setIconImage(icon.getImage());
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		
		window.setResizable(false);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}
}