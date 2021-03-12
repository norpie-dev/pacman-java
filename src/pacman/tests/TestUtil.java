package pacman.tests;

import pacman.MazeMap;
import pacman.Square;

public class TestUtil {

	/*public static Maze getMaze() {
		return MazeDescriptions.createMazeFromDescription(new Random(), """
				#####################
				#.........#.........#
				#.###.###.#.###.###.#
				#.###.###.#.###.###.#
				#.###.###.#.###.###.#
				#...................#
				#.###.#.#####.#.###.#
				#.###.#.#####.#.###.#
				#.....#...#...#.....#
				#####.### # ###.#####
				    #.#   G   #.#
				    #.# #   # #.#
				#####.# #   # #.#####
				     .  #GGG#  .
				#####.# ##### #.#####
				    #.#       #.#
				    # # ##### #.#
				#####.# ##### #.#####
				#.........#.........#
				#.###.###.#.###.###.#
				#...#.....P.....#...#
				###.#.#.#####.#.#.###
				###.#.#.#####.#.#.###
				#.....#...#...#.....#
				#.#######.#.#######.#
				#...................#
				#####################
				""");
	}*/

	public static MazeMap getMazeMap() {
		boolean[] passable = new boolean[100];
		passable[1] = true;
		return new MazeMap(10, 10, passable);
	}
	
	public static Square getSquare(int row, int column, MazeMap mazeMap) {
		return Square.of(mazeMap, row, column);
	}
	
	public static Square getStandardSquare(MazeMap mazeMap) {
		return getSquare(0, 0, mazeMap);
	}

}
