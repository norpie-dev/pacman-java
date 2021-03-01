package pacman;

import java.util.ArrayList;

/**
 * Each instance of this class represents a position in a maze, specified by a
 * row index and a column index. The top row and the leftmost column have index
 * 0.
 */
public class Square {
	
	private MazeMap mazeMap;
	private int row;
	private int column;
	private boolean passable;

	private Square(MazeMap mazeMap, int row, int column) {
		this.mazeMap = mazeMap;
		this.row = row;
		this.column = column;
		this.passable = mazeMap.isPassable(row, column);
	}

	// TODO: DOCUMENTATION
	public MazeMap getMazeMap() {
		return this.mazeMap;
	}

	// TODO: DOCUMENTATION
	public int getRowIndex() {
		return this.row;
	}

	// TODO: DOCUMENTATION
	public int getColumnIndex() {
		return this.column;
	}

	// TODO: DOCUMENTATION
	public boolean isPassable() {
		return this.passable;
	}

	// TODO: DOCUMENTATION
	public static Square of(MazeMap mazeMap, int rowIndex, int columnIndex) {
		return new Square(mazeMap, rowIndex, columnIndex);
	}

	/**
	 * Returns this square's neighbor in the given direction. If this square has no
	 * neigbor in the given direction, return the square that is furthest away in
	 * the opposite direction.
	 */
	// No formal documentation required
	public Square getNeighbor(Direction direction) {
		// Implementation hint: use method java.lang.Math.floorMod.
		switch (direction) {
			case DOWN -> {
				return Square.of(getMazeMap(), getRowIndex() + 1, getColumnIndex());
			}
			case LEFT -> {
				return Square.of(getMazeMap(), getRowIndex(), getColumnIndex() - 1);
			}
			case RIGHT -> {
				return Square.of(getMazeMap(), getRowIndex(), getColumnIndex() +  1);
			}
			case UP -> {
				return Square.of(getMazeMap(), getRowIndex() - 1, getColumnIndex());
			}
		}
		return null;
	}

	/**
	 * Returns whether this square's neighbor in the given direction is passable.
	 */
	// No formal documentation required
	public boolean canMove(Direction direction) {
		return getNeighbor(direction).isPassable();
	}

	/**
	 * Returns the directions that are different from the given excluded direction
	 * and such that the neighbor in that direction is passable. The returned array
	 * shall have no null elements and shall have no duplicates.
	 */
	// No formal documentation required
	public Direction[] getPassableDirectionsExcept(Direction excludedDirection) {
		ArrayList<Direction> directions = new ArrayList<>();
		for (Direction direction : Direction.values()) {
			if (direction.equals(excludedDirection))
				continue;
			if (getNeighbor(direction).isPassable()) {
				directions.add(direction);
			}
		}
		return directions.toArray(new Direction[0]);
	}

	/**
	 * Returns whether the given square refers to the same {@code MazeMap} object
	 * and has the same row and column index as this square.
	 */
	// TODO: DOCUMENTATION
	public boolean equals(Square other) {
		if (!other.getMazeMap().equals(this.getMazeMap())) {
			return false;
		}
		if (other.getColumnIndex() != this.getColumnIndex()) {
			return false;
		}
		if (other.getRowIndex() != this.getColumnIndex()) {
			return false;
		}
		return true;
	}

}
