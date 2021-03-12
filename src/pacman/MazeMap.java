package pacman;

/**
 * Each instance of this class represents a maze layout, specifying the width
 * and height of the maze and, for each position in the maze, whether it is
 * passable or not.
 * 
 * @immutable
 * @invar {@code getWidth()} cannot be negative | getWidth() >= 0
 * @invar {@code getHeight()} cannot be negative | getHeight() >= 0
 */
public class MazeMap {

	/**
	 * Stores this instance's {@code width}.
	 * 
	 * @invar {@code width} cannot be negative | width >= 0
	 */
	private int width;
	
	/**
	 * Stores this instance's {@code height}.
	 * 
	 * @invar {@code height} cannot be negative | height >= 0
	 */
	private int height;
	
	/**
	 * Stores this instance's array of passables. 
	 * 
	 * @representationObject
	 * @invar {@code passable} cannot be {@code null} | passable != null
	 */
	private boolean[] passable;
	
	/**
	 * Returns the {@code width} (i.e. the number of columns) of this maze map.
	 * 
	 * @post {@code result} is nonnegative | result >= 0
	 * @basic
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the {@code height} (i.e. the number of rows) of this maze map.
	 * 
	 * @post {@code result} is nonnegative | result >= 0
	 * @basic
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns whether the square in this maze at row index {@code row} and column
	 * index {@code column} is passable. The square in the top-left corner of the
	 * maze has row index 0 and column index 0.
	 * 
	 * @throws IllegalArgumentException | 0 > rowIndex | 0 > columnIndex
	 * @throws IllegalArgumentException | rowIndex >= getHeight() | columnIndex >= getWidth()
	 */
	public boolean isPassable(int rowIndex, int columnIndex) {
		if(0 > rowIndex | 0 > columnIndex) {
			throw new IllegalArgumentException("out of bounds, negative");
		} else if (rowIndex >= getHeight() | columnIndex >= getWidth()) {
			throw new IllegalArgumentException("out of bounds, too big");
		}
		return passable[rowIndex * getWidth() + columnIndex];
	}

	/**
	 * Initializes this object so that it represents a maze layout with the given
	 * width, height, and passable positions. The passable positions are given in
	 * row-major order (i.e. the first {@code width} elements of {@code passable}
	 * specify the passability of the maze positions in the first row of the maze).
	 * 
	 * @throws IllegalArgumentException | passable == null
	 * @throws IllegalArgumentException | width * height != passable.length
	 * @throws IllegalArgumentException | 0 >= width | 0 >= height
	 * @post | getWidth() == width
	 * @post | getHeight() == height
	 * @inspects | passable
	 */
	public MazeMap(int width, int height, boolean[] passable) {
		if(passable == null) {
			throw new IllegalArgumentException("passble is null");
		}
		if(width * height != passable.length) {
			throw new IllegalArgumentException("width and height do not match the size of the passable array");
		}
		if(width < 0 | height < 0) {
			throw new IllegalArgumentException("width and height cannot be negative");
		}
		this.width = width;
		this.height = height;
		this.passable = passable.clone();
	}
}
