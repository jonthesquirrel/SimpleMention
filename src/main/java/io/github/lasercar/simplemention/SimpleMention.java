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
    }

    //events

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        if (message.contains("@")) {
            Player player = event.getPlayer();
            Collection onlinePlayers = Bukkit.getOnlinePlayers();

            Pattern pattern = Pattern.compile("(@\\w+)");
            //make this^ looser and move checking to later if adding @/group formats
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
                getLogger().info(matcher.group(1));
            }

            //for @ matches, replace and ping

//            event.setMessage(modifiedMessage);
        }
    }

}
