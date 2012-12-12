package me.IronCrystal.Football;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;

public class GameObjects {
	
	/**
	 * Game State Booleans
	 */
	static boolean playing = false;
	static boolean makingField;
	static boolean joiningGame = false;
	static boolean emptyInventory = true;
	static boolean madeField;

	/**
	 * Logger
	 */
	public final Logger logger = Logger.getLogger("Minecraft");

	/**
	 * Timers
	 */
	static Map<String, Long> timer1 = new HashMap<String, Long>();  //Joining time
	static Map<String, Long> timer2 = new HashMap<String, Long>();  //Game time
	static Map<String, Long> timer3 = new HashMap<String, Long>();  //Checking whether the ball is in-bounds

	/**
	 * File for storing locations
	 */
	public static File locations;
	public static FileConfiguration locationsFile;
	
	public static File Config;
	public static FileConfiguration ConfigFile;

	/**
	 * Teams
	 */
	static List<String> blueTeam = new ArrayList<String>();
	static List<String> redTeam = new ArrayList<String>();
//	Map<String, String> blueTeam = new HashMap<String, String>();
//	Map<String, String> redTeam = new HashMap<String, String>();

	/**
	 * Number of players per team
	 */
//	int bluePlayer = 0;
//	int redPlayer = 0;

	/**
	 * Playing ball object
	 */
	static Item ball;
	
	/**
	 * Scoring
	 */
	static int BlueScore = 0;
	static int RedScore = 0;
}
