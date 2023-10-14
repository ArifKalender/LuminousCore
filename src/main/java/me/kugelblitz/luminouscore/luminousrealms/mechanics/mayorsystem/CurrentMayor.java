package me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CurrentMayor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (MayorHandler.mayor.equals("daithi")) {
            sender.sendMessage("§b§m                                                                                         ");
            sender.sendMessage("");
            sender.sendMessage("§aCurrent president is §eDaithi§r§a.");
            sender.sendMessage("§aAdvantages of §eDaithi§a:");
            sender.sendMessage("§dSugar Rush: §e40% chance of extra item drop from monsters");
            sender.sendMessage("§dGentle breeze: §e20% chance every minute to have a 60s regeneration effect");
            sender.sendMessage("§dGenerous: §eSmall raffles every hour.");
            sender.sendMessage("");
            sender.sendMessage("§b§m                                                                                          ");

        } else if (MayorHandler.mayor.equals("fiona")) {
            sender.sendMessage("§b§m                                                                                          ");
            sender.sendMessage("");
            sender.sendMessage("§aCurrent president is §2Fiona§a.");
            sender.sendMessage("§aAdvantages of §2Fiona§a:");
            sender.sendMessage("§dCalcium: §22x crop growth speed");
            sender.sendMessage("§dFertile: §240% chance of extra item drop from crops");
            sender.sendMessage("§dImpressive: §21% chance of dropping §3Gorbet§2 from crops");
            sender.sendMessage("");
            sender.sendMessage("§b§m                                                                                          ");
        } else if (MayorHandler.mayor.equals("morag")) {
            sender.sendMessage("§b§m                                                                                          ");
            sender.sendMessage("");
            sender.sendMessage("§aCurrent president is §cMorag§a.");
            sender.sendMessage("§aAdvantages of §cMorag§a:");
            sender.sendMessage("§dSlay girllll: §cMassacre bosses take 2x damage");
            sender.sendMessage("§dEvil eye: §cMassacre bosses have a low chance of dropping rare items");
            sender.sendMessage("§dMorag's Curse: §cYour hits have a 5% chance of stunning the boss for 5 seconds");
            sender.sendMessage("");
            sender.sendMessage("§b§m                                                                                          ");

        } else if (MayorHandler.mayor.equals("muirgen")) {
            sender.sendMessage("§b§m                                                                                          ");
            sender.sendMessage("");
            sender.sendMessage("§aCurrent president is §3Muirgen§r§a.");
            sender.sendMessage("§aAdvantages of §3Muirgen§a:");
            sender.sendMessage("§dTreasure Hunter: §3Chance to earn money while fishing");
            sender.sendMessage("§dRare Eye: §3Chance to obtain special items while fishing");
            sender.sendMessage("§dLoch Ness: §3Summon rare creatures from the sea");
            sender.sendMessage("");
            sender.sendMessage("§b§m                                                                                          ");

        } else if (MayorHandler.mayor.equals("sean")) {

            sender.sendMessage("§b§m                                                                                          ");
            sender.sendMessage("");
            sender.sendMessage("§aCurrent president is §7Sean§a.");
            sender.sendMessage("§aAdvantages of §7Sean§a:");
            sender.sendMessage("§dPure: §bIncreased chance of dropping §7Lumina Coin§b.");
            sender.sendMessage("§dWealth: §740% chance of extra item drop from specific ores");
            sender.sendMessage("§dInvulnerability: §7Regeneration effect while below Y32 coordinates");
            sender.sendMessage("");
            sender.sendMessage("§b§m                                                                                          ");


        } else {
            //komut girildiğnde bi problem olduğunu soylicek ve bana soylenmesi gerketiği söylenilcek
        }
        return false;

    }
}
