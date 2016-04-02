package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MessageParser {

    //TODO: config class?
//    String formatMention = config.getString("format-mention");
//    String formatDefault = config.getString("format-default");

    public static boolean hasMentions(String message) {
        return message.contains("@");
    }

//    public Collection findMentions(String message) {
//        Pattern pattern = Pattern.compile("@(\\w+)");
//        Matcher matcher = pattern.matcher(message);
//
//        return
//    }

//    public static StringBuffer highlight(String message) {
//
//    }

}
