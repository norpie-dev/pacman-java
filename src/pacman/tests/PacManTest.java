package pacman.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pacman.MazeMap;
import pacman.PacMan;
import pacman.Square;

class PacManTest {
	
	private MazeMap mazeMap;

	private Square startSquare;
	private PacMan pacman;

	@BeforeEach
	void setUp() throws Exception {
		mazeMap = TestUtil.getMazeMap();
		startSquare = TestUtil.getStandardSquare(mazeMap);
		pacman = new PacMan(3, startSquare);
	}

	@Test
	void testGetSquare() {
		// Normal Case
		assertEquals(pacman.getSquare(), startSquare);
	}

	@Test
	void testGetNbLives() {
		// Normal Case
		assertEquals(pacman.getNbLives(), 3);
	}

	@Test
	void testPacMan() {
		// IllegalArgumentException - square == null
		assertThrows(IllegalArgumentException.class, () -> new PacMan(3, null));
		// IllegalArgumentException - 0 >= nbLives
		assertThrows(IllegalArgumentException.class, () -> new PacMan(0, startSquare));
		// Normal Case
		assertDoesNotThrow(() -> new PacMan(3, startSquare));
	}

	@Test
	void testSetSquare() {
		// IllegalArgumentException - square == null
		assertThrows(IllegalArgumentException.class, () -> pacman.setSquare(null));
		// Normal Case
		Square goToSquare = TestUtil.getSquare(1, 1, mazeMap);
		pacman.setSquare(goToSquare);
		assertEquals(pacman.getSquare(), goToSquare);
	}

	@Test
	void testDie() {
		// Normal Case
		pacman.die();
		assertEquals(pacman.getNbLives(), 2);
	}

}
