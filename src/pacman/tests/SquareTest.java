package pacman.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.MazeMap;
import pacman.Square;

class SquareTest {

	private MazeMap mazeMap;
	private Square square;

	@BeforeEach
	void setUp() throws Exception {
		mazeMap = TestUtil.getMazeMap();
		square = TestUtil.getSquare(1, 1, mazeMap);
	}

	@Test
	void testGetMazeMap() {
		// Normal Case
		assertEquals(square.getMazeMap(), mazeMap);
	}

	@Test
	void testGetRowIndex() {
		// Normal Case
		assertEquals(square.getRowIndex(), 1);
	}

	@Test
	void testGetColumnIndex() {
		// Normal Case
		assertEquals(square.getColumnIndex(), 1);
	}
	
	@Test
	void testOf() {
		// IllegalArgumentException | mazeMap == null
		assertThrows(IllegalArgumentException.class, () -> Square.of(null, 0, 0));
		// IllegalArgumentException | row out of bounds
		assertThrows(IllegalArgumentException.class, () -> Square.of(mazeMap, -1, 0));
		assertThrows(IllegalArgumentException.class, () -> Square.of(mazeMap, 1000, 0));
		// IllegalArgumentException | column out of bounds
		assertThrows(IllegalArgumentException.class, () -> Square.of(mazeMap, 0, -1));
		assertThrows(IllegalArgumentException.class, () -> Square.of(mazeMap, 0, 1000));
	}
	
	@Test
	void testGetNeighbor() {
		// IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> square.getNeighbor(null));
	}

	@Test
	void testCanMove() {
		// IllegalArgumentException | direction == null
		assertThrows(IllegalArgumentException.class, () -> square.canMove(null));
		// Normal Case
		assertEquals(square.canMove(Direction.DOWN), true);
	}

	@Test
	void testGetPassableDirectionsExcept() {
		// IllegalArgumentException | direction == null
		assertThrows(IllegalArgumentException.class, () -> square.getPassableDirectionsExcept(null));
		// Normal Cases
		assertEquals(square.getPassableDirectionsExcept(Direction.RIGHT).length, 1);
		assertEquals(square.getPassableDirectionsExcept(Direction.DOWN).length, 1);
	}
	
	@Test
	void testEquals() {
		// IllegalArgumentException | other == null
		assertThrows(IllegalArgumentException.class, () -> square.equals(null));
		// Normal Cases
		assertEquals(square.equals(Square.of(mazeMap, 1, 0)), false);
		assertEquals(square.equals(Square.of(mazeMap, 0, 1)), false);
		assertEquals(square.equals(Square.of(TestUtil.getMazeMap(), 1, 1)), false);
		assertEquals(square.equals(Square.of(mazeMap, 1, 1)), true);
	}

}
