/**
 *			TO WRITE
 */
public class DoublyLinkedList<E> implements List<E> {

	/**
	 *			TO WRITE
	 */
	private static class Node<T> {
		
		T value;
		Node<T> previous;
		Node<T> next;
		
		private Node(T value, Node<T> previous, Node<T> next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
		
	}
	
	private Node<E> head;
	private int size;
	
	/**
	 *			TO WRITE
	 */
	public DoublyLinkedList() {
		head = new Node<E>(null, null, null); // Dummy node
		head.next = head;
		head.previous = head;
		size = 0; // Sentinel value;
	}
	
	
	/**
	 *			TO WRITE
	 */
	public void addFirst(E elem) {
		
		if (elem == null) {
			throw new NullPointerException("No null values in list!");
		}
		
		if (head.next.value == null) { // Case 1: The list is empty, as the dummy Node is pointing to itself
			Node<E> newNode = new Node<E>(elem, head, head);
			head.next = newNode;
			head.previous = newNode;
		} else {
			Node<E> newNode = new Node<E>(elem, head, head.next);
			head.next = newNode;
			head.next.next.previous = newNode;
		}
		
		size++;
		
	}
	
	
	/**
	 *			TO WRITE
	 */
	public void add(E elem) {
		
		if (elem == null) {
			throw new NullPointerException("No null values in list!");
		}
		
		if (head.next.value == null) { // Only dummy node in the list!
			Node<E> firstNode = new Node<E>(elem, head, head);
			head.next = head.previous = firstNode;
		} else {
			head.previous = new Node<E>(elem, head.previous, head);
			head.previous.previous.next = head.previous;
		}
		
		size++;
	}
	
	
	/**
	 *			TO WRITE
	 */
	public E removeLast() {
		
		if (isEmpty()) {
			throw new IllegalStateException("Cannot remove from empty list!");
		}
		
		E output;
		output = head.previous.value;
		head.previous = head.previous.previous;
		head.previous.next = head;
		
		size--;
		return output;
		
		
	}
	
	
	/**
	 *			TO WRITE
	 */
	public E removeFirst() {
		
		if (isEmpty()) {
			throw new IllegalStateException("Cannot remove from empty list!");
		}
		
		E output;
		output = head.next.value;
		head.next = head.next.next;
		head.next.previous = head;
		
		size--;
		return output;
	}
	
	/**
	 * I wonder if this can be sped up via an iteration system or even
	 * changing whether we look forwards or backward depending on if 
	 * the index is in the front or backhalf of the list
	 */
	public E remove(int index) {
		
		if (isEmpty()) {
			throw new IllegalStateException("Cannot remove from empty list!");
		}
		
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index out of bounds!");
		}
		
		int i = 0;
		Node<E> cursor = head;
		
		while (i != index) {
			cursor = cursor.next;
			i++;
		}
		
		E output = cursor.next.value;
		cursor.next = cursor.next.next;
		cursor.next.previous = cursor;
		
		size--;
		return output;
		
		
	}
	
	
	/**
	 *			TO WRITE
	 */
	public void remove(E value) {
		
		if (isEmpty()) {
			throw new IllegalStateException("Cannot remove from empty list!");
		}
		
		Node<E> cursor = head;
		
		while (cursor.next.value != null && !(cursor.next.value.equals(value))) {
			cursor = cursor.next;
		}
		
		if (cursor.next.value == null) {
			throw new IllegalArgumentException("No element with value: " + value + " in list!");
		}
		
		cursor.next = cursor.next.next;
		cursor.next.previous = cursor;
		
		size--;
		
	}
	
	
	/**
	 *			TO WRITE
	 */
	public E get(int index) {
		
		if (isEmpty()) {
			throw new IllegalStateException("Cannot get from empty list!");
		}
		
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index out of Bounds!");
		}
		
		int i = 0;
		Node<E> cursor = head;
		
		while (i != index) {
			cursor = cursor.next;
			i++;
		}
		
		E output = cursor.next.value;
		return output;
	}
	
	
	/**
	 *			TO WRITE
	 */
	public int indexOf(E value) {
		
		if (isEmpty()) {
			throw new IllegalStateException("Cannot get index of element for empty list!");
		}
		
		int i = 0;
		Node<E> cursor = head;
		
		while (cursor.next.value != null && !(cursor.next.value.equals(value))) {
			cursor = cursor.next;
			i++;
		}
		
		if (cursor.next.value == null) {
			throw new IllegalArgumentException("No element in list with value: " + value + " in list!");
		}
		
		return i;
	}
	
	
	/**
	 *			TO WRITE
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 *			TO WRITE
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	
	/**
	 *			TO WRITE
	 */
	public String toString() {
		
		StringBuffer output = new StringBuffer("[");
		Node<E> cursor = head;
		
		while (cursor.next.value != null) {
			output.append(cursor.next.value);
			
			if (cursor.next.next.value != null) { // Adds comma when the while loop will run for cursor.next
				output.append(", ");
			}
			
			cursor = cursor.next;
		}
		
		output.append("]");
		
		return output.toString();
		
	}
	

}