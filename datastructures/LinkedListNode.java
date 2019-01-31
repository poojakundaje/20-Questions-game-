package datastructures;
/**
 * This class creates a node
 * @author Pooja Kundaje
 *
 */
public class LinkedListNode<T>{
	private T data;
	private LinkedListNode<T> next;
	/**
	 * Set the data stored at this node.
	 * @param <T>
	 */
	public void setData( T data ){
		this.data = data;
	}

	/**
	 * Get the data stored at this node.
	 */
	public T getData(){
		return data;

	}

	/**
	 * Set the next pointer to passed node.
	 */
	public void setNext( LinkedListNode<T> node ){
		this.next = node;
	}

	/**
	 * Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext(){
		return next;

	}

	/**
	 * Returns a String representation of this node.
	 */
	public String toString(){
		return data + "";

	}
}