package mad.madster.msm;

import mad.madster.msm.listeners.InvFunctions;
import mad.madster.msm.listeners.PlayerChanges;
import mad.madster.msm.listeners.PlayerJoinLeave;
import mad.madster.msm.listeners.PlayerVisibility;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		
		
		
		
		getServer().getPluginManager().registerEvents(new PlayerJoinLeave(this), this);
		getServer().getPluginManager().registerEvents(new PlayerChanges(this), this);
		getServer().getPluginManager().registerEvents(new InvFunctions(this), this);
		//getServer().getPluginManager().registerEvents(new ServerSelector(this), this);
		

		
	}
	
	
	
	public void onDisable() {
		
	}

}
