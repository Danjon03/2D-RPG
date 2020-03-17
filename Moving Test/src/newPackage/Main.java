package newPackage;

import java.awt.Canvas;

import javax.swing.JFrame;
 
public class Main extends Canvas {
 
	
	//public Player player = new Player("Daniel", 10, 10, 10, 10, 10);
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		TestPane s = new TestPane();
		f.add(s);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		System.out.println(f.getHeight() + " " + f.getWidth());
		
		
		
	}
	
	public static void help()
	{
		

		

		
	}
	
	
	
	
}
