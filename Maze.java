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
	
	/**
	 * Gets the char at (row, column) where top left is (0,0) and bottom right is (rowCount-1, colCount-1)
	 *
	 * To be redone with Tiles at a later point
	 */
	public char getChar(int row, int column) {
		
		if (row < 0 || row >= rowCount) {
			throw new IllegalArgumentException("row input invalid!");
		}
		if (column < 0 || column >= colCount) {
			throw new IllegalArgumentException("column input invalid!");
		}
		
		return maze[row][column];
		
	}
	
	public static void main(String[] args) {
		char[][] test = null;
		
		Maze testMaze = new Maze();
		
		testMaze.populateMaze(test);
	}

}