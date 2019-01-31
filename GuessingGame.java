import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;

import java.io.IOException;

/**
 * This class creates the panel with the binary tree of 20 question game
 * @author Pooja Kundaje
 *
 */
public class GuessingGame extends JPanel implements ActionListener{
	
	//array of buttons to hold yes, no and restart
	private JButton[] optionBtns= new JButton[3];
	//creates a main panel that holds the gif, question, and buttons 
	private JPanel mainPanel = new JPanel (new GridLayout(3,1));
	//creates a main panel that holds the answer choice and instructions 
	JPanel grid= new JPanel(new GridLayout(2,0));
	//instructions for the game 
	private JLabel instructions;
	//answer choice to pick from
	private JLabel answerChoice;
	
	//20 question game which contains the parsed 20 question game 
	private TreeFileReader game;
	//instantiates a defaultBinaryTree
	private DefaultBinaryTree<String> tree;
	//label that holds the 20question game 
	private JLabel questionGame;
	//instantiates a BinaryTreeNode
	private BinaryTreeNode<String> node;
	
	//sets the color to the panel
		Color light_yellow = new Color (255,255,205);
		
		
	/**
	 * constructor- places panel on frame, gets tree from the FileReader 
	 */
	public GuessingGame(){
		//use a borderlayout
		super(new BorderLayout());
		
		game=new TreeFileReader();
		//gets the tree from the file reader
		tree=game.getTree();
		
		//adds panels to the frame at specific locations 	
		add(grid, new BorderLayout().NORTH);
		add(mainPanel, new BorderLayout().SOUTH);
		
		addMenu();
		refreshDisplay();  
		add(gif(), new BorderLayout().CENTER);

	}
	
	/**
	 * sets up the instructions on top of the panel
	 * @return instructions 
	 */
	public JLabel instructionLabel(){
		instructions= new JLabel("Pick a character from the list below and play the game");
		instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
		return instructions;
		
	}
	
	/**
	 * refreshes the display
	 */
	public void refreshDisplay(){
		repaint();
	}
	
	/**
	 * displays answer choices for user to pick from while playing the game 
	 * @return answerChoice
	 */
	public JLabel answersLabel(){
		 JLabel answerChoice = new JLabel ("<html>The Office: Kevin, Angela, Oscar, Kelly Kapoor, Erin," 
					+ "Pam, Ryan, Andy, Darryl, Creed" +  "<br>"
					+ "Friends: Mike, Joey, Gunther, Ross, Phoebe, Rachel," 
					+ "Chandler, Susan, Jack, Janice, Judy</html>"); 
		answerChoice.setAlignmentX(Component.CENTER_ALIGNMENT);
		//sets the color to the panel
		Color light_yellow = new Color (255,255,205);
		grid.setBackground(light_yellow);
		return answerChoice;
	}
	
	
	private void addMenu(){
		mainPanel.add(questionLabel(),SwingConstants.CENTER);
		//sets light blue color to panel 
		mainPanel.setBackground(new Color(200,204,255));
		mainPanel.add(createOptionMenu());
		grid.add(instructionLabel());
		grid.add(answersLabel());
		
	}
	
	/**
	 * creates a gif to place on the grid
	 * @return 
	 */
//    private JLabel gif() {
// 
//	    	Icon imgIcon = new ImageIcon(this.getClass().getResource("ajax-loader.gif"));
//	    	JLabel label = new JLabel(imgIcon);
//	    	//label.setBounds(668, 43, 46, 14); 
//    		return label;
//
//	}
	
	/**
	 * gets the root from the tree and prints onto the panel 
	 * @return
	 */
	private JLabel questionLabel() {
		node=tree.getRoot();
		questionGame= new JLabel( );
		questionGame.setText(node.getData().toString());
		return questionGame;
	}
	
	/**
	 * creates the yes, no and restart buttons for the user to answer the question
	 * @return
	 */
	private JPanel createOptionMenu(){
		//creates a panel that holds the buttons
		JPanel panel = new JPanel (new GridLayout(1,3));
		optionBtns[0] = new JButton("Yes");
		optionBtns[1] = new JButton("No");
		optionBtns[2] = new JButton("Restart");
		
		//sets color to the buttons 
		Color caramel = new Color (255, 204, 153);
		optionBtns[0].setBackground(caramel);
		optionBtns[0].setOpaque(true);
		optionBtns[0].setBorderPainted(false);
		optionBtns[1].setBackground(Color.PINK);
		optionBtns[1].setOpaque(true);
		optionBtns[1].setBorderPainted(false);
		Color light_green = new Color (204, 255, 153);
		optionBtns[2].setBackground(light_green);
		optionBtns[2].setOpaque(true);
		optionBtns[2].setBorderPainted(false);
		
		//action listener is being added to the button
		optionBtns[0].addActionListener(this);
		optionBtns[1].addActionListener(this);
		optionBtns[2].addActionListener(this);

		//adds the buttons to the panel
		panel.add(optionBtns[0]);
		panel.add(optionBtns[1]);
		panel.add(optionBtns[2]);

		
		return panel;
		
	}
	@Override
	/**
	 * if a specific optionBtns is pressed, it gets the corresponding child node 
	 */
	public void actionPerformed(ActionEvent e){
		
		if( e.getSource().equals(optionBtns[0])) {
			//if the getLeftChild !=null, get the left child when this button is pressed
			if(node.getLeftChild()!=null){
			node= node.getLeftChild();
			//prints the next question or child onto the screen 
			questionGame.setText(node.getData().toString());
			repaint();
			revalidate();
			
			}
		}
		else if (e.getSource().equals(optionBtns[1])){
			//if the getRightChild !=null, get the right child when this button is pressed
			if(node.getRightChild()!=null){
			node= node.getRightChild();
			//prints the next question or child onto the screen 
			questionGame.setText(node.getData().toString());
			repaint();
			revalidate();

			}
		}
		else if (e.getSource().equals(optionBtns[2])){
			//if this button is pressed, the game gets the root of the tree and restarts
			node= tree.getRoot();
			questionGame.setText(node.getData().toString());
			repaint();
			revalidate();
		}
		
		
}
	/**
	 * creates a gif to place on the grid
	 * @return 
	 */
    private JPanel gif() {
    	JPanel gifPanel= new JPanel();
    	gifPanel.setBackground(light_yellow);
	    	Icon imgIcon = new ImageIcon(this.getClass().getResource("giphy.gif"));
	    	JLabel label = new JLabel(imgIcon);
	    	label.setBounds(100, 20, 26, 4);
	    	gifPanel.add(label);
    		return gifPanel;

	}
}
