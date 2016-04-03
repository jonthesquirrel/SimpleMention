package io.github.lasercar.simplemention;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleMention extends JavaPlugin {

    public static FileConfiguration config;

    public void onEnable() {
        config = getConfig();

        saveDefaultConfig();
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

}
