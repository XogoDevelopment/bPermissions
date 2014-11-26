package mad.madster.msm.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Pets {
	
	public static void itemOnClick(Player player) {
		
		ItemStack Bone = new ItemStack(Material.BONE);
		ItemMeta meta = Bone.getItemMeta();
		
		if(player.getInventory().getItemInHand().getType() == Material.BONE || player.hasPermission("msm.pets")) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 40, 1));
			
			player.sendMessage(ChatColor.GRAY + "You have summoned a pet!");
			
			player.getInventory().remove(Material.BONE);
			
			
		}
		
	}

}
