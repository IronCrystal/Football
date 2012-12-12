package me.IronCrystal.Football;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class PlayerListener implements Listener {

	Methods methods = new Methods();
	GameObjects go = new GameObjects();

	@EventHandler
	public void onPlayerInteractEvent (PlayerInteractEvent event) {
		Player player = event.getPlayer();

		/**
		 * Making the field
		 */
		if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			if (GameObjects.makingField) {
				if (GameObjects.locationsFile.getDouble("Locations.block1.x") == 0) {
					Location block = event.getClickedBlock().getLocation();

					double x = block.getX();
					double y = block.getY();
					double z = block.getZ();

					World world = block.getWorld();

					Location centerBlock = new Location(world, x, y, z);

					double locx = centerBlock.getX();
					double locy = centerBlock.getY();
					double locz = centerBlock.getZ();

					GameObjects.locationsFile.set("Locations.block1.x", locx);
					GameObjects.locationsFile.set("Locations.block1.y", locy);
					GameObjects.locationsFile.set("Locations.block1.z", locz);
					methods.saveFile(GameObjects.locations, GameObjects.locationsFile);

					//go.block1.put("Location", block);
					player.sendMessage(ChatColor.GREEN + "Block location recorded.");
				}
				else if (GameObjects.locationsFile.getDouble("Locations.block2.x") == 0)
				{
					Location block = event.getClickedBlock().getLocation();

					double x = block.getX();
					double y = block.getY();
					double z = block.getZ();

					World world = block.getWorld();

					Location centerBlock = new Location(world, x, y, z);

					double locx = centerBlock.getX();
					double locy = centerBlock.getY();
					double locz = centerBlock.getZ();

					GameObjects.locationsFile.set("Locations.block2.x", locx);
					GameObjects.locationsFile.set("Locations.block2.y", locy);
					GameObjects.locationsFile.set("Locations.block2.z", locz);
					methods.saveFile(GameObjects.locations, GameObjects.locationsFile);

					//go.block2.put("Location", block);
					player.sendMessage(ChatColor.GREEN + "Both corner locations recorded.");
					player.sendMessage(ChatColor.GREEN + "Register center of field");
				}
				else if (GameObjects.locationsFile.getDouble("Locations.center.x") == 0)
				{
					Location block = event.getClickedBlock().getLocation();

					double x = block.getX();
					double y = block.getY();
					double z = block.getZ();

					World world = block.getWorld();

					Location centerBlock = new Location(world, x, y + 2, z);

					double locx = centerBlock.getX();
					double locy = centerBlock.getY();
					double locz = centerBlock.getZ();

					GameObjects.locationsFile.set("Locations.center.x", locx);
					GameObjects.locationsFile.set("Locations.center.y", locy);
					GameObjects.locationsFile.set("Locations.center.z", locz);
					methods.saveFile(GameObjects.locations, GameObjects.locationsFile);

					//go.center.put("Location", centerBlock);					

					player.sendMessage(ChatColor.GREEN + "Center of field registered");
					player.sendMessage(ChatColor.GREEN + "Register corner of " + ChatColor.RED + "Red" + ChatColor.GREEN + " touchdown zone");
				}
				else if (GameObjects.locationsFile.getDouble("Locations.touchdownRed1.x") == 0)
				{
					Location block = event.getClickedBlock().getLocation();

					double x = block.getX();
					double y = block.getY();
					double z = block.getZ();

					World world = block.getWorld();

					Location centerBlock = new Location(world, x, y, z);

					double locx = centerBlock.getX();
					double locy = centerBlock.getY();
					double locz = centerBlock.getZ();

					GameObjects.locationsFile.set("Locations.touchdownRed1.x", locx);
					GameObjects.locationsFile.set("Locations.touchdownRed1.y", locy);
					GameObjects.locationsFile.set("Locations.touchdownRed1.z", locz);
					methods.saveFile(GameObjects.locations, GameObjects.locationsFile);

					//go.touchdownRed1.put("Location", block);
					player.sendMessage(ChatColor.GREEN + "Corner of " + ChatColor.RED + "Red" + ChatColor.GREEN + " touchdown zone recorded");
					player.sendMessage(ChatColor.GREEN + "Register opposite corner of " + ChatColor.RED + "Red" + ChatColor.GREEN + " touchdown zone");
				}
				else if (GameObjects.locationsFile.getDouble("Locations.touchdownRed2.x") == 0)
				{
					Location block = event.getClickedBlock().getLocation();

					double x = block.getX();
					double y = block.getY();
					double z = block.getZ();

					World world = block.getWorld();

					Location centerBlock = new Location(world, x, y, z);

					double locx = centerBlock.getX();
					double locy = centerBlock.getY();
					double locz = centerBlock.getZ();

					GameObjects.locationsFile.set("Locations.touchdownRed2.x", locx);
					GameObjects.locationsFile.set("Locations.touchdownRed2.y", locy);
					GameObjects.locationsFile.set("Locations.touchdownRed2.z", locz);
					methods.saveFile(GameObjects.locations, GameObjects.locationsFile);

					//go.touchdownRed2.put("Location", block);
					player.sendMessage(ChatColor.GREEN + "Opposite corner of " + ChatColor.RED + "Red" + ChatColor.GREEN + " touchdown zone recorded");
					player.sendMessage(ChatColor.GREEN + "Register corner of " + ChatColor.BLUE + "Blue" + ChatColor.GREEN + " touchdown zone.");
				}
				else if (GameObjects.locationsFile.getDouble("Locations.touchdownBlue1.x") == 0)
				{
					Location block = event.getClickedBlock().getLocation();

					double x = block.getX();
					double y = block.getY();
					double z = block.getZ();

					World world = block.getWorld();

					Location centerBlock = new Location(world, x, y, z);

					double locx = centerBlock.getX();
					double locy = centerBlock.getY();
					double locz = centerBlock.getZ();

					GameObjects.locationsFile.set("Locations.touchdownBlue1.x", locx);
					GameObjects.locationsFile.set("Locations.touchdownBlue1.y", locy);
					GameObjects.locationsFile.set("Locations.touchdownBlue1.z", locz);
					methods.saveFile(GameObjects.locations, GameObjects.locationsFile);

					//go.touchdownBlue1.put("Location", block);
					player.sendMessage(ChatColor.GREEN + "Corner of " + ChatColor.BLUE + "Blue" + ChatColor.GREEN + " touchdown zone recorded");
					player.sendMessage(ChatColor.GREEN + "Register opposite corner of " + ChatColor.BLUE + "Blue" + ChatColor.GREEN + " touchdown zone");
				}
				else if (GameObjects.locationsFile.getDouble("Locations.touchdownBlue2.x") == 0)
				{
					Location block = event.getClickedBlock().getLocation();

					double x = block.getX();
					double y = block.getY();
					double z = block.getZ();

					World world = block.getWorld();

					Location centerBlock = new Location(world, x, y, z);

					double locx = centerBlock.getX();
					double locy = centerBlock.getY();
					double locz = centerBlock.getZ();

					GameObjects.locationsFile.set("Locations.touchdownBlue2.x", locx);
					GameObjects.locationsFile.set("Locations.touchdownBlue2.y", locy);
					GameObjects.locationsFile.set("Locations.touchdownBlue2.z", locz);
					GameObjects.locationsFile.set("Locations.world", world.getName());
					methods.saveFile(GameObjects.locations, GameObjects.locationsFile);

					//go.touchdownBlue2.put("Location", block);
					player.sendMessage(ChatColor.GREEN + "Opposite corner of " + ChatColor.BLUE + "Blue" + ChatColor.GREEN + " touchdown recorded");
					player.sendMessage(ChatColor.GREEN + "Type /fb done to finish");
				}
			}
		}

		/**
		 * Throwing the ball
		 */
		if (event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{ 
			if (GameObjects.playing == true && player.getItemInHand().getType().equals(Material.SLIME_BALL))
			{
				if(GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName()))
				{
					player.getInventory().clear();
					Location loc = player.getLocation();
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();

					World world = player.getWorld();

					Location playerLocation = new Location(world, x, y + 2, z);

					ItemStack itemStack = new ItemStack(Material.SLIME_BALL, 1);
					GameObjects.ball = world.dropItem(playerLocation, itemStack);
					Vector dir = player.getLocation().getDirection();

					double dirx = dir.getX();
					double diry = dir.getY();
					double dirz = dir.getZ();

					Vector vel = new Vector(dirx, diry, dirz);

					if (player.isSneaking()) {
						GameObjects.ball.setVelocity(vel.multiply(GameObjects.ConfigFile.getDouble("Throwing Distance Multiplier When Crouching")));
					}else{
						GameObjects.ball.setVelocity(vel);
					}

					GameObjects.timer3.put("Time", world.getTime());
//					if (GameObjects.blueTeam.contains(player.getName())) {
//						ItemStack itemStackBlue = new ItemStack(Material.WOOL, 1, (short)3);
//						player.getInventory().remove(103);
//						player.getInventory().setHelmet(itemStackBlue);
//					}
//					else if (GameObjects.redTeam.contains(player.getName())) {
//						ItemStack redHelmet = new ItemStack(Material.WOOL, 1, (short)14);
//						player.getInventory().remove(103);
//						player.getInventory().setHelmet(redHelmet);
//					}
				}
			}
		}
	}

	/**
	 * Catching the Ball
	 * @param event
	 */
	@EventHandler
	public void onPlayerCatchEvent (PlayerPickupItemEvent event) {
		Player player = event.getPlayer();

		if (event.getItem().equals(GameObjects.ball)) {
			if (GameObjects.playing && (GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName()))) { 
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(GameObjects.blueTeam.contains(p.getName()) || GameObjects.redTeam.contains(p.getName())) {
						p.sendMessage(ChatColor.GREEN + player.getDisplayName() + " picked up the ball!");
					}
				}
			}else{
				event.setCancelled(true);
			}
		}

		if (GameObjects.joiningGame && (GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName()))) {
			event.setCancelled(true);
		}

		if ((GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName())) && !event.getItem().equals(GameObjects.ball)) {
			event.setCancelled(true);
		}
	}

	/**
	 * Tackling players
	 * @param event
	 */
	@EventHandler
	public void onPlayerTackleEvent (EntityDamageByEntityEvent event) {
		if (GameObjects.playing == true && event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
			Player tackler = (Player) event.getDamager();
			Player tackled = (Player) event.getEntity();

			if((GameObjects.blueTeam.contains(tackler.getName()) || GameObjects.redTeam.contains(tackler.getName())) && (GameObjects.blueTeam.contains(tackled.getName()) || GameObjects.redTeam.contains(tackled.getName()))) {
				if (tackled.getInventory().contains(Material.SLIME_BALL)) {
					tackler.sendMessage(ChatColor.GREEN + "You tackled " + tackled.getDisplayName());
					tackled.sendMessage(ChatColor.RED + "You were tackled by " + tackler.getDisplayName());

					tackled.getInventory().clear();
					Location loc = tackled.getLocation();
					double x = loc.getX();
					double y = loc.getY();
					double z = loc.getZ();

					World world = tackled.getWorld();

					Location playerLocation = new Location(world, x, y, z);

					ItemStack itemStack = new ItemStack(Material.SLIME_BALL, 1);
					GameObjects.ball = world.dropItem(playerLocation, itemStack);

					tackled.setHealth(20);
					if (GameObjects.blueTeam.contains(tackled.getName())) {
						ItemStack item = new ItemStack(Material.WOOL, 1, (short)3);
						tackled.getInventory().setHelmet(item);
					}
					else if (GameObjects.redTeam.contains(tackled.getName())) {
						ItemStack item = new ItemStack(Material.WOOL, 1, (short)14);
						tackled.getInventory().setHelmet(item);
					}
				}else{
					event.setCancelled(true);
				}
			}
		}
	}

	/**
	 * Player running out of bounds
	 * @param event
	 */
	@EventHandler
	public void onPlayerOutOfBoundsEvent (PlayerMoveEvent event) {
		Player player = event.getPlayer();

		if (GameObjects.playing == true) {	
			if(GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName())) {
				Location playerLocation = event.getPlayer().getLocation();

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

				if (playerLocation.getX() > maxx ) {
					Location location = player.getLocation();
					double x = location.getX();
					double y = location.getY();
					double z = location.getZ();

					World world = player.getWorld();

					Location loc = new Location(world, x - 1, y, z);
					player.sendMessage(ChatColor.RED + "You are out of bounds!");
					player.teleport(loc);
				}
				else if (playerLocation.getX() < minx) {
					Location location = player.getLocation();
					double x = location.getX();
					double y = location.getY();
					double z = location.getZ();

					World world = player.getWorld();

					Location loc = new Location(world, x + 1, y, z);
					player.sendMessage(ChatColor.RED + "You are out of bounds!");
					player.teleport(loc);
				}
				else if (playerLocation.getZ() > maxz) {
					Location location = player.getLocation();
					double x = location.getX();
					double y = location.getY();
					double z = location.getZ();

					World world = player.getWorld();

					Location loc = new Location(world, x, y, z - 1);
					player.sendMessage(ChatColor.RED + "You are out of bounds!");
					player.teleport(loc);
				}
				else if (playerLocation.getZ() < minz) {
					Location location = player.getLocation();
					double x = location.getX();
					double y = location.getY();
					double z = location.getZ();

					World world = player.getWorld();

					Location loc = new Location(world, x, y, z + 1);
					player.sendMessage(ChatColor.RED + "You are out of bounds!");
					player.teleport(loc);
				}
			}
		}
	}

	/**
	 * Player scoring a touchdown
	 * @param event
	 */
	@EventHandler
	public void onPlayerTouchdownEvent (PlayerMoveEvent event) {
		Player player = event.getPlayer();

		if (GameObjects.playing == true) {	
			if(GameObjects.blueTeam.contains(player.getName()) && player.getItemInHand().getType().equals(Material.SLIME_BALL)) {
				Location playerLocation = event.getPlayer().getLocation();

				double minX1 = GameObjects.locationsFile.getDouble("Locations.touchdownBlue1.x");
				double minX2 = GameObjects.locationsFile.getDouble("Locations.touchdownBlue2.x");
				double minx =  Math.min( minX1, minX2 );

				double minZ1 = GameObjects.locationsFile.getDouble("Locations.touchdownBlue1.z");
				double minZ2 = GameObjects.locationsFile.getDouble("Locations.touchdownBlue2.z");
				double minz =  Math.min( minZ1, minZ2 );

				double maxX1 = GameObjects.locationsFile.getDouble("Locations.touchdownBlue1.x");
				double maxX2 = GameObjects.locationsFile.getDouble("Locations.touchdownBlue2.x");
				double maxx =  Math.max( maxX1, maxX2 );

				double maxZ1 = GameObjects.locationsFile.getDouble("Locations.touchdownBlue1.z");
				double maxZ2 = GameObjects.locationsFile.getDouble("Locations.touchdownBlue2.z");
				double maxz =  Math.max( maxZ1, maxZ2 );

				if (playerLocation.getX() < maxx && playerLocation.getX() > minx && player.getLocation().getZ() < maxz && player.getLocation().getZ() > minz) {
					player.sendMessage("You scored!");
					GameObjects.BlueScore++;
					player.getInventory().clear();

					World world = player.getWorld();

					Location loc = new Location (world, GameObjects.locationsFile.getDouble("Locations.center.x"), GameObjects.locationsFile.getDouble("Locations.center.y"), GameObjects.locationsFile.getDouble("Locations.center.z"));
					ItemStack itemStack = new ItemStack(Material.SLIME_BALL, 1);
					GameObjects.ball = world.dropItem(loc, itemStack);
					for(Player players : Bukkit.getOnlinePlayers()) {
						if(GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName())) {
							players.sendMessage(ChatColor.GREEN + "A touchdown was scored by " + ChatColor.BLUE + player.getName());
						}
					}					
				}
			}
			if(GameObjects.redTeam.contains(player.getName()) && player.getItemInHand().getType().equals(Material.SLIME_BALL)) {
				Location playerLocation = event.getPlayer().getLocation();

				double minX1 = GameObjects.locationsFile.getDouble("Locations.touchdownRed1.x");
				double minX2 = GameObjects.locationsFile.getDouble("Locations.touchdownRed2.x");
				double minx =  Math.min( minX1, minX2 );

				double minZ1 = GameObjects.locationsFile.getDouble("Locations.touchdownRed1.z");
				double minZ2 = GameObjects.locationsFile.getDouble("Locations.touchdownRed2.z");
				double minz =  Math.min( minZ1, minZ2 );

				double maxX1 = GameObjects.locationsFile.getDouble("Locations.touchdownRed1.x");
				double maxX2 = GameObjects.locationsFile.getDouble("Locations.touchdownRed2.x");
				double maxx =  Math.max( maxX1, maxX2 );

				double maxZ1 = GameObjects.locationsFile.getDouble("Locations.touchdownRed1.z");
				double maxZ2 = GameObjects.locationsFile.getDouble("Locations.touchdownRed2.z");
				double maxz =  Math.max( maxZ1, maxZ2 );

				if (playerLocation.getX() < maxx && playerLocation.getX() > minx && player.getLocation().getZ() < maxz && player.getLocation().getZ() > minz) {
					GameObjects.RedScore++;
					player.getInventory().clear();

					World world = player.getWorld();
					Location loc = new Location (world, GameObjects.locationsFile.getDouble("Locations.center.x"), GameObjects.locationsFile.getDouble("Locations.center.y"), GameObjects.locationsFile.getDouble("Locations.center.z"));

					ItemStack itemStack = new ItemStack(Material.SLIME_BALL, 1);
					GameObjects.ball = world.dropItem(loc, itemStack);
					for(Player players : Bukkit.getOnlinePlayers())
					{
						if(GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName()))
						{
							players.sendMessage(ChatColor.GREEN + "A touchdown was scored by " + ChatColor.RED + player.getName());
						}
					}		
				}
			}
		}
	}

	/**
	 * Player destroying block
	 * @param event
	 */
	@EventHandler
	public void onPlayerDestroyEvent (BlockBreakEvent event) {
		Player player = event.getPlayer();

		if (GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName())) {
			event.setCancelled(true);
		}
	}

	/**
	 * Player leaving the game
	 * @param event
	 */
	@EventHandler
	public void onPlayerDisconnectEvent (PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if (GameObjects.blueTeam.contains(player.getName())) {
			if (player.getItemInHand().equals(GameObjects.ball)) {
				World world = player.getWorld();
				Location loc = new Location (world, GameObjects.locationsFile.getDouble("Locations.center.x"), GameObjects.locationsFile.getDouble("Locations.center.y"), GameObjects.locationsFile.getDouble("Locations.center.z"));

				ItemStack itemStack = new ItemStack(Material.SLIME_BALL, 1);
				GameObjects.ball = world.dropItem(loc, itemStack);
			}
			GameObjects.blueTeam.remove(player);
		}
		else if (GameObjects.redTeam.contains(player.getName())) {
			if (player.getItemInHand().equals(GameObjects.ball)) {
				World world = player.getWorld();
				Location loc = new Location (world, GameObjects.locationsFile.getDouble("Locations.center.x"), GameObjects.locationsFile.getDouble("Locations.center.y"), GameObjects.locationsFile.getDouble("Locations.center.z"));

				ItemStack itemStack = new ItemStack(Material.SLIME_BALL, 1);
				GameObjects.ball = world.dropItem(loc, itemStack);
			}
			GameObjects.redTeam.remove(player);
		}
	}

	@EventHandler
	public void onPlayerDropBall(PlayerDropItemEvent event) {
		Player player = event.getPlayer();

		if (GameObjects.blueTeam.contains(player.getName()) || GameObjects.redTeam.contains(player.getName())) {
			if (event.getItemDrop().getItemStack().getType() == Material.SLIME_BALL){
				GameObjects.ball = event.getItemDrop();
			}
		}
	}
}