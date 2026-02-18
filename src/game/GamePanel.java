package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import entities.Enemy;
import entities.Player;
import models.EnemyModel;

public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 450;
	private final int FPS = 60;
	
	Thread gameThread;
	KeyHandler keyH = new KeyHandler();
	
	Player player;
	EnemyModel enemyModel;
	boolean gameOver = false;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		player = new Player(keyH);
		player.setSpeed(5);	
		player.setSize(50, 50);
		player.setColor(Color.blue);
		player.setPosition((WIDTH - player.getWidth()) / 2, (HEIGHT - player.getHeight()) / 2);

		enemyModel = new EnemyModel(30, 30, 5, Color.red);
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
					if (!gameOver) {
						update();
						repaint();
					}

	        long remaining = nextDrawTime - System.nanoTime();
	        long sleepMillis = remaining > 0 ? remaining / 1_000_000L : 0L;

	        try {
	            if (sleepMillis > 0) {
	                Thread.sleep(sleepMillis);
	            } else {
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
		enemyModel.update();
		gameOver = enemyModel.checkCollisions(player);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		player.draw(g);
		enemyModel.draw(g);

		if (!gameOver) return;
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.drawString("Game Over", WIDTH / 2 - 70, HEIGHT / 2);
	}
}