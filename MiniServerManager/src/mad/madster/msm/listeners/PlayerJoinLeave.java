package mad.madster.msm.listeners;

import mad.madster.msm.Main;

import org.bukkit.ChatColor;
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
	public void playerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
			
			event.setJoinMessage(null);
			
			if(player.hasPermission("msm.joinbypass")) {
				player.getInventory().clear();
				itemAdd.addItem(player, Material.MAGMA_CREAM, ChatColor.GOLD.toString()  + ChatColor.BOLD + "Game Selector", 
						ChatColor.GRAY + "Navigate through the Minigames list", 0);
			}
	}
}
