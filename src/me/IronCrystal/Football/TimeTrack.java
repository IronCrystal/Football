package me.IronCrystal.Football;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class TimeTrack implements Runnable {
	GameObjects go = new GameObjects();
	Methods methods = new Methods();
	int gameLength = 0;
	public void run() {
		if (GameObjects.timer1.isEmpty()) {
		}
		
		/**
		 * Check if it is time to start the game
		 */
		else if ((Bukkit.getWorld(GameObjects.locationsFile.getString("Locations.world")).getTime() - GameObjects.timer1.get("Time")) >= GameObjects.ConfigFile.getDouble("Length of Joining Period in Seconds") * 20) {
			for(Player player : Bukkit.getOnlinePlayers()) {
				if(GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName())) {
					player.sendMessage(ChatColor.GREEN + "The game started!");
					go.logger.info("The football game has started!");
					World world = Bukkit.getWorld(GameObjects.locationsFile.getString("Locations.world"));
					Location loc = new Location (world, GameObjects.locationsFile.getDouble("Locations.center.x"), GameObjects.locationsFile.getDouble("Locations.center.y"), GameObjects.locationsFile.getDouble("Locations.center.z"));
					player.teleport(loc);
					player.getInventory().clear();
				}
			}
			GameObjects.playing = true;
			GameObjects.joiningGame = false;
			ItemStack itemStack = new ItemStack(Material.SLIME_BALL, 1);
			World world = Bukkit.getWorld(GameObjects.locationsFile.getString("Locations.world"));
			Location loc = new Location (world, GameObjects.locationsFile.getDouble("Locations.center.x"), GameObjects.locationsFile.getDouble("Locations.center.y"), GameObjects.locationsFile.getDouble("Locations.center.z"));
			GameObjects.ball = world.dropItem(loc, itemStack);
			GameObjects.timer1.clear();
			GameObjects.timer2.put("Time", world.getTime());
		}
		if (GameObjects.timer2.isEmpty()) {
		}
		
		/**
		 * Check if it is time to End the game
		 */
		else if ((Bukkit.getWorld(GameObjects.locationsFile.getString("Locations.world")).getTime() - GameObjects.timer2.get("Time")) >= GameObjects.ConfigFile.getDouble("Length of Game in Seconds") * 20) {
			GameObjects.playing = false;
			GameObjects.timer2.clear();
			for(Player player : Bukkit.getOnlinePlayers()) {
				if(GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName())) {
					player.sendMessage(ChatColor.GREEN + "The game is over!");
					player.sendMessage(ChatColor.GREEN + "The score was " + ChatColor.RED + GameObjects.RedScore + " " + ChatColor.GREEN + "- "+ ChatColor.BLUE + GameObjects.BlueScore);
					GameObjects.RedScore = 0;
					GameObjects.BlueScore = 0;
					player.getInventory().clear();
					GameObjects.blueTeam.clear();
					GameObjects.redTeam.clear();
				}
			}
			GameObjects.ball.remove();
		}
		else if ((Bukkit.getWorld(GameObjects.locationsFile.getString("Locations.world")).getTime() - GameObjects.timer2.get("Time")) <= 12000) {
		}
		if (GameObjects.timer3.isEmpty()) {
		}
		
		/**
		 * Check if ball is out of bounds
		 */
		else if (((Bukkit.getWorld(GameObjects.locationsFile.getString("Locations.world")).getTime() - GameObjects.timer3.get("Time")) >= 20) && !methods.ballInsideField()) {
			World world = Bukkit.getWorld(GameObjects.locationsFile.getString("Locations.world"));
			Location loc = new Location (world, GameObjects.locationsFile.getDouble("Locations.center.x"), GameObjects.locationsFile.getDouble("Locations.center.y"), GameObjects.locationsFile.getDouble("Locations.center.z"));
			GameObjects.ball.teleport(loc);
			for(Player player : Bukkit.getOnlinePlayers()) {
				if(GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName())) {
					player.sendMessage(ChatColor.RED + "Ball out of bounds.  Teleporting to center of field.");
				}
			}
		}
	}
}