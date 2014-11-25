package mad.madster.msm.listeners;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class itemAdd {
	
	
	public static void addItem(Player player, Material Material, String ItemName, String Lore, int slot) {
		
		ItemStack item = new ItemStack(Material);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ItemName);
		
		ArrayList<String> description = new ArrayList<String>();
		
		description.add(Lore);
		meta.setLore(description);
		
		item.setItemMeta(meta);
		player.getInventory().setItem(slot, item);
		
	}
	

}
