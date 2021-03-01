package pacman;

/**
 * Each instance of this class represents the player-controlled Pac-Man
 * character in a Pac-Man maze.
 */
public class PacMan {
	
	private Square square;
	private int nbLives;

	// TODO: DOCUMENTATION
	public Square getSquare() {
		return this.square;
	}

	// TODO: DOCUMENTATION
	public int getNbLives() {
		return this.nbLives;
	}

	// TODO: DOCUMENTATION
	public PacMan(int nbLives, Square square) {
		this.nbLives = nbLives;
		this.square = square;
	}

	// TODO: DOCUMENTATION
	public void setSquare(Square square) {
		this.square = square;
	}

	/**
	 * Decreases this Pac-Man character's number of lives by one.
	 */
	// TODO: DOCUMENTATION
	public void die() {
		this.nbLives--;
	}

}