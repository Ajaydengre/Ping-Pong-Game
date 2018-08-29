package pingpong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;





public class GamePlay extends JPanel implements KeyListener, ActionListener {
	
	private boolean play = false;
	private int playerX=270;
	private int playerY=270;
	private int ballXpos=558;
	private int ballYpos=300;
	private int ballXdir=-1;
	private int ballYdir=-2;
	private Timer timer;
	private int delay = 8;
	public GamePlay(){
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		timer = new Timer(delay,this);
		timer.start();
	}

	public void paint(Graphics g){
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 600, 600);
		
		g.setColor(Color.blue);
		g.fillRect(10, playerY, 8, 100);
		
		g.setColor(Color.red);
		g.fillRect(580, playerX, 8, 100);
		
		g.setColor(Color.green);
		g.fillOval(ballXpos,ballYpos, 20, 20);
		
		if(ballXpos>585){
			play=false;
			ballXdir=0;
			ballYdir=0;
			
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("Player1 Won",220, 300);
			
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("Press Enter To Restart",200, 350);
			
		}
		
		if(ballXpos<10){
			play=false;
			ballXdir=0;
			ballYdir=0;
			
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,30));
			g.drawString("Player2 Won",220, 300);
			
			g.setColor(Color.red);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString("Press Enter To Restart",200, 350);
			
		}
		
		
		
		g.dispose();
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play){
			if(new Rectangle(ballXpos,ballYpos,20,20).intersects(new Rectangle(580,playerX,8,100))){
				ballXdir=-ballXdir;
				
			}
			if(new Rectangle(ballXpos,ballYpos,20,20).intersects(new Rectangle(10,playerY,8,100))){
				ballXdir=-ballXdir;
				
			}
		

	
		ballXpos+=ballXdir;
		ballYpos+=ballYdir;
		}
		
		if(ballYpos<0){
			ballYdir= -ballYdir;
		}
		if(ballYpos>570){
			ballYdir= -ballYdir;
		}
		
	
	repaint();

}

	

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			if(playerX <= 10){
				playerX =10;
			}
			else{
				play = true;
			    playerX-=40;}
		}
			
		
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
        	if(playerX >= 500){
				playerX =500;
			}
			else{
				play = true;
			    playerX+=40;}
			
		 }
if(e.getKeyCode()==KeyEvent.VK_W){
	if(playerY <= 10){
		playerY =10;
	}
	else{
		play = true;
	    playerY-=40;}
			
		}
if(e.getKeyCode()==KeyEvent.VK_S){
	if(playerY >= 500){
		playerY =500;
	}
	else{
		play = true;
	    playerY+=40;}
}

if( e.getKeyCode() == KeyEvent.VK_ENTER) {
	if(!play){
		
		
		ballXdir=-1;
		ballYdir=-2;
	    playerX=270;
		playerY=270;
		ballXpos=15;
		ballYpos=300;
		
		
		repaint();
		
	}
}
		

	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}

}
