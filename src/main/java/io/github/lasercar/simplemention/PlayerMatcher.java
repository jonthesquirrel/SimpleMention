package io.github.lasercar.simplemention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerMatcher {

    public static Player[] findAllByPartialName(String name) {
        return Bukkit.getOnlinePlayers().stream().filter(
                player -> player.getPlayerListName().toLowerCase().contains(name.toLowerCase())
                        || MessageParser.removeFormatting(player.getDisplayName().toLowerCase()).contains(name.toLowerCase())
        ).toArray(Player[]::new);

        //TODO: return only one player if name matches exactly either username or displayname
    }

}
