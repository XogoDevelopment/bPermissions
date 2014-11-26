package mad.madster.msm.listeners;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import mad.madster.msm.Main;
import mad.madster.msm.listeners.player.PlayerVisibility;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InvFunctions implements Listener {
	
	Main plugin;
	
	public InvFunctions(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
			
			  if(player.getItemInHand().getType() == Material.CLAY_BALL){
	    	PlayerVisibility.itemOnClick(player);
	    } else if(player.getItemInHand().getType() == Material.FIREWORK_CHARGE){
	    	PlayerVisibility.itemOnClick(player);
	    } else if(player.getItemInHand().getType() == Material.MAGMA_CREAM){
	    	sendToServer(player, "games");
	    	player.sendMessage("TEST MESSAGE");
	    } 	
		} 
	}
	
	
	
	/** Bungee
	 * 
	 */
	public void sendToServer(Player player, String targetServer) {
		ByteArrayOutputStream b= new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Connect");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}

	

}
