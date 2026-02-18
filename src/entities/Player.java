package entities;

import java.awt.Color;
import java.awt.Graphics;

import game.GamePanel;
import game.KeyHandler;
import interfaces.InputHandler;
import interfaces.Movable;
import interfaces.Renderable;
import interfaces.Updatable;

public class Player extends Entity implements Updatable, Renderable, Movable, InputHandler{
	private int speed;
	private Color color;
	private int maxWidth = GamePanel.WIDTH, maxHeight = GamePanel.HEIGHT;

	KeyHandler keyH;
	
	public Player(KeyHandler keyH) {
		this.keyH = keyH;
	}
	
	@Override public void moveLeft()  {x -= speed;}
	@Override public void moveRight() {x += speed;}
	@Override public void moveUp()    {y -= speed;}
	@Override public void moveDown()  {y += speed;}
	
	@Override
	public void handleInput() {
		if(keyH.upPressed) moveUp();
		if(keyH.downPressed) moveDown();
		if(keyH.rightPressed) moveRight();
		if(keyH.leftPressed) moveLeft();		
	}
	
	@Override
	public void update() {
		handleInput();
		restrict();
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	private void restrict() {
		x = Math.max(0, Math.min(x, maxWidth - width));
		y = Math.max(0, Math.min(y, maxHeight - height));
	}

	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = Math.max(0, speed);}
	
	public Color getColor() {return color;}
	public void setColor(Color color) {this.color = color;}
}