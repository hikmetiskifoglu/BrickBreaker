package game;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Brick Breaker");
		ObjAction objects = new ObjAction();
		
		f.setSize(600,600);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(objects);
		f.setVisible(true);
		
		

	}

}
