import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class unrestrictedGameApplication {
	
	protected TreeFileReader fileReader;
	protected GuessingGame game;
	//dimensions of the JFrame 
		protected static final int HEIGHT= 700;
		protected static final int WIDTH = 600;
		
		/**
		 * creates a JFrame for the IceCreamMaker and sets the size of the window
		 */
		public unrestrictedGameApplication(){
			fileReader= new TreeFileReader();
			JFrame Frame = new JFrame ("20 Questions game");
			Frame.setSize(WIDTH,HEIGHT);
			Color light_blue= new Color(51, 204, 255);
			//JFrame.game.getContentPanel().setBackground(light_blue);
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame.add(new unrestrictedGuessingGame());
			Frame.setVisible(true);
			
		}
		
		/**
		 * main method starts the game 
		 */
		public static void main(java.lang.String[] args){
			new unrestrictedGameApplication();
		}
		
}

	