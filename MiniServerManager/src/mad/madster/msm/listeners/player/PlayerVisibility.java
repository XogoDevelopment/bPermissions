package mad.madster.msm.listeners.player;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerVisibility {
	
	public static void itemOnClick(Player player) {
		
		//Firework Charge
		ItemStack Rock = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = Rock.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Space Rock" + ChatColor.WHITE.toString().toString() + ChatColor.ITALIC + " of " +
		ChatColor.DARK_GREEN + "Player Visibility");
		
		ArrayList<String> description = new ArrayList<String>();
		description.add("toggle player visibility on or off");
		
		meta.setLore(description);
		Rock.setItemMeta(meta);
		
		//Clay
		ItemStack Clay = new ItemStack(Material.CLAY_BALL);
		ItemMeta meta1 = Clay.getItemMeta();
		
		meta1.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Space Rock" + ChatColor.WHITE.toString() + ChatColor.ITALIC + " of " +
		ChatColor.DARK_GREEN + "Player Visibility");
		
		ArrayList<String> description1 = new ArrayList<String>();
		
		description1.add("Toggle on or off");
		
		meta1.setLore(description);
		Clay.setItemMeta(meta1);
		
		
		
		if(player.getInventory().getItemInHand().getType() == Material.CLAY_BALL) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 1));
			
			player.sendMessage(ChatColor.GREEN + "You hold the rock in your hand and the world around you starts to change....");
			player.sendMessage(ChatColor.GRAY + "You have toggled player visibility, right click again to toggle off.");
			
			player.getInventory().remove(Material.CLAY_BALL);
			for(Player oplayers : Bukkit.getOnlinePlayers()) {
				player.hidePlayer(oplayers);
			}
			player.getInventory().setItem(1, Rock);
		} else if(player.getInventory().getItemInHand().getType() == Material.FIREWORK_CHARGE) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 1));
			
			player.sendMessage(ChatColor.GREEN + "You hold the rock in your hand and the world around you starts to change....");
			player.sendMessage(ChatColor.GRAY + "You have toggled player visibility, right click again to toggle on.");
			
			player.getInventory().remove(Material.FIREWORK_CHARGE);
			for(Player oplayers : Bukkit.getOnlinePlayers()) {
				player.showPlayer(oplayers);
			}
			
			player.getInventory().setItem(1, Clay);
		}
		
	}

}
