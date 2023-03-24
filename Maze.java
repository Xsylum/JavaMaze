/**
 *
 * TO DO: -javadoc, properly describe class
 *		  -assign temp char values for walls, visited, current location
 *		  -populate maze through user input
 *		  -replace char[][] with a Tile[][] system!
 */
 
import java.util.Arrays; // does this go before or after javadoc?
import java.io.*;
 
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
	
	
	/**
	 *              Will populate the maze using a file input (Strings and chars currently; maybe char to Tile converter?);
	 */
	public void populateMazeFromFile(String fileName) {
		
		try {
			BufferedReader input;
			input = new BufferedReader ( new InputStreamReader ( new FileInputStream (fileName) ) );
			String fileLine;
			int fileLineCount = 0; // will be 1 ahead of maze index, should max at rowCount
			
			
			while ( (fileLine = input.readLine()) != null) {
				fileLineCount++;
				if (fileLineCount > rowCount) { // overfill!
					throw new IllegalArgumentException("File line count exceeds maze size!");
				}
				
				if (fileLine.length() != colCount) { // chars per line must be equal!
					throw new IllegalArgumentException("File column count on line" + (fileLineCount + 1) + "not equal to colCount!");  // This line should probably wrap
				}
				
				for (int col = 0; col < fileLine.length(); col++) {
					maze[fileLineCount-1][col] = fileLine.charAt(col);
				}
			}
			
			if (fileLineCount != rowCount) { // underfill!
				throw new IllegalArgumentException("File line count less than maze size!");
			}
		} catch (IllegalArgumentException e) { // the input file is invalid
			for (char[] array: maze) { // empty the maze
				Arrays.fill(array, '\u0000');
			}
			e.printStackTrace();
			System.exit(1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(2);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(2);
		}
		
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

}