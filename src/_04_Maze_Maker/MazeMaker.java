package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		
		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.getCell(randGen.nextInt(width), randGen.nextInt(height)));

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {

		ArrayList<Cell> lonely = new ArrayList<Cell>();
		// A. mark cell as visited
		currentCell.setBeenVisited(true);

		if (currentCell.getX() == 0 && currentCell.getY() == 0) {
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() + 1));

			}
		}
//upper right corner
		else if (currentCell.getX() == width - 1 && currentCell.getY() == 0) {
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() - 1));

			}
		}
//lower left corner
		else if (currentCell.getX() == 0 && currentCell.getY() == height) {
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() - 1));

			}

		}
//lower right corner
		else if (currentCell.getX() == width && currentCell.getY() == height) {
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() - 1));

			}

		}

//left side
		else if (currentCell.getX() == 0 && currentCell.getY() != 0 && currentCell.getY() != height - 1) {
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() - 1));

			}
		}

//top side
		else if (currentCell.getY() == 0 && currentCell.getX() != 0 && currentCell.getX() != width - 1) {
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY()));

			}

		}
//right side
		else if (currentCell.getX() == width - 1 && currentCell.getY() != 0 && currentCell.getY() != height - 1) {
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() + 1));

			}

		}
//bottom side
		else if (currentCell.getY() == height - 1 && currentCell.getX() != 0 && currentCell.getX() != width - 1) {
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY()));

			}

		}

//other
		else if (currentCell.getX() != 0 && currentCell.getX() != width - 1 && currentCell.getY() != 0
				&& currentCell.getY() != height - 1) {

			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY()).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY()));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX(), currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX(), currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY() - 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY() - 1));

			}
			if (!(maze.getCell(currentCell.getX() + 1, currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() + 1, currentCell.getY() + 1));

			}
			if (!(maze.getCell(currentCell.getX() - 1, currentCell.getY() + 1).hasBeenVisited())) {
				lonely.add(maze.getCell(currentCell.getX() - 1, currentCell.getY() + 1));

			}
		}

		// C. if has unvisited neighbors,
		if (lonely.size() > 0) {

			// C1. select one at random.
			
			// C2. push it to the stack
				uncheckedCells.push(lonely.get(randGen.nextInt(lonely.size())));
			// C3. remove the wall between the two cells
				removeWalls(currentCell, uncheckedCells.lastElement());
			// C4. make the new cell the current cell and mark it as visited
				currentCell = uncheckedCells.pop();
			// C5. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
		}
		// D. if all neighbors are visited
		else {
			// D1. if the stack is not empty
			if(uncheckedCells.isEmpty() == false) {
				
				currentCell = uncheckedCells.pop();
				selectNextPath(currentCell);
				
			}
			// D1a. pop a cell from the stack

			// D1b. make that the current cell

			// D1c. call the selectNextPath method with the current cell
		}
	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX() == c2.getX()) {
			if(c1.getY() - 1 == c2.getY()) {
				c1.setNorthWall(false);
				
			}else if(c1.getY() + 1 == c2.getY()) {
				c1.setSouthWall(false);
				
			}
			
			
		}
		else if(c1.getY() == c2.getY()) {
			if(c1.getX() - 1 == c2.getX()) {
				c1.setWestWall(false);
				
			}else if(c1.getX() + 1 == c2.getX()) {
				c1.setEastWall(false);
				
			}
			
		}
		
		
	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}
