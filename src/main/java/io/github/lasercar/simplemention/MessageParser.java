package io.github.lasercar.simplemention;

import org.bukkit.ChatColor;

public class MessageParser {

    //TODO: config class?
//    String formatHandle = ChatColor.translateAlternateColorCodes('&', config.getString("format-handle"));
//    String formatMention = ChatColor.translateAlternateColorCodes('&', config.getString("format-mention"));
//    String formatReset = ChatColor.translateAlternateColorCodes('&', config.getString("format-reset"));
    //TEMP: hardcode
    static String formatHandle = ChatColor.translateAlternateColorCodes('&', "&e");
    static String formatMention = ChatColor.translateAlternateColorCodes('&', "&l");
    static String formatReset = ChatColor.translateAlternateColorCodes('&', "&7");

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
        return formatHandle + "@" + formatMention + mention + formatReset;
    }

}
