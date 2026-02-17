package entities;

import java.awt.Color;
import java.awt.Graphics;

import game.GamePanel;
import game.KeyHandler;
import interfaces.InputHandler;
import interfaces.Moveable;
import interfaces.Renderable;
import interfaces.Updatable;

public class Player extends Entity implements Updatable, Renderable, Moveable, InputHandler{
	private int speed;
	private Color color;

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
	
	protected void restrict() {
		if(x < 0) x = 0;
		if(y < 0) y = 0;
		if(x + width > GamePanel.WIDTH) x = GamePanel.WIDTH - width;
		if(y + height > GamePanel.HEIGHT) y = GamePanel.HEIGHT - height;		
	}

	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed < 0 ? 0 : speed;}
	
	public Color getColor() {return color;}
	public void setColor(Color color) {this.color = color;}
}