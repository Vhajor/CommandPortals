package me.vhajor.commandportals.commands;

import me.vhajor.commandportals.utils.PortalCreator;
import me.vhajor.commandportals.utils.WhitelistManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;

        if (args.length > 0)
            switch (args[0]) {

                case "create":
                    if (args.length > 3) {

                        World world = player.getWorld();

                        Location location = new Location(world, player.getLocation().getX(), player.getLocation().getY() + 1, player.getLocation().getZ());
                        Location destination = new Location(player.getWorld(), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));

                        PortalCreator.createPortal(player, location, destination);

                    } else
                        player.sendMessage(ChatColor.RED + "Invalid number of args.");
                    break;

                case "whitelist":
                    if (args.length > 1)
                        switch (args[1]) {

                            case "add":
                                if (args.length > 2 && Bukkit.getOfflinePlayer(args[2]).hasPlayedBefore())
                                    WhitelistManager.addWhitelist(player.getUniqueId(), Bukkit.getOfflinePlayer(args[2]));
                                else
                                    player.sendMessage(ChatColor.RED + "Invalid number of args.");
                                break;

                            case "remove":
                                if (args.length > 2 && Bukkit.getOfflinePlayer(args[2]).hasPlayedBefore())
                                    WhitelistManager.removeWhitelist(player.getUniqueId(), Bukkit.getOfflinePlayer(args[2]));
                                else
                                    player.sendMessage(ChatColor.RED + "Invalid number of args.");
                                break;

                        }
                    else
                        player.sendMessage(ChatColor.RED + "Invalid number of args.");
                    break;

            }
        else
            player.sendMessage(ChatColor.RED + "Invalid number of args.");

        return false;
    }

}
