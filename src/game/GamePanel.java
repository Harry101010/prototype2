package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import entities.Player;

public class GamePanel extends JPanel implements Runnable{
	public final int WIDTH = 500;
	public final int HEIGHT = 450;
	
	private final int FPS = 60;
	
	Thread gameThread;
	KeyHandler keyH = new KeyHandler();
	Player player, player2, player3;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		player = new Player(this, keyH);
		player.setSpeed(5);	
		player.setSize(50, 50);
		player.setColor(Color.blue);
		player.setPosition((WIDTH - player.getWidth()) / 2, (HEIGHT - player.getHeight()) / 2);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
	    final double drawInterval = 1_000_000_000.0 / FPS;
	    long nextDrawTime = System.nanoTime() + (long) drawInterval;

	    while (gameThread != null) {
	        update();
	        repaint();
	        
	        System.out.println(player.getPosition());

	        long remaining = nextDrawTime - System.nanoTime();
	        long sleepMillis = remaining > 0 ? remaining / 1_000_000L : 0L;

	        try {
	            if (sleepMillis > 0) {
	                Thread.sleep(sleepMillis);
	            } else {
	                // we're behind schedule — yield briefly so we don't spin hard
	                Thread.yield();
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            break;
	        }

	        nextDrawTime += (long) drawInterval;
	    }
	}
	
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		player.draw(g);
	}
}
