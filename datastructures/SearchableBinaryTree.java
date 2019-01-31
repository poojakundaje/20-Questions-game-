package datastructures;
/**
 * 
 * @author Pooja Kundaje 
 *
 * @param <T>
 */
 public class SearchableBinaryTree<T extends Comparable<T>>
extends DefaultBinaryTree<T> implements BinarySearchTree<T>{
	 
	
	 
	 /**
	  * Takes a binaryTreeNode and inserts into a specific position in the tree
	  */
	@Override
	public void insert(T data) {
		DefaultBinaryTreeNode<T> treeNode= new DefaultBinaryTreeNode<T>();
		treeNode.setData(data);
		if(root==null){
			setRoot(treeNode);
		}
		else{
			nodeInsert(data, root);


		}
	}

	/**
	 * recursive method which checks if the 
	 * @param data
	 * @param node
	 */
	public void nodeInsert(T data, BinaryTreeNode<T> node) {
		DefaultBinaryTreeNode<T> treeNode= new DefaultBinaryTreeNode<T>();
		treeNode.setData(data);
			
		if (data.compareTo(node.getData())<0){
			if(node.getLeftChild()==null){
				node.setLeftChild(treeNode);
			}
			
			nodeInsert(data, node.getLeftChild());
			
		}
		else if(data.compareTo(node.getData())>0){
			if(node.getRightChild()==null){
				
				node.setRightChild(treeNode);
			}
			
			nodeInsert(data, node.getRightChild());
			
		}
		else if (data.compareTo(node.getData())==0){
			
		}
		}
	


	/**
	 * takes data of type t and returns node containing this data 
	 */
	@Override
	public BinaryTreeNode<T> search(T data) {
		if (root==null){
		return null;
		}
		else{
			return searchNode(data, root);
			
		}
	}
	
	/**
	 * searches through the array to get a node 
	 */
	public BinaryTreeNode<T> searchNode (T data,  BinaryTreeNode<T> node ) {
		if (node!=null){
		if (data.compareTo(node.getData())==0){
			return node;
		}
		else if(data.compareTo(node.getData())<0){
			return searchNode(data,node.getLeftChild());
		}
		else if(data.compareTo(node.getData())>0){
			return searchNode(data,node.getRightChild());
		}
			
		}
		return null;
		
	}
	
	
	
	/**
	 * finds and returns the minimum element in the tree of type T
	 */
	@Override
	public T minElement() {
		if(root==null){
			return null;
		}
		else {
			BinaryTreeNode treeNode = root;
			while(treeNode.getLeftChild()!=null){
				treeNode= treeNode.getLeftChild();
			}
			return (T) treeNode.getData();
		}
		
	}
	
	/**
	 *  finds and returns the minimum element in the tree of type T
	 */
	@Override
	public T maxElement() {
		if(root==null){
			return null;
		}
		else {
			BinaryTreeNode treeNode = root;
			while(treeNode.getRightChild()!=null){
				treeNode=   treeNode.getRightChild();
			}
			return (T) treeNode.getData();
		}
		
	}
}
