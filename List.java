public interface List<E> {

	public void addFirst(E elem);
	public void add(E elem);
	public E removeLast();
	public E removeFirst();
	public E remove(int index);
	public void remove(E value);
	public int indexOf(E value);
	public E get(int index);
	public boolean isEmpty();
	public int size();

}