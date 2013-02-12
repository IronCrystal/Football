package me.IronCrystal.Football;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor {

	Methods methods = new Methods();
	GameObjects go = new GameObjects();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (sender instanceof Player) {
			player = (Player) sender;
		}
		if (player != null) {
			if (cmd.getName().equalsIgnoreCase("fb")) {
				if (args.length == 0) {
					player.sendMessage("/fb create - creates a football field");
					player.sendMessage("/fb cancel - deletes the current football field");
					player.sendMessage("/fb start - starts a football game");
					player.sendMessage("/fb join - joins the current footbal game");
					player.sendMessage("/fb over - ends the current football game");
					return true;
				}
				if (args [0].equalsIgnoreCase("field")) {
					player.sendMessage(GameObjects.locationsFile.getBoolean("MadeField") + "");
				}
				if (args [0].equalsIgnoreCase("start"))  {
					if (!GameObjects.locationsFile.getBoolean("MadeField")) {
						player.sendMessage(ChatColor.RED + "You must make the field first!");
						return true;
					}
					if (!GameObjects.playing) {
						GameObjects.timer1.put("Time", Bukkit.getServer().getWorld(player.getWorld().getName()).getTime());
						player.sendMessage(ChatColor.GREEN + "Initiated the game!");
						Bukkit.broadcastMessage(ChatColor.GREEN + "Hurry up and join the football game!");
						Bukkit.broadcastMessage(ChatColor.GREEN + "Type in /fb join");
						GameObjects.joiningGame = true;
						return true;
					}else{
						player.sendMessage(ChatColor.RED + "Game already in session");
						return true;
					}
				}
				else if (args [0].equalsIgnoreCase("over")) {
					GameObjects.playing = false;
					player.sendMessage(ChatColor.RED + "You ended the game!");
					GameObjects.timer1.clear();
					GameObjects.blueTeam.clear();
					GameObjects.redTeam.clear();
					return true;
				}
				else if (args [0].equalsIgnoreCase("times")) { 
					World world = player.getWorld();
					player.sendMessage("The current time is " + world.getTime());
					player.sendMessage("The saved time is " + GameObjects.timer1.values());
					player.sendMessage("The saved time is " + GameObjects.timer2.values());
					return true;
				}
				else if (args [0].equalsIgnoreCase("create")) {
					player.sendMessage(ChatColor.GREEN + "Left click each of the opposite corners of the field");
					GameObjects.makingField = true;
					go.logger.info(GameObjects.makingField + "");
					return true;
				}
				else if (args [0].equalsIgnoreCase("done")) {
					player.sendMessage(ChatColor.GREEN + "Field Created");
					GameObjects.makingField = false;
					GameObjects.madeField = true;
					GameObjects.locationsFile.set("MadeField", true);
					methods.saveFile(GameObjects.locations, GameObjects.locationsFile);
					return true;
				}
				else if (args [0].equalsIgnoreCase("join")) {
					if (GameObjects.joiningGame != true) {
						player.sendMessage(ChatColor.RED +"Game has not been initialized yet or is in progress.");
						return true;
					}
					else if (!GameObjects.blueTeam.contains(player.getName()) && !GameObjects.redTeam.contains(player.getName())) {
						if (GameObjects.blueTeam.size() == GameObjects.redTeam.size()) {
							Inventory inv = player.getInventory();

							for(ItemStack stack : inv.getContents()) {
								try {
									if(stack.getType()!=(Material.AIR))  {
										player.sendMessage(ChatColor.RED + "Empty your inventory!");
										GameObjects.emptyInventory = false;
										return true;
									}
								} catch (Exception e){}
							}
							if (GameObjects.emptyInventory = true) {
								int color = GameObjects.ConfigFile.getInt("Team 1 Color");
								GameObjects.blueTeam.add(player.getName());
								ItemStack itemStackBlue = new ItemStack(Material.WOOL, 1, (short)color);
								player.getInventory().clear();
								player.getInventory().setHelmet(itemStackBlue);
								player.sendMessage(ChatColor.BLUE + "You joined the " + GameObjects.ConfigFile.getString("Team 1 Name") + " team!");
								return true;
							}
						}else{
							Inventory inv = player.getInventory();

							for(ItemStack stack : inv.getContents()) {
								try {
									if(stack.getType()!=(Material.AIR)) {
										player.sendMessage(ChatColor.RED + "Empty your inventory!");
										GameObjects.emptyInventory = false;
										return true;
									}
								} catch (Exception e){}
							}
							if (GameObjects.emptyInventory = true) {
								GameObjects.redTeam.add(player.getName());
								int color = GameObjects.ConfigFile.getInt("Team 2 Color");
								ItemStack itemStackRed = new ItemStack(Material.WOOL, 1, (short)color);
								player.getInventory().clear();
								player.getInventory().setHelmet(itemStackRed);
								player.sendMessage(ChatColor.RED + "You joined the " + GameObjects.ConfigFile.getString("Team 2 Name") + " team!");
								return true;
							}
						}
					}else{
						player.sendMessage(ChatColor.RED + "You are already in the game!");
						return true;
					}
				}
				else if (args [0].equalsIgnoreCase("cancel")) {
					methods.clearField();

					player.sendMessage(ChatColor.GREEN + "Field creation cancelled.");
					return true;
				}
			}			
		}
		return false;
	}
}