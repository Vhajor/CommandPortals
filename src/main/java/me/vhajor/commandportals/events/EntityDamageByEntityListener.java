package me.vhajor.commandportals.events;

import me.vhajor.commandportals.utils.WhitelistManager;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.UUID;

public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

        Entity damager = event.getDamager();
        Entity damaged = event.getEntity();

        if (!(damager instanceof Player)) return;
        if (damaged.getType() != EntityType.ARMOR_STAND) return;

        Player player = (Player) damager;
        ArmorStand armorStand = (ArmorStand) damaged;
        String name = armorStand.getName();

        String[] cords = name.split(":")[1].split("_");

        UUID uuid = UUID.fromString(name.split(":")[2]);

        if (WhitelistManager.getWhitelist(uuid).contains(player.getUniqueId().toString()))
            player.teleport(new Location(player.getWorld(), Double.parseDouble(cords[0]), Double.parseDouble(cords[1]), Double.parseDouble(cords[2])));

    }

}
