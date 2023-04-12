/**
 * Future Note: This class will be used to move from some start point to
 *				the end point of a Maze, using a series of steps. Essentially,
 *				this is used to solve a Maze instance
 *
 * TO DO: Implement class, bring up to scratch with javadoc
 */
public class MazeSimulation {
	
	private DoublyLinkedList<String> visitedList = new DoublyLinkedList<String>();
	
	
	public void solve(Maze maze)
	{
		
		int rowCount = maze.getRowCount();
		int colCount = maze.getColCount();
		CoordinatePair start = maze.getStart();
		CoordinatePair finish = maze.getFinish();
		LinkedQueue<String> moveQueue = new LinkedQueue<String>();
		
		if (moveQueue.isEmpty()) {
			if (start.getX() - 1 >= 0) {
				moveQueue.enqueue("L");
			}
			if (start.getX() + 1 < colCount) {
				moveQueue.enqueue("R");
			}
			if (start.getY() - 1 >= 0) {
				moveQueue.enqueue("U");
			}
			if (start.getY() + 1 < rowCount) {
				moveQueue.enqueue("D");
			}
		}
		
		while (!moveQueue.isEmpty()) {
			
			String currentMove = moveQueue.dequeue();
			
			if 
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
	}
	
}