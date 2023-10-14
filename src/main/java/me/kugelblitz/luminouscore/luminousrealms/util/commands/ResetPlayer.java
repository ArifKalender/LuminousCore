package me.kugelblitz.luminouscore.luminousrealms.util.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ResetPlayer implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("luminouscore.resetplayer")) {
                if (args.length > 0) {
                    if (Bukkit.getPlayer(args[0]).isOnline()) {
                        player.setAbsorptionAmount(0);
                    }
                } else {
                    player.setAbsorptionAmount(0);
                }
            } else {
                player.sendMessage("§cYou don't have enough permission to use this command.");
            }
        }

        return false;
    }
}
