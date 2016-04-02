package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;

import java.util.stream.Stream;

public class PlayerMatcher {

    public static Stream findExact(String name) {
        String strLowercase = name.toLowerCase();
        return Bukkit.getOnlinePlayers().stream().filter(
                p -> p.getPlayerListName().toLowerCase().equals(strLowercase)
                        || p.getDisplayName().toLowerCase().equals(strLowercase)
        );
    }

    public static Stream findPartial(String name) {
        String strLowercase = name.toLowerCase();
        return Bukkit.getOnlinePlayers().stream().filter(
                p -> p.getPlayerListName().toLowerCase().contains(strLowercase)
                        || p.getDisplayName().contains(strLowercase)
        );
    }

}
