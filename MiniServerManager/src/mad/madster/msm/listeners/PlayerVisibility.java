package mad.madster.msm.listeners;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
		
		meta1.setDisplayName(ChatColor.AQUA.toString() + "");
	}

}
