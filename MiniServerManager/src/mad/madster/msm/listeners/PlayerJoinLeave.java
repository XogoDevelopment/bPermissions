package mad.madster.msm.listeners;

import mad.madster.msm.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinLeave implements Listener {
	Main plugin;
	
	public PlayerJoinLeave(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	  public void pJoin(PlayerJoinEvent event) {
		  Player player = event.getPlayer();
		  
		  
		  event.setJoinMessage(null);
		  
		  if(player.hasPermission("craftarc.joinbypass")){
			  player.getInventory().clear();
			  itemAdd.addItem(player, Material.MAGMA_CREAM, ChatColor.GOLD.toString() + ChatColor.BOLD + "Magical Teleportation Thingy",
					  ChatColor.GREEN + "Right click this item to naviagte through minigames", 0);
			  
			  itemAdd.addItem(player, Material.CLAY_BALL, ChatColor.AQUA.toString() + ChatColor.BOLD + "Space Rock" +
					  ChatColor.WHITE.toString() + ChatColor.ITALIC +" of " + ChatColor.GREEN + "Player Visibility",
		      ChatColor.GREEN + "Right click this to toggle player invisibility!", 1);
		      
			  
			  itemAdd.addItem(player, Material.CHEST, ChatColor.RED.toString() +  ChatColor.BOLD + "Shop " + ChatColor.DARK_RED + "Teleporter",
					  ChatColor.GREEN + "Teleport to the player shop with this item", 6);
			  itemAdd.addItem(player, Material.BONE, ChatColor.AQUA + "Summoners Bone", ChatColor.GREEN + "Right click to summon a pet!", 8);
		  
		  } else {
			  player.setGameMode(GameMode.ADVENTURE);
			  player.setFlying(false);
			  player.getInventory().clear();
			  itemAdd.addItem(player, Material.MAGMA_CREAM, ChatColor.GOLD.toString() + ChatColor.BOLD + "Magical Teleportation Thingy",
					  ChatColor.GREEN + "Right click this item to naviagte through minigames", 1);
			  
			  itemAdd.addItem(player, Material.CLAY_BALL, ChatColor.AQUA.toString() + ChatColor.BOLD + "Space Rock" +
					  ChatColor.WHITE.toString() + ChatColor.ITALIC +" of " + ChatColor.GREEN + "Player Visibility",
		      ChatColor.GREEN + "Right click this to toggle player invisibility!", 1);
		      
			  
			  itemAdd.addItem(player, Material.CHEST, ChatColor.RED.toString() +  ChatColor.BOLD + "Shop " + ChatColor.DARK_RED + "Teleporter",
					  ChatColor.GREEN + "Teleport to the player shop with this item", 6);
			  
			  itemAdd.addItem(player, Material.BONE, ChatColor.AQUA + "Summoners Bone", ChatColor.GREEN 
					  + "Right click to summon a pet!", 8);
			  
			  
		  }
	  }
}
