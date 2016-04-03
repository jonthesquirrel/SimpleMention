package io.github.lasercar.simplemention;

import org.bukkit.ChatColor;

public class MessageParser {

    static String formatHandle = ChatColor.translateAlternateColorCodes('&', SimpleMention.config.getString("format-handle"));
    static String formatMention = ChatColor.translateAlternateColorCodes('&', SimpleMention.config.getString("format-mention"));
    static String formatReset = ChatColor.translateAlternateColorCodes('&', SimpleMention.config.getString("format-reset"));

    public static boolean hasMentions(String message) {
        return message.contains("@");
    }

    public static String highlightMention(String mention) {
        return formatHandle + "@" + formatMention + mention + formatReset;
    }

}
