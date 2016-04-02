package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;

import java.util.Collection;
import java.util.stream.Collectors;

public class PlayerMatcher {

    public static final Collection findExactMatches(String str) {
        String input = str.toLowerCase();
        return Bukkit.getOnlinePlayers().stream().filter(
                p -> p.getPlayerListName().toLowerCase().equals(input)
                        || p.getDisplayName().toLowerCase().equals(input)
        ).collect(Collectors.toList());
    }

    public static final Collection findPartialMatches(String str) {
        String input = str.toLowerCase();
        return Bukkit.getOnlinePlayers().stream().filter(
                p -> p.getPlayerListName().toLowerCase().contains(input)
                        || p.getDisplayName().contains(input)
        ).collect(Collectors.toList());
    }

}
