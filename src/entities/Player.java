package entities;

import java.awt.Color;
import java.awt.Graphics;

import game.GamePanel;
import game.KeyHandler;
import interfaces.Moveable;

public class Player extends Entity implements Moveable{
	private int speed;
	private Color color;
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
	}
	
	@Override public void moveLeft()  {x -= speed;}
	@Override public void moveRight() {x += speed;}
	@Override public void moveUp()    {y -= speed;}
	@Override public void moveDown()  {y += speed;}
	
	public void handleInput() {
		if(keyH.upPressed) moveUp();
		if(keyH.downPressed) moveDown();
		if(keyH.rightPressed) moveRight();
		if(keyH.leftPressed) moveLeft();		
	}
	
	public void restrict() {
		if(x < 0) x = 0;
		if(y < 0) y = 0;
		if(x + width > gp.WIDTH) x = gp.WIDTH - width;
		if(y + height > gp.HEIGHT) y = gp.HEIGHT - height;		
	}
	
	public void update() {
		handleInput();
		restrict();
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed < 0 ? 0 : speed;}
	
	public Color getColor() {return color;}
	public void setColor(Color color) {this.color = color;}
}