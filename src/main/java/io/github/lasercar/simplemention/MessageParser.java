package io.github.lasercar.simplemention;

import java.util.Collection;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void iterateMentions(Function lambda) {
        //TODO: separate class for this
        if (MessageParser.hasMentions(message)) {

            Pattern pattern = Pattern.compile("@(\\w+)");
            Matcher matcher = pattern.matcher(message);

            String mention = matcher.group(1);

            while (matcher.find()) {
                lambda();
            }
        }
    }

    public static StringBuffer highlightMention(String mention) {
        return formatMention + mention + formatDefault;
    }

}
