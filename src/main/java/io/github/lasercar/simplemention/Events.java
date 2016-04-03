package io.github.lasercar.simplemention;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

import java.util.Set;
import java.util.TreeSet;
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

                Player[] playersMatched = PlayerMatcher.findAllByPartialName(mention);

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
        if (event.getLastToken().charAt(0) == '@') {

            Set<String> names = new TreeSet<>();
            String toComplete = event.getLastToken().substring(1);

            for (Player player : PlayerMatcher.findAllByPartialName(toComplete)) {
                names.add("@" + player.getPlayerListName());
                names.add("@" + MessageParser.removeFormatting(player.getDisplayName()));
            }

            names.removeIf(name -> !name.toLowerCase().contains(toComplete.toLowerCase()));

            event.getTabCompletions().clear();
            event.getTabCompletions().addAll(names);
        }
    }

}
