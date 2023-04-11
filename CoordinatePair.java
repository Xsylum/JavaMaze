public class CoordinatePair<E> {

	private E x, y;

	public CoordinatePair(E x, E y) {
		this.x = x;
		this.y = y;
	}
	
	public E getX() {
		return x;
	}
	
	public E getY() {
		return y;
	}
	
	public String toString() {
		String output = "(" + x + ", " + y + ")";
		return output;
	}


}