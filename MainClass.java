package pingpong;

import javax.swing.JFrame;

public class MainClass {
	
	public static void main(String[] args){
		
		JFrame frame=new JFrame("PingPong");
		frame.setContentPane(new GamePlay());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.setBounds(0,0,600,620);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
