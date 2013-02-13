package me.IronCrystal.Football;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Football extends JavaPlugin {

	Methods methods = new Methods();
	GameObjects go = new GameObjects();

	public final PlayerListener PlayerListener = new PlayerListener();
	public final TimeTrack TimeTrack = new TimeTrack();

	@Override
	public void onDisable() {

	}

	@Override
	public void onEnable() {
		
		/**
		 * Plugin Metrics
		 */
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}

		/**
		 * Register Events
		 */
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.PlayerListener, this);

		//final FileConfiguration config = this.getConfig();

		/**
		 * Timers
		 */
		Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new TimeTrack(), 0, 20L);

		/**
		 * Initialize files
		 */
		GameObjects.locations = new File(getDataFolder(), "field locations.yml");
		GameObjects.locationsFile = new YamlConfiguration();

		if (GameObjects.locations.exists()) {
			methods.loadFile(GameObjects.locations, GameObjects.locationsFile);
		}else{
			methods.clearField();
		}
		
		GameObjects.Config = new File(getDataFolder(), "config.yml");
		GameObjects.ConfigFile = new YamlConfiguration();

		if (GameObjects.Config.exists()) {
			methods.loadFile(GameObjects.Config, GameObjects.ConfigFile);
		}else{
			methods.initializeConfig();
		}
		
		/**
		 * Commands
		 */
		Commands Commands = new Commands();
		getCommand("fb").setExecutor(Commands);
	}

	//	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
	//		Player player = (Player) sender;
	//		if (sender instanceof Player) {
	//			player = (Player) sender;
	//		}
	//		if (player != null) 
	//		{
	//			if (cmd.getName().equalsIgnoreCase("fb"))
	//			{
	//				if (args.length == 0)
	//				{
	//					player.sendMessage("/fb create - creates a football field");
	//					player.sendMessage("/fb cancel - deletes the current football field");
	//					player.sendMessage("/fb start - starts a football game");
	//					player.sendMessage("/fb join - joins the current footbal game");
	//					player.sendMessage("/fb over - ends the current football game");
	//					return true;
	//				}
	//				if (args [0].equalsIgnoreCase("field"))
	//				{
	//					player.sendMessage(this.getConfig().getBoolean("MadeField") + "");
	//				}
	//				if (args [0].equalsIgnoreCase("start")) 
	//				{
	//					if (this.getConfig().getBoolean("MadeField") == false)
	//					{
	//						player.sendMessage(ChatColor.RED + "You must make the field first!");
	//						return true;
	//					}
	//					if (playing == false) 
	//					{
	//						timer1.put("Time", Bukkit.getServer().getWorld(player.getWorld().getName()).getTime());
	//						player.sendMessage(ChatColor.GREEN + "Initiated the game!");
	//						Bukkit.broadcastMessage(ChatColor.GREEN + "Hurry up and join the football game!");
	//						Bukkit.broadcastMessage(ChatColor.GREEN + "Type in /fb join");
	//						joiningGame = true;
	//						return true;
	//					} else 
	//					{
	//						player.sendMessage(ChatColor.RED + "Game already in session");
	//						return true;
	//					}
	//				}
	//				else if (args [0].equalsIgnoreCase("over"))
	//				{
	//					playing = false;
	//					player.sendMessage(ChatColor.RED + "You ended the game!");
	//					timer1.clear();
	//					blueTeam.clear();
	//					redTeam.clear();
	//					redPlayer = 0;
	//					bluePlayer = 0;
	//					return true;
	//				}
	//				else if (args [0].equalsIgnoreCase("times"))
	//				{ 
	//					World world = player.getWorld();
	//					player.sendMessage("The current time is " + world.getTime());
	//					player.sendMessage("The saved time is " + timer1.values());
	//					player.sendMessage("The saved time is " + timer2.values());
	//					return true;
	//				}
	//				else if (args [0].equalsIgnoreCase("create"))
	//				{
	//					player.sendMessage(ChatColor.GREEN + "Left click each of the opposite corners of the field");
	//					makingField = true;
	//					return true;
	//				}
	//				else if (args [0].equalsIgnoreCase("done"))
	//				{
	//					player.sendMessage(ChatColor.GREEN + "Field Created");
	//					makingField = false;
	//					madeField = true;
	//					this.getConfig().set("MadeField", true);
	//					this.saveConfig();
	//					return true;
	//				}
	//				else if (args [0].equalsIgnoreCase("join"))
	//				{
	//					if (joiningGame != true) 
	//					{
	//						player.sendMessage(ChatColor.RED +"Game has not been initialized yet or is in progress.");
	//						return true;
	//					}
	//					else if (!blueTeam.containsValue(player) && !redTeam.containsValue(player))
	//					{
	//						if (bluePlayer == redPlayer)
	//						{
	//							Inventory inv = player.getInventory();
	//
	//							for(ItemStack stack : inv.getContents())
	//							{
	//								try
	//								{
	//									if(stack.getType()!=(Material.AIR)) 
	//									{
	//										player.sendMessage(ChatColor.RED + "Empty your inventory!");
	//										emptyInventory = false;
	//										return true;
	//									}
	//								} catch (Exception e){}
	//							}
	//							if (emptyInventory = true)
	//							{
	//								blueTeam.put("Blue", player);
	//								ItemStack itemStackBlue = new ItemStack(Material.WOOL, 1, (short)3);
	//								player.getInventory().clear();
	//								player.getInventory().setHelmet(itemStackBlue);
	//								bluePlayer++;
	//								player.sendMessage(ChatColor.BLUE + "You joined the Blue team!");
	//								return true;
	//							}
	//						}
	//
	//						else
	//						{
	//							Inventory inv = player.getInventory();
	//
	//							for(ItemStack stack : inv.getContents())
	//							{
	//								try
	//								{
	//									if(stack.getType()!=(Material.AIR)) 
	//									{
	//										player.sendMessage(ChatColor.RED + "Empty your inventory!");
	//										emptyInventory = false;
	//										return true;
	//									}
	//								} catch (Exception e){}
	//							}
	//							if (emptyInventory = true)
	//							{
	//								redTeam.put("Red", player);
	//								ItemStack itemStackRed = new ItemStack(Material.WOOL, 1, (short)14);
	//								player.getInventory().clear();
	//								player.getInventory().setHelmet(itemStackRed);
	//								redPlayer++;
	//								player.sendMessage(ChatColor.RED + "You joined the Red team!");
	//								return true;
	//							}
	//						}
	//					}
	//					else
	//					{
	//						player.sendMessage(ChatColor.RED + "You are already in the game!");
	//						return true;
	//					}
	//				}
	//				else if (args [0].equalsIgnoreCase("cancel"))
	//				{
	//					this.getConfig().set("MadeField", false);
	//					this.getConfig().set("Locations.block1.x", 0);
	//					this.getConfig().set("Locations.block1.y", 0);
	//					this.getConfig().set("Locations.block1.z", 0);
	//					this.getConfig().set("Locations.block2.x", 0);
	//					this.getConfig().set("Locations.block2.y", 0);
	//					this.getConfig().set("Locations.block2.z", 0);
	//					this.getConfig().set("Locations.center.x", 0);
	//					this.getConfig().set("Locations.center.y", 0);
	//					this.getConfig().set("Locations.center.z", 0);
	//					this.getConfig().set("Locations.touchdownRed1.x", 0);
	//					this.getConfig().set("Locations.touchdownRed1.y", 0);
	//					this.getConfig().set("Locations.touchdownRed1.z", 0);
	//					this.getConfig().set("Locations.touchdownRed2.x", 0);
	//					this.getConfig().set("Locations.touchdownRed2.y", 0);
	//					this.getConfig().set("Locations.touchdownRed2.z", 0);
	//					this.getConfig().set("Locations.touchdownBlue1.x", 0);
	//					this.getConfig().set("Locations.touchdownBlue1.y", 0);
	//					this.getConfig().set("Locations.touchdownBlue1.z", 0);
	//					this.getConfig().set("Locations.touchdownBlue2.x", 0);
	//					this.getConfig().set("Locations.touchdownBlue2.y", 0);
	//					this.getConfig().set("Locations.touchdownBlue2.z", 0);
	//					this.saveConfig();
	//					/*block1.clear();
	//					block2.clear();
	//					center.clear();
	//					touchdownRed1.clear();
	//					touchdownRed2.clear();
	//					touchdownBlue1.clear();
	//					touchdownBlue2.clear();*/
	//
	//					player.sendMessage(ChatColor.GREEN + "Field creation cancelled.");
	//					return true;
	//				}
	//			}
	//		}
	//		return false;
	//	}

}