/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 11/07/2017
 * Description - This program set slider position, ball position and detect intersection between two objects. 
 **/

package BrickBreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener,ActionListener{ 
	private static final long serialVersionUID = 1L;
	
	 boolean play = false;
	
	// total score
	private int score = 0;
	
	// total no of brick for the game
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	//Slider position in the beginning
	private int PlayerX= 310;
	
	//Ball position in the beginning
	private int ballPosX = 120;
	private int ballPosY = 350;
	
	//Ball Direction
	private int ballXDir = -1;
	private int ballYDir = -2;
	
	//to generate bricks
	private MapGenerator map;
	
	
	
	public GamePlay() {
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		//background color
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		//border
		g.setColor(Color.yellow);
		g.fillRect(0,0,3,592);
		g.fillRect(0,0,692,3);
		g.fillRect(691,0,3,592);
		
		// display score 
		g.setColor(Color.WHITE);
		g.setFont(new Font("Roman", Font.BOLD, 35));
		g.drawString(" "+score, 590, 30);
		
		
		// draw map
		map.drawBricks((Graphics2D)g);
		
		//paddle
		g.setColor(Color.green);
		g.fillRect(PlayerX,550,100,8);
		
		//the ball
		g.setColor(Color.yellow);
		g.fillOval(ballPosX,ballPosY,20,20);
		
		if(totalBricks <= 0) {
			play = false;
			ballXDir = 0;
			ballYDir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("Roman", Font.BOLD, 45));
			g.drawString("You Won ", 260, 300);
			
			g.setFont(new Font("Roman", Font.BOLD, 25));
			g.drawString("Press enter to restart ", 230, 350);
		}
		
		if(ballPosY > 570) {
			play = false;
			ballXDir = 0;
			ballYDir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("Roman", Font.BOLD, 45));
			g.drawString("Game Over. Score: "+ score, 190, 300);
			
			g.setFont(new Font("Roman", Font.BOLD, 25));
			g.drawString("Press enter to restart ", 230, 350);		
			
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		timer.start();
		if(play) {
			// Detect intersection between two objects
			if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(PlayerX, 550, 100, 8))) {
				ballYDir = -ballYDir;
			}
			A: for(int i =0; i< map.map.length;i++) {
				for(int j =0; j<map.map[0].length;j++) {
					if(map.map[i][j] > 0) {
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballrect = new Rectangle(ballPosX, ballPosY, 20, 20);
						Rectangle brickrect = rect;
						
						// if ball intersect brick
						if(ballrect.intersects(brickrect)) {
							map.setBricks(0, i, j);
							totalBricks--;
							score += 5;
							
							if(ballPosX + 19 <= brickrect.x || ballPosX + 1 >= brickrect.x + brickrect.width ) {
								ballXDir = -ballXDir;
							}
							else {
								ballYDir = -ballYDir;
							}
							break A;
						}

					}
				}
			}
			// to move paddle according to pressed key
			ballPosX += ballXDir;
			ballPosY += ballYDir;
			if(ballPosX < 0) {
				ballXDir = -ballXDir;
			}
			if(ballPosY < 0) {
				ballYDir = -ballYDir;
			}
			if(ballPosX > 670) {
				ballXDir = -ballXDir;
			}
			
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(PlayerX >= 600) {
				PlayerX = 600;
			}
			else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(PlayerX < 10) {
				PlayerX = 10;
			}
			else {
				moveLeft();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play = true;
				ballPosX = 120;
				ballPosY = 350;
				ballXDir = -1;
				ballYDir = -2;
				PlayerX = 310;
				score = 0;
				totalBricks = 21;
				map = new MapGenerator(3, 7);
				
				repaint();
				
			}
		}
			
	}
	
	public void moveRight() {
		play = true;
		PlayerX+=20;
	}
	public void moveLeft() {
		play = true;
		PlayerX-=20;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	} 	

}
