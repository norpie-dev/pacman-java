package pacman;

import java.util.Arrays;

/**
 * Each instance of this class represents a position in a maze, specified by a
 * row index and a column index. The top row and the leftmost column have index
 * 0.
 * 
 * @immutable
 * @invar mazeMap cannot be null | getMazeMap() != null
 */
public class Square {

	/**
	 * Stores the MazeMap of the current instance.
	 * 
	 * @invar mazeMap cannot be null | mazeMap != null
	 */
	private MazeMap mazeMap;

	/**
	 * Stores the row index of the current instance.
	 */
	private int row;

	/**
	 * Stores the column index of the current instance.
	 */
	private int column;

	/**
	 * Stores if the current instance is passable.
	 */
	private boolean passable;

	/**
	 * Initializes the current object with the given, MazeMap, row index, column
	 * index, and if the square is passable.
	 * 
	 * @post | getMazeMap() == mazeMap
	 * @post | getRowIndex() == row
	 * @post | getColumnIndex() == column
	 * @post | isPassable() == passable
	 * 
	 */
	private Square(MazeMap mazeMap, int row, int column, boolean passable) {
		this.mazeMap = mazeMap;
		this.row = row;
		this.column = column;
		this.passable = passable;
	}

	/**
	 * Returns the MazeMap of the current instance.
	 * 
	 * @basic
	 * @post result cannot be null | result != null
	 */
	public MazeMap getMazeMap() {
		return this.mazeMap;
	}

	/**
	 * Returns the rowIndex of the current instance.
	 * 
	 * @basic
	 */
	public int getRowIndex() {
		return this.row;
	}

	/**
	 * Returns the columnIndex of the current instance.
	 * 
	 * @basic
	 */
	public int getColumnIndex() {
		return this.column;
	}

	/**
	 * Returns true if the square instance is passable.
	 * 
	 * @basic
	 */
	public boolean isPassable() {
		return this.passable;
	}

	/**
	 * Static factory for the square object, returns a square object with the given
	 * MazeMap, row index, and column index.
	 * 
	 * @throws IllegalArgumentException | mazeMap == null
	 * @throws IllegalArgumentException | !(rowIndex > 0) || rowIndex > mazeMap.getHeight()
	 * @throws IllegalArgumentException | !(columnIndex > 0) || columnIndex > mazeMap.getWidth()
	 * 
	 * @inspects | mazeMap
	 * 
	 * @creates | result
	 */
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		if(mazeMap == null) {
			throw new IllegalArgumentException("mazeMap cannot be null");
		} else if(rowIndex < 0 || rowIndex > mazeMap.getHeight()) {
			throw new IllegalArgumentException("rowIndex out of bounds");
		} else if(columnIndex < 0 || columnIndex > mazeMap.getWidth()) {
			throw new IllegalArgumentException("columnIndex out of bounds");
		}
		return new Square(mazeMap, rowIndex, columnIndex, mazeMap.isPassable(rowIndex, columnIndex));
	}

	/**
	 * Returns this square's neighbor in the given direction. If this square has no
	 * neigbor in the given direction, return the square that is furthest away in
	 * the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		if(direction == null) {
			throw new IllegalArgumentException("direction is not either: down, up, right, or left");
		}
		// Implementation hint: use method java.lang.Math.floorMod.
		switch (direction) {
			case DOWN -> {
				return Square.of(mazeMap, Math.floorMod(row + 1, mazeMap.getHeight()), column);
			}
			case UP -> {
				return Square.of(mazeMap, Math.floorMod(row - 1, mazeMap.getHeight()), column);
			}
			case LEFT -> {
				return Square.of(mazeMap, row, Math.floorMod(column - 1, mazeMap.getWidth()));
			}
			case RIGHT -> {
				return Square.of(mazeMap, row, Math.floorMod(column + 1, mazeMap.getWidth()));
			}
		}
		return null;// Should never hit this return? Could fix this by changing the last case to default, 
					// and assuming that Direction#RIGHT will go through default, but thats way too hacky.
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		if(direction == null) {
			throw new IllegalArgumentException("direction is null");
		}
		return getNeighbor(direction).isPassable();
	}

	/**
	 * Returns the directions that are different from the given excluded direction
	 * and such that the neighbor in that direction is passable. The returned array
	 * shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		if(excludedDirection == null) {
			throw new IllegalArgumentException("excludedDirection is null");
		}
		Direction[] directions = new Direction[0];
		for (Direction direction : Direction.values()) {
			if (direction.equals(excludedDirection))
				continue;
			if (getNeighbor(direction).isPassable()) {
				directions = Arrays.copyOf(directions, directions.length + 1);
				directions[directions.length - 1] = direction;
			}
		}
		return directions.clone();
	}

	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object
	 * and has the same row and column index as this square.
	 * 
	 * @throws IllegalArgumentException | other == null
	 * @inspects | other
	 */
	public boolean equals(Square other) {
		if(other == null) 
			throw new IllegalArgumentException("other is null"); 
		if (this.row != other.getRowIndex())
			return false;
		if (this.column != other.getColumnIndex())
			return false;
		if (this.mazeMap != other.getMazeMap())
			return false;
		return true;
	}

}
