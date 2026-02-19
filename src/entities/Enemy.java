package entities;

import java.awt.Color;
import java.awt.Graphics;

import interfaces.Movable;
import interfaces.Renderable;
import interfaces.Updatable;

public class Enemy extends Entity implements Updatable, Renderable, Movable{
	private int speed;
	private Color color;

  public Enemy() {}
	public Enemy(int x, int y, int width, int height, int speed, Color color) {
		setPosition(x, y);
		setSize(width, height);
		this.speed = speed;
		this.color = color;
	}

	@Override public void moveLeft()  {x -= speed;}
	@Override public void moveRight() {x += speed;}
	@Override public void moveUp()    {y -= speed;}
	@Override public void moveDown()  {y += speed;}

	@Override
	public void update() {
		moveDown();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public boolean outOfHeight(int maxHeight) {return y > maxHeight;}
	public boolean outOfWidth(int maxWidth) {return x > maxWidth;}
}