package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in
 * a Pac-Man maze.
 * 
 * @immutable
 * @invar getSquare() cannot be null | getSquare() != null
 */
public class Dot {

	/**
	 * Stores this instance's square object.
	 * 
	 * @invar square cannot be null | square != null
	 */
	private Square square;

	/**
	 * Returns this instance's square object.
	 * 
	 * @basic
	 * @post the result is not null | result != null
	 */
	public Square getSquare() {
		return this.square;
	}

	/**
	 * Initializes this object with the given square.
	 * 
	 * @throws IllegalArgumentException | square == null
	 * @post This object's square equals the given square | getSquare() == square
	 */
	public Dot(Square square) {
		if(square == null) {
			throw new IllegalArgumentException("square is null");
		}
		this.square = square;
	}

}
