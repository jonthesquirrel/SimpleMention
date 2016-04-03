package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events implements Listener {

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
                    matcher.appendReplacement(messageBuffer, MessageParser.highlightMention(mention));

                    SoundManager.pingPlayers(playersMatched);
                }
            }
            matcher.appendTail(messageBuffer);

            event.setMessage(messageBuffer.toString());
        }
    }

    @EventHandler
    public void onTabComplete(PlayerChatTabCompleteEvent event) {
//        if (event.getLastToken().equals("@")) {
//            event.getTabCompletions().push(Bukkit.getOnlinePlayers());
//        }

        //DEBUG
        Bukkit.getLogger().info(event.getTabCompletions().toString());
        event.getTabCompletions().clear();
        Bukkit.getLogger().info(event.getTabCompletions().toString());
    }

}
