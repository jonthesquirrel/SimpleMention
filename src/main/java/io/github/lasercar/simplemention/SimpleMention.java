package io.github.lasercar.simplemention;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleMention extends JavaPlugin implements Listener {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

}
