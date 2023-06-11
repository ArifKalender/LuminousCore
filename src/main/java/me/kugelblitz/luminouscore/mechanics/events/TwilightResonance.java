package me.kugelblitz.luminouscore.mechanics.events;

import me.kugelblitz.luminouscore.LuminousCore;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.active.DisharmonicResonance;
import me.kugelblitz.luminouscore.custom.custommobs.overworld.boss.VoidRippingTwilightFire;
import me.kugelblitz.luminouscore.util.UtilizationMethods;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class TwilightResonance {
    public static boolean isTwilightResonance;
    Random random;
    int randomNumber;

    public TwilightResonance(Location location) {
        isTwilightResonance = true;

        new VoidRippingTwilightFire(location);
        for (World world : Bukkit.getWorlds()) {
            if (world.getEnvironment() == World.Environment.NORMAL) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        world.setTime(world.getTime() + 200);
                        for (Player player : UtilizationMethods.getNearbyPlayers(location, 100)) {
                            random = new Random();
                            randomNumber = random.nextInt(1000);
                            if (randomNumber == 1) {
                                spawnResonance(player);
                                player.setNoDamageTicks(0);
                            }
                            player.setNoDamageTicks(0);

                            if (!isTwilightResonance) {
                                this.cancel();
                            }

                        }

                    }
                }.runTaskTimer(LuminousCore.plugin, 0, 1);
            }
        }
    }


    public void spawnResonance(Player player) {
        for (int i = 0; i <= 10; i++) {
            Location randomLocation = UtilizationMethods.getRandomLocation(player.getLocation(), 15);
            new DisharmonicResonance(randomLocation);
        }
    }
}
