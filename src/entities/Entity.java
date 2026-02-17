package entities;

public class Entity {
	int x, y;
	int width, height;
		
	public int getX() {return x;}
	public int getY() {return y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSize(int width, int height) {
		this.width = width < 0 ? 0 : width;
		this.height = height < 0 ? 0 : height;
	}

  private int prevX = 0, prevY = 0;
	private int prevWidth = 0, prevHeight = 0;

	public void printPosition() {
		if(x == prevX && y == prevY) return;
		prevX = x; prevY = y;
		System.out.printf("(%d, %d)\n", x, y);
	}

	public void printSize() {
		if(width == prevWidth && height == prevHeight) return;
		prevWidth = width; prevHeight = height;
		System.out.printf("(%d, %d)\n", width, height);
	}
}