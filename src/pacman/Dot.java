package pacman;

/**
 * Each instance of this class represents a dot (a piece of food for Pac-Man) in
 * a Pac-Man maze.
 * 
 * @immutable
 * @invar {@code getSquare()} cannot be {@code null} | getSquare() != null
 */
public class Dot {

	/**
	 * Stores this instance's square object.
	 * 
	 * @invar {@code square} cannot be {@code null} | square != null
	 */
	private Square square;

	/**
	 * Returns this instance's square object.
	 * 
	 * @basic
	 * @post the {@code result} is not {@code null} | result != null
	 */
	public Square getSquare() {
		return square;
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
