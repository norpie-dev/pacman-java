package pacman.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.Ghost;
import pacman.MazeMap;
import pacman.Square;

class GhostTest {
	
	private MazeMap mazeMap;

	private Square startSquare;
	private Direction startDirection;
	private Ghost ghost;

	@BeforeEach
	void setUp() throws Exception {
		mazeMap = TestUtil.getMazeMap();
		startSquare = TestUtil.getStandardSquare(mazeMap);
		startDirection = Direction.DOWN;
		ghost = new Ghost(startSquare, startDirection);
	}

	@Test
	void testGetSquare() {
		// Normal Case
		assertEquals(ghost.getSquare(), startSquare);
	}

	@Test
	void testGetDirection() {
		// Normal Case
		assertEquals(ghost.getDirection(), startDirection);
	}
	
	@Test
	void testGhost() {
		// IllegalArgumentException - square == null
		assertThrows(IllegalArgumentException.class, () -> new Ghost(null, startDirection));
		// IllegalArgumentCase - direction == null
		assertThrows(IllegalArgumentException.class, () -> new Ghost(startSquare, null));
	}

	@Test
	void testSetSquare() {
		// IllegalArgumentException - square == null
		assertThrows(IllegalArgumentException.class, () -> ghost.setSquare(null));
		// Normal Case
		ghost = new Ghost(TestUtil.getSquare(1, 1, mazeMap), startDirection);
		ghost.setSquare(startSquare);
		assertEquals(ghost.getSquare(), startSquare);
	}

	@Test
	void testSetDirection() {
		// IllegalArgumentException - square == null
		assertThrows(IllegalArgumentException.class, () -> ghost.setDirection(null));
		// Normal Case
		ghost = new Ghost(TestUtil.getSquare(1, 1, mazeMap), Direction.LEFT);
		ghost.setDirection(startDirection);
		assertEquals(ghost.getDirection(), startDirection);
	}

}
