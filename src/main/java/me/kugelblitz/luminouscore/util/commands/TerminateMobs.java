package me.kugelblitz.luminouscore.util.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class TerminateMobs implements CommandExecutor {

    int i = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            if (sender.hasPermission("luminouscore.terminatemobs")) {
                terminateMobs(sender);
            } else {
                sender.sendMessage("§cYou dont have enough permissions to execute this command.");
            }
        } else {
            terminateMobs(sender);
        }

        return false;
    }

    public void terminateMobs(CommandSender sender) {
        for (World world : Bukkit.getWorlds()) {
            for (LivingEntity entity : world.getLivingEntities()) {
                if (entity.getCustomName() != null && !entity.getCustomName().isEmpty()) {
                    i++;
                    entity.remove();
                }
            }
        }
        sender.sendMessage("§a" + i + " mobs have been terminated.");
        i = 0;

    }
}
