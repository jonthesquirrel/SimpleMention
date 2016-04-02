package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MessageParser {

    public static final boolean hasMatches(String message) {
        return message.contains("@");
    }

//    public Collection findMentions(String message) {
//        Pattern pattern = Pattern.compile("@(\\w+)");
//        Matcher matcher = pattern.matcher(message);
//
//        return
//    }

}
