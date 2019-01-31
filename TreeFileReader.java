import javax.xml.parsers.*;

import org.xml.sax.SAXException;  
import org.w3c.dom.*;

import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

import java.io.*;

/**
 * parses the xml file into a binary tree
 * @author Pooja Kundaje
 *
 */
public class TreeFileReader {
//private static DefaultBinaryTree<String> tree;
	public static DefaultBinaryTree<String> tree;
	
	/**
	 *  Creates a document which takes the XML file and parses it into something 
	 *  that can be read by the program. try/catch blocks to prevent exceptions 
	 *  from crashing the program.
	 */
	public TreeFileReader(){
		try {
			//Setup XML Document,
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File( "20_Questions.xml");
			Document document = builder.parse( xmlFile );
			parseFounderFile(  document );

		} catch (ParserConfigurationException pce) {
			//what to do if this exception happens
			System.out.println(pce);

		} catch (SAXException saxe) {				
			//what to do if this exception happens
			System.out.println(saxe);

		} catch (IOException ioe) {
			//what to do if this exception happens
			System.out.println(ioe);
		}
	}

	/**
	 * Navigates through the major document structure, calls parseNode and passes in the 
	 * root node of the document 
	 * @param document
	 */
	private static void parseFounderFile( Document document ){
		 tree= new DefaultBinaryTree<String>();
		Element docRoot =  document.getDocumentElement();
		tree.setRoot(parseQuestionNode(docRoot));
		System.out.println(tree.preorderTraversal().toString());
	}

	/**
	 * Recursive method that is called on all question nodes in the document, including child nodes.
	 * @param n
	 * @return newNode
	 */
	private static DefaultBinaryTreeNode<String> parseQuestionNode(Element n){
			
		
		if(n.getTagName().equals("question")){

			DefaultBinaryTreeNode<String> newNode= new DefaultBinaryTreeNode<String>();
			newNode.setData(n.getAttribute("id"));
			
			
			if(n.hasChildNodes()){
				//the list of children nodes
				NodeList child = n.getChildNodes();
				//run a for loop through the list 
				for(int i=0; i<child.getLength(); i++){
					if(child.item(i) instanceof Element){	
						//checks if childNode has the nodeType Element
						Element childElement= (Element)child.item(i);
					
						if(childElement.getAttribute("userAns").equals("yes")){

							//gets the left child of the node if "yes"
							newNode.setLeftChild(parseAnswerNode(childElement));
						}
						else {
							//gets the left child of the node if "no"
							newNode.setRightChild(parseAnswerNode(childElement));
					}
				}

			}
			}
			return newNode;
		}
		return null;
		
	}

	/**
	 *  Recursive method that is called on all leaf nodes in the document, including child nodes.
	 * @param n
	 * @return leafNode
	 */
	private static DefaultBinaryTreeNode<String> parseAnswerNode(Element n) {
		

//		DefaultBinaryTreeNode<String> newNode= new DefaultBinaryTreeNode<String>();
		DefaultBinaryTreeNode<String> leafNode= new DefaultBinaryTreeNode<String>();
		if(n.getTagName().equals("answer")){
			if(n.hasChildNodes()){
				//the list of children nodes
				NodeList child = n.getChildNodes();
				//run a for loop through the list 
				for(int i=0; i<child.getLength(); i++){

					//checks if childNode has the nodeType Element
					if( child.item(i) instanceof Element){
						
						Element childEl= (Element)child.item(i);
						
						//if the tag name is guess, create a leaf node and print the text
						if(childEl.getTagName().equals("guess")){
							leafNode.setData(childEl.getAttribute("text"));
						}
						else{
							//if its a question call parseQuestionNode
							leafNode= parseQuestionNode(childEl);
						}
					}
				}

				
			}
		
		}
		return leafNode;	
		}
	
	/**
	 * gets the tree 
	 * @return tree
	 */
	public DefaultBinaryTree<String> getTree(){
		return tree;
	}

}