package datastructures;


/**
 * This class creates methods to transverse through a binary search tree and creates
 * the tree
 * @author Pooja Kundaje 
 *
 * @param <T>
 */
public class DefaultBinaryTree<T> implements BinaryTree<T>{

	protected DefaultBinaryTreeNode<T> root;

	/**
	 * main method for the DefaultBinaryTreeClass which prints the tree corresponding to 
	 * the seven dwarfs.
	 * @param args
	 */
	public static void main (String[]args){
		//creates a new defualtBinaryTree
		DefaultBinaryTree<String> tree = new DefaultBinaryTree<String>();
		
		//creates 7 new nodes
		DefaultBinaryTreeNode<String> Happy = new DefaultBinaryTreeNode<String>();
		Happy.setData("happy");
		DefaultBinaryTreeNode<String> Doc = new DefaultBinaryTreeNode<String>();
		Doc.setData("doc");
		DefaultBinaryTreeNode<String> Bashful = new DefaultBinaryTreeNode<String>();
		Bashful.setData("Bashful");
		DefaultBinaryTreeNode<String> Grumpy = new DefaultBinaryTreeNode<String>();
		Grumpy.setData("Grumpy");
		DefaultBinaryTreeNode<String> Dopey = new DefaultBinaryTreeNode<String>();
		Dopey.setData("Dopey");
		DefaultBinaryTreeNode<String> Sleepy = new DefaultBinaryTreeNode<String>();
		Sleepy.setData("Sleepy");
		DefaultBinaryTreeNode<String> Sneezy = new DefaultBinaryTreeNode<String>();
		Sneezy.setData("Sneezy");
		
		//sets happy as the root and creates the tree in a specific order
		tree.setRoot(Happy);
		Happy.setLeftChild(Doc);
		Happy.setRightChild(Sleepy);
		Doc.setRightChild(Grumpy);
		Doc.setLeftChild(Bashful);
		Grumpy.setRightChild(Dopey);
		Sleepy.setRightChild(Sneezy);
		
		//calls the inorderTraversal, preorderTraversal, postorderTraversal
		tree.inorderTraversal();
		tree.preorderTraversal();
		tree.postorderTraversal();
		
		
		
	}


	/**
	 * Get the root node for this tree.
	 * 
	 * @return root 
	 */
	@Override
	public BinaryTreeNode getRoot() {
		
		return root;
	}


	/**
	 * Set the root node for this tree.
	 */
	@Override
	public void setRoot(BinaryTreeNode<T> root) {
		this.root=(DefaultBinaryTreeNode<T>) root;

	}


	/**
	 * Test if the tree is empty. Checks if root has data, if not returns true
	 * 
	 * @return true if root is set to null
	 */
	@Override
	public boolean isEmpty() {
		if(root==null){
			return true;
		}
		return false;
	}


	/**
	 * Get the data of this tree using inorder traversal.
	 * @return inorder List.
	 */
	@Override
	public LinkedList<T> inorderTraversal() {
		LinkedList<T> list = new LinkedList<T>();
		inorderTraversal(root, list);
		System.out.println(list);
		return list;
	}

	/**
	 * gets data in order of left child, root and then right child 
	 * @param node is a binaryTreeNode in the tree 
	 * @param traversal is a linkedlist which stores the order of the traversal
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal){
		if(node!=null){
			inorderTraversal(node.getLeftChild(), traversal);
			traversal.add(traversal.size(),node.getData());
			inorderTraversal(node.getRightChild(), traversal);
		}
	}


	/**
	 * Get the data of this tree using preorder traversal.
	 * @return preorder List.
	 */
	@Override
	public LinkedList<T> preorderTraversal() {
		LinkedList<T> list = new LinkedList<T>();
		preorderTraverse(root, list);
		System.out.println(list);
		return list;
	}

	/**
	 * gets data in order of root, left child, and then right child 
	 * @param node is a binaryTreeNode in the tree 
	 * @param traversal is a linkedlist which stores the order of the traversal
	 */
	private void preorderTraverse(BinaryTreeNode<T> node, LinkedList<T> traversal){
		if(node!=null){
			traversal.add(traversal.size(),node.getData());
			preorderTraverse(node.getLeftChild(), traversal);
			preorderTraverse(node.getRightChild(), traversal);
		}
	}

	/**
	 * Get the data of this tree using postorder traversal.
	 * left child, right child, root
	 * @return postorder List.
	 */
	@Override
	public LinkedList<T> postorderTraversal() {
		LinkedList<T> list = new LinkedList<T>();
		postorderTraverse(root, list);
		System.out.println(list);
		return list;
	}

	/**
	 * gets data in order of left child, right child and then root
	 * @param node is a binaryTreeNode in the tree 
	 * @param traversal is a linkedlist which stores the order of the traversal
	 */
	private void postorderTraverse(BinaryTreeNode<T> node, LinkedList<T> traversal){

		if(node!=null){
			postorderTraverse(node.getLeftChild(), traversal);
			postorderTraverse(node.getRightChild(), traversal);
			traversal.add(traversal.size(),node.getData());

		}
	}

}
