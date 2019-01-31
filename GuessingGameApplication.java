import java.awt.Color;

import javax.swing.JFrame;


public class GuessingGameApplication {
	
	protected TreeFileReader fileReader;
	//dimensions of the JFrame 
		protected static final int HEIGHT= 700;
		protected static final int WIDTH = 600;
		
		/**
		 * creates a JFrame for the IceCreamMaker and sets the size of the window
		 */
		public GuessingGameApplication(){
			fileReader= new TreeFileReader();
			JFrame Frame = new JFrame ("20 Questions game");
			Frame.setSize(WIDTH,HEIGHT);
			Color light_blue= new Color(51, 204, 255);
			//JFrame.getContentPanel().setBackground(light_blue);
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame.add(new GuessingGame());
			Frame.setVisible(true);
			
		}
		
		/**
		 * main method starts the game 
		 */
		public static void main(java.lang.String[] args){
			new GuessingGameApplication();
		}

	
}
