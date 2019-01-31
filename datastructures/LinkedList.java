package datastructures;
/**
 * This class creates Linked Lists
 * @author Pooja Kundaje
 *
 */
public class LinkedList<T> implements List<T> {

	public LinkedListNode<T> head;


	/**
	 * Helper method to access the node at index. 
	 * If the index is invalid (negative or >= size of list), return null pointer.
	 **/
	private LinkedListNode<T> getNode( int index ){

		LinkedListNode<T> tempNode= head;
		if (index<0 || index>=size()){
			tempNode=null;
		}
		else{
		int Counter =0;
		while (Counter<index){
			tempNode = tempNode.getNext();
			Counter++;		 	
		}
		}
		return tempNode;	
	}

	/**
	 * Add (insert) data at specific index in list,
	 * e.g., add( 0, data ) inserts data to front/head of list
	 **/
	@Override
	public void add(int index, T data) {
		LinkedListNode<T> node = new LinkedListNode<T>();
		node.setData(data);

		if (index==0){
			node.setNext(head);
			head = node;
		}
		else{

			int Counter = 0;
			LinkedListNode<T> temp = head;
			while (Counter < index-1){
				temp = temp.getNext();
				Counter++;
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
	}

	/**
	 * Get data stored at specific index in list.
	 **/
	@Override
	public T get(int index) {
		return getNode(index).getData();

	}

	/**
	 * Delete data at specific index in list,
	 * e.g., delete( 0 ) removes the first element from the list
	 **/
	@Override
	public void delete(int index) {
		if (index==0){
			head = getNode(index+1);
		}
		else{
			LinkedListNode<T> prevNode = getNode(index-1);
			LinkedListNode<T> nextNode = getNode(index+1);
			prevNode.setNext(nextNode);		
		}
		
	}

	/**
	 * Get the number of elements in this list.
	 **/
	@Override
	public int size() {
		LinkedListNode<T> temp = head;
		int counter = 0;
		while (temp!= null){
			temp = temp.getNext();
			counter++;
		}
		return counter;
	}

	/**
	 * Check if the list is empty.
	 **/
	@Override
	public boolean isEmpty() {
		if(head==null){
			return true;
		}
		return false;
	}
	
	/**
	 * Prints the linked list
	 **/
	@Override
	public String toString(){
		LinkedListNode<T> node = head;
		String string = "";
		
		for (int i=0; i< size(); i++){
			string = string + node.getData() + "->";
			node= node.getNext();
		}
		
		return string;
	}

	public LinkedListNode<T> getFirstNode() {
		return getNode(0);
	}
}
