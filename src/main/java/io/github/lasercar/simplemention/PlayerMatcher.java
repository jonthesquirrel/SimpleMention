package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PlayerMatcher {

    public static Player[] findAllByName(String name) {
        String strLowercase = name.toLowerCase();

        for (Player player : Bukkit.getOnlinePlayers()) {
            Bukkit.broadcastMessage("player username: " + player.getPlayerListName());
            Bukkit.broadcastMessage("player displayname scrubbed: " + player.getDisplayName());
        }

        return Bukkit.getOnlinePlayers().stream().filter(
                player -> player.getPlayerListName().toLowerCase().contains(strLowercase)
                        || player.getDisplayName().replaceAll("§\\w", "").contains(strLowercase)
        ).toArray(Player[]::new);

        //TODO: return only one player if name matches exactly either username or displayname
    }

}
