package datastructures;

public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;
	

	
	/**
	 * Get the data stored at this node.
	 * @return Object data.
	 */
	@Override
	public T getData() {
		return data;
	}


	/**
	 * Set the data stored at this node.
	 * @param data
	 */
	@Override
	public void setData (T data) {
		this.data = data;
	}
	
	
	/**
	 * Get the left child.
	 * @return BinaryTreeNode that is left child,
	 * or null if no child.
	 */
	@Override
	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}


	/**
	 * Get the right child.
	 * @return BinaryTreeNode that is right child,
	 * or null if no child.
	 */
	@Override
	public BinaryTreeNode<T> getRightChild() {
		// TODO Auto-generated method stub
		return rightChild;
	}


	/**
	 * Set the left child.
	 */
	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		this.leftChild=left;

	}


	/**
	 * Set the right child.
	 */
	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		// TODO Auto-generated method stub
		this.rightChild=right;
	}

	/**
	 * Tests if this node is a leaf (has no children).
	 * @return true if leaf node.
	 */
	@Override
	public boolean isLeaf() {
		if (rightChild==null && leftChild==null){
			return true;
		}
		return false;
	}

}
