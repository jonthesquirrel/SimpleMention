package io.github.lasercar.simplemention;

import org.bukkit.ChatColor;

public class MessageParser {

    //TODO: config class?
//    String formatMention = ChatColor.translateAlternateColorCodes('&', config.getString("format-mention"));
//    String formatDefault = ChatColor.translateAlternateColorCodes('&', config.getString("format-default"));
    //TEMP: hardcode
    static String formatMention = ChatColor.translateAlternateColorCodes('&', "&e");
    static String formatDefault = ChatColor.translateAlternateColorCodes('&', "&7");

    public static boolean hasMentions(String message) {
        return message.contains("@");
    }

//    public Collection findMentions(String message) {
//        Pattern pattern = Pattern.compile("@(\\w+)");
//        Matcher matcher = pattern.matcher(message);
//
//        return
//    }

    public static String highlightMention(String mention) {
        return formatMention + mention + formatDefault;
    }

}
