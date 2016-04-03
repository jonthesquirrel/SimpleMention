package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Listeners implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        if (MessageParser.hasMentions(message)) {

            Pattern pattern = Pattern.compile("@(\\w+)");
            Matcher matcher = pattern.matcher(message);
            StringBuffer messageBuffer = new StringBuffer();

            while (matcher.find()) {
                String mention = matcher.group(1);

                Player[] playersMatched = PlayerMatcher.findAllByName(mention);

                if (playersMatched.length > 0) {
                    //TODO
                    matcher.appendReplacement(messageBuffer, MessageParser.highlightMention(mention));

                    SoundManager.pingPlayers(playersMatched);

                    //DEBUG
                    Bukkit.broadcastMessage("players matched: " + playersMatched.toString());
                }
            }
            matcher.appendTail(messageBuffer);

            event.setMessage(messageBuffer.toString());
        }
    }

}
