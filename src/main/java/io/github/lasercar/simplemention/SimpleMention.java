package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SimpleMention extends JavaPlugin implements Listener {

    //init

    String formatMention;
    String formatDefault;

    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        formatMention = getConfig().getString("format-mention");
        formatDefault = getConfig().getString("format-default");

        getServer().getPluginManager().registerEvents(this, this);
    }

    //events

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        StringBuffer messageBuffer = new StringBuffer();

        if (message.contains("@")) {
            Player player = event.getPlayer();
            Collection players = Bukkit.getOnlinePlayers();

            Pattern pattern = Pattern.compile("@(\\w+)");
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
                String match = matcher.group(1);

                Collection found = players.stream().filter(p -> p.getPlayerListName().contains(match) || p.getDisplayName().contains(match));

                //TODO: partial matching of display name and username
                //TODO: only highlight mentions if found (prefix formatMention and suffix formatDefault)

                //TODO: ping matched players with sound
            }

//            event.setMessage(messageBuffer.toString());
        }
    }

}
