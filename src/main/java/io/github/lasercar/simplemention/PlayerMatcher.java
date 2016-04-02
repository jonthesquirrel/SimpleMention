package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerMatcher {

    public static final List<Player> findExact(String name) {
        String strLowercase = name.toLowerCase();
        return Bukkit.getOnlinePlayers().stream().filter(
                p -> p.getPlayerListName().toLowerCase().equals(strLowercase)
                        || p.getDisplayName().toLowerCase().equals(strLowercase)
        ).collect(Collectors.toList());
    }

    public static final List<Player> findPartial(String name) {
        String strLowercase = name.toLowerCase();
        return Bukkit.getOnlinePlayers().stream().filter(
                p -> p.getPlayerListName().toLowerCase().contains(strLowercase)
                        || p.getDisplayName().contains(strLowercase)
        ).collect(Collectors.toList());
    }

}
