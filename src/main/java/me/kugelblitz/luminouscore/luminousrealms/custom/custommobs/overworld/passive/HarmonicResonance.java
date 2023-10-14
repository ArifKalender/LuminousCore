package me.kugelblitz.luminouscore.luminousrealms.custom.custommobs.overworld.passive;

import me.kugelblitz.luminouscore.LuminousCore;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Allay;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class HarmonicResonance {
    Location harmonicLocation;
    double randomNumber;

    public HarmonicResonance(Location location) {
        Allay harmonicResonance = (Allay) location.getWorld().spawnEntity(location, EntityType.ALLAY, false);
        harmonicResonance.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000);
        Random random = new Random();
        harmonicResonance.setCustomNameVisible(true);
        harmonicResonance.setHealth(1000);
        new BukkitRunnable() {
            @Override
            public void run() {
                randomNumber = random.nextDouble();
                harmonicLocation = harmonicResonance.getLocation();
                harmonicResonance.setCustomName("§dHarmonic Resonance §c[" + (int) harmonicResonance.getHealth() + "§e/§c" + (int) harmonicResonance.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() + "]");
                if (randomNumber < 0.2) {
                    harmonicLocation.getWorld().playSound(harmonicLocation, Sound.ENTITY_ALLAY_AMBIENT_WITH_ITEM, 1, 0);
                } else if (randomNumber < 0.4) {
                    harmonicLocation.getWorld().playSound(harmonicLocation, Sound.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM, 1, 0);
                } else if (randomNumber < 0.6) {
                    harmonicLocation.getWorld().playSound(harmonicLocation, Sound.ENTITY_ALLAY_ITEM_TAKEN, 1, 0);
                } else if (randomNumber < 0.8) {
                    harmonicLocation.getWorld().playSound(harmonicLocation, Sound.ENTITY_ALLAY_ITEM_GIVEN, 1, 0);
                }


                if (harmonicResonance.isDead()) {
                    this.cancel();
                }
            }
        }.runTaskTimer(LuminousCore.plugin, 0, 6);
    }
}
