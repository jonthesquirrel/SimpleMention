package io.github.lasercar.simplemention;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Listeners implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        if (MessageParser.hasMentions(message)) {
            String modifiedString = message;

            org.bukkit.Bukkit.broadcastMessage("@ detected");

            Pattern pattern = Pattern.compile("@(\\w+)");
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
                String mention = matcher.group(1);

                org.bukkit.Bukkit.broadcastMessage("mention found: " + mention);

                Player[] playersMatched = PlayerMatcher.findAllByName(mention);

                if (playersMatched.length > 0) {
                    modifiedString = MessageParser.highlightMention(mention);
                    SoundManager.pingPlayers(playersMatched);
                    org.bukkit.Bukkit.broadcastMessage("players matched: " + playersMatched.toString());
                }
            }

            event.setMessage(modifiedString);
        }
    }

}
