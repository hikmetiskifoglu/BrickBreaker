package game;

import java.awt.*;


public class Obj extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	boolean brickCheck = true;
	
	Image im;
	
	int xPos = -1;
	int yPos = -2;

	Toolkit t=Toolkit.getDefaultToolkit();

	Obj(int x, int y, int width, int height, String name){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		if(name == "yellow") {
			im = t.getImage("resources/yellow.png");
		}
		else if (name == "red") {
			im = t.getImage("resources/red.png");
		}
		else if (name == "paddle") {
			im = t.getImage("resources/paddle.png");
		}
		else if (name == "ball") {
			im = t.getImage("resources/ball.png");
		}
		
	}
	
	public void draw(Graphics g, Component c) {
		if(brickCheck) 
			g.drawImage(im, x, y, width, height, c);
			
	}
	
}
