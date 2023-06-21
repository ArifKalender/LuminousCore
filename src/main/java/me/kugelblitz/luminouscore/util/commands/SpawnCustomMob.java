package me.kugelblitz.luminouscore.util.commands;

import me.kugelblitz.luminouscore.custom.custommobs.arcanehaven.active.CelestialOrchard;
import me.kugelblitz.luminouscore.custom.custommobs.arcanehaven.active.Dread;
import me.kugelblitz.luminouscore.custom.custommobs.arcanehaven.active.Nightmare;
import me.kugelblitz.luminouscore.custom.custommobs.arcanehaven.passive.AncientEarthling;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.active.*;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.boss.SerenityDivider;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.boss.VoidRippingTwilightFire;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.passive.HarmonicResonance;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.passive.Quark;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

    public class SpawnCustomMob implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("lumina.admin.spawnmob")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("harmonicresonance")) {
                        new HarmonicResonance(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("disharmonicresonance")) {
                        new DisharmonicResonance(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("quark")) {
                        new Quark(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("neuronfly")) {
                        new NeuronFly(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("alivestructure")) {
                        new AliveStructure(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("sentientcore")) {
                        new SentientCore(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("gazesthewaves")) {
                        new GazesTheWaves(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("serenitydivider")) {
                        new SerenityDivider(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("voidripper")) {
                        new VoidRippingTwilightFire(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("celestialorchard")) {
                        new CelestialOrchard(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("nightmare")) {
                        new Nightmare(player.getLocation());
                    } else if (args[0].equalsIgnoreCase("earthling")) {
                        new AncientEarthling(player.getLocation());
                    }else if (args[0].equalsIgnoreCase("dread")) {
                        new Dread(player.getLocation());
                    }
                } else {
                    player.sendMessage("§cYou need to have an arguement to execute this command.");
                }
            } else {
                sender.sendMessage("§cYou dont have enough permissions to execute this command.");
            }

        } else {
            sender.sendMessage("§cThis command can only be executed by players.");
        }

        return false;
    }
}
