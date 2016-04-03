package io.github.lasercar.simplemention;

public class MessageParser {

    //TODO: config class?
//    String formatMention = config.getString("format-mention");
//    String formatDefault = config.getString("format-default");
    //TEMP: hardcode
    static String formatMention = "&e";
    static String formatDefault = "&7";

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
