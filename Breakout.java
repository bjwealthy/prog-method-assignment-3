/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
	}



private void createBricks(int n, double cx, double cy){
	for(int row = 0; row < 10; row++){
		for(int col = 0; col < 10; col++){
			//to get the x- and y-coordinates of the starting brick
			//i.e the one at the centre
			double x = cx - (NBRICKS_PER_ROW*BRICK_WIDTH)/2 - (NBRICKS_PER_ROW - 1)*BRICK_SEP/2  + col*BRICK_WIDTH + col*BRICK_SEP)/2 + BRICK_WIDTH + col*BRICK_SEP;
			double y = cy + row*BRICK_HEIGHT + row*BRICK_SEP;
			
		private GRect bri;
		bri = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(bri);
		
		//painting bricks
		for(row = 0; row < 2; row++ )
			bri.setColor(Color.RED);
		for(row = 2; row < 4; row++)
			bri.setColor(Color.ORANGE);
		for (row = 4; row < 6; row++)
			bri.setColor(Color.YELLOW);
		for(row = 6; row < 8; row++)
			bri.setColor(Color.GREEN);
		for(row = 7; row < 10; row++ );
		
			
		}
	}
}

//to add and crate paddles
private GRect paddle; //paddle as an instance variable

private void makePaddl(){
	double x = getWidth()/2 - PADDLE_WIDTH/2; //THIS IS WHRE PADDLe starts from x = 0;
	double y = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT; //BASELINE OF PADDLE
	paddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
	paddle.setFilled(true);
	
	addMouseListeners(); //to listen foe mouse events
	add(paddle);	
}

public void mouseMoved(MouseEvent e){
	if(e.getX() < (getWidth() - (PADDLE_WIDTH/2))) && (e.getX() > (PADDLE_WIDTH/2)))
paddle.setLocation(e.getX() - PADDLE_WIDTH/2, getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
}
}

//drawing and adding ball
private GOval ball;  //ball is declared as an instance variable 

private void drawBall(){
	ball = new GOval(x, y, BALL_RADIUS);
	ball.setFilled(true);
	double x = getWidth()/2 - BALL_RADIUS;
	double y = getHeight()/2 - BALL_RADIUS;
	add(ball);
}

private void play(){
	getVelocityOfBall();
	waitForClick();
	while(true){
		moveBall();
		
		if(ball.getY() >= getHeight()){
			break;
		}
	}
}

private void moveBall(){
	ball.move(vx, vy);
	
	if((ball.getX() - vy <= 0 && vx < 0)){
		vx = -vy;
}
	
	GObject collider = getCollidingObject();
	if(collider == paddle){
		if(ball.getY() >= getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS*2 && ball.getY() < getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS*2 + 4){
			vy = -vy;
		}
	}
	
	else if(collider != null){
		remove(collider);
		brickCounter--;
		vy = -vy;
	}
	pause(DELAY);
}

private GObject getCollidingObject(){
	if(getElentAt(ball.get(), ball.getY()) != null){
		return  getElementAt(ball.getX(), ball.getY());
    }
  else if (getElementAt( (ball.getX() + BALL_RADIUS*2), ball.getY()) != null ){
       return getElementAt(ball.getX() + BALL_RADIUS*2, ball.getY());
    }
  else if(getElementAt(ball.getX(), (ball.getY() + BALL_RADIUS*2)) != null ){
       return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS*2);
    }
  else if(getElementAt((ball.getX() + BALL_RADIUS*2), (ball.getY() + BALL_RADIUS*2)) != null ){
       return getElementAt(ball.getX() + BALL_RADIUS*2, ball.getY() + BALL_RADIUS*2);
    }
  //need to return null if there are no objects present
  else{
       return null;
    }
  
}

private void printGameOver() {
  GLabel gameOver = new GLabel ("Game Over", getWidth()/2, getHeight()/2);
  gameOver.move(-gameOver.getWidth()/2, -gameOver.getHeight());
  gameOver.setColor(Color.RED);
  add (gameOver);
}

private int brickCounter = 100;

private void printWinner() {
  GLabel Winner = new GLabel ("Winner!!", getWidth()/2, getHeight()/2);
  Winner.move(-Winner.getWidth()/2, -Winner.getHeight());
  Winner.setColor(Color.RED);
  add (Winner);

		
	}
	
}

