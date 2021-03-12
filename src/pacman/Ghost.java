package pacman;

import java.util.Random;

/**
 * Each instance of this class represents a ghost in a Pac-Man maze.
 * 
 * @invar getSquare() cannot be null | getSquare() != null
 * @invar getDirection() cannot be null | getDirection() != null
 * 
 */
public class Ghost {
	
	/**
	 * Stores this instance's square object.
	 * 
	 * @invar {@code square} cannot be {@code null} | square != null
	 */
	private Square square;
	
	/**
	 * Stores this instance's direction enum object.
	 * 
	 * @invar {@code direction} cannot be {@code null} | direction != null
	 */
	private Direction direction;

	/**
	 * Returns this instance's square object.
	 * 
	 * @basic
	 * @post {@code result} cannot be {@code null} | result != null
	 */
	public Square getSquare() {
		return square;
	}

	/**
	 * Returns the direction in which this ghost will preferably move next.
	 * 
	 * @basic
	 * @post {@code result} cannot be {@code null} | result != null
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Initializes this instance with the given square and direction.
	 * 
	 * @throws IllegalArgumentException | square == null
	 * @throws IllegalArgumentException | direction == null
	 * @post | getSquare() == square
	 * @post | getDirection() == direction
	 */
	public Ghost(Square square, Direction direction) {
		if(square == null | direction == null) {
			throw new IllegalArgumentException("square or direction cannot be null");
		}
		this.square = square;
		this.direction = direction;
	}

	/**
	 * Sets the square of the current instance.
	 * 
	 * @throws IllegalArgumentException | square == null
	 * @mutates | this, getSquare()
	 * @post | getSquare() == square
	 */
	public void setSquare(Square square) {
		if(square == null) {
			throw new IllegalArgumentException("square is null");
		}
		this.square = square;
	}

	/**
	 * Sets the direction enum of the current instance.
	 * 
	 * @throws IllegalArgumentException | direction == null
	 * @mutates | this, getDirection()
	 * @post | getDirection() == direction
	 */
	public void setDirection(Direction direction) {
		if(direction == null) {
			throw new IllegalArgumentException("direction is null");
		}
		this.direction = direction;
	}

	private static int MOVE_FORWARD_PREFERENCE = 10;

	// No formal document required
	public Direction chooseNextMoveDirection(Random random) {
		int moveForwardPreference = getSquare().canMove(getDirection()) ? MOVE_FORWARD_PREFERENCE : 0;
		Direction[] passableDirections = getSquare().getPassableDirectionsExcept(getDirection().getOpposite());
		if (passableDirections.length == 0)
			return getDirection().getOpposite();
		int result = random.nextInt(moveForwardPreference + passableDirections.length);
		if (result < moveForwardPreference)
			return getDirection();
		return passableDirections[result - moveForwardPreference];
	}

	// No formal document required
	public void move(Random random) {
		setDirection(chooseNextMoveDirection(random));
		setSquare(getSquare().getNeighbor(getDirection()));
	}
}
