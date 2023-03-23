/**
 *
 * TO DO: -javadoc, properly describe class
 *		  -assign temp char values for walls, visited, current location
 *		  -populate maze through user input
 *		  -replace char[][] with a Tile[][] system!
 */
public class Maze {

	static int DEFAULT_SIZE = 5;
	int rowCount, colCount;
	char[][] maze;  // char[rows][columns]
	
	public Maze() {
		rowCount = colCount = DEFAULT_SIZE;
		maze = new char[rowCount][colCount];
	}
	
	public Maze(int rows, int columns) {
		rowCount = rows;
		colCount = columns;
		maze = new char[rowCount][colCount];
	}
	
	public void populateMaze(char[][] mazeInput) {
		
		if (mazeInput == null) {
			throw new NullPointerException("Null maze!");
		}
		
		if (mazeInput != null && (mazeInput.length != rowCount || mazeInput[0].length != colCount)) {  // Figure out how to wrap this
			throw new IllegalArgumentException("Input size does not match instance!"
												+ " input: " + mazeInput.length + "x" + mazeInput[0].length
												+ " vs. " + rowCount + "x" + colCount);
		}
		
		for(int i = 0; i < mazeInput.length; i++) {
			maze[i] = mazeInput[i];
		}
	}
	
	/**
	 * 				Will use USER INPUT
	 */
	public void populateMaze() {
		
	}
		
	public void populateRow() {
		
	}
	
	public static void main(String[] args) {
		char[][] test = null;
		
		Maze testMaze = new Maze();
		
		testMaze.populateMaze(test);
	}

}