package me.vhajor.commandportals.utils;

import me.vhajor.commandportals.CommandPortals;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PortalCreator {

    public static void createPortal(Player player, Location location, Location destination) {

        Plugin plugin = CommandPortals.plugin;

        for (int i = 0; i < 20; i++)
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> ParticleShapeCreator.createOval(location, 1, 32), 10L * i);
        ArmorStand armorStand = ArmorStandCreator.createArmorStand(player.getUniqueId(), location, destination);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, armorStand::remove, 200L);

    }

}
