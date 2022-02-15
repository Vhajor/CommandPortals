package me.vhajor.commandportals.utils;

import me.vhajor.commandportals.CommandPortals;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.UUID;

public class WhitelistManager {

    private static final Plugin plugin = CommandPortals.plugin;

    public static ArrayList<String> getWhitelist(UUID uuid) {

        Configuration configuration = CommandPortals.configuration;

        return (ArrayList<String>) configuration.getStringList("whitelists." + uuid);
    }

    public static void addWhitelist(UUID uuid, OfflinePlayer offlinePlayer) {

        Configuration configuration = CommandPortals.configuration;

        String stringUUID = offlinePlayer.getUniqueId().toString();

        ArrayList<String> uuids = getWhitelist(uuid);

        if (!(uuids.contains(stringUUID)))
            uuids.add(stringUUID);

        configuration.set("whitelists." + uuid, uuids);

        plugin.saveConfig();

    }

    public static void removeWhitelist(UUID uuid, OfflinePlayer offlinePlayer) {

        Configuration configuration = CommandPortals.configuration;

        String stringUUID = offlinePlayer.getUniqueId().toString();

        ArrayList<String> uuids = getWhitelist(uuid);

        uuids.remove(stringUUID);

        configuration.set("whitelists." + uuid, uuids);

        plugin.saveConfig();

    }

}
