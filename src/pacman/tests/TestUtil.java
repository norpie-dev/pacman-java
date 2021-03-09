package pacman.tests;

import java.util.Random;

import pacman.Maze;
import pacman.MazeDescriptions;
import pacman.MazeMap;
import pacman.Square;

public class TestUtil {

	public static Maze getMaze() {
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
	}

	public static MazeMap getMazeMap() {
		return getMaze().getMap();
	}
	
	public static Square getSquare(int row, int column, MazeMap mazeMap) {
		return Square.of(mazeMap, row, column);
	}
	
	public static Square getStandardSquare(MazeMap mazeMap) {
		return getSquare(0, 0, mazeMap);
	}

}
