package me.vhajor.commandportals.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import java.util.UUID;

public class ArmorStandCreator {

    public static ArmorStand createArmorStand(UUID uuid, Location location, Location destination) {

        World world = location.getWorld();
        assert world != null;

        ArmorStand armorStand = (ArmorStand) world.spawnEntity(new Location(world, location.getX(), location.getY() - 1, location.getZ() + 0.25), EntityType.ARMOR_STAND);

        armorStand.setCustomName("portal:" + destination.getX() + "_" + destination.getY() + "_" + destination.getZ() + ":" + uuid.toString());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setInvulnerable(true);
        armorStand.setCanPickupItems(false);

        return armorStand;
    }

}
