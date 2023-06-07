package me.kugelblitz.luminouscore.util.commands;

import me.kugelblitz.luminouscore.mechanics.religionmanager.CrystalLexicon;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenLexicon implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("luminouscore.openlexicon")) {
                new CrystalLexicon().openLexicon(player);
            } else {
                player.sendMessage("You don't have enough permissions to execute this command.");
            }

        } else {
            sender.sendMessage("§cThis command can only be executed by players.");
        }

        return false;
    }
}


