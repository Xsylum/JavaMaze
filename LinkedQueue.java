public class LinkedQueue<E> implements Queue<E> {

	private static class Node<T> {
		
		private Node<T> next;
		private T value;
		
		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
		
	}
	
	private Node<E> head;
	private Node<E> rear;
	private int size = 0;


	public LinkedQueue() {
		head = rear = null;
	}

	/**
	 * Adds an item to the rear of the queue
	 */
	public void enqueue(E elem) {
		
		if (elem == null) {
			throw new NullPointerException("No null elements in this queue!");
		}
		
		// Case 1: Queue is empty
		if (head == null) {
			Node<E> firstNode = new Node<E>(elem, null);
			head = rear = firstNode;
		}
		// General case
		else {
			Node<E> newNode = new Node<E>(elem, null);
			rear.next = newNode;
			rear = newNode;
		}
		
		size++;
		
	}
	
	public E dequeue() {
		
		if (isEmpty()) {
			throw new IllegalStateException("The queue is empty!");
		}
		
		E tempValue = head.value;
		
		if (head == rear) { // Case 1: Single element in list
			head = rear = null;
			
		} else { // General case
			head = head.next;
		}
		size--;
		
		return tempValue;
	}
	
	public E peek() {
		
		if (isEmpty()) {
			throw new IllegalStateException("The queue is empty!");
		}
		
		return head.value;
	}
	
	public boolean isEmpty() {
		if (size == 0) { 
			return true;
		}
		
		return false;
	}



}