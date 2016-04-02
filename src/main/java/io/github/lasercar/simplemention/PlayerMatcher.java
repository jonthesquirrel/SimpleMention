package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.stream.Collectors;

public class PlayerMatcher {

    public static Collection<Player> findAllByName(String name) {
        String strLowercase = name.toLowerCase();
        Collection players = Bukkit.getOnlinePlayers();
        return players.stream().filter(
                p -> p.getPlayerListName().toLowerCase().contains(strLowercase)
                        || p.getDisplayName().contains(strLowercase)
        ).collect(Collectors.toList());
        //TODO: return only one player if name matches exactly either username or displayname
    }

}
