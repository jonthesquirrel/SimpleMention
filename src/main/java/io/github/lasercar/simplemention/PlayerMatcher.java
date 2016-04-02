package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;

import java.util.stream.Stream;

public class PlayerMatcher {

    public static Stream getMatches(String name) {
        String strLowercase = name.toLowerCase();
        return Bukkit.getOnlinePlayers().stream().filter(
                p -> p.getPlayerListName().toLowerCase().contains(strLowercase)
                        || p.getDisplayName().contains(strLowercase)
        );
        //TODO: return only the exact matched player if name matches exactly either username or displayname
    }

}
