package sokobon;

/**
 * show the level of the player or create a level map
 * 
 * @author aliab
 *
 */
public class Level {
	// levels number
	private static final int CountLevel = 6;
	// height of the map
	private static final int height = 8;
	// width of the map
	private static final int width = 10;
	// Three-dimensional array to store the map and level
	private char[][][] mapLevel;

	public Level() {
		// Initialize the mapLevel array with these dimensions
		mapLevel = new char[CountLevel][height][width];
		// Create the level map
		setLevelMaps();
	}

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

	public char[][] getMapLevel(int level) {
		// check if the level is in the range
		if (level >= 0 && level < CountLevel) {
			// return the map level for the current level
			return mapLevel[level];
		}
		// if invalid level it return null
		return null;
	}

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

	private static void printLevelMap(char[][] mapLevel) {
		for (char[] row : mapLevel) {
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}

}
