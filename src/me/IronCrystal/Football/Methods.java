package me.IronCrystal.Football;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

public class Methods {

	GameObjects go = new GameObjects();

	public void loadFile(File file, FileConfiguration fileConfig) {
		try {
			fileConfig.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveFile(File file, FileConfiguration fileConfig) {
		try {
			fileConfig.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initializeConfig() {
		GameObjects.ConfigFile.set("Length of Game in Seconds", 300);
		GameObjects.ConfigFile.set("Length of Joining Period in Seconds", 60);
		GameObjects.ConfigFile.set("Throwing Distance Multiplier When Crouching", 1);
		GameObjects.ConfigFile.set("Max Team Size", 10);
		GameObjects.ConfigFile.set("Team 1 Name", "Blue");
		GameObjects.ConfigFile.set("Team 1 Color", 11);
		GameObjects.ConfigFile.set("Team 2 Name", "Red");
		GameObjects.ConfigFile.set("Team 2 Color", 14);
		GameObjects.ConfigFile.set("Colors can be found here", "http://www.minecraftwiki.net/wiki/Data_Value#Wool");
		saveFile(GameObjects.Config, GameObjects.ConfigFile);
	}

	public void clearField() {
		GameObjects.locationsFile.set("MadeField", false);
		GameObjects.locationsFile.set("Locations.block1.x", 0);
		GameObjects.locationsFile.set("Locations.block1.y", 0);
		GameObjects.locationsFile.set("Locations.block1.z", 0);
		GameObjects.locationsFile.set("Locations.block2.x", 0);
		GameObjects.locationsFile.set("Locations.block2.y", 0);
		GameObjects.locationsFile.set("Locations.block2.z", 0);
		GameObjects.locationsFile.set("Locations.center.x", 0);
		GameObjects.locationsFile.set("Locations.center.y", 0);
		GameObjects.locationsFile.set("Locations.center.z", 0);
		GameObjects.locationsFile.set("Locations.touchdownRed1.x", 0);
		GameObjects.locationsFile.set("Locations.touchdownRed1.y", 0);
		GameObjects.locationsFile.set("Locations.touchdownRed1.z", 0);
		GameObjects.locationsFile.set("Locations.touchdownRed2.x", 0);
		GameObjects.locationsFile.set("Locations.touchdownRed2.y", 0);
		GameObjects.locationsFile.set("Locations.touchdownRed2.z", 0);
		GameObjects.locationsFile.set("Locations.touchdownBlue1.x", 0);
		GameObjects.locationsFile.set("Locations.touchdownBlue1.y", 0);
		GameObjects.locationsFile.set("Locations.touchdownBlue1.z", 0);
		GameObjects.locationsFile.set("Locations.touchdownBlue2.x", 0);
		GameObjects.locationsFile.set("Locations.touchdownBlue2.y", 0);
		GameObjects.locationsFile.set("Locations.touchdownBlue2.z", 0);
		saveFile(GameObjects.locations, GameObjects.locationsFile);
	}

	public boolean ballInsideField() {
		double minX1 = GameObjects.locationsFile.getDouble("Locations.block1.x");
		double minX2 = GameObjects.locationsFile.getDouble("Locations.block2.x");
		double minx = Math.min(minX1, minX2);

		double minZ1 = GameObjects.locationsFile.getDouble("Locations.block1.z");
		double minZ2 = GameObjects.locationsFile.getDouble("Locations.block2.z");
		double minz = Math.min(minZ1, minZ2);

		double maxX1 = GameObjects.locationsFile.getDouble("Locations.block1.x");
		double maxX2 = GameObjects.locationsFile.getDouble("Locations.block2.x");
		double maxx = Math.max(maxX1, maxX2);

		double maxZ1 = GameObjects.locationsFile.getDouble("Locations.block1.z");
		double maxZ2 = GameObjects.locationsFile.getDouble("Locations.block2.z");
		double maxz = Math.max(maxZ1, maxZ2);

		if (GameObjects.ball.getLocation().getX() > maxx || GameObjects.ball.getLocation().getX() < minx || GameObjects.ball.getLocation().getZ() > maxz || GameObjects.ball.getLocation().getZ() < minz) {
			return false;
		}
		return true;

	}
}
