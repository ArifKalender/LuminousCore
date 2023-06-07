package me.kugelblitz.luminouscore.custom.custommobs.overworld.active;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Vex;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class DisharmonicResonance {
    Location harmonicLocation;
    double randomNumber;

    public DisharmonicResonance(Location location) {
        Vex disharmonicResonance = (Vex) location.getWorld().spawnEntity(location, EntityType.VEX, false);
        disharmonicResonance.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000);
        Random random = new Random();
        disharmonicResonance.setCustomNameVisible(true);
        disharmonicResonance.setHealth(1000);
        new BukkitRunnable() {
            @Override
            public void run() {
                randomNumber = random.nextDouble();
                harmonicLocation = disharmonicResonance.getLocation();
                disharmonicResonance.setCustomName("§4Disharmonic Resonance §c[" + (int) disharmonicResonance.getHealth() + "§e/§c" + (int) disharmonicResonance.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() + "]");
                if (randomNumber < 0.3) {
                    harmonicLocation.getWorld().playSound(harmonicLocation, Sound.ENTITY_WARDEN_DEATH, 0.25F, 0);
                } else if (randomNumber < 0.6) {
                    harmonicLocation.getWorld().playSound(harmonicLocation, Sound.ENTITY_WITHER_SHOOT, 0.25F, 0);
                }


                if (disharmonicResonance.isDead()) {
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 1);
    }
}
