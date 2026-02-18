package models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import entities.Enemy;
import entities.Player;
import game.GamePanel;
import interfaces.Renderable;
import interfaces.Updatable;

public class EnemyModel implements Updatable, Renderable{
  private int SPAWN_INTERVAL_FRAMES = 45, frameCounter = 0;
  private int maxWidth = GamePanel.WIDTH, maxHeight = GamePanel.HEIGHT;
  private Random random = new Random();
  
  private List<Enemy> enemies = new ArrayList<>();
  private int WIDTH, HEIGHT, SPEED;
  private Color COLOR;

  public EnemyModel(int width, int height, int speed, Color color) {
    WIDTH = width;
    HEIGHT = height;
    SPEED = speed;
    COLOR = color;
  }

  private void spawnEnemy() {
		frameCounter = frameCounter == Integer.MAX_VALUE ? 0 : frameCounter + 1;
		if (frameCounter % SPAWN_INTERVAL_FRAMES != 0) return;
		int X_POSITION = random.nextInt(maxWidth - WIDTH);
		enemies.add(new Enemy(X_POSITION, -HEIGHT, WIDTH, HEIGHT, SPEED, COLOR));
	}

  public boolean checkCollisions(Player player) {
		for (Enemy enemy : enemies) {
			if (player.intersects(enemy)) {
        return true;
      }
		}
    return false;
  }

  private void updateEnemies() {
		Iterator<Enemy> iterator = enemies.iterator();
		while (iterator.hasNext()) {
			Enemy enemy = iterator.next();
			enemy.update();
			if (enemy.outOfHeight(maxHeight)) iterator.remove();
		}
	}

  @Override
  public void update() {
    spawnEnemy();
    updateEnemies();
  }

  @Override
  public void draw(Graphics g) {
    for (Enemy enemy : enemies) {
      enemy.draw(g);
    }
  }
}