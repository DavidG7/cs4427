package Constants;

public final class Constants {

	public static final int EASY_DIFFICULTY = 0;
	public static final int MEDIUM_DIFFICULTY = 1;
	public static final int HARD_DIFFICULTY = 2;

    public static final int ZERO = 0;

	public static final String GAME_TITLE = "MAZE RUNNER";
	public static final String START = "START";
	public static final String OPTIONS = "OPTIONS";
	public static final String EXIT = "EXIT";
	public static final String DIFFICULTY = "DIFFICULTY";
	
	public static final String MONSTER = "MONSTER";
	public static final String ZOMBIE = "ZOMBIE";

	public static final int SCREEN_DIMENSIONS = 400;
	public static final String MENU_TITLE = "Menu";
	public static final int MENU_OPTIONS_ROWS = 5;
	public static final int MENU_OPTIONS_COLUMNS = 1;
	public static final int MENU_OPTIONS_TEXT_SIZE = 20;
	public static final int MENU_OPTIONS_TEXT_SIZE_HEADING = 25;

	public static final int GOAL = 9;
	public static final int INT_ROWS = 10;
	public static final int INT_COLS = 10;

	public static final String ENEMEY_MOVES = "Enemy moves";
	public static final String ENEMY_DOESNT_MOVE = "Enemy doesn't move";

	public static final String UP = "UP";
	public static final String DOWN = "DOWN";
	public static final String RIGHT = "RIGHT";
	public static final String LEFT = "LEFT";
	public static final String BACK = "BACK";
	public static final String FORWARD = "FORWARD";

	public static final String ATTACH_DIFFICULTYUI = "Difficulty UI attached";
	public static final String ATTACH_ZOMBIE = "Zombie attached to Difficulty and Player";
	public static final String ATTACH_MONSTER = "Monster attached to Difficulty and Player";
	public static final String ZOMBIE_MOVEMENT = "Zombie movement updated to";
	public static final String MONSTER_MOVEMENT = "Monster movement updated to";
	public static final String PLAYER_AT= "Player at";
	
	public static final String MOVES_UP_OUTPUT = "Player moves up, new position is";
	public static final String MOVES_DOWN_OUTPUT = "Player moves down, new position is";
	public static final String MOVES_LEFT_OUTPUT= "Player moves left, new position is";
	public static final String MOVES_RIGHT_OUTPUT = "Player moves right, new position is";
	
	public static final String NEG_MOVES_UP_OUTPUT = "Not possible to move up";
	public static final String NEG_MOVES_DOWN_OUTPUT = "Not possible to move down";
	public static final String NEG_MOVES_LEFT_OUTPUT= "Not possible to move left";
	public static final String NEG_MOVES_RIGHT_OUTPUT = "Not possible to move right";
	
	public static final int ALLOWED_MOVES = 20;
	public static final int DOUBLE_MOVE = 2;
	public static final int[] START_POSITION = {0,0};
	
	/*
	 * public static final String DOWN = "DOWN"; public static final String
	 * RIGHT = "RIGHT"; public static final String LEFT = "LEFT"; public static
	 * final String BACK = "BACK";
	 */

	public static final String NO_MORE_MOVE_RESPONSE = "No more moves to undo";
	public static final String GAME_PASSED_RESPONSE = "Success, you have successfully navigated the Maze!!!";

	public static final String EASY_TEXT = "EASY";
	public static final String MEDIUM_TEXT = "MEDIUM";
	public static final String HARD_TEXT = "HARD";

	/** Opposite of {@link #FAILS}. */
	public static final boolean PASSES = true;
	/** Opposite of {@link #PASSES}. */
	public static final boolean FAILS = false;

	/** Opposite of {@link #FAILURE}. */
	public static final boolean SUCCESS = true;
	/** Opposite of {@link #SUCCESS}. */
	public static final boolean FAILURE = false;

	public static final boolean TRUE = true;

	public static final boolean FALSE = false;
	/**
	 * Useful for {@link String} operations, which return an index of
	 * <tt>-1</tt> when an item is not found.
	 */
	public static final int NOT_FOUND = -1;

	/** System property - <tt>line.separator</tt> */
	public static final String NEW_LINE = System.getProperty("line.separator");
	/** System property - <tt>file.separator</tt> */
	public static final String FILE_SEPARATOR = System
			.getProperty("file.separator");
	/** System property - <tt>path.separator</tt> */
	public static final String PATH_SEPARATOR = System
			.getProperty("path.separator");

	public static final String EMPTY_STRING = "";
	public static final String SPACE = " ";
	public static final String TAB = "\t";
	public static final String SINGLE_QUOTE = "'";
	public static final String PERIOD = ".";
	public static final String DOUBLE_QUOTE = "\"";
	public static final String SEMI_COLON = ":";

}
