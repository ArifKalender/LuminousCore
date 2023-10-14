package me.kugelblitz.luminouscore.luminousrealms.util.commands;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetEventLocation implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("kugeltials.admin.seteventlocation")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("twilightresonance")) {
                        LuminousCore.plugin.getConfig().set("Events.TwilightResonance.location", player.getLocation());
                        LuminousCore.plugin.saveConfig();
                        player.sendMessage("§aLocation of §5Twilight Resonance§a has been set. Make sure to use /reloadlumina.");
                    } else if (args[0].equalsIgnoreCase("silentshaman")) {
                        LuminousCore.plugin.getConfig().set("Events.SilentShaman.location", player.getLocation());
                        player.sendMessage("§aLocation of §2Silent Shaman§a has been set. Make sure to use /reloadlumina.");
                        LuminousCore.plugin.saveConfig();
                    } else {
                        player.sendMessage("§cIncorrect arguement. Correct usage: /seteventlocation <silentshaman | twilightresonance>");
                    }
                } else {
                    player.sendMessage("§cIncorrect arguement. Correct usage: /seteventlocation <silentshaman | twilightresonance>");
                }
            } else {
                player.sendMessage("§cYou don't have enough permissions to use this command.");
            }
        } else {
            sender.sendMessage("§cThis command can only be executed by players.");
        }

        return false;
    }
}
