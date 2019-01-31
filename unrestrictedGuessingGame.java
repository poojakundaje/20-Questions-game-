import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

import java.io.IOException;

/**
 * This class creates the panel with the binary tree of 20 question game
 * @author Pooja Kundaje
 *
 */
public class unrestrictedGuessingGame extends JPanel implements ActionListener{
	
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
	
	//instantiates a new JtextField to hold the users answer
	private JTextField suggestedAns;
	//instantiates a new JtextField to hold the users answer
	private JTextField suggestedQ;
	//boolean determines when the user's answer is wrong
	private boolean correctAns;
	//creates the ok button
	private JButton ok;
	//combo box with the answer to the question "Is this the answer you were thinking of?" 
	private JComboBox<String> ansCb;
	//sets the color to the panel
	Color light_yellow = new Color (255,255,205);
	
	/**
	 * constructor- places panel on frame, gets tree from the FileReader 
	 */
	public unrestrictedGuessingGame(){
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
		additionalQuestions();
		add(gif(), new BorderLayout().CENTER);
	}
	
	/**
	 * sets up the instructions on top of the panel
	 * @return instructions 
	 */
	public JLabel instructionLabel(){
		instructions= new JLabel("Pick a character from the list below or think of any character"
				+ " and play the game!");
		instructions.setFont(new Font("Arial",1,15));
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
		answerChoice.setFont(new Font("Arial",1,15));
		
		grid.setBackground(light_yellow);
		return answerChoice;
	}
	
	
	/**
	 * adds different components to panels 
	 */
	private void addMenu(){
		mainPanel.add(questionLabel());
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
    private JPanel gif() {
    	JPanel gifPanel= new JPanel();
    	gifPanel.setBackground(light_yellow);
	    	Icon imgIcon = new ImageIcon(this.getClass().getResource("giphy.gif"));
	    	JLabel label = new JLabel(imgIcon);
	    	label.setBounds(100, 20, 26, 4);
	    	gifPanel.add(label);
    		return gifPanel;

	}
	
	/**
	 * gets the root from the tree and prints onto the panel 
	 * @return
	 */
	private JLabel questionLabel() {
		node=tree.getRoot();
		questionGame= new JLabel( );
		questionGame.setFont(new Font("Arial",1,20));
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
	
	/**
	 * 
	 * @return
	 */
	public JPanel additionalQuestions(){
		//creates the panel that pops up once the answer shows 
		JPanel unrestrictedPanel= new JPanel(new GridLayout(4,0));
		
	    
	  //this JTextField holds the question "What was your answer?"
	     suggestedAns= new JTextField("What was your answer?");
	    unrestrictedPanel.add(suggestedAns);
	    
	  //this JTextField holds the question "What was your question?"
	     suggestedQ= new JTextField("What question would you use to differenciate?");
	    unrestrictedPanel.add(suggestedQ);
	    
	  //this panel holds the question "Is this the answer you were thinking of?"
	    JPanel optionPanel= new JPanel (new GridLayout(0,2));
	    JLabel quesLabel = new JLabel("Would it answer as yes or no?");
	    optionPanel.add(quesLabel);
	    //answer to "Is this the answer you were thinking of?"
	    String[] options = { "Yes", "No" };
	    ansCb = new JComboBox<String>(options);
	    optionPanel.add(ansCb);
	    unrestrictedPanel.add(optionPanel);
	    
	    //ok button 
	    ok= new JButton("ok");
	    ok.addActionListener(this);
	    unrestrictedPanel.add(ok);
	    
		return unrestrictedPanel;
		
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
			
			revalidate();
			
			//prints the next question or child onto the screen 
			questionGame.setText(node.getData().toString());
			super.update(this.getGraphics());
			}
		}
		else if (e.getSource().equals(optionBtns[1])){
			//if the getRightChild !=null, get the right child when this button is pressed
			if(node.getRightChild()!=null){
			node= node.getRightChild();
			revalidate();
			
			//prints the next question or child onto the screen 
			questionGame.setText(node.getData().toString());
			super.update(this.getGraphics());
			}
			else if(node.getRightChild()==null){
				//if there is no right child and the no button is pressed, this additional questions
				//panel pops up. 
				if (correctAns==false)			
				mainPanel.add(additionalQuestions());
				repaint();
				revalidate();
				correctAns=true;
			}
			
		}
		else if (e.getSource().equals(optionBtns[2])){
			//if this button is pressed, the game gets the root of the tree and restarts
			node= tree.getRoot();
			questionGame.setText(node.getData().toString());
			remove(additionalQuestions());
			repaint();
			revalidate();
			
		}
		else if(e.getSource().equals(ok)){
			//when you click ok after inputting user answer & question, you save the input into the tree 
			 String answer= suggestedAns.getText();
			 String question= suggestedQ.getText();
			 String value= ansCb.getSelectedItem().toString();
			 String current = node.getData();
			 node.setData(question);
			 
			 //if they said that the answer to their question should be inserted as yes, create nodes
			 //and set the child nodes 
			 if(value=="Yes"){
				  DefaultBinaryTreeNode<String> leftNode= new DefaultBinaryTreeNode<String>(); 
				  DefaultBinaryTreeNode<String> rightNode= new DefaultBinaryTreeNode<String>(); 
				  leftNode.setData(answer);
				  node.setLeftChild(leftNode);
				  
				  rightNode.setData(current);
				  node.setRightChild(rightNode);

			 }
			//if they said that the answer to their question should be inserted as yes, create nodes
			 //and set the child nodes 
			 else if(value=="No"){
				 DefaultBinaryTreeNode<String> leftNode= new DefaultBinaryTreeNode<String>(); 
				  DefaultBinaryTreeNode<String> rightNode= new DefaultBinaryTreeNode<String>(); 
				  leftNode.setData(current);
				  node.setLeftChild(leftNode);
				  
				  rightNode.setData(answer);
				  node.setRightChild(rightNode);
				 
			 }
			 
		}
		

}
}
