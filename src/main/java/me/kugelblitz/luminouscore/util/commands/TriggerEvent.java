package me.kugelblitz.luminouscore.util.commands;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.mechanics.events.TwilightResonance;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TriggerEvent implements CommandExecutor {

    Location twilightlocation;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("luminouscore.admin.triggerevent")) {
            if (args.length > 1) {
                if (args[0].equalsIgnoreCase("start")) {
                    if (args[1].equalsIgnoreCase("twilightresonance")) {
                        twilightlocation = LuminousCore.plugin.getConfig().getLocation("Events.TwilightResonance.location");
                        sender.sendMessage("§aTriggering §5Twilight Resonance§a...");
                        new TwilightResonance(twilightlocation);
                    } else if (args[1].equalsIgnoreCase("silentshaman")) {

                    } else {
                        sender.sendMessage("§cAcceptable arguements: <TwilightResonanca | SilentShaman>");
                    }
                } else if (args[0].equalsIgnoreCase("end")) {
                    if (args[1].equalsIgnoreCase("twilightresonance")) {
                        twilightlocation = LuminousCore.plugin.getConfig().getLocation("Events.TwilightResonance.location");
                        sender.sendMessage("§aRemoving §5Twilight Resonance§a...");
                        TwilightResonance.isTwilightResonance = false;
                    } else if (args[1].equalsIgnoreCase("silentshaman")) {

                    } else {
                        sender.sendMessage("§cAcceptable arguements: <TwilightResonanca | SilentShaman>");
                    }
                }
            } else {
                sender.sendMessage("§cPlease specify an event. <TwilightResonanca | SilentShaman>");
            }
        }


        return false;
    }
}
