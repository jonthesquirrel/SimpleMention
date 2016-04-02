package io.github.lasercar.simplemention;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SimpleMention extends JavaPlugin implements Listener {

    //init

    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(this, this);
    }

    //events

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        StringBuffer messageBuffer = new StringBuffer();

        if (MessageParser.hasMentions(message)) {

            Pattern pattern = Pattern.compile("@(\\w+)");
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
                String mention = matcher.group(1);

                Stream players = PlayerMatcher.getMatches(mention);

                if (players.Length > 0) {
                    messageBuffer = MessageParser.highlight(message);
                    SoundManager.pingPlayers(players);
                }

                //TODO: partial matching of display name and username

            }

            event.setMessage(messageBuffer.toString());
        }
    }

}
