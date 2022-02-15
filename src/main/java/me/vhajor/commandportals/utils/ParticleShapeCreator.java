package me.vhajor.commandportals.utils;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;

public class ParticleShapeCreator {

    public static void createOval(Location location, int radius, int particleAmount) {

        for (int d = 0; d < particleAmount; d += 1) {

            Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
            particleLoc.setX(location.getX() + Math.cos(d) * radius / 2);
            particleLoc.setY(location.getY() + Math.sin(d) * radius);
            location.getWorld().spawnParticle(Particle.REDSTONE, particleLoc, 1, new Particle.DustOptions(Color.PURPLE, 2));

        }

    }

}
