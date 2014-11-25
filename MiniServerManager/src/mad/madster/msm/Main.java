package mad.madster.msm;

import mad.madster.msm.listeners.PlayerChanges;
import mad.madster.msm.listeners.PlayerJoinLeave;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		
		
		
		
		getServer().getPluginManager().registerEvents(new PlayerJoinLeave(this), this);
		getServer().getPluginManager().registerEvents(new PlayerChanges(this), this);
		
		
	}
	
	
	
	public void onDisable() {
		
	}

}
