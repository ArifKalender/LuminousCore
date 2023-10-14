package me.kugelblitz.luminouscore.luminousrealms.util.commands;

import me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem.mayors.FionaMayorF;
import me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem.mayors.MoragMayorF;
import me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem.mayors.MuirgenMayorF;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class AdminItem implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            if (sender.isOp()) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("corruptedheart")) {
                        MoragMayorF.dropCorruptedHeart((Entity) sender, (Player) sender);
                    } else if (args[0].equalsIgnoreCase("smite")) {
                        MoragMayorF.dropSmite((Player) sender, (Player) sender);
                    } else if (args[0].equalsIgnoreCase("totemofjustice")) {
                        MoragMayorF.dropTotemOfJustice((Entity) sender, (Player) sender);
                    } else if (args[0].equalsIgnoreCase("rodoftheancient")) {
                        MuirgenMayorF.dropAncientRod(((Player) sender).getPlayer());
                    } else if (args[0].equalsIgnoreCase("luckshard")) {
                        MuirgenMayorF.dropLuckShard((Player) sender);
                    } else if (args[0].equalsIgnoreCase("kraken")) {
                        MuirgenMayorF.spawnKraken((Player) sender);
                    } else if (args[0].equalsIgnoreCase("gorbet")) {
                        FionaMayorF.dropGorbet((Player) sender);
                    } else {
                        sender.sendMessage("§cThe first arguement has to be <corruptedheart|smite|totemofjustice|rodoftheancient|luckshard|kraken|gorbet>");
                    }
                } else {
                    sender.sendMessage("§cYou need to have an arguement to execute this command.");
                }
            } else {
                sender.sendMessage("§cYou need to be an admin to execute this command.");
            }
        } else {
            sender.sendMessage("§cThis command can only be executed by a player.");
        }

        return false;
    }
}
