package pacman.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pacman.MazeMap;

class MazeMapTest {
	
	private MazeMap mazeMap;

	@BeforeEach
	void setUp() throws Exception {
		mazeMap = TestUtil.getMazeMap();
	}

	@Test
	void testGetWidth() {
		assertEquals(mazeMap.getWidth(), 10);
	}

	@Test
	void testGetHeight() {
		assertEquals(mazeMap.getHeight(), 10);
	}

	@Test
	void testIsPassable() {
		// IllegalArgumentException - 0 > rowIndex 
		assertThrows(IllegalArgumentException.class, () -> mazeMap.isPassable(-1, 0));
		// IllegalArgumentException - 0 > columnIndex 
		assertThrows(IllegalArgumentException.class, () -> mazeMap.isPassable(0, -1));
		// IllegalArgumentException - rowIndex > mazeMap.getHeight() 
		assertThrows(IllegalArgumentException.class, () -> mazeMap.isPassable(1000, 0));
		// IllegalArgumentException - columnIndex > mazeMap.getWidth()
		assertThrows(IllegalArgumentException.class, () -> mazeMap.isPassable(0, 1000));
		// Normal Case
		assertEquals(mazeMap.isPassable(0, 0), false);
	}

	@Test
	void testMazeMap() {
		boolean[] passableNull = null;
		// IllegalArgumentException - passable == null
		assertThrows(IllegalArgumentException.class, () -> new MazeMap(5, 5, passableNull));
		boolean[] passable = new boolean[10];
		// IllegalArgumentException - width and height do not match the size of the passable array
		assertThrows(IllegalArgumentException.class, () -> new MazeMap(5, 5, passable));
	}

}
