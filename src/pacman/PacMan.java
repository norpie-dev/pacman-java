package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man
 * character in a Pac-Man maze.
 * 
 * @invar getSquare() cannot be null | getSquare() != null
 * @invar getNbLives() cannot be negative | getNbLives() >= 0
 */
public class PacMan {
	
	/**
	 * Stores the current instance's square object.
	 * 
	 * @invar square cannot be null | square != null
	 */
	private Square square;
	
	/**
	 * Stores the current instance's lives.
	 * 
	 * @invar nbLives cannot be negative | nbLives >= 0
	 */
	private int nbLives;

	/**
	 * Returns the current instance's square object.
	 * 
	 * @post result is not null | result != null
	 * @basic
	 */
	public Square getSquare() {
		return this.square;
	}

	/**
	 * Returns the current instance's lives.
	 * 
	 * @post result is nonnegative | result >= 0
	 * @basic
	 */
	public int getNbLives() {
		return this.nbLives;
	}

	/**
	 * Initializes this instance with the given square and lives
	 * 
	 * @throws IllegalArgumentException | 0 >= nbLives
	 * @throws IllegalArgumentException | square == null
	 * @post | getSquare() == square
	 * @post | getNbLives() == nbLives
	 * 
	 */
	public PacMan(int nbLives, Square square) { 
		if(nbLives <= 0) {
			throw new IllegalArgumentException("Pacman lives out of range");
		} else if (square == null) {
			throw new IllegalArgumentException("square is null");
		}
		this.nbLives = nbLives;
		this.square = square;
	}

	/**
	 * Sets the square of the current instance.
	 * 
	 * @throws IllegalArgumentException | square == null
	 * @mutates_properties | getSquare()
	 * @post | getSquare() == square
	 */
	public void setSquare(Square square) {
		if(square == null) {
			throw new IllegalArgumentException("square is null");
		}
		this.square = square;
	}

	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 * @mutates | this
	 */
	public void die() {
		this.nbLives--;
	}

}