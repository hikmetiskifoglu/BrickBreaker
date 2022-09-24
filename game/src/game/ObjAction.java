package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ObjAction extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Obj> objBrick = new ArrayList<Obj>(); //for bricks
	ArrayList<Obj> objBall = new ArrayList<Obj>(); // for ball

	int xSpace = 5;
	int ySpace = 3;
	
	int xBrick = 71;
	int yBrick = 25;
	
	int btwnBrick = 1;
	//int a = 0;

	Obj paddle;
	Obj ball;
	
	int xBall = 150;
	int yBall = 350;
	
	Thread gamePlay;
	Play play;
	
	boolean start = false;

	public ObjAction() { 
		paddle =new Obj(320, 505, 110, 10, "paddle");
		ball = new Obj(180, 380, 12, 12, "ball");
		
		for( int a = 1 ; a < 3 ; a++) {
			for(int i = 0 ; i < 8 ; i++) {
				objBrick.add(new Obj(xSpace +  (i*(70 + 2)) , ySpace + ((a-1)*(2*25 +5)), xBrick, yBrick, "yellow")); 
					 
				if(a == 1) {
					objBrick.add(new Obj(xSpace + (i*(70 + 2)) , ySpace + ((a)*(25 +3)), xBrick, yBrick, "red"));
			 }
				if(a == 2) {
					objBrick.add(new Obj( xSpace + (i*(70 + 2)) , ySpace + ((a+1)*(25)+8), xBrick, yBrick, "red"));
					
				 }
			 }
		 }
	
		objBall.add(ball);
		setFocusable(true);
		addKeyListener(this);
	}
	
	public void paint (Graphics objects) {
		super.paint(objects);
		
		/*objects.setColor(Color.black);
		objects.fillRect(1, 1, 592, 592);*/
		
		for (Obj o : objBrick) 
			o.draw(objects, this);

		for(Obj ball : objBall)
			ball.draw(objects, this);

		paddle.draw(objects, this);
		

	}
	
	
	public void update() {
	
		if(start) {
			
			if(ball.intersects(paddle)) {
				int paddlePos = (int) paddle.getMinX();
				int ballPos = (int) ball.getMinX();
				
				
				
				if(ballPos < paddlePos + 22) {
					ball.yPos = -1;
					ball.xPos = -1;

				}
				
				if(ballPos >= paddlePos + 22 && ballPos < paddlePos + 44) {
					ball.xPos = -1;
					ball.yPos = -ball.yPos;

				}
				if(ballPos >= paddlePos + 44 && ballPos < paddlePos + 66) {
					ball.xPos = 0;
					ball.yPos = -1;

				}
				if(ballPos >= paddlePos + 66 && ballPos < paddlePos + 88) {
					ball.xPos = 1;
					ball.yPos = -ball.yPos;

				}
				if(ballPos > paddlePos + 88 ) {
					ball.xPos = 1;
					ball.yPos = -1;

				}
			}
			
			//borders
			if(ball.x < 0)// for the left border
				ball.xPos = -ball.xPos;
			
			if(ball.x >= 570) //for the right border
				ball.xPos = -ball.xPos;
			
			if(ball.y < 0) // for the top border
				ball.yPos = -ball.yPos; 
			
			ball.x += ball.xPos;
			ball.y += ball.yPos;

			for(Obj brick : objBrick) {
				if(brick.brickCheck) {
					if((ball.intersects(brick))) {
						brick.brickCheck = false;
						ball.yPos = -ball.yPos; 
					}			
				}	
			}
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			play = new Play(this);
			gamePlay = new Thread(play);
			gamePlay.start();
			start = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			if(paddle.x >= 483) 
				paddle.x = 483;
			else
				slideToRight();
		}
	
		if(e.getKeyCode() == KeyEvent.VK_A) { 
			if(paddle.x < 10) 
				paddle.x = 10;
			else
				slideToLeft();
			}
		}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	public void slideToRight() {
		paddle.x += 10;
		
	  }

	public void slideToLeft() {
		paddle.x -= 10;
	    
	  }
}
