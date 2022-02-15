package me.vhajor.commandportals;

import me.vhajor.commandportals.commands.CommandManager;
import me.vhajor.commandportals.events.EntityDamageByEntityListener;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandPortals extends JavaPlugin {

    public static Plugin plugin;
    public static Configuration configuration;

    @Override
    public void onEnable() {

        plugin = this;
        configuration = getConfig();

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);

        PluginCommand portal = Bukkit.getPluginCommand("portal");
        assert portal != null;
        portal.setExecutor(new CommandManager());

    }

    @Override
    public void onDisable() {

        for (World world : Bukkit.getWorlds())
            for (Entity entity : world.getEntities())
                if (entity.getCustomName() != null)
                    if (entity.getCustomName().split(":")[0].equals("portal"))
                        entity.remove();

    }

}
