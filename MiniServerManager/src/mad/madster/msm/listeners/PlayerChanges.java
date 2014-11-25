package mad.madster.msm.listeners;

import mad.madster.msm.Main;

import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class PlayerChanges implements Listener {
	Main plugin;
	
	public PlayerChanges(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void itemPickip(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();
		if(!(player.hasPermission("msm.iteminteract"))) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler 
	public void itemDrop(PlayerDropItemEvent event) {
		Player player = event.getPlayer();
		if(!(player.hasPermission("msm.iteminteract"))) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void noDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if(entity instanceof Player) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void noFood(FoodLevelChangeEvent event) {
		Entity entity = event.getEntity();
		if(entity instanceof Player) {
			event.setFoodLevel(20);
		}
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(!(player.hasPermission("msm.breakblocks"))) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler 
	public void itemMove(InventoryClickEvent event) {
		HumanEntity he = event.getWhoClicked();
		if(!(he.hasPermission("msm.itemmove"))) {
			if(he instanceof Player) {
				InventoryType pe = InventoryType.PLAYER;
				if(he.getInventory().getType().equals(pe)) {
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void weatherChange(WeatherChangeEvent event) {
		event.setCancelled(true);
	}

}
