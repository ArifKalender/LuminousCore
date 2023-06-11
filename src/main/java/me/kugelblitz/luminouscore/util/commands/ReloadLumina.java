package me.kugelblitz.luminouscore.util.commands;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.util.PlayerStats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadLumina implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.isOp()) {
                sender.sendMessage("§aReloading PlayerStats.yml!");
                sender.sendMessage("§aReloading config.yml!");
                PlayerStats.reloadStats();
                LuminousCore.plugin.reloadConfig();
            }
        } else {

        }

        return false;
    }
}
