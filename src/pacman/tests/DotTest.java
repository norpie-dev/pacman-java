package pacman.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pacman.Dot;
import pacman.MazeMap;
import pacman.Square;

class DotTest {
	
	private MazeMap mazeMap;
	private Square startSquare;
	private Dot dot;

	@BeforeEach
	void setUp() throws Exception {
		mazeMap = TestUtil.getMazeMap();
		startSquare = TestUtil.getStandardSquare(mazeMap);
		dot = new Dot(startSquare);
	}

	@Test
	void testGetSquare() {
		// Normal Case
		assertEquals(dot.getSquare(), startSquare);
	}

	@Test
	void testDot() {
		// IllegalArgumentException | square == null
		assertThrows(IllegalArgumentException.class, () -> new Dot(null));
	}

}
