package io.github.lasercar.simplemention;

import org.bukkit.plugin.java.JavaPlugin;

public class SimpleMention extends JavaPlugin {

    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

}
