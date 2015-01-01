package de.bananaco.bpermissions.imp;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import de.bananaco.bpermissions.api.WorldManager;
import de.bananaco.permissions.interfaces.PromotionTrack;

public class Config {

    private final File file = new File("plugins/bPermissions/config.yml");
    private YamlConfiguration config = new YamlConfiguration();
    private String trackType = "multi";
    private PromotionTrack track = null;
    private boolean useGlobalFiles = false;
    private boolean autoSave = true;
    private boolean offlineMode = false;
    private boolean trackLimit = false;
    private boolean globalPlayerFiles = false;
    private boolean autoSort = true;
    private boolean newCommands = true;

    public void load() {
        try {
            loadUnsafe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadUnsafe() throws Exception {
        // Your standard create if not exist shizzledizzle
        if (!file.exists()) {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        config.load(file);
        // set the value to default
        config.set("auto-save", config.get("auto-save", autoSave));
        config.set("auto-sort", config.get("auto-sort", autoSort));
        config.set("new-commands", config.get("new-commands", newCommands));
        config.set("track-type", config.get("track-type", trackType));
        // set the debugger value to default
        config.set("debug-mode", Debugger.setDebug(config.getBoolean("debug-mode", Debugger.getDebug())));
        config.set("allow-offline-mode", config.get("allow-offline-mode", offlineMode));
        config.set("use-global-files", config.get("use-global-files", useGlobalFiles));
        config.set("global-player-files", config.get("global-player-files", globalPlayerFiles));
        config.set("track-limit", config.get("track-limit", trackLimit));
        // then load it into memory
        useGlobalFiles = config.getBoolean("use-global-files");
        newCommands = config.getBoolean("new-commands");
        autoSave = config.getBoolean("auto-save");
        trackType = config.getString("track-type");
        offlineMode = config.getBoolean("allow-offline-mode");
        trackLimit = config.getBoolean("track-limit");
        globalPlayerFiles = config.getBoolean("global-user-files");
        autoSort = config.getBoolean("auto-sort");
        // then load our PromotionTrack
        if (trackType.equalsIgnoreCase("multi")) {
            track = new MultiGroupPromotion();
        } else if (trackType.equalsIgnoreCase("lump")) {
            track = new LumpGroupPromotion();
        } else {
            track = new SingleGroupPromotion();
        }
        // Then set the worldmanager
        WorldManager.getInstance().setAutoSave(autoSave);
        // Load the track
        track.load();
        // finally save the config
        config.save(file);
    }

    public boolean trackLimit() {
        return trackLimit;
    }

    public boolean getUseGlobalFiles() {
        return useGlobalFiles;
    }

    public PromotionTrack getPromotionTrack() {
        return track;
    }

    public boolean getAllowOfflineMode() {
        return offlineMode;
    }

    public boolean getUseGlobalUsers() {
        return globalPlayerFiles;
    }

    public boolean getAutoSort() {
        return autoSort;
    }

    public boolean newCommands() {
        return newCommands;
    }
}
