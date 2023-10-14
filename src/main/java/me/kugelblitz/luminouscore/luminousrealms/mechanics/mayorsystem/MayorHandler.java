package me.kugelblitz.luminouscore.luminousrealms.mechanics.mayorsystem;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class MayorHandler implements CommandExecutor {
    public static String mayor;
    private final LuminousCore plugin;

    public MayorHandler(LuminousCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            sender.sendMessage("§4[Hata] §cBaşkan döngüsü yalnızca konsoldan çalıştırılabilir!");
        } else {
            Random random = new Random();
            double randomNumber = random.nextDouble();

            if (randomNumber < 0.2) {
                plugin.getConfig().set("mayor", "daithi");
                Bukkit.broadcastMessage("§b§m                                                                                         ");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§aSelected president: §e§lDAITHI§r§a!");
                Bukkit.broadcastMessage("§aAdvantages of §eDaithi§a:");
                Bukkit.broadcastMessage("§dSugar Rush: §e40% chance of extra item drop from monsters");
                Bukkit.broadcastMessage("§dGentle breeze: §e20% chance every minute to have a 60s regeneration effect");
                Bukkit.broadcastMessage("§dGenerous: §eSmall raffles every hour.");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§b§m                                                                                          ");
            } else if (randomNumber < 0.4) {
                plugin.getConfig().set("mayor", "fiona");
                Bukkit.broadcastMessage("§b§m                                                                                          ");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§aSelected president: §2§lFIONA§r§a!");
                Bukkit.broadcastMessage("§aAdvantages of §2Fiona§a:");
                Bukkit.broadcastMessage("§dCalcium: §22x crop growth speed");
                Bukkit.broadcastMessage("§dFertile: §240% chance of extra item drop from crops");
                Bukkit.broadcastMessage("§dImpressive: §21% chance of dropping §3Gorbet§2 from crops");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§b§m                                                                                          ");
            } else if (randomNumber < 0.6) {
                plugin.getConfig().set("mayor", "morag");
                Bukkit.broadcastMessage("§b§m                                                                                          ");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§aSelected president: §c§lMORAG§r§a!");
                Bukkit.broadcastMessage("§aAdvantages of §cMorag§a:");
                Bukkit.broadcastMessage("§dSlay girllll: §cMassacre bosses take 2x damage");
                Bukkit.broadcastMessage("§dEvil eye: §cMassacre bosses have a low chance of dropping rare items");
                Bukkit.broadcastMessage("§dMorag's Curse: §cYour hits have a 5% chance of stunning the boss for 5 seconds");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§b§m                                                                                          ");
            } else if (randomNumber < 0.8) {
                plugin.getConfig().set("mayor", "muirgen");
                Bukkit.broadcastMessage("§b§m                                                                                          ");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§aSelected president: §3§lMUIRGEN§r§a!");
                Bukkit.broadcastMessage("§aAdvantages of §3Muirgen§a:");
                Bukkit.broadcastMessage("§dTreasure Hunter: §3Chance to earn money while fishing");
                Bukkit.broadcastMessage("§dRare Eye: §3Chance to obtain special items while fishing");
                Bukkit.broadcastMessage("§dLoch Ness: §3Summon rare creatures from the sea");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§b§m                                                                                          ");

            } else {
                plugin.getConfig().set("mayor", "sean");
                Bukkit.broadcastMessage("§b§m                                                                                          ");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§aSelected president: §7§lSEAN§r§a!");
                Bukkit.broadcastMessage("§aAdvantages of §7Sean§a:");
                Bukkit.broadcastMessage("§dPure: §bIncreased chance of dropping §7Lumina Coin§b.");
                Bukkit.broadcastMessage("§dWealth: §740% chance of extra item drop from specific ores");
                Bukkit.broadcastMessage("§dInvulnerability: §7Regeneration effect while below Y32 coordinates");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§b§m                                                                                          ");

            }
            plugin.saveConfig();
            mayor = plugin.getConfig().getString("mayor");
        }

        return false;
    }
}
