package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man
 * character in a Pac-Man maze.
 * 
 * @invar {@code getSquare()} cannot be {@code null} | getSquare() != null
 * @invar {@code getNbLives()} cannot be negative | getNbLives() >= 0
 */
public class PacMan {
	
	/**
	 * Stores the current instance's square object.
	 * 
	 * @invar {@code square} cannot be {@code null} | square != null
	 */
	private Square square;
	
	/**
	 * Stores the current instance's lives.
	 * 
	 * @invar {@code nbLives} cannot be negative | nbLives >= 0
	 */
	private int nbLives;

	/**
	 * Returns the current instance's square object.
	 * 
	 * @post {@code result} is not {@code null} | result != null
	 * @basic
	 */
	public Square getSquare() {
		return this.square;
	}

	/**
	 * Returns the current instance's lives.
	 * 
	 * @post {@code result} is nonnegative | result >= 0
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
			throw new IllegalArgumentException("Pacman's lives have to positive");
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
	 * Decreases this Pac-Man character's number of lives by one.
	 * 
	 * @throws RuntimeException | getNbLives() == 0
	 * @mutates | this, getNbLives()
	 * @post pacman's {@code nbLives} cannot be negative | getNbLives() >= 0
	 */
	public void die() {
		if(nbLives <= 0) {
			throw new RuntimeException("lives cannot be negative should not happen");
		}
		this.nbLives--;
	}

}