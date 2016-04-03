package io.github.lasercar.simplemention;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Listeners implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        StringBuffer messageBuffer = new StringBuffer();

        MessageParser.iterateMentions(Function(String mention) {


            Collection players = PlayerMatcher.findAllByName(mention);

            if (players.length > 0) {
                messageBuffer = MessageParser.highlightMention(mention);
                SoundManager.pingPlayers(players);
            }

            //TODO: partial matching of display name and username
        });

        event.setMessage(messageBuffer.toString());
    }

}
