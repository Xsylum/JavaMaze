public class DoublyLinkedList<E> implements List<E> {

	
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
	
	public DoublyLinkedList() {
		head = new Node<E>(null, null, null); // Dummy node
		head.next = head;
		head.previous = head;
		size = -1; // Sentinel value;
	}
	
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
		
	}
	
	public void add(E elem) {
		throw new UnsupportedOperationException("method not implemented!");
	}
	
	public E removeLast() {
		throw new UnsupportedOperationException("method not implemented!");
	}
	
	public E removeFirst() {
		throw new UnsupportedOperationException("method not implemented!");
	}
	
	public E remove(int index) {
		throw new UnsupportedOperationException("method not implemented!");
	}
	
	public void remove(E value) {
		throw new UnsupportedOperationException("method not implemented!");
	}
	
	public E get(int index) {
		throw new UnsupportedOperationException("method not implemented!");
	}
	
	public int indexOf(E value) {
		throw new UnsupportedOperationException("method not implemented!");
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == -1);
	}
	

}