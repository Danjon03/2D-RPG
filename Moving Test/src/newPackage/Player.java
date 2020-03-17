package newPackage;

public class Player extends Main
{
	
	
	 int X, Y, Height, Width;
	 
	
	public Player(int x, int y, int height, int width) 
	{
		
		
		X = x;
		Y = y;
		Height = height;
		Width = width;
		
	}


	@Override
	public int getX() {
		return X;
	}


	public void setX(int x) {
		X = x;
	}


	@Override
	public int getY() {
		return Y;
	}


	public void setY(int y) {
		Y = y;
	}


	@Override
	public int getHeight() {
		return Height;
	}


	public void setHeight(int height) {
		Height = height;
	}


	@Override
	public int getWidth() {
		return Width;
	}


	public void setWidth(int width) {
		Width = width;
	}
	
	
	
	
	
	
	
}
