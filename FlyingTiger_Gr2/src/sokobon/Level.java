package sokobon;

/**
 * show the level of the player or create a level map
 * 
 * @author aliab and Abd Alrahman Atieh
 *
 */
public class Level {

	/**
	 * The number of levels
	 */
	private static final int CountLevel = 6;

	/**
	 * The height of map = how many rows
	 */
	private static final int height = 8;

	/**
	 * The width of map = how many cols
	 */
	private static final int width = 10;

	/**
	 * Three-dimensional array to store the map and level
	 * [level number][row number][col number]
	 */
	private char[][][] mapLevel;

	/**
	 * Initializes the mapLevel array with these dimensions. Define the different
	 * levels
	 */
	public Level() {
		// Initialize the mapLevel array with these dimensions
		mapLevel = new char[CountLevel][height][width];
		// Create the level map
		setLevelMaps();
	}

	/**
	 * Define the different levels
	 */
	private void setLevelMaps() {

		mapLevel[0] = new char[][] {
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', ' ', 'p', 'o', 'g', 'g', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ 'o', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };
		mapLevel[1] = new char[][] {
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', 'o', ' ', ' ', ' ', ' ', ' ', 'g', ' ', '#' },
				{ '#', '#', '#', ' ', ' ', ' ', '#', '#', ' ', '#' },
				{ '#', ' ', ' ', 'p', ' ', '#', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', 'o', '#', ' ', ' ', ' ', ' ', '#', 'g', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
		};

		// Level 2
		mapLevel[2] = new char[][] {

				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', 'g', ' ', ' ', ' ', '#', '#', '#', ' ', '#' },
				{ '#', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', '#', 'o', '#', ' ', '#', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#' },
				{ '#', 'p', ' ', ' ', 'o', ' ', ' ', '#', 'g', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
		};

		// Level 3
		mapLevel[3] = new char[][] {
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', ' ', ' ', '#', ' ', ' ', '#', '#', ' ', '#' },
				{ '#', 'o', 'o', ' ', 'o', ' ', ' ', ' ', '#', '#' },
				{ '#', '#', 'p', '#', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', '#', '#', '#', '#', ' ', ' ', '#' },
				{ '#', ' ', ' ', ' ', 'g', 'g', ' ', ' ', 'g', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
		};

		// Level 4
		mapLevel[4] = new char[][] {
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', '#' },
				{ '#', ' ', ' ', ' ', 'o', ' ', ' ', ' ', ' ', '#' },
				{ '#', 'g', '#', '#', '#', '#', '#', ' ', ' ', '#' },
				{ '#', 'g', '#', ' ', 'p', 'o', '#', ' ', '#', '#' },
				{ '#', 'g', '#', ' ', ' ', 'o', ' ', ' ', ' ', '#' },
				{ '#', 'g', 'o', ' ', '#', ' ', ' ', ' ', ' ', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
		};

		// Level 5
		mapLevel[5] = new char[][] {
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', ' ', ' ', '#', '#', '#', 'p', '#', ' ', '#' },
				{ '#', ' ', 'g', ' ', ' ', '#', ' ', ' ', ' ', '#' },
				{ '#', 'g', '#', 'g', ' ', '#', 'o', 'o', 'o', '#' },
				{ '#', ' ', 'g', ' ', ' ', '#', '#', ' ', ' ', ' ' },
				{ '#', 'g', ' ', ' ', ' ', '#', ' ', 'o', 'o', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
		};
	}

	/**
	 * Get the level layout
	 * 
	 * @param specifies which level you want.
	 * @return char[][] a matrix of game map, [row][col] = (y, x)
	 */
	public char[][] getMapLevel(int level) {
		// check if the level is in the range
		if (level >= 0 && level < CountLevel) {
			// return the map level for the current level
			return mapLevel[level];
		}
		// if invalid level it return null
		return null;
	}

	/**
	 * @return int: how many levels are defined
	 */
	public int countLevel() {
		// return the numbers of the avaible levels
		return CountLevel;
	}

	public static void main(String[] args) {
		Level level = new Level();
		int levelCounter = level.countLevel();
		for (int i = 0; i < levelCounter; i++) {
			char[][] mapLevel = level.getMapLevel(i);
			System.out.println("Level " + (i + 1) + ":");
			printLevelMap(mapLevel);
			System.out.println();
		}
	}

	/**
	 * Print the level to system out print
	 * 
	 * @param mapLevel the level number need to print
	 */
	private static void printLevelMap(char[][] mapLevel) {
		for (char[] row : mapLevel) {
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}
}
