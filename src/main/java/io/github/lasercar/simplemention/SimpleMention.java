package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleMention extends JavaPlugin implements Listener {

    //init

    String format_mention;
    String format_default;

    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        format_mention = getConfig().getString("format-mention");
        format_default = getConfig().getString("format-default");

        getServer().getPluginManager().registerEvents(this, this);

        getLogger().info("format-mention: " + format_mention);
        getLogger().info("format-default: " + format_default);
    }

    //events

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        if (message.contains("@")) {
            Player player = event.getPlayer();
            Collection onlinePlayers = Bukkit.getOnlinePlayers();

//            getLogger().info(message);

//            Pattern pattern = Pattern.compile("");
//            Matcher matcher = pattern.matcher(message);

//            while () {
//
//            }

            //for @ matches, replace and ping

//            event.setMessage(modifiedMessage);
        }
    }

}
