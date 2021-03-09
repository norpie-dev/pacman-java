package pacman;

/**
 * Each instance of this class represents a maze layout, specifying the width
 * and height of the maze and, for each position in the maze, whether it is
 * passable or not.
 * 
 * @immutable
 */
public class MazeMap {

	/**
	 * Stores this instance's width.
	 */
	private int width;
	
	/**
	 * Stores this instance's height.
	 */
	private int height;
	
	/**
	 * Stores this instance's array of passables. 
	 * 
	 * @representationObject
	 * @invar passable cannot be null | passable != null
	 */
	private boolean[] passable;
	
	/**
	 * Returns the width (i.e. the number of columns) of this maze map.
	 * 
	 * @basic
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height (i.e. the number of rows) of this maze map.
	 * 
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
	 * @inspects | this
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
		this.width = width;
		this.height = height;
		this.passable = passable.clone();
	}
}
