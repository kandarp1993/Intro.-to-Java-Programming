/**
 * Author - Kandarp Desai
 * CWID - 10419687
 * Date - 11/07/2017
 * Description - This program use to start Brick Breaker game. 
 **/

package BrickBreaker;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame obj = new JFrame();
		GamePlay gamePlay = new GamePlay();
		
		// set bounds of JFrame
		obj.setBounds(10, 10, 700, 600);
		// set title of JFrame
		obj.setTitle("Brick Breaker");
		// set resize of JFrmae to false
		obj.setResizable(false);

		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
	}

}
