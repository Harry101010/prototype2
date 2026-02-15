package entities;

import java.awt.Point;

public class Entity {
	int x, y;
	int width, height;
		
	public int getX() {return x;}
	public int getY() {return y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public Point getPosition() {return new Point(x,y);}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
}