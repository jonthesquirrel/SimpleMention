package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PlayerMatcher {

    public static Player[] findAllByName(String name) {
        return Bukkit.getOnlinePlayers().stream().filter(
                player -> player.getPlayerListName().toLowerCase().contains(name.toLowerCase())
                        || player.getDisplayName().toLowerCase().replaceAll("§\\w", "").contains(name.toLowerCase())
        ).toArray(Player[]::new);

        //TODO: return only one player if name matches exactly either username or displayname
    }

}
