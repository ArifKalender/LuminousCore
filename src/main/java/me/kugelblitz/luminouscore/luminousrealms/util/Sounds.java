package me.kugelblitz.luminouscore.luminousrealms.util;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

//NADİR DROP 1%-5%
//FEVKALADE DROP 0.99%-0.11%
//OLAĞANÜSTÜ DROP 0.1%-0.011%%


public class Sounds {
    private static int raredrop = 0;
    private static int fevkalade = 0;


    public static void bossSpawn(Player player) {
        Location location = player.getLocation();
        location.getWorld().playSound(location, Sound.BLOCK_END_PORTAL_SPAWN, 3, 1);
        player.sendTitle("§C§LA BOSS HAS SPAWNED", "", 30, 90, 30);
    }

    public static void rareDrop(Player player) {
        Location location = player.getLocation();
        new BukkitRunnable() {
            @Override
            public void run() {
                raredrop++;
                if (raredrop == 1) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 0);
                    player.sendTitle("§9§LRARE DROP", "", 0, 20, 0);
                } else if (raredrop == 2) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 1);
                    player.sendTitle("§b§LRARE DROP", "", 0, 20, 0);
                } else if (raredrop == 3) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 0);
                    player.sendTitle("§9§LRARE DROP", "", 0, 20, 0);
                } else if (raredrop == 4) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 2);
                    player.sendTitle("§b§LRARE DROP", "", 0, 20, 0);
                } else if (raredrop == 5) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 0);
                    player.sendTitle("§9§LRARE DROP", "", 0, 20, 0);
                } else if (raredrop == 6) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 1);
                    player.sendTitle("§b§LRARE DROP", "", 0, 20, 0);
                } else if (raredrop == 7) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 0);
                    player.sendTitle("§9§LRARE DROP", "", 0, 20, 20);
                } else {
                    raredrop = 0;
                    this.cancel();
                }

            }
        }.runTaskTimer(LuminousCore.plugin, 0, 3);
    }

    public static void remarkableDrop(Player player) {
        Location location = player.getLocation();

        fevkalade++;

        new BukkitRunnable() {
            @Override

            public void run() {

                fevkalade++;
                if (fevkalade == 1) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 1);
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_BELL, 3, 1);
                    player.sendTitle("§D§lREMARKABLE DROP", "", 0, 20, 0);
                } else if (fevkalade == 2) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_BELL, 3, 1);
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 0);
                    player.sendTitle("§b§lREMARKABLE DROP", "", 0, 20, 0);
                } else if (fevkalade == 3) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_BELL, 3, 1);
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 1);
                    player.sendTitle("§d§lREMARKABLE DROP", "", 0, 20, 0);
                } else if (fevkalade == 4) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_BELL, 3, 1);
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 2);
                    player.sendTitle("§b§lREMARKABLE DROP", "", 0, 20, 0);
                } else if (fevkalade == 5) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_BELL, 3, 1);
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 1);
                    player.sendTitle("§d§lREMARKABLE DROP", "", 0, 20, 0);
                } else if (fevkalade == 6) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_BELL, 3, 1);
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 0);
                    player.sendTitle("§b§lREMARKABLE DROP", "", 0, 20, 0);
                } else if (fevkalade == 7) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_BELL, 3, 1);
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 1);
                    player.sendTitle("§d§lREMARKABLE DROP", "", 0, 20, 20);
                } else if (fevkalade == 8) {
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_BELL, 3, 1);
                    location.getWorld().playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, 3, 1);
                    player.sendTitle("§b§lREMARKABLE DROP", "", 0, 20, 20);
                } else {
                    fevkalade = 0;
                    this.cancel();
                }

            }
        }.runTaskTimer(LuminousCore.plugin, 0, 3);
    }

    public static void exoticDrop(Player player) {
        Location location = player.getLocation();
        location.getWorld().playSound(location, Sound.UI_TOAST_CHALLENGE_COMPLETE, 3, 0);
        player.sendTitle("§4§lE§c§lX§4§lO§c§lT§4§lI§c§lC §4§lD§c§lR§4§lO§c§lP", "", 30, 90, 30);
    }

    public static void bossSlain(Player player) {
        Location location = player.getLocation();
        location.getWorld().playSound(location, Sound.UI_TOAST_CHALLENGE_COMPLETE, 3, 0);
        player.sendTitle("§4§lB§c§lO§4§lS§c§lS §4§lS§c§lL§4§lA§c§lI§4§lN!", "", 30, 90, 30);
    }


}
