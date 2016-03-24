package io.github.lasercar.simplemention;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleMention extends JavaPlugin implements Listener {

    //init

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    //events

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (message.contains("@")) {
            //event.setMessage();
            getLogger().info("mention found");
        } else {
            getLogger().info("mention not found");
        }
    }

}
